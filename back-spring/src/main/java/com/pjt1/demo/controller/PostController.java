package com.pjt1.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pjt1.demo.model.dto.Comment;
import com.pjt1.demo.model.dto.Files;
import com.pjt1.demo.model.dto.Likes;
import com.pjt1.demo.model.dto.Members;
import com.pjt1.demo.model.dto.Post;
import com.pjt1.demo.model.service.MembersService;
import com.pjt1.demo.model.service.PostService;
import com.pjt1.demo.utils.MorePageBean;
import com.pjt1.demo.utils.MorePageMaker;
import com.pjt1.demo.utils.PageBean;
import com.pjt1.demo.utils.PageMaker;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
public class PostController {
    @Autowired
    private PostService service;
    @Autowired
    private MembersService m_service;

    @ExceptionHandler
    public ResponseEntity<Map<String, Object>> handle(Exception e) {
        return handleFail(e.getMessage(), HttpStatus.OK); // 전송에는 지장 없음
    }

    public ResponseEntity<Map<String, Object>> handleSuccess(Object data) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("state", "ok");
        resultMap.put("data", data);
        return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
    }

    public ResponseEntity<Map<String, Object>> handleFail(Object data, HttpStatus state) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("state", "fail");
        resultMap.put("data", data);
        return new ResponseEntity<Map<String, Object>>(resultMap, state);
    }

    @ApiOperation("전체 Post 목록을 조회하는 기능")
    @GetMapping("/Post/searchAll")
    public ResponseEntity<Map<String, Object>> searchAll() {
        List<Post> list = service.searchAll();
        return handleSuccess(list);
    }

    @ApiOperation("no에 따른 Post 정보 조회하는 기능")
    @GetMapping("/Post/search/{post_no}")
    public ResponseEntity<Map<String, Object>> search(@PathVariable int post_no) {
        System.out.println(post_no);
        Post Post = service.search(post_no);
        int memNo = Post.getMem_no();
        Members Members = m_service.search(memNo);
        String writer = Members.getMem_id();
        Post.setPost_writer(writer);
        System.out.println(Post);
        service.updatePostHits(post_no);
        return handleSuccess(Post);
    }

    @ApiOperation("mem_no에 따른 내가 쓴 POST 조회하는 기능")
    @GetMapping("/Post/searchMyPost/{mem_no}")
    public ResponseEntity<Map<String, Object>> searchMyPost(@PathVariable int mem_no) {
        List<Post> list = service.searchMyPost(mem_no);
        return handleSuccess(list);
    }

    @ApiOperation("더보기로 Post 검색하기 조회 - searchOption은 all/ title / content/ tag / writer 중 전달")
    @GetMapping("/Post/search/page/{btnCnt}/{searchOption}/{word}")
    public ResponseEntity<Map<String, Object>> searchPostByOption(@PathVariable int btnCnt,
            @PathVariable String searchOption, @PathVariable String word) {
        PageBean pageBean = new PageBean(btnCnt, 16);
        PageMaker pageMaker = new PageMaker();
        pageMaker.setPageBean(pageBean);
        pageMaker.setStartPage(pageBean.getPage());
        pageMaker.setEndPage(pageMaker.getStartPage());
        if (searchOption.equals("empty")) {
            pageMaker.setSearchOption("all");
        } else
            pageMaker.setSearchOption(searchOption);
        if (word.equals("empty")) {
            // pageMaker.setWord("''");
        } else
            pageMaker.setWord(word);

        // PageBean.setWord(word);
        System.out.println(pageBean);
        System.out.println(pageMaker);
        List<Map<String, Object>> list = service.searchMorePostByOption(pageMaker);
        System.out.println(list);
        return list.size() == 0 ? handleSuccess(list) : handleSuccess(list); // 일단 무조건 확인해야 하므로
    }

    @PostMapping("/Post/insert")
    @ApiOperation("Post 정보 등록")
    public ResponseEntity<Map<String, Object>> insert(@RequestBody Post Post) {
        Members writer = m_service.search(Post.getMem_no());
        Post.setPost_writer(writer.getMem_id());
        service.insert(Post);
        return handleSuccess("");
    }

    @ApiOperation("Post 정보 삭제")
    @DeleteMapping("/Post/delete/{post_no}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable int post_no) {
        List<Map<String, Object>> delList_Likes = service.findChildLike(post_no);
        List<Map<String, Object>> delList_Comment = service.findChildCmt(post_no);
        List<Map<String, Object>> delList_Files = service.findChildFiles(post_no);
        List<Integer> del_Likes_IndexList = new ArrayList<Integer>();
        List<Integer> del_Comment_IndexList = new ArrayList<Integer>();
        List<Integer> del_Files_IndexList = new ArrayList<Integer>();
        for (Object o : delList_Likes) {
            del_Likes_IndexList.add(((Likes) o).getLike_no());
        }
        for (Object o : delList_Comment) {
            del_Comment_IndexList.add(((Comment) o).getCmt_no());
        }
        for (Object o : delList_Files) {
            del_Files_IndexList.add(((Files) o).getFiles_no());
        }
        service.deleteChildLike(del_Likes_IndexList);
        service.deleteChildCmt(del_Comment_IndexList);
        service.deleteChildFiles(del_Files_IndexList);
        service.delete(post_no);
        return handleSuccess("삭제 완료");
    }

    @ApiOperation("Post 정보 수정")
    @PutMapping("/Post/update")
    public ResponseEntity<Map<String, Object>> update(@RequestBody Post Post) {
        service.update(Post);
        return handleSuccess("수정 완료");
    }

    @ApiOperation("페이징된 Post 전체 목록 조회")
    @GetMapping("/Post/search/pageAll/{btnCnt}")
    public ResponseEntity<Map<String, Object>> searchPagePostAll(PageBean pageBean, @PathVariable int btnCnt) {
        PageMaker pageMaker = new PageMaker();
        pageBean.setPage(btnCnt);
        pageMaker.setPageBean(pageBean);
        pageMaker.setStartPage(pageBean.getPage());
        pageMaker.setEndPage(pageMaker.getStartPage());
        List<Map<String, Object>> list = service.searchPagePostAll(pageMaker);
        return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
    }

    @ApiOperation("페이징된 Post 중 일정(Plan) 목록 조회")
    @GetMapping("/Post/search/pagePlan/{btnCnt}")
    public ResponseEntity<Map<String, Object>> searchPagePlan(PageBean pageBean, @PathVariable int btnCnt) {
        PageMaker pageMaker = new PageMaker();
        pageBean.setPage(btnCnt);
        pageMaker.setPageBean(pageBean);
        pageMaker.setStartPage(pageBean.getPage());
        pageMaker.setEndPage(pageMaker.getStartPage());
        List<Map<String, Object>> list = service.searchPagePlan(pageMaker);
        return list.size() == 0 ? handleSuccess("이 페이지에는 일정이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
    }

    @ApiOperation("내가 팔로우한 회원들 게시물 가져오기")
    @GetMapping("/Post/searchFollowingPost")
    public ResponseEntity<Map<String, Object>> searchFollowingPost(int following_no) {
        List<Post> list = service.searchFollowingPost(following_no);
        return handleSuccess(list);
    }

    @ApiOperation("게시글 마지막번호")
    @GetMapping("Post/LastNo")
    public ResponseEntity<Map<String, Object>> searchLastNo() {
        int last = service.searchLastNo();
        return handleSuccess(last);
    }

}
// @ApiOperation("더보기로 Post 전체 목록 조회")
// @GetMapping("/Post/search/moreAll/{btnCnt}")
// public ResponseEntity<Map<String, Object>> searchMorePostAll(PageBean
// pageBean, @PathVariable int btnCnt) {
//// MorePageMaker morePage = new MorePageMaker();
// PageMaker page = new PageMaker();
//// int change = pageNum * btnCnt;
//// pageBean.setPerPageNum(change);
// pageBean.setPage(page.getStartPage());
//// morePage.setPageBean(pageBean);
// List<Map<String, Object>> list = service.searchMorePostAll(pageBean);
// return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") :
// handleSuccess(list); // 일단 무조건 확인해야 하므로
// }

// @ApiOperation("더보기로 Post 중 후기(Report) 목록 조회")
// @GetMapping("/Post/search/moreReport/{btnCnt}")
// public ResponseEntity<Map<String, Object>> searchMoreReport(MorePageBean
// pageBean, @PathVariable int btnCnt) {
// MorePageMaker morePage = new MorePageMaker();
// int change = pageNum * btnCnt;
// pageBean.setPerPageNum(change);
// morePage.setPageBean(pageBean);
// List<Map<String, Object>> list = service.searchPageReport(pageBean);
// return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") :
// handleSuccess(list); // 일단 무조건 확인해야 하므로
// }
//
// @ApiOperation("더보기로 Post 중 일정(Plan) 목록 조회")
// @GetMapping("/Post/search/morePlan/{btnCnt}")
// public ResponseEntity<Map<String, Object>> searchMorePlan(MorePageBean
// pageBean, @PathVariable int btnCnt) {
// MorePageMaker morePage = new MorePageMaker();
// int change = pageNum * btnCnt;
// pageBean.setPerPageNum(change);
// morePage.setPageBean(pageBean);
// List<Map<String, Object>> list = service.searchPagePlan(pageBean);
// return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") :
// handleSuccess(list); // 일단 무조건 확인해야 하므로
// }
//
// @ApiOperation("no에 따른 Post 정보 조회하는 기능")
// @GetMapping("/Post/search/WithCmtAndFiles/{post_no}")
// public ResponseEntity<Map<String, Object>>
// searchWithCmtAndFiles(@PathVariable int post_no) {
// Post Post = service.searchWithCmtAndFiles(post_no);
// service.updatePostHits(post_no);
// // 그러면 여기서 포스트넘 기반으로 comment 호출하는거 하나 하고
// // 멤버 호출하는거 하나한다음에
// // postPagebean 하나 만들어서 그걸 넘겨주자.
// return handleSuccess(Post);
// }
// }
/*
 * @ApiOperation("페이징된 Post 전체 목록 조회")
 * 
 * @GetMapping("/Post/search/pageAll") public ResponseEntity<Map<String,
 * Object>> searchPagePostAll(PerPageBean pageBean) { PerPageMaker pageMaker =
 * new PerPageMaker(); pageMaker.setPageBean(pageBean);
 * pageMaker.setTotalCnt(service.getCountPostAll()); List<Map<String, Object>>
 * list = service.searchPagePostAll(pageBean); return list.size() == 0 ?
 * handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야
 * 하므로 }
 * 
 * @ApiOperation("페이징된 Post 중 후기(Report) 목록 조회")
 * 
 * @GetMapping("/Post/search/pageReport") public ResponseEntity<Map<String,
 * Object>> searchPageReport(PerPageBean pageBean) { PerPageMaker pageMaker =
 * new PerPageMaker(); pageMaker.setPageBean(pageBean);
 * pageMaker.setTotalCnt(service.getCountPostAll()); List<Map<String, Object>>
 * list = service.searchPageReport(pageBean); return list.size() == 0 ?
 * handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야
 * 하므로 }
 * 
 * @ApiOperation("페이징된 Post 중 일정(Plan) 목록 조회")
 * 
 * @GetMapping("/Post/search/pagePlan") public ResponseEntity<Map<String,
 * Object>> searchPagePlan(PerPageBean pageBean) { PerPageMaker pageMaker = new
 * PerPageMaker(); pageMaker.setPageBean(pageBean);
 * pageMaker.setTotalCnt(service.getCountPostAll()); List<Map<String, Object>>
 * list = service.searchPagePlan(pageBean); return list.size() == 0 ?
 * handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야
 * 하므로 }
 */
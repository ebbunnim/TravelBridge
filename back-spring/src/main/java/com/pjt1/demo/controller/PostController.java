package com.pjt1.demo.controller;

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

import com.pjt1.demo.model.dto.Post;
import com.pjt1.demo.model.service.PostService;
import com.pjt1.demo.utils.MorePageBean;
import com.pjt1.demo.utils.MorePageMaker;
import com.pjt1.demo.utils.PerPageBean;
import com.pjt1.demo.utils.PerPageMaker;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
public class PostController {

    @Autowired
    private PostService service;

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
    public ResponseEntity<Map<String, Object>> search(int post_no) {
        Post Post = service.search(post_no);
        //그러면 여기서 포스트넘 기반으로 comment 호출하는거 하나 하고
        //멤버 호출하는거 하나한다음에
        //postPagebean 하나 만들어서 그걸 넘겨주자.
        return handleSuccess(Post);
    }

    @PostMapping("/Post/insert")
    @ApiOperation("Post 정보 등록")
    public ResponseEntity<Map<String, Object>> insert(@RequestBody Post Post) {
        service.insert(Post);
        return handleSuccess("");
    }

    @ApiOperation("Post 정보 삭제")
    @DeleteMapping("/Post/delete/{post_no}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable int post_no) {
        service.delete(post_no);
        return handleSuccess("삭제 완료");
    }

    @ApiOperation("Post 정보 수정")
    @PutMapping("/Post/update")
    public ResponseEntity<Map<String, Object>> update(@RequestBody Post Post) {
        service.update(Post);
        return handleSuccess("수정 완료");
    }
    @ApiOperation("더보기로 Post 전체 목록 조회")
    @GetMapping("/Post/search/moreAll/{btnCnt}")
    public ResponseEntity<Map<String, Object>> searchMorePostAll(MorePageBean pageBean, @PathVariable int btnCnt) {
        MorePageMaker morePage = new MorePageMaker();
        int change = 3 * btnCnt;
        pageBean.setPerPageNum(change);
        morePage.setMorePageBean(pageBean);
        List<Map<String, Object>> list = service.searchMorePostAll(pageBean);
        return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
    }
    @ApiOperation("더보기로 Post 중 후기(Report) 목록 조회")
    @GetMapping("/Post/search/moreReport/{btnCnt}")
    public ResponseEntity<Map<String, Object>> searchMoreReport(MorePageBean pageBean, @PathVariable int btnCnt) {
        MorePageMaker morePage = new MorePageMaker();
        int change = 3 * btnCnt;
        pageBean.setPerPageNum(change);
        morePage.setMorePageBean(pageBean);
        List<Map<String, Object>> list = service.searchMoreReport(pageBean);
        return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
    }
    @ApiOperation("더보기로 Post 중 일정(Plan) 목록 조회")
    @GetMapping("/Post/search/morePlan/{btnCnt}")
    public ResponseEntity<Map<String, Object>> searchMorePlan(MorePageBean pageBean, @PathVariable int btnCnt) {
        MorePageMaker morePage = new MorePageMaker();
        int change = 3 * btnCnt;
        pageBean.setPerPageNum(change);
        morePage.setMorePageBean(pageBean);
        List<Map<String, Object>> list = service.searchMorePlan(pageBean);
        return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
    }
    @ApiOperation("페이징된 Post 전체 목록 조회")
    @GetMapping("/Post/search/pageAll")
    public ResponseEntity<Map<String, Object>> searchPagePostAll(PerPageBean pageBean) {
        PerPageMaker pageMaker = new PerPageMaker();
        pageMaker.setPageBean(pageBean);
        pageMaker.setTotalCnt(service.getCountPostAll());
        List<Map<String, Object>> list = service.searchPagePostAll(pageBean);
        return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
    }
    @ApiOperation("페이징된 Post 중 후기(Report) 목록 조회")
    @GetMapping("/Post/search/pageReport")
    public ResponseEntity<Map<String, Object>> searchPageReport(PerPageBean pageBean) {
        PerPageMaker pageMaker = new PerPageMaker();
        pageMaker.setPageBean(pageBean);
        pageMaker.setTotalCnt(service.getCountPostAll());
        List<Map<String, Object>> list = service.searchPageReport(pageBean);
        return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
    }
    @ApiOperation("페이징된 Post 중 일정(Plan) 목록 조회")
    @GetMapping("/Post/search/pagePlan")
    public ResponseEntity<Map<String, Object>> searchPagePlan(PerPageBean pageBean) {
        PerPageMaker pageMaker = new PerPageMaker();
        pageMaker.setPageBean(pageBean);
        pageMaker.setTotalCnt(service.getCountPostAll());
        List<Map<String, Object>> list = service.searchPagePlan(pageBean);
        return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
    }
    
}

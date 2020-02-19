package com.pjt1.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

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

import com.pjt1.demo.model.dto.Festival;
import com.pjt1.demo.model.dto.Likes;
import com.pjt1.demo.model.service.FestivalService;
import com.pjt1.demo.utils.MorePageBean;
import com.pjt1.demo.utils.MorePageMaker;
import com.pjt1.demo.utils.PageBean;
import com.pjt1.demo.utils.PageMaker;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
public class FestivalController {

	private static StringTokenizer st;
	@Autowired
	private FestivalService service;
	private static int fvalPageNum = 4;

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

	@ApiOperation("전체 Festival 목록을 조회하는 기능")
	@GetMapping("/Festival/searchAll")
	public ResponseEntity<Map<String, Object>> searchAll() {
		List<Festival> list = service.searchAll();
		return handleSuccess(list);
	}

	@ApiOperation("no에 따른 Festival 정보 조회하는 기능")
	@GetMapping("/Festival/search/{fval_no}")
	public ResponseEntity<Map<String, Object>> search(@PathVariable int fval_no) {
		Festival Festival = service.search(fval_no);
		return handleSuccess(Festival);
	}

	@PostMapping("/Festival/insert")
	@ApiOperation("Festival 정보 등록")
	public ResponseEntity<Map<String, Object>> insert(@RequestBody Festival Festival) {
		service.insert(Festival);
		return handleSuccess("");
	}

	@ApiOperation("Festival 정보 삭제")
    @DeleteMapping("/Festival/delete/{fval_no}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable int fval_no) {
		List<Map<String, Object>> delList_Likes = service.findChildLike(fval_no);
		System.out.println(delList_Likes);
		List<Integer> del_Likes_IndexList = new ArrayList<Integer>();
		for(Object o : delList_Likes) {  del_Likes_IndexList.add(((Likes) o).getLike_no());}
		service.deleteChildLike(del_Likes_IndexList);
		service.delete(fval_no);
        return handleSuccess("삭제 완료");
    }
	@ApiOperation("Festival 정보 수정")
    @PutMapping("/Festival/update")
    public ResponseEntity<Map<String, Object>> update(@RequestBody Festival Festival) {
        service.update(Festival);
        return handleSuccess("수정 완료");
    }
	 @ApiOperation("더보기로 Festival 전체 목록 조회")
		@GetMapping("/Festival/search/more/{btnCnt}")
		public ResponseEntity<Map<String, Object>> searchMoreFestivalAll(MorePageBean pageBean, @PathVariable int btnCnt) {
			MorePageMaker pageMaker = new MorePageMaker();
			int change = pageNum * btnCnt;
			pageBean.setPerPageNum(change);
			pageMaker.setPageBean(pageBean);
			List<Map<String, Object>> list = service.searchMoreFestivalAll(pageBean);
			return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
		}

	@ApiOperation("더보기로 Festival 도시이름으로 목록 조회")
	@GetMapping("/Festival/search/more/cityname/{btnCnt}/{word}")
	public ResponseEntity<Map<String, Object>> searchMoreFestivalByCityName(MorePageBean pageBean,
			@PathVariable int btnCnt, @PathVariable String word) {
		MorePageMaker pageMaker = new MorePageMaker();
		int change = fvalPageNum * btnCnt;
		pageBean.setWord(word);
		pageBean.setPerPageNum(change);
		pageMaker.setPageBean(pageBean);
		List<Map<String, Object>> list = service.searchMoreFestivalByCityName(pageBean);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}
	@ApiOperation("페이지로 Festival 도시이름으로 목록 조회")
	@GetMapping("/Festival/search/page/cityname/{btnCnt}/{word}")
	public ResponseEntity<Map<String, Object>> searchPageFestivalByCityName(@PathVariable int btnCnt, @PathVariable String word) {
		PageBean pageBean = new PageBean(btnCnt, fvalPageNum);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPageBean(pageBean);
		pageMaker.setWord(word);
		pageMaker.setStartPage(pageBean.getPage());
		pageMaker.setEndPage(pageMaker.getStartPage());
		List<Festival> list = service.searchPageFestivalByCityName(pageMaker);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}
	@ApiOperation("더보기로 Festival 태그로 목록 조회")
	@GetMapping("/Festival/search/more/tag/{btnCnt}/{word}")
	public ResponseEntity<Map<String, Object>> searchMoreFestivalByTag(MorePageBean pageBean, @PathVariable int btnCnt,
			@PathVariable String word) {
		MorePageMaker pageMaker = new MorePageMaker();
		int change = fvalPageNum * btnCnt;
		pageBean.setWord(word);
		pageBean.setPerPageNum(change);
		pageMaker.setPageBean(pageBean);
		List<Map<String, Object>> list = service.searchMoreFestivalByTag(pageBean);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}
	@ApiOperation("페이지로 Festival 태그로 목록 조회")
	@GetMapping("/Festival/search/page/tag/{btnCnt}/{word}")
	public ResponseEntity<Map<String, Object>> searchPageFestivalByTag(@PathVariable int btnCnt, @PathVariable String word) {
		PageBean pageBean = new PageBean(btnCnt, fvalPageNum);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPageBean(pageBean);
		pageMaker.setWord(word);
		pageMaker.setStartPage(pageBean.getPage());
		pageMaker.setEndPage(pageMaker.getStartPage());
		List<Festival> list = service.searchPageFestivalByTag(pageMaker);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}
	@ApiOperation("더보기로 Festival 테마로 목록 조회")
	@GetMapping("/Festival/search/more/theme/{btnCnt}/{word}")
	public ResponseEntity<Map<String, Object>> searchMoreFestivalByTheme(MorePageBean pageBean,
			@PathVariable int btnCnt, @PathVariable String word) {
		MorePageMaker pageMaker = new MorePageMaker();
		int change = fvalPageNum * btnCnt;
		List<String> selected_theme = new ArrayList<String>();
		st = new StringTokenizer(word);
		while (st.hasMoreTokens()) {
			selected_theme.add(st.nextToken());
		}
		;

		pageBean.setPerPageNum(change);
		pageBean.setFilters(selected_theme);
		pageMaker.setPageBean(pageBean);

		List<Map<String, Object>> list = service.searchMoreFestivalByTheme(pageBean);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}
	@ApiOperation("페이지로 Festival 테마로 목록 조회")
	@GetMapping("/Festival/search/page/theme/{btnCnt}/{word}")
	public ResponseEntity<Map<String, Object>> searchPageFestivalByTheme(@PathVariable int btnCnt, @PathVariable String word) {
		PageBean pageBean = new PageBean(btnCnt, fvalPageNum);
		PageMaker pageMaker = new PageMaker();
		List<String> selected_theme = new ArrayList<String>();
		st = new StringTokenizer(word);
		while (st.hasMoreTokens()) {
			selected_theme.add(st.nextToken());
		};
		pageMaker.setPageBean(pageBean);
		pageMaker.setFilters(selected_theme);
		pageMaker.setStartPage(pageBean.getPage());
		pageMaker.setEndPage(pageMaker.getStartPage());

		List<Festival> list = service.searchPageFestivalByTheme(pageMaker);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}
	@ApiOperation("더보기로 Festival 검색하기 조회 - searchOption은 all/ title / content/ tag중 전달")
	@GetMapping("/Festival/search/more/{btnCnt}/{searchOption}/{word}")
	public ResponseEntity<Map<String, Object>> searchMoreFestival(MorePageBean pageBean, @PathVariable int btnCnt,
			@PathVariable String searchOption, @PathVariable String word) {
		MorePageMaker pageMaker = new MorePageMaker();
		int change = fvalPageNum * btnCnt;
		searchOption = (searchOption == null) ? "all" : searchOption;
		word = (word == null || word == " ") ? "" : word;
		pageBean.setSearchOption(searchOption);
		pageBean.setWord(word);
		pageBean.setPerPageNum(change);
		pageMaker.setPageBean(pageBean);
		List<Map<String, Object>> list = service.searchMoreFestival(pageBean);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}
	@ApiOperation("페이지로 Festival 검색하기 조회 - searchOption은 all/ title / content/ tag /city중 전달")
	@GetMapping("/Festival/search/page/{btnCnt}/{searchOption}/{word}")
	public ResponseEntity<Map<String, Object>> searchPageFestival(@PathVariable int btnCnt,
			@PathVariable String searchOption, @PathVariable String word) {
		PageBean pageBean = new PageBean(btnCnt, fvalPageNum);
		PageMaker pageMaker = new PageMaker();
		searchOption = (searchOption == null || searchOption.equals("empty")) ? "all" : searchOption;
		word = (word == null || word.equals(" ") || word.equals("empty")) ? "''" : word;
		pageMaker.setSearchOption(searchOption);
		pageMaker.setWord(word);
		pageMaker.setPageBean(pageBean);
		pageMaker.setStartPage(pageBean.getPage());
		pageMaker.setEndPage(pageMaker.getStartPage());
		List<Festival> list = service.searchPageFestival(pageMaker);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}
}
/*
 * @ApiOperation("페이징된 Festival 전체 목록 조회")
 * 
 * @GetMapping("/Festival/search/pageAll") public ResponseEntity<Map<String,
 * Object>> searchPageFestivalAll(PerPageBean pageBean) { PerPageMaker pageMaker
 * = new PerPageMaker(); pageMaker.setPageBean(pageBean);
 * pageMaker.setTotalCnt(service.getCountFestivalAll()); List<Map<String,
 * Object>> list = service.searchPageFestivalAll(pageBean); return list.size()
 * == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단
 * 무조건 확인해야 하므로 }
 * 
 * @ApiOperation("페이징된 Festival 태그로 목록 조회")
 * 
 * @GetMapping("/Festival/search/page/tag/{keyword}") public
 * ResponseEntity<Map<String, Object>> searchPageFestivalByTag(PerPageBean
 * pageBean,
 * 
 * @PathVariable String keyword) { PerPageMaker pageMaker = new PerPageMaker();
 * pageBean.setKeyword(keyword); pageMaker.setPageBean(pageBean);
 * pageMaker.setTotalCnt(service.getCountFestivalByTag(keyword));
 * List<Map<String, Object>> list = service.searchPageFestivalByTag(pageBean);
 * return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") :
 * handleSuccess(list); // 일단 무조건 확인해야 하므로 }
 * 
 * @ApiOperation("페이징된 Festival 도시이름으로 목록 조회")
 * 
 * @GetMapping("/Festival/search/page/cityname/{keyword}") public
 * ResponseEntity<Map<String, Object>> searchPageFestivalByCityName(PerPageBean
 * pageBean,
 * 
 * @PathVariable String keyword) { PerPageMaker pageMaker = new PerPageMaker();
 * pageBean.setWord(keyword); pageMaker.setPageBean(pageBean);
 * pageMaker.setTotalCnt(service.getCountFestivalByCityName(keyword));
 * List<Map<String, Object>> list =
 * service.searchPageFestivalByCityName(pageBean); return list.size() == 0 ?
 * handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야
 * 하므로 }
 */
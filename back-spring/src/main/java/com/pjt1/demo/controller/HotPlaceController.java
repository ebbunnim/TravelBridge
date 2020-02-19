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

import com.pjt1.demo.model.dto.HotPlace;
import com.pjt1.demo.model.dto.Likes;
import com.pjt1.demo.model.service.HotPlaceService;
import com.pjt1.demo.utils.MorePageBean;
import com.pjt1.demo.utils.MorePageMaker;
import com.pjt1.demo.utils.PageBean;
import com.pjt1.demo.utils.PageMaker;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
public class HotPlaceController {
	private static final int pageNum = 4;
	private static StringTokenizer st;
	@Autowired
	private HotPlaceService service;
	private static int hotPageNum = 4;

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

	@ApiOperation("전체 HotPlace 목록을 조회하는 기능")
	@GetMapping("/HotPlace")
	public ResponseEntity<Map<String, Object>> searchAll() {
		List<HotPlace> list = service.searchAll();
		return handleSuccess(list);
	}

	@ApiOperation("no에 따른 HotPlace 정보 조회하는 기능")
	@GetMapping("/HotPlace/{no}")
	public ResponseEntity<Map<String, Object>> search(@PathVariable int no) {
		System.out.println(no);
		HotPlace HotPlace = service.search(no);
		return handleSuccess(HotPlace);
	}

	@PostMapping("/HotPlace")
	@ApiOperation("HotPlace 정보 등록")
	public ResponseEntity<Map<String, Object>> insert(@RequestBody HotPlace HotPlace) {
		service.insert(HotPlace);
		return handleSuccess("");
	}
	@ApiOperation("HotPlace 정보 삭제")
	@DeleteMapping("/HotPlace/{no}")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable int no) {
		List<Map<String, Object>> delList_Likes = service.findChildLike(no);
		System.out.println(delList_Likes);
		List<Integer> del_Likes_IndexList = new ArrayList<Integer>();
		for(Object o : delList_Likes) {  del_Likes_IndexList.add(((Likes) o).getLike_no());}
		System.out.println(del_Likes_IndexList);
		service.deleteChildLike(del_Likes_IndexList);
		service.delete(no);
		return handleSuccess("삭제 완료");
	}

	@ApiOperation("HotPlace 정보 수정")
	@PutMapping("/HotPlace")
	public ResponseEntity<Map<String, Object>> update(@RequestBody HotPlace HotPlace) {
		service.update(HotPlace);
		return handleSuccess("수정 완료");
	}

	@ApiOperation("더보기로 Hotplace 전체 목록 조회")
	@GetMapping("/HotPlace/search/more/{btnCnt}")
	public ResponseEntity<Map<String, Object>> searchMoreHotPlaceAll(MorePageBean pageBean, @PathVariable int btnCnt) {
		MorePageMaker pageMaker = new MorePageMaker();
		int change = pageNum * btnCnt;
		pageBean.setPerPageNum(change);
		pageMaker.setPageBean(pageBean);
		List<Map<String, Object>> list = service.searchMoreHotPlaceAll(pageBean);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}
	@ApiOperation("페이지로 Hotplace 전체 목록 조회")
	@GetMapping("/HotPlace/search/page/{btnCnt}")
	public ResponseEntity<Map<String, Object>> searchPageHotPlaceAll(@PathVariable int btnCnt) {
    	PageBean pageBean = new PageBean(btnCnt, hotPageNum);
		PageMaker pageMaker = new PageMaker();
        pageMaker.setPageBean(pageBean);
        pageMaker.setStartPage(pageBean.getPage());
        pageMaker.setEndPage(pageMaker.getStartPage());
        System.out.println(pageBean);
        System.out.println(pageMaker);
		List<HotPlace> list = service.searchPageHotPlaceAll(pageMaker);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}

	@ApiOperation("더보기로 Hotplace 도시이름으로 목록 조회")
	@GetMapping("/HotPlace/search/more/cityname/{btnCnt}/{word}")
	public ResponseEntity<Map<String, Object>> searchMoreHotPlaceByCityName(MorePageBean pageBean,
			@PathVariable int btnCnt, @PathVariable String word) {
		MorePageMaker pageMaker = new MorePageMaker();
		int change = pageNum * btnCnt;
		pageBean.setWord(word);
		pageBean.setPerPageNum(change);
		pageMaker.setPageBean(pageBean);
		List<Map<String, Object>> list = service.searchMoreHotPlaceByCityName(pageBean);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}
	@ApiOperation("페이지로 Hotplace 도시이름으로 목록 조회")
	@GetMapping("/HotPlace/search/page/cityname/{btnCnt}/{word}")
	public ResponseEntity<Map<String, Object>> searchPageHotPlaceByCityName(@PathVariable int btnCnt, @PathVariable String word) {
		PageBean pageBean = new PageBean(btnCnt, hotPageNum);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPageBean(pageBean);
		pageMaker.setWord(word);
		pageMaker.setStartPage(pageBean.getPage());
		pageMaker.setEndPage(pageMaker.getStartPage());
		List<HotPlace> list = service.searchPageHotPlaceByCityName(pageMaker);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}


	@ApiOperation("더보기로 Hotplace 태그로 목록 조회")
	@GetMapping("/HotPlace/search/more/tag/{btnCnt}/{word}")
	public ResponseEntity<Map<String, Object>> searchMoreHotPlaceByTag(MorePageBean pageBean, @PathVariable int btnCnt,
			@PathVariable String word) {
		MorePageMaker pageMaker = new MorePageMaker();
		int change = pageNum * btnCnt;
		pageBean.setWord(word);
		pageBean.setPerPageNum(change);
		pageMaker.setPageBean(pageBean);
		List<Map<String, Object>> list = service.searchMoreHotPlaceByTag(pageBean);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}
	@ApiOperation("페이지로 Hotplace 태그로 목록 조회")
	@GetMapping("/HotPlace/search/page/tag/{btnCnt}/{word}")
	public ResponseEntity<Map<String, Object>> searchPageHotPlaceByTag(@PathVariable int btnCnt, @PathVariable String word) {
		PageBean pageBean = new PageBean(btnCnt, hotPageNum);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPageBean(pageBean);
		pageMaker.setWord(word);
		pageMaker.setStartPage(pageBean.getPage());
		pageMaker.setEndPage(pageMaker.getStartPage());
		List<HotPlace> list = service.searchPageHotPlaceByTag(pageMaker);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}

	@ApiOperation("더보기로 Hotplace 주소로 목록 조회")
	@GetMapping("/HotPlace/search/more/address/{btnCnt}/{word}")
	public ResponseEntity<Map<String, Object>> searchMoreHotPlaceByAddress(MorePageBean pageBean,
			@PathVariable int btnCnt, @PathVariable String word) {
		MorePageMaker pageMaker = new MorePageMaker();
		int change = pageNum * btnCnt;
		pageBean.setWord(word);
		pageBean.setPerPageNum(change);
		pageMaker.setPageBean(pageBean);
		List<Map<String, Object>> list = service.searchMoreHotPlaceByAddress(pageBean);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}
	@ApiOperation("페이지로 Hotplace 주소로 목록 조회")
	@GetMapping("/HotPlace/search/page/address/{btnCnt}/{word}")
	public ResponseEntity<Map<String, Object>> searchPageHotPlaceByAddress(@PathVariable int btnCnt, @PathVariable String word) {
		PageBean pageBean = new PageBean(btnCnt, hotPageNum);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPageBean(pageBean);
		pageMaker.setWord(word);
		pageMaker.setStartPage(pageBean.getPage());
		pageMaker.setEndPage(pageMaker.getStartPage());
		List<HotPlace> list = service.searchPageHotPlaceByAddress(pageMaker);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}

	
	@ApiOperation("더보기로 Hotplace 테마로 목록 조회")
	@GetMapping("/HotPlace/search/more/theme/{btnCnt}/{word}")
	public ResponseEntity<Map<String, Object>> searchMoreHotPlaceByTheme(MorePageBean pageBean, @PathVariable int btnCnt,
			@PathVariable String word) {
		MorePageMaker pageMaker = new MorePageMaker();
		int change = pageNum * btnCnt;
		List<String> selected_theme = new ArrayList<String>();
		st = new StringTokenizer(word);
		while(st.hasMoreTokens()) {selected_theme.add(st.nextToken());};
		
		pageBean.setPerPageNum(change);
		pageBean.setFilters(selected_theme);
		pageMaker.setPageBean(pageBean);
		
		List<Map<String, Object>> list = service.searchMoreHotPlaceByTheme(pageBean);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}
	@ApiOperation("페이지로 Hotplace 테마로 목록 조회")
	@GetMapping("/HotPlace/search/page/theme/{btnCnt}/{word}")
	public ResponseEntity<Map<String, Object>> searchPageHotPlaceByTheme(@PathVariable int btnCnt, @PathVariable String word) {
		PageBean pageBean = new PageBean(btnCnt, hotPageNum);
		PageMaker pageMaker = new PageMaker();
		List<String> selected_theme = new ArrayList<String>();
		st = new StringTokenizer(word);
		while(st.hasMoreTokens()) {selected_theme.add(st.nextToken());};
		
		pageMaker.setPageBean(pageBean);
		pageMaker.setFilters(selected_theme);
		pageMaker.setStartPage(pageBean.getPage());
		pageMaker.setEndPage(pageMaker.getStartPage());
		
		List<HotPlace> list = service.searchPageHotPlaceByTheme(pageMaker);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}
	@ApiOperation("더보기로 HotPlace 검색하기 조회 - searchOption은 all/ title / content/ tag city중 전달")
	@GetMapping("/HotPlace/search/more/{btnCnt}/{searchOption}/{word}")
	public ResponseEntity<Map<String, Object>> searchMoreHotPlace(MorePageBean pageBean, @PathVariable int btnCnt,
			@PathVariable String searchOption, @PathVariable String word) {
		MorePageMaker pageMaker = new MorePageMaker();
		int change = pageNum * btnCnt;
		searchOption = (searchOption == null)?"all":searchOption;
		word = (word == null || word == " ")?"":word;
		pageBean.setSearchOption(searchOption);
		pageBean.setWord(word);
		pageBean.setPerPageNum(change);
		pageMaker.setPageBean(pageBean);
		List<Map<String, Object>> list = service.searchMoreHotPlace(pageBean);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}
	@ApiOperation("페이지로  HotPlace 검색하기 조회 - searchOption은 all/ title / content/ tag /city중 전달")
	@GetMapping("/HotPlace/search/page/{btnCnt}/{searchOption}/{word}")
	public ResponseEntity<Map<String, Object>> searchPageHotPlace(@PathVariable int btnCnt,	@PathVariable String searchOption, @PathVariable String word) {
		PageBean pageBean = new PageBean(btnCnt, hotPageNum);
		PageMaker pageMaker = new PageMaker();
		searchOption = (searchOption == null || searchOption.equals("empty"))?"all":searchOption;
		word = (word == null || word.equals(" ") || word.equals("empty")) ?"''":word;
		pageMaker.setPageBean(pageBean);
		pageMaker.setSearchOption(searchOption);
		pageMaker.setWord(word);
		pageMaker.setStartPage(pageBean.getPage());
		pageMaker.setEndPage(pageMaker.getStartPage());
		List<HotPlace> list = service.searchPageHotPlace(pageMaker);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}
}

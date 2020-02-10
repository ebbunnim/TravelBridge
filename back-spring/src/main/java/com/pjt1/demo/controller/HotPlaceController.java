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

import com.pjt1.demo.model.dto.HotPlace;
import com.pjt1.demo.model.service.HotPlaceService;
import com.pjt1.demo.utils.MorePageBean;
import com.pjt1.demo.utils.MorePageMaker;
import com.pjt1.demo.utils.PerPageBean;
import com.pjt1.demo.utils.PerPageMaker;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
public class HotPlaceController {

	@Autowired
	private HotPlaceService service;

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
	public ResponseEntity<Map<String, Object>> search(int no) {
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
		int change = 3 * btnCnt;
		pageBean.setPerPageNum(change);
		pageMaker.setMorePageBean(pageBean);
		List<Map<String, Object>> list = service.searchMoreHotPlaceAll(pageBean);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}

	@ApiOperation("페이징된 Hotplace 전체 목록 조회")
	@GetMapping("/HotPlace/search/pageAll")
	public ResponseEntity<Map<String, Object>> searchPageHotPlaceAll(PerPageBean pageBean) {
		PerPageMaker pageMaker = new PerPageMaker();
		pageMaker.setPageBean(pageBean);
		pageMaker.setTotalCnt(service.getCountHotPlaceAll());
		List<Map<String, Object>> list = service.searchPageHotPlaceAll(pageBean);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}

	@ApiOperation("더보기로 Hotplace 도시이름으로 목록 조회")
	@GetMapping("/HotPlace/search/more/cityname/{btnCnt}/{keyword}")
	public ResponseEntity<Map<String, Object>> searchMoreHotPlaceByCityName(MorePageBean pageBean,
			@PathVariable int btnCnt, @PathVariable String keyword) {
		MorePageMaker pageMaker = new MorePageMaker();
		int change = 3 * btnCnt;
		pageBean.setKeyword(keyword);
		pageBean.setPerPageNum(change);
		pageMaker.setMorePageBean(pageBean);
		List<Map<String, Object>> list = service.searchMoreHotPlaceByCityName(pageBean);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}

	@ApiOperation("페이징된 Hotplace 도시이름으로 목록 조회")
	@GetMapping("/HotPlace/search/page/cityname/{keyword}")
	public ResponseEntity<Map<String, Object>> searchPageHotPlaceByCityName(PerPageBean pageBean,
			@PathVariable String keyword) {
		PerPageMaker pageMaker = new PerPageMaker();
		pageBean.setKeyword(keyword);
		pageMaker.setPageBean(pageBean);
		pageMaker.setTotalCnt(service.getCountHotPlaceByCityName(keyword));
		List<Map<String, Object>> list = service.searchPageHotPlaceByCityName(pageBean);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}

	@ApiOperation("더보기로 Hotplace 태그로 목록 조회")
	@GetMapping("/HotPlace/search/more/tag/{btnCnt}/{keyword}")
	public ResponseEntity<Map<String, Object>> searchMoreHotPlaceByTag(MorePageBean pageBean, @PathVariable int btnCnt,
			@PathVariable String keyword) {
		MorePageMaker pageMaker = new MorePageMaker();
		int change = 3 * btnCnt;
		pageBean.setKeyword(keyword);
		pageBean.setPerPageNum(change);
		pageMaker.setMorePageBean(pageBean);
		List<Map<String, Object>> list = service.searchMoreHotPlaceByTag(pageBean);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}

	@ApiOperation("페이징된 Hotplace 태그로 목록 조회")
	@GetMapping("/HotPlace/search/page/tag/{keyword}")
	public ResponseEntity<Map<String, Object>> searchPageHotPlaceByTag(PerPageBean pageBean,
			@PathVariable String keyword) {
		PerPageMaker pageMaker = new PerPageMaker();
		pageBean.setKeyword(keyword);
		pageMaker.setPageBean(pageBean);
		pageMaker.setTotalCnt(service.getCountHotPlaceByTag(keyword));
		List<Map<String, Object>> list = service.searchPageHotPlaceByTag(pageBean);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}

	@ApiOperation("더보기로 Hotplace 주소로 목록 조회")
	@GetMapping("/HotPlace/search/more/address/{btnCnt}/{keyword}")
	public ResponseEntity<Map<String, Object>> searchMoreHotPlaceByAddress(MorePageBean pageBean,
			@PathVariable int btnCnt, @PathVariable String keyword) {
		MorePageMaker pageMaker = new MorePageMaker();
		int change = 3 * btnCnt;
		pageBean.setKeyword(keyword);
		pageBean.setPerPageNum(change);
		pageMaker.setMorePageBean(pageBean);
		List<Map<String, Object>> list = service.searchMoreHotPlaceByAddress(pageBean);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}

	@ApiOperation("페이징된 Hotplace 주소로 목록 조회")
	@GetMapping("/HotPlace/search/page/address/{keyword}")
	public ResponseEntity<Map<String, Object>> searchPageHotPlaceByAddress(PerPageBean pageBean,
			@PathVariable String keyword) {
		PerPageMaker pageMaker = new PerPageMaker();
		pageBean.setKeyword(keyword);
		pageMaker.setPageBean(pageBean);
		pageMaker.setTotalCnt(service.getCountHotPlaceByAddress(keyword));
		List<Map<String, Object>> list = service.searchPageHotPlaceByAddress(pageBean);
		return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
	}
}

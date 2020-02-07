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

import com.pjt1.demo.model.dto.Festival;
import com.pjt1.demo.model.service.FestivalService;
import com.pjt1.demo.utils.MorePageBean;
import com.pjt1.demo.utils.MorePageMaker;
import com.pjt1.demo.utils.PerPageBean;
import com.pjt1.demo.utils.PerPageMaker;

import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
public class FestivalController{
	
    @Autowired
    private FestivalService service;
    
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
    public ResponseEntity<Map<String, Object>> search(int fval_no) {
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
        service.delete(fval_no);
        return handleSuccess("삭제 완료");
    }
	@ApiOperation("Festival 정보 수정")
    @PutMapping("/Festival/update")
    public ResponseEntity<Map<String, Object>> update(@RequestBody Festival Festival) {
        service.update(Festival);
        return handleSuccess("수정 완료");
    }
	 @ApiOperation("더보기로 Hotplace 전체 목록 조회")
		@GetMapping("/Festival/search/more/{btnCnt}")
		public ResponseEntity<Map<String, Object>> searchMoreFestivalAll(MorePageBean pageBean, @PathVariable int btnCnt) {
			MorePageMaker pageMaker = new MorePageMaker();
			int change = 3 * btnCnt;
			pageBean.setPerPageNum(change);
			pageMaker.setMorePageBean(pageBean);
			List<Map<String, Object>> list = service.searchMoreFestivalAll(pageBean);
			return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
		}

		@ApiOperation("페이징된 Hotplace 전체 목록 조회")
		@GetMapping("/Festival/search/pageAll")
		public ResponseEntity<Map<String, Object>> searchPageFestivalAll(PerPageBean pageBean) {
			PerPageMaker pageMaker = new PerPageMaker();
			pageMaker.setPageBean(pageBean);
			pageMaker.setTotalCnt(service.getCountFestivalAll());
			List<Map<String, Object>> list = service.searchPageFestivalAll(pageBean);
			return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
		}

		@ApiOperation("더보기로 Hotplace 도시이름으로 목록 조회")
		@GetMapping("/Festival/search/more/cityname/{btnCnt}/{keyword}")
		public ResponseEntity<Map<String, Object>> searchMoreFestivalByCityName(MorePageBean pageBean,
				@PathVariable int btnCnt, @PathVariable String keyword) {
			MorePageMaker pageMaker = new MorePageMaker();
			int change = 3 * btnCnt;
			pageBean.setKeyword(keyword);
			pageBean.setPerPageNum(change);
			pageMaker.setMorePageBean(pageBean);
			List<Map<String, Object>> list = service.searchMoreFestivalByCityName(pageBean);
			return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
		}

		@ApiOperation("페이징된 Hotplace 도시이름으로 목록 조회")
		@GetMapping("/Festival/search/page/cityname/{keyword}")
		public ResponseEntity<Map<String, Object>> searchPageFestivalByCityName(PerPageBean pageBean,
				@PathVariable String keyword) {
			PerPageMaker pageMaker = new PerPageMaker();
			pageBean.setKeyword(keyword);
			pageMaker.setPageBean(pageBean);
			pageMaker.setTotalCnt(service.getCountFestivalByCityName(keyword));
			List<Map<String, Object>> list = service.searchPageFestivalByCityName(pageBean);
			return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
		}

		@ApiOperation("더보기로 Hotplace 태그로 목록 조회")
		@GetMapping("/Festival/search/more/tag/{btnCnt}/{keyword}")
		public ResponseEntity<Map<String, Object>> searchMoreFestivalByTag(MorePageBean pageBean, @PathVariable int btnCnt,
				@PathVariable String keyword) {
			MorePageMaker pageMaker = new MorePageMaker();
			int change = 3 * btnCnt;
			pageBean.setKeyword(keyword);
			pageBean.setPerPageNum(change);
			pageMaker.setMorePageBean(pageBean);
			List<Map<String, Object>> list = service.searchMoreFestivalByTag(pageBean);
			return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
		}

		@ApiOperation("페이징된 Hotplace 태그로 목록 조회")
		@GetMapping("/Festival/search/page/tag/{keyword}")
		public ResponseEntity<Map<String, Object>> searchPageFestivalByTag(PerPageBean pageBean,
				@PathVariable String keyword) {
			PerPageMaker pageMaker = new PerPageMaker();
			pageBean.setKeyword(keyword);
			pageMaker.setPageBean(pageBean);
			pageMaker.setTotalCnt(service.getCountFestivalByTag(keyword));
			List<Map<String, Object>> list = service.searchPageFestivalByTag(pageBean);
			return list.size() == 0 ? handleSuccess("이 페이지에는 게시글이 존재하지 않습니다") : handleSuccess(list); // 일단 무조건 확인해야 하므로
		}
}

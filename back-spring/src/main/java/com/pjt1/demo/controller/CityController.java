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

import com.pjt1.demo.model.dto.City;
import com.pjt1.demo.model.dto.Ranking;
import com.pjt1.demo.model.service.CityService;
import com.pjt1.demo.model.service.RankingService;

import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
public class CityController{
	
    @Autowired
    private CityService service;
    @Autowired
    private RankingService r_service;
    
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
    @ApiOperation("전체 City 목록을 조회하는 기능")
    @GetMapping("/City")
    public ResponseEntity<Map<String, Object>> searchAll() {
        List<City> list = service.searchAll();
        return handleSuccess(list);
    }
    @ApiOperation("no에 따른 City 정보 조회하는 기능")
    @GetMapping("/City/{no}")
    public ResponseEntity<Map<String, Object>> search(@PathVariable int no) {
        City City = service.search(no);
        return handleSuccess(City);
    }
    @ApiOperation("City 정보 등록")
    @PostMapping("/City")
    public ResponseEntity<Map<String, Object>> insert(@RequestBody City City) {
        service.insert(City);
        return handleSuccess("");
    }
	@ApiOperation("City 정보 삭제")
    @DeleteMapping("/City/{no}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable int no) {
        service.delete(no);
        return handleSuccess("삭제 완료");
    }
	@ApiOperation("City 정보 수정")
    @PutMapping("/City")
    public ResponseEntity<Map<String, Object>> update(@RequestBody City City) {
        service.update(City);
        return handleSuccess("수정 완료");
    }
	@ApiOperation("전국 지역별 후기 개수랑 랭킹")
	@GetMapping("/Rank/national")
	public ResponseEntity<Map<String, Object>> searchNationalReviewsRank(){
		List<Ranking> list = r_service.searchNationalReviewsRank();
		System.out.println(list);
		return handleSuccess(list);
	}
	@ApiOperation("지역 후기 개수랑 랭킹")
	@GetMapping("/Rank/national/{city_name}")
	public ResponseEntity<Map<String, Object>> searchCityReviewsRank(@PathVariable String city_name){
		List<Ranking> list = r_service.searchCityReviewsRank(city_name);
		System.out.println(list);
		return handleSuccess(list);
	}
}

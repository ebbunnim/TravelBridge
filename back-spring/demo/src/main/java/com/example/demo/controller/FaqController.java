package com.example.demo.controller;

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

import com.example.demo.model.dto.Faq;
import com.example.demo.model.service.FaqService;

import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
public class FaqController{
	
    @Autowired
    private FaqService service;
    
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
    @ApiOperation("전체 Faq 목록을 조회하는 기능")
    @GetMapping("/Faq/search/all")
    public ResponseEntity<Map<String, Object>> searchAll() {
        List<Faq> list = service.searchAll();
        System.out.println("ASD");
        return handleSuccess(list);
    }
    @ApiOperation("no에 따른 Faq 정보 조회하는 기능")
    @GetMapping("/Faq/search/{faq_no}")
    public ResponseEntity<Map<String, Object>> search(@PathVariable int faq_no) {
        Faq Faq = service.search(faq_no);
        return handleSuccess(Faq);
    }
    @ApiOperation("Faq 정보 등록")
    @PostMapping("/Faq/insert")
    public ResponseEntity<Map<String, Object>> insert(@RequestBody Faq Faq) {
        service.insert(Faq);
        return handleSuccess("");
    }
	 @ApiOperation("Faq 정보 삭제")
    @DeleteMapping("/Faq/delete/{faq_no}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable int faq_no) {
        service.delete(faq_no);
        return handleSuccess("삭제 완료");
    }
	@ApiOperation("Faq 정보 수정")
    @PutMapping("/Faq/update")
    public ResponseEntity<Map<String, Object>> update(@RequestBody Faq Faq) {
        service.update(Faq);
        return handleSuccess("수정 완료");
    }
}

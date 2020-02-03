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

import com.pjt1.demo.model.dto.Blame;
import com.pjt1.demo.model.service.BlameService;

import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
public class BlameController{
	
    @Autowired
    private BlameService service;
    
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
    @ApiOperation("전체 Blame 목록을 조회하는 기능")
    @GetMapping("/Blame")
    public ResponseEntity<Map<String, Object>> searchAll() {
        List<Blame> list = service.searchAll();
        return handleSuccess(list);
    }
    @ApiOperation("no에 따른 Blame 정보 조회하는 기능")
    @GetMapping("/Blame/search/{no}")
    public ResponseEntity<Map<String, Object>> search(int no) {
        Blame Blame = service.search(no);
        return handleSuccess(Blame);
    }
    @PostMapping("/Blame/update")
    @ApiOperation("Blame 정보 등록")
    public ResponseEntity<Map<String, Object>> insert(@RequestBody Blame Blame) {
        service.insert(Blame);
        return handleSuccess("");
    }
	@ApiOperation("Blame 정보 삭제")
    @DeleteMapping("/Blame/delete/{no}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable int no) {
        service.delete(no);
        return handleSuccess("삭제 완료");
    }
	 @ApiOperation("Blame 정보 수정")
    @PutMapping("/Blame")
    public ResponseEntity<Map<String, Object>> update(@RequestBody Blame Blame) {
        service.update(Blame);
        return handleSuccess("수정 완료");
    }
}

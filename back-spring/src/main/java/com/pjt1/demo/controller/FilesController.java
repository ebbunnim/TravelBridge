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

import com.pjt1.demo.model.dto.Files;
import com.pjt1.demo.model.service.FilesService;

import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
public class FilesController{
	
    @Autowired
    private FilesService service;
    
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
    
    @ApiOperation("전체 Files 목록을 조회하는 기능")
    @GetMapping("/Files/searchAll")
    public ResponseEntity<Map<String, Object>> searchAll() {
        List<Files> list = service.searchAll();
        return handleSuccess(list);
    }
    @ApiOperation("no에 따른 Files 정보 조회하는 기능")
    @GetMapping("/Files/search/{no}")
    public ResponseEntity<Map<String, Object>> search(int no) {
        Files Files = service.search(no);
        return handleSuccess(Files);
    }
    @PostMapping("/Files/insert")
    @ApiOperation("Files 정보 등록")
    public ResponseEntity<Map<String, Object>> insert(@RequestBody Files Files) {
        service.insert(Files);
        return handleSuccess("");
    }
	 @ApiOperation("Files 정보 삭제")
    @DeleteMapping("/Files/delete/{no}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable int no) {
        service.delete(no);
        return handleSuccess("삭제 완료");
    }
	 @ApiOperation("Files 정보 수정")
    @PutMapping("/Files/update")
    public ResponseEntity<Map<String, Object>> update(@RequestBody Files Files) {
        service.update(Files);
        return handleSuccess("수정 완료");
    }
}

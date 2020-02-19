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
import com.pjt1.demo.model.dto.SubCourse;
import com.pjt1.demo.model.dto.Members;
import com.pjt1.demo.model.service.SubCourseService;
import com.pjt1.demo.model.service.PostService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
public class SubCourseController {

    @Autowired
    private SubCourseService service;

    @Autowired
    private PostService p_service;

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

    @ApiOperation("전체 SubCourse 목록을 조회하는 기능")
    @GetMapping("/SubCourse")
    public ResponseEntity<Map<String, Object>> searchAll() {
        List<SubCourse> list = service.searchAll();
        return handleSuccess(list);
    }

    @ApiOperation("no에 따른 Course 정보 조회하는 기능")
    @GetMapping("/SubCourse/{no}")
    public ResponseEntity<Map<String, Object>> search(@PathVariable int no) {
        SubCourse SubCourse = service.search(no);
        return handleSuccess(SubCourse);
    }

    @PostMapping("/SubCourse")
    @ApiOperation("SubCourse 정보 등록")
    public ResponseEntity<Map<String, Object>> insert(@RequestBody SubCourse SubCourse) {
        // Course가 들어오면 그 description은 내가 리스트로 만들어서 course_sub에 넣어야
        // String description = Course.getCourse_description();
        // System.out.println("====description===");
        // System.out.println(description);

        // String[] splitStr = description.split(" ");

        // List<String> list = new ArrayList<String>();
        // for (int i = 0; i < splitStr.length; i++) {
        // list.add(splitStr[i]);
        // }
        // System.out.println("====list===");
        // System.out.println(list);

        // Course.setCourse_sub(list);

        service.insert(SubCourse);
        return handleSuccess("");
    }

    @ApiOperation("SubCourse 정보 삭제")
    @DeleteMapping("/SubCourse/{no}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable int no) {
        service.delete(no);
        return handleSuccess("삭제 완료");
    }

    @ApiOperation("SubCourse 정보 수정")
    @PutMapping("/SubCourse")
    public ResponseEntity<Map<String, Object>> update(@RequestBody SubCourse SubCourse) {
        service.update(SubCourse);
        return handleSuccess("수정 완료");
    }

}

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

<<<<<<< HEAD:back-spring/src/main/java/com/pjt1/demo/controller/CourseController.java
import com.pjt1.demo.model.dto.Comment;
import com.pjt1.demo.model.dto.Course;
import com.pjt1.demo.model.dto.Members;
import com.pjt1.demo.model.service.CourseService;
import com.pjt1.demo.model.service.PostService;
=======
import com.pjt1.demo.model.dto.Party;
import com.pjt1.demo.model.service.PartyService;
>>>>>>> 6511ea245cbd2206eb958212e5fbf6cdd007d64c:back-spring/src/main/java/com/pjt1/demo/controller/PartyController.java

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
<<<<<<< HEAD:back-spring/src/main/java/com/pjt1/demo/controller/CourseController.java
public class CourseController {

    @Autowired
    private CourseService service;
    @Autowired
    private PostService p_service;
=======
public class PartyController {

    @Autowired
    private PartyService service;
>>>>>>> 6511ea245cbd2206eb958212e5fbf6cdd007d64c:back-spring/src/main/java/com/pjt1/demo/controller/PartyController.java

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

<<<<<<< HEAD:back-spring/src/main/java/com/pjt1/demo/controller/CourseController.java
    @ApiOperation("전체 Course 목록을 조회하는 기능")
    @GetMapping("/Course")
    public ResponseEntity<Map<String, Object>> searchAll() {
        List<Course> list = service.searchAll();
        return handleSuccess(list);
    }

    @ApiOperation("no에 따른 Course 정보 조회하는 기능")
    @GetMapping("/Course/{no}")
    public ResponseEntity<Map<String, Object>> search(int no) {
        Course Course = service.search(no);
        return handleSuccess(Course);
    }

    @PostMapping("/Course")
    @ApiOperation("Course 정보 등록")
    public ResponseEntity<Map<String, Object>> insert(@RequestBody Course Course) {
        service.insert(Course);
        return handleSuccess("");
    }

    @ApiOperation("Course 정보 삭제")
    @DeleteMapping("/Course/{no}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable int no) {
        service.delete(no);
        return handleSuccess("삭제 완료");
    }

    @ApiOperation("Course 정보 수정")
    @PutMapping("/Course")
    public ResponseEntity<Map<String, Object>> update(@RequestBody Course Course) {
        service.update(Course);
=======
    @ApiOperation("전체 Party 목록을 조회하는 기능")
    @GetMapping("/Party")
    public ResponseEntity<Map<String, Object>> searchAll() {
        List<Party> list = service.searchAll();
        return handleSuccess(list);
    }

    @ApiOperation("no에 따른 Party 정보 조회하는 기능")
    @GetMapping("/Party/{party_no}")
    public ResponseEntity<Map<String, Object>> search(@PathVariable int party_no) {
        Party party = service.search(party_no);
        return handleSuccess(party);
    }

    @PostMapping("/Party")
    @ApiOperation("Party 정보 등록")
    public ResponseEntity<Map<String, Object>> insert(@RequestBody Party party) {
        service.insert(party);
        return handleSuccess("");
    }

    @ApiOperation("Party 정보 삭제")
    @DeleteMapping("/Party/{party_no}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable int party_no) {
        service.delete(party_no);
        return handleSuccess("삭제 완료");
    }

    @ApiOperation("Party 정보 수정")
    @PutMapping("/Party")
    public ResponseEntity<Map<String, Object>> update(@RequestBody Party party) {
        service.update(party);
>>>>>>> 6511ea245cbd2206eb958212e5fbf6cdd007d64c:back-spring/src/main/java/com/pjt1/demo/controller/PartyController.java
        return handleSuccess("수정 완료");
    }
}

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

import com.pjt1.demo.model.dto.Members;
import com.pjt1.demo.model.dto.PartyIn;
import com.pjt1.demo.model.service.MembersService;
import com.pjt1.demo.model.service.PartyInService;
import com.pjt1.demo.model.service.PartyService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
public class PartyInController {

    @Autowired
    private PartyInService service;
    @Autowired
    private PartyService p_service;
    @Autowired
    private MembersService m_service;
    
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

    @ApiOperation("전체 PartyIn 목록을 조회하는 기능")
    @GetMapping("/PartyIn")
    public ResponseEntity<Map<String, Object>> searchAll() {
        List<PartyIn> list = service.searchAll();
        return handleSuccess(list);
    }

    @ApiOperation("no에 따른 PartyIn 정보 조회하는 기능")
    @GetMapping("/PartyIn/{partyin_no}")
    public ResponseEntity<Map<String, Object>> search(@PathVariable int partyin_no) {
        PartyIn partyin = service.search(partyin_no);
        return handleSuccess(partyin);
    }

    @PostMapping("/PartyIn")
    @ApiOperation("PartyIn 정보 등록. 멤버가 클릭시 해당번호가 담긴 PartyIn이 삽입(입력 시 회원번호만 필요)")
    public ResponseEntity<Map<String, Object>> insert(@RequestBody PartyIn partyin) {
		Members members = m_service.search(partyin.getMem_no());
	    partyin.setMem_name(members.getMem_name());
	    partyin.setMem_email(members.getMem_email());
	    partyin.setMem_phone(members.getMem_phone());
	    partyin.setMem_interest(members.getMem_interest());
	    service.insert(partyin);
	    // p_service.addPeople(partyin.getParty_no());
	    return handleSuccess("");
    }

    @ApiOperation("PartyIn 정보 삭제")
    @DeleteMapping("/PartyIn/{partyin_no}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable int partyin_no) {
        service.delete(partyin_no);
        return handleSuccess("삭제 완료");
    }

    @ApiOperation("Party 정보 수정")
    @PutMapping("/PartyIn")
    public ResponseEntity<Map<String, Object>> update(@RequestBody PartyIn partyin) {
        service.update(partyin);
        return handleSuccess("수정 완료");
    }
}

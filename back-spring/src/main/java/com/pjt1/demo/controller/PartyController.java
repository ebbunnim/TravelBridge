package com.pjt1.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.env.IModule.IService;
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

import com.pjt1.demo.model.dto.Party;
import com.pjt1.demo.model.dto.PartyIn;
import com.pjt1.demo.model.service.PartyInService;
import com.pjt1.demo.model.service.PartyService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
public class PartyController {

    @Autowired
    private PartyService service;
    @Autowired
    private PartyInService i_service;
    
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

    @ApiOperation("전체 Party 목록을 조회하는 기능")
    @GetMapping("/Party")
    public ResponseEntity<Map<String, Object>> searchAll() {
        List<Party> list = service.searchAll();
        for(Party p : list) {
        	p.setParty_inMemList(i_service.searchPartyList(p.getParty_no()));
        }
        return handleSuccess(list);
    }

    @ApiOperation("no에 따른 Party 정보 조회하는 기능")
    @GetMapping("/Party/{party_no}")
    public ResponseEntity<Map<String, Object>> search(@PathVariable int party_no) {
        Party party = service.search(party_no);
        try {
            party.setParty_inMemList(i_service.searchPartyList(party_no));
        } catch (Exception e) {
          e.printStackTrace();
        }
       
        return handleSuccess(party);
    }

    @PostMapping("/Party")
    @ApiOperation("Party 정보 등록")
    public ResponseEntity<Map<String, Object>> insert(@RequestBody Party party) {
        service.insert(party);
        PartyIn partyIn = new PartyIn();
        partyIn.setParty_no(party.getParty_no());
        partyIn.setMem_no(party.getHost_no());
        i_service.insert(partyIn);
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
        return handleSuccess("수정 완료");
    }
}

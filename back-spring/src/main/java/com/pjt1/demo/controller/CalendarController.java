package com.pjt1.demo.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.pjt1.demo.model.dto.Calendar;
import com.pjt1.demo.model.service.CalendarService;
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
import io.swagger.annotations.ApiOperation;
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
public class CalendarController {
    @Autowired
    private CalendarService service;
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
    @ApiOperation("전체 Calendar 목록을 조회하는 기능")
    @GetMapping("/Calendar")
    public ResponseEntity<Map<String, Object>> searchAll() {
        List<Calendar> list = service.searchAll();
        return handleSuccess(list);
    }
    // @ApiOperation("no에 따른 Board 정보 조회하는 기능")
    // @GetMapping("/Board/{board_no}")
    // public ResponseEntity<Map<String, Object>> search(int board_no) {
    // Board Board = service.search(board_no);
    // return handleSuccess(Board);
    // }
    @PostMapping("/Calendar")
    @ApiOperation("Calendar 정보 등록")
    public ResponseEntity<Map<String, Object>> insert(@RequestBody Calendar Calendar) {
        service.insert(Calendar);
        return handleSuccess("");
    }
    // @ApiOperation("Board 정보 삭제")
    // @DeleteMapping("/Calendar/{calendar_no}")
    // public ResponseEntity<Map<String, Object>> delete(@PathVariable int board_no)
    // {
    // service.delete(board_no);
    // return handleSuccess("삭제 완료");
    // }
    @ApiOperation("Calendar 정보 수정")
    @PutMapping("/Calendar")
    public ResponseEntity<Map<String, Object>> update(@RequestBody Calendar Calendar) {
        service.update(Calendar);
        return handleSuccess("Calendar 수정 완료");
    }
    @ApiOperation("mem_no으로 해당 유저가 가진 모든 일정 가져오기")
    @GetMapping("/Calendar/{mem_no}")
    public ResponseEntity<Map<String, Object>> searchCalendarByMem_no(@PathVariable int mem_no) {
        Calendar Calendar = service.searchCalendarByMem_no(mem_no);
        return handleSuccess(Calendar);
    }
}
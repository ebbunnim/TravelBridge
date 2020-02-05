package com.pjt1.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ImgurController {
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

    private String CLIENT_ID = ""; // 애플리케이션 클라이언트 아이디값";
    private String CLI_SECRET = ""; // 애플리케이션 클라이언트 시크릿값";
  
    //Autowired 할 것 있음?
    



    
}
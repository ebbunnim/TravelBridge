package com.pjt1.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// interceptor에서 전달될 예외를 처리할 restcontrolleradvisor
@RestControllerAdvice
public class GlobalRestExceptionHandler {
    @ExceptionHandler(value = { RuntimeException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> internalServerError(Exception e) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg", e.getMessage());
        return resultMap;
    }
}
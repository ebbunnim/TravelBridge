package com.pjt1.demo.model.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler)
            throws Exception {
        System.out.println("#######PREHANDLE######");
        System.out.println(request.getMethod() + " :" + request.getServletPath());

        // option으로 달고 온건 바로 통과시켜줌
        if (request.getMethod().equals("OPTIONS")) {
            System.out.println("option으로 달고 온건 바로 통과시켜줌");
            return true;
        } else {
            // request에서 auth_token으로 넘어온 것을 찾아본다.
            String token = request.getHeader("jwt-auth-token");
            System.out.println("######토큰 넘어오는지 일단 확인#####");
            System.out.println(token);


            // 유효한 토큰이면 진행
            System.out.println("@@@@@@@@JWT interceptor로 검증@@@@@@");
            if (token != null && token.length() > 0) {
                jwtService.checkValid(token);
                System.out.println("$$$$$유효한 토큰$$$$$$");

                return true;
            } else { // 유효하지 않을 때 예외 발생시킴
                throw new RuntimeException("cannot get token.");
            }
        }
    }
}
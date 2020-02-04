package com.pjt1.demo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.JsonNode;
import com.pjt1.demo.model.dto.Members;
import com.pjt1.demo.model.service.JwtService;
import com.pjt1.demo.model.service.MembersService;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
public class GoogleLoginService {

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



    /**
     * 콜백 페이지 컨트롤러
     * 
     * @param session
     * @param request
     * @param model
     * @return
     * @throws IOException
     * @throws ParseException
     * @throws URISyntaxException
     */

    @Autowired
    private JwtService jwtService;

    @Autowired
    private MembersService service;

    // 여기로 vue에서 던지면,이렇게 들어옴
    @ApiOperation("로그인")
    @PostMapping("/loginGoogle") // /user/login에서 바꿈
    // 일단 유저 이메일, 패스워드빼고는 requestbody로 받은 user를 쓰지 않으니까
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody Members members,HttpServletResponse response) throws URISyntaxException {
        System.out.println("----------------------------------------------------------------------pp");
        String email = members.getMem_email();
        String id = members.getMem_id();
        System.out.println("email"+email+"id"+id);
        Members checkSocialMembers = service.searchMemberByEmail(email);
        System.out.println(checkSocialMembers);
        System.out.println("#######DEBUG === check Social User == ####");
        System.out.println(checkSocialMembers);
        if (checkSocialMembers != null) {
            // 있는 유저라면 grant를 준다.
            int grant = checkSocialMembers.getMem_grant();
            System.out.println("#######start make token#######");
            Map<String, Object> resultMap = new HashMap<>();
            HttpStatus status = null;
            String token = jwtService.create(checkSocialMembers);
            System.out.println(token);

            // 토큰 정보를 request 헤더로 보내고 나머지는 Map에 담는다.
            response.setHeader("jwt-auth-token", token);
            // resultMap.put("jwt-auth-token", token);
            resultMap.put("data", checkSocialMembers);
            resultMap.put("status", true);
            status = HttpStatus.ACCEPTED;
            // jwt 토큰 생성하고 성공하면 success data에 넣어서 보낸다.e

            return new ResponseEntity<Map<String, Object>>(resultMap, status);


            // return new ResponseEntity<Map<String, Object>>(resultMap, status);

            } else {
                // 새로운 유저면 무조건 0에서 시작
                int grant = 0;
                Members socialUser = new Members();
                socialUser.setMem_email(email);
                socialUser.setMem_id(id);
                service.insert(socialUser);

                System.out.println("#######start make token#######");
                Map<String, Object> resultMap = new HashMap<>();
                HttpStatus status = null;
                String token = jwtService.create(checkSocialMembers);
                System.out.println(token);
    
                // 토큰 정보를 request 헤더로 보내고 나머지는 Map에 담는다.
                response.setHeader("jwt-auth-token", token);
                // resultMap.put("jwt-auth-token", token);
                resultMap.put("data", checkSocialMembers);
                resultMap.put("status", true);
                status = HttpStatus.ACCEPTED;
                // jwt 토큰 생성하고 성공하면 success data에 넣어서 보낸다.e
    
                return new ResponseEntity<Map<String, Object>>(resultMap, status);

            }
        }




    // @ApiOperation("구글로 로그인한 유저 정보 가져가기")
    // @RequestMapping("/loginGoogle")
    // // String -> responseEntity
    // public ResponseEntity<Object> googleCallback(HttpServletRequest request, HttpServletResponse response)
    //         throws IOException, ParseException, URISyntaxException {
    //     // vue에서 email, id라는 키워드로 파라미터를 넘긴다.
    //     System.out.println(request);
    //     String email = request.getParameter("user_email");
    //     String id = request.getParameter("user_id");
    //     System.out.println("email"+email+"id"+id);

    //     User checkSocialMembers = service.searchUserByEmail(email);
    //     System.out.println(checkSocialMembers);
    //     System.out.println("#######DEBUG === check Social User == ####");
    //     System.out.println(checkSocialUser);
    //     if (checkSocialUser != null) {
    //         // 있는 유저라면 grant를 준다.
    //         int grant = checkSocialUser.getUser_grant();
    //         System.out.println("#######start make token#######");
    //         Map<String, Object> resultMap = new HashMap<>();
    //         HttpStatus status = null;
    //         String token = jwtService.create(checkSocialUser);
    //         System.out.println(token);
    //         response.setHeader("jwt-auth-token", token);
    //         resultMap.put("data", checkSocialUser);
    //         resultMap.put("status", true);
    //         status = HttpStatus.ACCEPTED;
    //         //

    //         URI redirectUri = new URI("http://localhost:8080?email=" + email + "&grant=" + grant);
    //         HttpHeaders httpHeaders = new HttpHeaders();
    //         httpHeaders.setLocation(redirectUri);
    //         return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);

    //         // return new ResponseEntity<Map<String, Object>>(resultMap, status);

    //         } else {
    //             // 새로운 유저면 무조건 0에서 시작
    //             int grant = 0;
    //             User socialUser = new User();
    //             socialUser.setUser_email(email);
    //             socialUser.setUser_id(id);
    //             service.insertUser(socialUser);

    //             System.out.println("#######start make token#######");
    //             Map<String, Object> resultMap = new HashMap<>();
    //             HttpStatus status = null;
    //             String token = jwtService.create(socialUser);
    //             System.out.println(token);
    //             response.setHeader("jwt-auth-token", token);
    //             resultMap.put("data", socialUser);
    //             resultMap.put("status", true);

    //             // URI redirectUri = new URI("http://localhost:8080/?email"++);

    //             // public ResponseEntity<Object> logintest() throws URISyntaxException {
    //             // System.out.println("hello naver -----------------------------------------");
    //             // URI redirectUri = new URI("http://localhost:8080");
    //             // HttpHeaders httpHeaders = new HttpHeaders();
    //             // httpHeaders.setLocation(redirectUri);
    //             // return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    //             // }

    //             status = HttpStatus.ACCEPTED;

    //             URI redirectUri = new URI("http://localhost:8080?email=" + email + "&grant=" + grant);
    //             HttpHeaders httpHeaders = new HttpHeaders();
    //             httpHeaders.setLocation(redirectUri);
    //             return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    //             // return new ResponseEntity<Map<String, Object>>(resultMap, status);

    //         }
    //     }
    

  
    // private String requestToServer(String apiURL) throws IOException {
    //     return requestToServer(apiURL, "");
    // }

    // /**
    //  * 서버 통신 메소드
    //  * 
    //  * @param apiURL
    //  * @param headerStr
    //  * @return
    //  * @throws IOException
    //  */
    // private String requestToServer(String apiURL, String headerStr) throws IOException {
    //     URL url = new URL(apiURL);
    //     HttpURLConnection con = (HttpURLConnection) url.openConnection();
    //     con.setRequestMethod("GET");
    //     System.out.println("header Str: " + headerStr);
    //     // Authorization 헤더 : 인증토큰(jwt, Bearer etc) 서버로 보낼때 사용하는 헤더
    //     if (headerStr != null && !headerStr.equals("")) {
    //         con.setRequestProperty("Authorization", headerStr);
    //     }
    //     int responseCode = con.getResponseCode();
    //     BufferedReader br;
    //     System.out.println("responseCode=" + responseCode);
    //     if (responseCode == 200) { // 정상 호출
    //         br = new BufferedReader(new InputStreamReader(con.getInputStream()));
    //     } else { // 에러 발생
    //         br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
    //     }
    //     String inputLine;
    //     StringBuffer res = new StringBuffer();
    //     while ((inputLine = br.readLine()) != null) {
    //         res.append(inputLine);
    //     }
    //     br.close();
    //     if (responseCode == 200) {
    //         return res.toString();
    //     } else {
    //         return null;
    //     }
    // }

    public static String googleCallback() {
        return GoogleLoginService.googleCallback();

    }
}
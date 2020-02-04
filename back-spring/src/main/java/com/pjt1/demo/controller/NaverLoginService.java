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
import com.pjt1.demo.utils.NaverUserInfo;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

@Controller
public class NaverLoginService {

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

  private String CLIENT_ID = "_8CH4AlS9eXUFGHZ1bxe"; // 애플리케이션 클라이언트 아이디값";
  private String CLI_SECRET = "TJrKNi6FZB"; // 애플리케이션 클라이언트 시크릿값";

  // vue에서 localhost:8081/login으로 요청을 보냄
  // 이후 서버측에서 서버로 다시 redirect하는 post요청을 통해 토큰들을 발급한다.
  // 다 담은 토큰들은 프론트에서 상태유지 및 유저정보를 유지할 수 있도록 가지고 있는다.
  // 만약 accessToken을 잃어버렸다면 refresh Token으로 갱신해줘야 한다.

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
  @ApiOperation("네이버로 로그인한 유저 정보 가져가기")
  @RequestMapping("/loginNaver")
  // String -> responseEntity
  public ResponseEntity<Object> naverCallback(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ParseException, URISyntaxException {
    // 위에서 넘김 reqeust
    String code = request.getParameter("code");
    System.out.println("@@@@@@@@code#############");
    System.out.println(code);
    System.out.println("@@@@@@@@code#############");

    String state = request.getParameter("state");
    String redirectURI = URLEncoder.encode("http://localhost:8081/login", "UTF-8"); // 서버로 와야
    String apiURL;
    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
    apiURL += "client_id=" + CLIENT_ID;
    apiURL += "&client_secret=" + CLI_SECRET;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&code=" + code;
    apiURL += "&state=" + state;
    System.out.println("apiURL=" + apiURL);
    String res = requestToServer(apiURL);

    if (res != null && !res.equals("")) {
      Map<String, Object> parsedJson = new JSONParser(res).parseObject();
      System.out.println("##########parsedJson#########");
      System.out.println(parsedJson);
      System.out.println("##########parsedJson#########");
      String accessToken = (String) parsedJson.get("access_token");
      System.out.println("========accessToken=======");
      System.out.println(accessToken);
      System.out.println("========accessToken=======");

      JsonNode userInfo = NaverUserInfo.getNaverUserInfo(accessToken);
      System.out.println("@@@@@@@@@TODAY DEBUG@@@@@@@@@");
      // System.out.println(userInfo);
      JsonNode response1 = userInfo.path("response");
      System.out.println(response1);
      String id = response1.path("id").asText();
      String name = response1.path("name").asText();
      String email = response1.path("email").asText();
      System.out.println(email);

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
        response.setHeader("jwt-auth-token", token);
        resultMap.put("data", checkSocialMembers);
        resultMap.put("status", true);
        status = HttpStatus.ACCEPTED;
        //

        URI redirectUri = new URI("http://localhost:8080?email=" + email + "&grant=" + grant);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(redirectUri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);

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
        String token = jwtService.create(socialUser);
        System.out.println(token);
        response.setHeader("jwt-auth-token", token);
        resultMap.put("data", socialUser);
        resultMap.put("status", true);

        // URI redirectUri = new URI("http://localhost:8080/?email"++);

        // public ResponseEntity<Object> logintest() throws URISyntaxException {
        // System.out.println("hello naver -----------------------------------------");
        // URI redirectUri = new URI("http://localhost:8080");
        // HttpHeaders httpHeaders = new HttpHeaders();
        // httpHeaders.setLocation(redirectUri);
        // return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
        // }

        status = HttpStatus.ACCEPTED;

        URI redirectUri = new URI("http://localhost:8080?email=" + email + "&grant=" + grant);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(redirectUri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
        // return new ResponseEntity<Map<String, Object>>(resultMap, status);

      }
    }
    return null;

    // 네이버와 통신 후 res 실어옴
    // if (res != null && !res.equals("")) {
    // Map<String, Object> parsedJson = new JSONParser(res).parseObject();
    // System.out.println("##########parsedJson#########");
    // System.out.println(parsedJson);
    // System.out.println("##########parsedJson#########");

    // URI redirectUri = new URI("http://localhost:8080");
    // // requestToServer 활용해서 원하는 URL로 headerStr 값 보내는 것 활용하자
    // HttpHeaders httpHeaders = new HttpHeaders();
    // httpHeaders.add("access_token", (String) parsedJson.get("access_token"));
    // httpHeaders.add("refresh_token", (String) parsedJson.get("refresh_token"));
    // httpHeaders.setLocation(redirectUri);

    // System.out.println("##########Headers#########");
    // System.out.println(httpHeaders);
    // System.out.println("##########Headers#########");

    // return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);

    // } else {
    // // model.addAttribute("res", "Login failed!");
    // return null;
    // }
  }

  // 가정 : refresh Token을 새로 발급받을만큼 서비스를 길게 끌고 가지 않을것임.
  // 다만, 우리 DB에 refresh Token만 가지고 있는 형태라면 accessToken을 새롭게 발급받을 수 있는데 이걸 네이버와 어떻게
  // 처리할거냐의 문제

  // refreshToken은 내가 request요청에서 파라미터로 받아야 하는 것(request에서 getParameters하겠다.)
  @RequestMapping("/login/refreshToken")
  public ResponseEntity<Map<String, Object>> refreshToken(HttpSession session, HttpServletRequest request, Model model)
      throws IOException, ParseException {
    // vue에서 "refreshToken" 이름으로 넘겨받는다고 가정한다.
    String refreshToken = request.getParameter("refreshToken");
    System.out.println("refreshToken" + refreshToken);

    String apiURL;
    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=refresh_token&";
    apiURL += "client_id=" + CLIENT_ID;
    apiURL += "&client_secret=" + CLI_SECRET;
    apiURL += "&refresh_token=" + refreshToken;
    System.out.println("apiURL=" + apiURL);
    String res = requestToServer(apiURL);
    System.out.println("result of request Server = " + res);
    return handleSuccess(res);
  }

  // vue에서 요청하고 들어온 accessToken으로 유저정보를 가져온다. 받아서 프론트로 토스해야
  @ResponseBody
  @RequestMapping("/login/getProfile")
  public String getProfileFromNaver(HttpServletRequest request) throws IOException {
    // 네이버 로그인 접근 토큰;
    String accessToken = request.getParameter("accessToken");
    String apiURL = "https://openapi.naver.com/v1/nid/me";
    String headerStr = "Bearer " + accessToken; // Bearer 다음에 공백 추가
    String res = requestToServer(apiURL, headerStr);
    return res;
    // 이후에 res를 다시 프론트로 던져야 한다.
  }

  /**
   * 서버 통신 메소드
   * 
   * @param apiURL
   * @return
   * @throws IOException
   */
  private String requestToServer(String apiURL) throws IOException {
    return requestToServer(apiURL, "");
  }

  /**
   * 서버 통신 메소드
   * 
   * @param apiURL
   * @param headerStr
   * @return
   * @throws IOException
   */
  private String requestToServer(String apiURL, String headerStr) throws IOException {
    URL url = new URL(apiURL);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");
    System.out.println("header Str: " + headerStr);
    // Authorization 헤더 : 인증토큰(jwt, Bearer etc) 서버로 보낼때 사용하는 헤더
    if (headerStr != null && !headerStr.equals("")) {
      con.setRequestProperty("Authorization", headerStr);
    }
    int responseCode = con.getResponseCode();
    BufferedReader br;
    System.out.println("responseCode=" + responseCode);
    if (responseCode == 200) { // 정상 호출
      br = new BufferedReader(new InputStreamReader(con.getInputStream()));
    } else { // 에러 발생
      br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
    }
    String inputLine;
    StringBuffer res = new StringBuffer();
    while ((inputLine = br.readLine()) != null) {
      res.append(inputLine);
    }
    br.close();
    if (responseCode == 200) {
      return res.toString();
    } else {
      return null;
    }
  }

  public static String naverCallback() {
    return NaverLoginService.naverCallback();

  }
}
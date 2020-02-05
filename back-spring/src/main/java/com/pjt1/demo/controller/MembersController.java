package com.pjt1.demo.controller;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.pjt1.demo.model.service.JwtService;
import com.pjt1.demo.model.service.MembersService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
public class MembersController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private MembersService service;

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

    @ApiOperation("전체 Member 목록을 조회하는 기능")
    @GetMapping("/Members/searchAll")
    public ResponseEntity<Map<String, Object>> searchAll() {
        List<Members> list = service.searchAll();
        return handleSuccess(list);
    }

    @ApiOperation("no에 따른 Member 정보 조회하는 기능")
    @GetMapping("/Members/search/{mem_no}")
    public ResponseEntity<Map<String, Object>> search(int mem_no) {
        Members members = service.search(mem_no);
        return handleSuccess(members);
    }



    
    @ApiOperation("Member 조회(email에 따른)")
    @GetMapping("/Members/search/email/{mem_email}")
    public ResponseEntity<Map<String, Object>> searchMemberByEmail(@PathVariable String mem_email) {
        Members members = service.searchMemberByEmail(mem_email);
        return (members == null) ? handleFail("해당 멤버 조회 실패", HttpStatus.NOT_FOUND) : handleSuccess(members);
    }

    
    // @PostMapping("/Members/insert")
    // @ApiOperation("Member 정보 등록")
    // public ResponseEntity<Map<String, Object>> insert(@RequestBody Members members) {
    //     service.insert(members);
    //     return handleSuccess("");
    // }

    
    @ApiOperation("Member 정보 등록")
    @PostMapping("/Members/insert")
    public ResponseEntity<Map<String, Object>> insert(@RequestBody Members members) {
        // email 검증 (앞단에서도 하겠지만) // valid하지 않은 경우에는 handleFail을 리턴한다.
        if (!isValidEmail(members.getMem_email())) {
            return handleFail("잘못된 이메일 형식입니다.", HttpStatus.BAD_REQUEST);
        }
        // 중복 검증
        String email = members.getMem_email();
        Members checkMembers = service.searchMemberByEmail(email);
        if (checkMembers != null) {
            return handleFail("이미 존재하는 이메일입니다.", HttpStatus.BAD_REQUEST);
        }
        // pw 컬럼 버림
        service.insert(members);
        return handleSuccess("Member 등록 성공");
    }

    // 암호화 - 필요없음
    // public static String encrypt(String base) {
    //     try {
    //         MessageDigest digest = MessageDigest.getInstance("SHA-256");
    //         byte[] hash = digest.digest(base.getBytes("UTF-8"));
    //         StringBuffer hexString = new StringBuffer();

    //         for (int i = 0; i < hash.length; i++) {
    //             String hex = Integer.toHexString(0xff & hash[i]);
    //             if (hex.length() == 1)
    //                 hexString.append('0');
    //             hexString.append(hex);
    //         }
    //         // 출력
    //         return hexString.toString();

    //     } catch (Exception ex) {
    //         throw new RuntimeException(ex);
    //     }
    // };

    // 이메일 형식 검증
    public static boolean isValidEmail(String email) {
        boolean err = false;
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if (m.matches()) {
            err = true;
        }
        return err;
    }


    // @ApiOperation("Member 정보 수정")
    // @PutMapping("/Members/update")
    // public ResponseEntity<Map<String, Object>> update(@RequestBody Members members) {
    //     service.update(members);
    //     return handleSuccess("수정 완료");
    // }


    @ApiOperation("Member 정보 수정")
    @PutMapping("/Members/update")
    public ResponseEntity<Map<String, Object>> update(@RequestBody Members members) {
        service.update(members);
        return handleSuccess("User 정보 수정 완료");
    }

    // @ApiOperation("Members 정보 삭제")
    // @DeleteMapping("/Member/delete/{mem_no}")
    // public ResponseEntity<Map<String, Object>> delete(@PathVariable int mem_no) {
    //     service.delete(mem_no);
    //     return handleSuccess("삭제 완료");
    // }


    // email로 삭제로 바꿈
    @ApiOperation("Member 삭제")
    @DeleteMapping("/Members/delete/{mem_email}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable String mem_email) {
        Members members  = service.searchMemberByEmail(mem_email);
        service.delete(members.getMem_no());
        return (members.isMem_del_check() == false) ? handleSuccess("Member 삭제 완료")
                : handleFail("없는 회원입니다", HttpStatus.NOT_FOUND);
    }

    @ApiOperation("로그인")
    @PostMapping("/Members/login") // /user/login에서 바꿈
    public ResponseEntity<Map<String, Object>> loginMembers(@RequestBody Members members, HttpServletResponse res) {
        // String id = user.getUser_id();
        String email = members.getMem_email();
        // String pw = members.getMem_password();
        // System.out.println(email + pw);
        Members checkMembers = service.searchMemberByEmail(email);
        System.out.println("#######DEBUG === checkUser == ####");
        System.out.println(checkMembers);
        if (checkMembers != null) {
            // String check_password_inDB = checkMembers.getMem_password();
            // String check_password_inMembers = encrypt(pw);
            // if (check_password_inDB.equals(check_password_inMembers)) {
            System.out.println("#######start make token#######");

            Map<String, Object> resultMap = new HashMap<>();
            HttpStatus status = null;
            String token = jwtService.create(checkMembers);
            System.out.println(token);

            // 토큰 정보를 request 헤더로 보내고 나머지는 Map에 담는다.
            res.setHeader("jwt-auth-token", token);
            // resultMap.put("jwt-auth-token", token);
            resultMap.put("data", checkMembers);
            resultMap.put("status", true);
            status = HttpStatus.ACCEPTED;
            // jwt 토큰 생성하고 성공하면 success data에 넣어서 보낸다.e

            return new ResponseEntity<Map<String, Object>>(resultMap, status);

            } else {
                return handleFail("존재하지 않는 회원입니다.", HttpStatus.NOT_FOUND);
            } 
    }

    // 굳이 필요한가? 안필요하면 버리기
    @ApiOperation("jwtinfo 전달하는 api")
    @PostMapping("/api/jwtinfo")
    public ResponseEntity<Map<String, Object>> getInfo(HttpServletRequest req, @RequestBody Members members) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        try {
            // 토큰에 담긴 정보를 전달한다.
            resultMap.putAll(jwtService.get(req.getHeader("jwt-auth-token")));
            System.out.println(resultMap);
            resultMap.put("status", true);
            //members안나오면 members 꺼내올까?
            resultMap.put("request_body", members);
            status = HttpStatus.ACCEPTED;
        } catch (RuntimeException e) {
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }


}

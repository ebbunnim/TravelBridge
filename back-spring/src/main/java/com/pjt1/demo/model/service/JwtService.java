package com.pjt1.demo.model.service;

import java.util.Date;
import java.util.Map;

import com.pjt1.demo.model.dto.Members;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// component -> service test
@Component
public class JwtService {
    @Value("${jwt.salt}")
    private String salt;

    @Value("${jwt.expmin}")
    private Long expireMin;

    // 로그인 성공 시 사용자 정보 기반으로 jwt 생성해 반환한다.
    public String create(final Members members) {
        
        System.out.println("create jwt process start");
        final JwtBuilder builder = Jwts.builder();
        // jwt token = 1. header + 2. payload + 3. signagure
        // 1.
        System.out.println("11111create jwt process start");
        builder.setHeaderParam("typ", "JWT"); // 토큰 타입 고정
        // 2.
        System.out.println("22222create jwt process start");
        builder.setSubject("loginToken") // 토큰 name 설정
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * expireMin)).claim("Members", members)
                .claim("second", "Do you want insert more information?"); // 추가적 정보 설정
        // secret key를 이용한 암호화 과정
        System.out.println("333333create jwt process start");

        builder.signWith(SignatureAlgorithm.HS256, salt.getBytes());

        // 직렬화
        final String jwt = builder.compact();
        System.out.print(jwt);
        return jwt;
    }

    // 전달받은 토큰의 유효성 확인(문제 있다면 runtime 예외 발생)
    // 이 로직은 아래에 똑같이 있어서 필요없을 듯
    public void checkValid(final String jwt) {
        System.out.println("$$$$$$Check Validation or token$$$$$$$$");
        Jwts.parser().setSigningKey(salt.getBytes()).parseClaimsJws(jwt);
    }

    // jwt 토큰을 분석하고 필요한 정보를 반환함
    public Map<String, Object> get(final String jwt) {
        System.out.println("######Analyze token and bring out the info#####");
        Jws<Claims> claims = null;

        try {
            // check validation of token
            claims = Jwts.parser().setSigningKey(salt.getBytes()).parseClaimsJws(jwt);
        } catch (final Exception e) {
            throw new RuntimeException();
        }
        return claims.getBody();
    }
}
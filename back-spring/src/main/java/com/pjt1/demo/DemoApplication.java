package com.pjt1.demo;

import java.util.Arrays;

import com.pjt1.demo.model.service.JwtInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DemoApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private JwtInterceptor jwtInterceptor;

	// JWTInterceptor를 설치한다. (WebMvcConfigurer 상속받음 -> 이렇게 해도 되는지 보기)
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("addInterceptors를 거치는지 확인 ====================");
		registry.addInterceptor(jwtInterceptor).addPathPatterns("/api/**")
				.excludePathPatterns(Arrays.asList("/Members/**"));
		// 여기서 예외처리하는 곳이 더욱 크면 될 수 있나?
		// login하기 전에 수행할 수 있는 기능들(login, 회원가입, 비밀번호 찾기 등)은 인터셉터를 거치면 안되므로
		// excludePathPatterns에 선언해야
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*")
				.exposedHeaders("jwt-auth-token");

	}

}

package com.pjt1.demo.model.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Members implements Serializable {

	private static final long serialVersionUID = 8244898444448265876L;

	@Getter
	private int mem_no; // int PRIMARY KEY AUTO_INCREMENT, # 회원 관리번호
	@NonNull
	@Getter
	@Setter
	private String mem_id; // varchar( 50) NOT NULL UNIQUE, # 아이디
	@NonNull
	@Getter
	@Setter
	private String mem_email; // varchar(150) NOT NULL UNIQUE, # 이메일
	@NonNull
	@Getter
	@Setter
	private String mem_phone; // varchar( 50) NOT NULL UNIQUE, # 핸드폰번호
	@Getter
	@Setter
	private String mem_name; // varchar( 50), # 이름
	@Getter
	@Setter
	private int mem_sex; // int, # 성별 0: 남 1:여
	@Getter
	@Setter
	private String mem_birth; // date,(받아서 string으로 변환) # 생년월일
	@Getter
	@Setter
	private String mem_address; // varchar(300), # 주소
	@Getter
	@Setter
	private int mem_grant; // int DEFAULT 0 # 멤버 권한(0:방문자, 1:관리자, 2:팀원)
	@Getter
	@Setter
	private boolean mem_receive_email; // boolean DEFAULT TRUE, # 이메일 수신여부
	@Getter
	@Setter
	private int mem_following; // int DEFAULT 0, # 팔로잉 수
	@Getter
	@Setter
	private int mem_followed; // int DEFAULT 0, # 팔로우 수
	@Getter
	@Setter
	private String mem_lastlogin; // datetime DEFAULT NOW(), # 마지막 로그인 시간
	@Getter
	@Setter
	private String mem_regtime; // datetime DEFAULT NOW(), # 가입 시간
	@Getter
	@Setter
	private String mem_interest; // varchar(400), # 관심 카테고리들
	@Getter
	@Setter
	private String mem_token; // varchar(500) # 짧은 로그인처리 토큰 (front에서 자바스크립트 접근제한하는 secure 등 필요)
	@Getter
	@Setter
	private String mem_login_type; // varchar(10) # 소셜 로그인 종류 (0:기본, 1:구글, 2:네이버, 3:카카오)
	@Getter
	@Setter
	private boolean mem_del_check; // boolean DEFAULT FALSE # 삭제 여부
	@Getter
	@Setter
	private List<Post> mem_likePost;
	@Getter
	@Setter
	private List<HotPlace> mem_likeHotPlace;
	@Getter
	@Setter
	private List<Festival> mem_likeFestival;
	@Getter
	@Setter
	private List<Members> mem_followMe;
	@Getter
	@Setter
	private List<Members> mem_followList;
	@Getter
	@Setter
	private List<Post> mem_followPost;
	@Getter
	@Setter
	private List<Party> mem_partyList;	// 멤버가 들어간 파티 글. 여기서 번호 꺼내다 쓸것

}

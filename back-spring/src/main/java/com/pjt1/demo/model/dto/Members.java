package com.pjt1.demo.model.dto;

import java.io.Serializable;
import java.util.List;

public class Members implements Serializable {

	private static final long serialVersionUID = 8244898444448265876L;

	private int mem_no;// int PRIMARY KEY AUTO_INCREMENT, # 회원 관리번호
	private String mem_id;// varchar( 50) NOT NULL UNIQUE, # 아이디
	private String mem_email;// varchar(150) NOT NULL UNIQUE, # 이메일
	// private String mem_password;// varchar(500) NOT NULL , # 패스워드
	private String mem_phone;// varchar( 50) NOT NULL UNIQUE, # 핸드폰번호
	private String mem_name;// varchar( 50), # 이름
	private int mem_sex;// int, # 성별 0: 남 1:여
	private String mem_birth;// date,(받아서 string으로 변환) # 생년월일
	private String mem_address;// varchar(300), # 주소
	private int mem_grant;// int DEFAULT 0 # 멤버 권한(0:방문자, 1:관리자, 2:팀원)
	private boolean mem_receive_email;// boolean DEFAULT TRUE, # 이메일 수신여부
	private int mem_following;// int DEFAULT 0, # 팔로잉 수
	private int mem_followed;// int DEFAULT 0, # 팔로우 수
	private String mem_lastlogin;// datetime DEFAULT NOW(), # 마지막 로그인 시간
	private String mem_regtime;// datetime DEFAULT NOW(), # 가입 시간
	private String mem_interest;// varchar(400), # 관심 카테고리들
	private String mem_token;// varchar(500) # 짧은 로그인처리 토큰 (front에서 자바스크립트 접근제한하는 secure 등 필요)
	private String mem_login_type;// varchar(10) # 소셜 로그인 종류 (0:기본, 1:구글, 2:네이버, 3:카카오)
	private boolean mem_del_check;// boolean DEFAULT FALSE # 삭제 여부
	private List<Likes> mem_likeList;
	private List<Post> mem_likePost;
	
	public Members() {
		super();
	}

	public Members(String mem_id, String mem_email,  String mem_phone, String mem_name, int mem_sex,
			String mem_birth, String mem_address, boolean mem_receive_email, String mem_interest, String mem_token,
			String mem_login_type) {
		super();
		this.mem_id = mem_id;
		this.mem_email = mem_email;
		this.mem_phone = mem_phone;
		this.mem_name = mem_name;
		this.mem_sex = mem_sex;
		this.mem_birth = mem_birth;
		this.mem_address = mem_address;
		this.mem_receive_email = mem_receive_email;
		this.mem_interest = mem_interest;
		this.mem_token = mem_token;
		this.mem_login_type = mem_login_type;
	}

	public Members(int mem_no, String mem_id, String mem_email,String mem_phone, String mem_name,
			int mem_sex, String mem_birth, String mem_address, int mem_grant, boolean mem_receive_email,
			int mem_following, int mem_followed, String mem_lastlogin, String mem_regtime, String mem_interest,
			String mem_token, String mem_login_type, boolean mem_del_check) {
		super();
		this.mem_no = mem_no;
		this.mem_id = mem_id;
		this.mem_email = mem_email;
		this.mem_phone = mem_phone;
		this.mem_name = mem_name;
		this.mem_sex = mem_sex;
		this.mem_birth = mem_birth;
		this.mem_address = mem_address;
		this.mem_grant = mem_grant;
		this.mem_receive_email = mem_receive_email;
		this.mem_following = mem_following;
		this.mem_followed = mem_followed;
		this.mem_lastlogin = mem_lastlogin;
		this.mem_regtime = mem_regtime;
		this.mem_interest = mem_interest;
		this.mem_token = mem_token;
		this.mem_login_type = mem_login_type;
		this.mem_del_check = mem_del_check;
	}
	
	public Members(int mem_no, String mem_id, String mem_email, String mem_phone, String mem_name, int mem_sex,
			String mem_birth, String mem_address, int mem_grant, boolean mem_receive_email, int mem_following,
			int mem_followed, String mem_lastlogin, String mem_regtime, String mem_interest, String mem_token,
			String mem_login_type, boolean mem_del_check, List<Likes> mem_likeList, List<Post> mem_likePost) {
		super();
		this.mem_no = mem_no;
		this.mem_id = mem_id;
		this.mem_email = mem_email;
		this.mem_phone = mem_phone;
		this.mem_name = mem_name;
		this.mem_sex = mem_sex;
		this.mem_birth = mem_birth;
		this.mem_address = mem_address;
		this.mem_grant = mem_grant;
		this.mem_receive_email = mem_receive_email;
		this.mem_following = mem_following;
		this.mem_followed = mem_followed;
		this.mem_lastlogin = mem_lastlogin;
		this.mem_regtime = mem_regtime;
		this.mem_interest = mem_interest;
		this.mem_token = mem_token;
		this.mem_login_type = mem_login_type;
		this.mem_del_check = mem_del_check;
		this.mem_likeList = mem_likeList;
		this.mem_likePost = mem_likePost;
	}

	@Override
	public String toString() {
		return "Members [mem_no=" + mem_no + ", mem_id=" + mem_id + ", mem_email=" + mem_email + ", mem_phone="
				+ mem_phone + ", mem_name=" + mem_name + ", mem_sex=" + mem_sex + ", mem_birth=" + mem_birth
				+ ", mem_address=" + mem_address + ", mem_grant=" + mem_grant + ", mem_receive_email="
				+ mem_receive_email + ", mem_following=" + mem_following + ", mem_followed=" + mem_followed
				+ ", mem_lastlogin=" + mem_lastlogin + ", mem_regtime=" + mem_regtime + ", mem_interest=" + mem_interest
				+ ", mem_token=" + mem_token + ", mem_login_type=" + mem_login_type + ", mem_del_check=" + mem_del_check
				+ ", mem_likeList=" + mem_likeList + ", mem_likePost=" + mem_likePost + "]";
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_phone() {
		return mem_phone;
	}

	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public int getMem_sex() {
		return mem_sex;
	}

	public void setMem_sex(int mem_sex) {
		this.mem_sex = mem_sex;
	}

	public String getMem_birth() {
		return mem_birth;
	}

	public void setMem_birth(String mem_birth) {
		this.mem_birth = mem_birth;
	}

	public String getMem_address() {
		return mem_address;
	}

	public void setMem_address(String mem_address) {
		this.mem_address = mem_address;
	}

	public int getMem_grant() {
		return mem_grant;
	}

	public void setMem_grant(int mem_grant) {
		this.mem_grant = mem_grant;
	}

	public boolean isMem_receive_email() {
		return mem_receive_email;
	}

	public void setMem_receive_email(boolean mem_receive_email) {
		this.mem_receive_email = mem_receive_email;
	}

	public int getMem_following() {
		return mem_following;
	}

	public void setMem_following(int mem_following) {
		this.mem_following = mem_following;
	}

	public int getMem_followed() {
		return mem_followed;
	}

	public void setMem_followed(int mem_followed) {
		this.mem_followed = mem_followed;
	}

	public String getMem_lastlogin() {
		return mem_lastlogin;
	}

	public void setMem_lastlogin(String mem_lastlogin) {
		this.mem_lastlogin = mem_lastlogin;
	}

	public String getMem_regtime() {
		return mem_regtime;
	}

	public void setMem_regtime(String mem_regtime) {
		this.mem_regtime = mem_regtime;
	}

	public String getMem_interest() {
		return mem_interest;
	}

	public void setMem_interest(String mem_interest) {
		this.mem_interest = mem_interest;
	}

	public String getMem_token() {
		return mem_token;
	}

	public void setMem_token(String mem_token) {
		this.mem_token = mem_token;
	}

	public String getMem_login_type() {
		return mem_login_type;
	}

	public void setMem_login_type(String mem_login_type) {
		this.mem_login_type = mem_login_type;
	}

	public boolean isMem_del_check() {
		return mem_del_check;
	}

	public void setMem_del_check(boolean mem_del_check) {
		this.mem_del_check = mem_del_check;
	}

	public int getMem_no() {
		return mem_no;
	}

	public List<Post> getMem_likePost() {
		return mem_likePost;
	}

	public void setMem_likePost(List<Post> mem_likePost) {
		this.mem_likePost = mem_likePost;
	}

	public List<Likes> getMem_likeList() {
		return mem_likeList;
	}

	public void setMem_likeList(List<Likes> mem_likeList) {
		this.mem_likeList = mem_likeList;
	}

}
package com.pjt1.model.dto;

import java.io.Serializable;
//회원 테이블
public class Member implements Serializable {

	private static final long serialVersionUID = 8244898444448265876L;
	
	private int mem_no					;//int	PRIMARY KEY AUTO_INCREMENT,	# 회원 관리번호
	private String mem_id				;//varchar( 50) NOT NULL UNIQUE,		# 아이디
    private String mem_email			;//varchar(150) NOT NULL UNIQUE,		# 이메일
	private String mem_password			;//varchar(500) NOT NULL ,			# 패스워드
	private String mem_phone			;//varchar( 50) NOT NULL UNIQUE,		# 핸드폰번호
	private String mem_name				;//varchar( 50),						# 이름
	private int mem_sex					;//int,								# 성별 0: 남 1:여
	private String mem_birth			;//date,(받아서 string으로 변환)			# 생년월일
	private String mem_address			;//varchar(300),						# 주소
	private boolean mem_admin			;//boolean DEFAULT FALSE,			# 관리자권한
	private boolean mem_receive_email	;//boolean DEFAULT TRUE,				# 이메일 수신여부
	private int mem_following			;//int DEFAULT 0, 					# 팔로잉 수		
	private int mem_followed			;//int DEFAULT 0,					# 팔로우 수		
	private String mem_lastlogin		;//datetime DEFAULT NOW(),			# 마지막 로그인 시간		
	private String mem_regtime			;//datetime DEFAULT NOW(),			# 가입 시간
    private String mem_interest			;//varchar(400),						# 관심 카테고리들
    private boolean mem_del_check		;//boolean DEFAULT FALSE				# 삭제여부
    
    
	public Member() {
		super();
	}
	
	public Member(String mem_id, String mem_email, String mem_password, String mem_phone, String mem_name, int mem_sex,
			String mem_birth, String mem_address, boolean mem_admin, boolean mem_receive_email, int mem_following,
			int mem_followed, String mem_interest) {
		super();
		this.mem_id = mem_id;
		this.mem_email = mem_email;
		this.mem_password = mem_password;
		this.mem_phone = mem_phone;
		this.mem_name = mem_name;
		this.mem_sex = mem_sex;
		this.mem_birth = mem_birth;
		this.mem_address = mem_address;
		this.mem_admin = mem_admin;
		this.mem_receive_email = mem_receive_email;
		this.mem_following = mem_following;
		this.mem_followed = mem_followed;
		this.mem_interest = mem_interest;
	}

	public Member(int mem_no, String mem_id, String mem_email, String mem_password, String mem_phone, String mem_name,
			int mem_sex, String mem_birth, String mem_address, boolean mem_admin, boolean mem_receive_email,
			int mem_following, int mem_followed, String mem_lastlogin, String mem_regtime, String mem_interest,
			boolean mem_del_check) {
		super();
		this.mem_no = mem_no;
		this.mem_id = mem_id;
		this.mem_email = mem_email;
		this.mem_password = mem_password;
		this.mem_phone = mem_phone;
		this.mem_name = mem_name;
		this.mem_sex = mem_sex;
		this.mem_birth = mem_birth;
		this.mem_address = mem_address;
		this.mem_admin = mem_admin;
		this.mem_receive_email = mem_receive_email;
		this.mem_following = mem_following;
		this.mem_followed = mem_followed;
		this.mem_lastlogin = mem_lastlogin;
		this.mem_regtime = mem_regtime;
		this.mem_interest = mem_interest;
		this.mem_del_check = mem_del_check;
	}

	@Override
	public String toString() {
		return "Member [mem_no=" + mem_no + ", mem_id=" + mem_id + ", mem_email=" + mem_email + ", mem_password="
				+ mem_password + ", mem_phone=" + mem_phone + ", mem_name=" + mem_name + ", mem_sex=" + mem_sex
				+ ", mem_birth=" + mem_birth + ", mem_address=" + mem_address + ", mem_admin=" + mem_admin
				+ ", mem_receive_email=" + mem_receive_email + ", mem_following=" + mem_following + ", mem_followed="
				+ mem_followed + ", mem_lastlogin=" + mem_lastlogin + ", mem_regtime=" + mem_regtime + ", mem_interest="
				+ mem_interest + ", mem_del_check=" + mem_del_check + "]";
	}

	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
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
	public String getMem_password() {
		return mem_password;
	}
	public void setMem_password(String mem_password) {
		this.mem_password = mem_password;
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
	public boolean isMem_admin() {
		return mem_admin;
	}
	public void setMem_admin(boolean mem_admin) {
		this.mem_admin = mem_admin;
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
	public boolean isMem_del_check() {
		return mem_del_check;
	}
	public void setMem_del_check(boolean mem_del_check) {
		this.mem_del_check = mem_del_check;
	}


}
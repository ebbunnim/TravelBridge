package com.pjt1.demo.model.dto;

import java.io.Serializable;

/* 핫플 테이블
# 이름, 도시번호, 주소, 상세주소, List<이미지>, 
# 컨텐츠, 태그 + api(지도, 리뷰 등), 상세정보(홈페이지, 휴일, 요금, 기타) //운영시간은 거의 없어서 제외하고 기타로 대체
*/
public class HotPlace implements Serializable  {
	
	private static final long serialVersionUID = 5443973642661281888L;
	private int hp_no;// int NOT NULL KEY AUTO_INCREMENT,	# 핫플 관리번호
    private String hp_name;// varchar(200) NOT NULL,			# 핫플 이름
    private String hp_address;// varchar(200) NOT NULL,		# 핫플 주소 //ex) 서울 강남구
    private String hp_detail;//_adr varchar(500) NOT NULL,	# 핫플 상세주소
    private String hp_content;// varchar(3000) NOT NULL,		# 핫플 컨텐츠
    private String hp_tag;// varchar(1000) NOT NULL,			# 핫플 태그 (" "로 구분)
    private String hp_homepage;// varchar(500),				# 핫플 홈페이지
    private String hp_holiday;// varchar(200),				# 핫플 휴일
    private String hp_fee;// varchar(500),					# 핫플 요금
    private String hp_etc;// varchar(2000),					# 핫플 관련 기타사항
    private boolean hp_del_check;// boolean DEFAULT FALSE		# 핫플 삭제 여부
	public HotPlace() {
		super();
	}
	public HotPlace(String hp_name, String hp_address, String hp_detail, String hp_content, String hp_tag) {
		super();
		this.hp_name = hp_name;
		this.hp_address = hp_address;
		this.hp_detail = hp_detail;
		this.hp_content = hp_content;
		this.hp_tag = hp_tag;
	}
	public HotPlace(int hp_no, String hp_name, String hp_address, String hp_detail, String hp_content, String hp_tag,
			String hp_homepage, String hp_holiday, String hp_fee, String hp_etc, boolean hp_del_check) {
		super();
		this.hp_no = hp_no;
		this.hp_name = hp_name;
		this.hp_address = hp_address;
		this.hp_detail = hp_detail;
		this.hp_content = hp_content;
		this.hp_tag = hp_tag;
		this.hp_homepage = hp_homepage;
		this.hp_holiday = hp_holiday;
		this.hp_fee = hp_fee;
		this.hp_etc = hp_etc;
		this.hp_del_check = hp_del_check;
	}
	@Override
	public String toString() {
		return "HotPlace [hp_no=" + hp_no + ", hp_name=" + hp_name + ", hp_address=" + hp_address + ", hp_detail="
				+ hp_detail + ", hp_content=" + hp_content + ", hp_tag=" + hp_tag + ", hp_homepage=" + hp_homepage
				+ ", hp_holiday=" + hp_holiday + ", hp_fee=" + hp_fee + ", hp_etc=" + hp_etc + ", hp_del_check="
				+ hp_del_check + "]";
	}
	public String getHp_name() {
		return hp_name;
	}
	public void setHp_name(String hp_name) {
		this.hp_name = hp_name;
	}
	public String getHp_address() {
		return hp_address;
	}
	public void setHp_address(String hp_address) {
		this.hp_address = hp_address;
	}
	public String getHp_detail() {
		return hp_detail;
	}
	public void setHp_detail(String hp_detail) {
		this.hp_detail = hp_detail;
	}
	public String getHp_content() {
		return hp_content;
	}
	public void setHp_content(String hp_content) {
		this.hp_content = hp_content;
	}
	public String getHp_tag() {
		return hp_tag;
	}
	public void setHp_tag(String hp_tag) {
		this.hp_tag = hp_tag;
	}
	public String getHp_homepage() {
		return hp_homepage;
	}
	public void setHp_homepage(String hp_homepage) {
		this.hp_homepage = hp_homepage;
	}
	public String getHp_holiday() {
		return hp_holiday;
	}
	public void setHp_holiday(String hp_holiday) {
		this.hp_holiday = hp_holiday;
	}
	public String getHp_fee() {
		return hp_fee;
	}
	public void setHp_fee(String hp_fee) {
		this.hp_fee = hp_fee;
	}
	public String getHp_etc() {
		return hp_etc;
	}
	public void setHp_etc(String hp_etc) {
		this.hp_etc = hp_etc;
	}
	public boolean isHp_del_check() {
		return hp_del_check;
	}
	public void setHp_del_check(boolean hp_del_check) {
		this.hp_del_check = hp_del_check;
	}
	public int getHp_no() {
		return hp_no;
	}
    
    
}

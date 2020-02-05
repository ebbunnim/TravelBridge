package com.pjt1.demo.model.dto;

import java.io.Serializable;

/* 도시 테이블
# 국내/국외여부, 주소(서울 강남ㅇㅇ구), 이미지
*/
public class City implements Serializable  {
	
	private static final long serialVersionUID = -3618527702074684690L;
	private int city_no ;// int NOT NULL KEY AUTO_INCREMENT, # 도시 관리번호
    private String city_name; // varchar(200) NOT NULL,		 # 도시 이름
    private boolean city_is_overseas;// boolean NOT NULL,	 	 # 국내/해외 여부
    private String city_address; // varchar(500) NOT NULL, 	 # 도시 주소 //ex) 대한민국 서울시
    private String city_img; // varchar(500),					 # 도시 이미지
    private boolean city_del_check;// boolean DEFAULT FALSE	 # 도시 삭제 여부
	public City() {
		super();
	}
	public City(String city_name, boolean city_is_overseas, String city_address, String city_img) {
		super();
		this.city_name = city_name;
		this.city_is_overseas = city_is_overseas;
		this.city_address = city_address;
		this.city_img = city_img;
	}
	public City(int city_no, String city_name, boolean city_is_overseas, String city_address, String city_img,
			boolean city_del_check) {
		super();
		this.city_no = city_no;
		this.city_name = city_name;
		this.city_is_overseas = city_is_overseas;
		this.city_address = city_address;
		this.city_img = city_img;
		this.city_del_check = city_del_check;
	}
	@Override
	public String toString() {
		return "City [city_no=" + city_no + ", city_name=" + city_name + ", city_is_overseas=" + city_is_overseas
				+ ", city_address=" + city_address + ", city_img=" + city_img + ", city_del_check=" + city_del_check
				+ "]";
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public boolean isCity_is_overseas() {
		return city_is_overseas;
	}
	public void setCity_is_overseas(boolean city_is_overseas) {
		this.city_is_overseas = city_is_overseas;
	}
	public String getCity_address() {
		return city_address;
	}
	public void setCity_address(String city_address) {
		this.city_address = city_address;
	}
	public String getCity_img() {
		return city_img;
	}
	public void setCity_img(String city_img) {
		this.city_img = city_img;
	}
	public boolean isCity_del_check() {
		return city_del_check;
	}
	public void setCity_del_check(boolean city_del_check) {
		this.city_del_check = city_del_check;
	}
	public int getCity_no() {
		return city_no;
	}
	
}

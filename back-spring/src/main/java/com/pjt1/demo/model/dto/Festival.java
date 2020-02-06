package com.pjt1.demo.model.dto;

import java.io.Serializable;

public class Festival implements Serializable{
	private static final long serialVersionUID = 9144830003212943493L;
	private int fval_no 			;//int NOT NULL KEY AUTO_INCREMENT,
    private int city_no 			;//int NOT NULL,
    private String fval_name 		;//varchar(200) NOT NULL,
    private String fval_address 	;//varchar(500) NOT NULL,
    private String fval_img 		;//varchar(500),
    private String fval_content	 	;//varchar(3000) NOT NULL,
    private String fval_tag 		;//varchar(500),
    private String fval_start_day 	;//date,
    private String fval_end_day 		;//date,
    private int fval_fee 			;//int DEFAULT 0,
    private String fval_map_img 		;//varchar(500),
    private String fval_homepage 	;//varchar(300),
	private String fval_host 		;//varchar(200),
	private boolean fval_del_check  ;//fval_del_check boolean DEFAULT FALSE, # 축제 삭제 여부
//    FOREIGN KEY(clm_no) REFERENCES CITY_LAYER_MID(clm_no)
	public Festival() {
		super();
	}
	public Festival(int city_no, String fval_name, String fval_address, String fval_content, String fval_map_img) {
		super();
		this.city_no = city_no;
		this.fval_name = fval_name;
		this.fval_address = fval_address;
		this.fval_content = fval_content;
		this.fval_map_img = fval_map_img;
	}
	public Festival(int city_no, String fval_name, String fval_address, String fval_img, String fval_content,
			String fval_tag, String fval_start_day, String fval_end_day, int fval_fee, String fval_map_img,
			String fval_homepage, String fval_host) {
		super();
		this.city_no = city_no;
		this.fval_name = fval_name;
		this.fval_address = fval_address;
		this.fval_img = fval_img;
		this.fval_content = fval_content;
		this.fval_tag = fval_tag;
		this.fval_start_day = fval_start_day;
		this.fval_end_day = fval_end_day;
		this.fval_fee = fval_fee;
		this.fval_map_img = fval_map_img;
		this.fval_homepage = fval_homepage;
		this.fval_host = fval_host;
	}
	public Festival(int fval_no, int city_no, String fval_name, String fval_address, String fval_img, String fval_content,
			String fval_tag, String fval_start_day, String fval_end_day, int fval_fee, String fval_map_img,
			String fval_homepage, String fval_host, boolean fval_del_check) {
		super();
		this.fval_no = fval_no;
		this.city_no = city_no;
		this.fval_name = fval_name;
		this.fval_address = fval_address;
		this.fval_img = fval_img;
		this.fval_content = fval_content;
		this.fval_tag = fval_tag;
		this.fval_start_day = fval_start_day;
		this.fval_end_day = fval_end_day;
		this.fval_fee = fval_fee;
		this.fval_map_img = fval_map_img;
		this.fval_homepage = fval_homepage;
		this.fval_host = fval_host;
		this.fval_del_check = fval_del_check;
	}
	@Override
	public String toString() {
		return "Festival [fval_no=" + fval_no + ", city_no=" + city_no + ", fval_name=" + fval_name + ", fval_address="
				+ fval_address + ", fval_img=" + fval_img + ", fval_content=" + fval_content + ", fval_tag=" + fval_tag
				+ ", fval_start_day=" + fval_start_day + ", fval_end_day=" + fval_end_day + ", fval_fee=" + fval_fee
				+ ", fval_map_img=" + fval_map_img + ", fval_homepage=" + fval_homepage + ", fval_host=" + fval_host
				+ ", fval_del_check=" + fval_del_check + "]";
	}
	public int getCity_no() {
		return city_no;
	}
	public void setCity_no(int clm_no) {
		this.city_no = clm_no;
	}
	public String getFval_name() {
		return fval_name;
	}
	public void setFval_name(String fval_name) {
		this.fval_name = fval_name;
	}
	public String getFval_address() {
		return fval_address;
	}
	public void setFval_address(String fval_address) {
		this.fval_address = fval_address;
	}
	public String getFval_img() {
		return fval_img;
	}
	public void setFval_img(String fval_img) {
		this.fval_img = fval_img;
	}
	public String getFval_content() {
		return fval_content;
	}
	public void setFval_content(String fval_content) {
		this.fval_content = fval_content;
	}
	public String getFval_tag() {
		return fval_tag;
	}
	public void setFval_tag(String fval_tag) {
		this.fval_tag = fval_tag;
	}
	public String getFval_start_day() {
		return fval_start_day;
	}
	public void setFval_start_day(String fval_start_day) {
		this.fval_start_day = fval_start_day;
	}
	public String getFval_end_day() {
		return fval_end_day;
	}
	public void setFval_end_day(String fval_end_day) {
		this.fval_end_day = fval_end_day;
	}
	public int getFval_fee() {
		return fval_fee;
	}
	public void setFval_fee(int fval_fee) {
		this.fval_fee = fval_fee;
	}
	public String getFval_map_img() {
		return fval_map_img;
	}
	public void setFval_map_img(String fval_map_img) {
		this.fval_map_img = fval_map_img;
	}
	public String getFval_homepage() {
		return fval_homepage;
	}
	public void setFval_homepage(String fval_homepage) {
		this.fval_homepage = fval_homepage;
	}
	public String getFval_host() {
		return fval_host;
	}
	public void setFval_host(String fval_host) {
		this.fval_host = fval_host;
	}
	public boolean isFval_del_check() {
		return fval_del_check;
	}
	public void setFval_del_check(boolean fval_del_check) {
		this.fval_del_check = fval_del_check;
	}
	public int getFval_no() {
		return fval_no;
	}
	    
		
}

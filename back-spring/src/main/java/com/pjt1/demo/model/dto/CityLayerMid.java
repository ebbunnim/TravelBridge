package com.pjt1.demo.model.dto;

import java.io.Serializable;
public class CityLayerMid implements Serializable {
	private static final long serialVersionUID = -632952727324054590L;
	
	private int clm_no 								;//int NOT NULL KEY AUTO_INCREMENT,
    private int clt_no 					;//int NOT NULL,
    private String clm_name 		;//varchar(200) NOT NULL,
    private String clm_address 	;//varchar(500) NOT NULL,
    private String clm_img 					;//varchar(500),
    private String clm_content 	;//varchar(3000) NOT NULL,
    private int clm_type 			;//int NOT NULL,
    private String clm_character	;//varchar(500),
    private String clm_subtitle 	;//varchar(200),
    private boolean clm_del_check			;//clm_del_check boolean DEFAULT FALSE,			# 중도시 삭제여부
    
    
	public CityLayerMid() {
		super();
	}

	public CityLayerMid(int clt_no, String clm_name, String clm_address, String clm_img, String clm_content,
			int clm_type, String clm_character, String clm_subtitle) {
		super();
		this.clt_no = clt_no;
		this.clm_name = clm_name;
		this.clm_address = clm_address;
		this.clm_img = clm_img;
		this.clm_content = clm_content;
		this.clm_type = clm_type;
		this.clm_character = clm_character;
		this.clm_subtitle = clm_subtitle;
	}

	public CityLayerMid(int clm_no, int clt_no, String clm_name, String clm_address, String clm_img, String clm_content,
			int clm_type, String clm_character, String clm_subtitle, boolean clm_del_check) {
		super();
		this.clm_no = clm_no;
		this.clt_no = clt_no;
		this.clm_name = clm_name;
		this.clm_address = clm_address;
		this.clm_img = clm_img;
		this.clm_content = clm_content;
		this.clm_type = clm_type;
		this.clm_character = clm_character;
		this.clm_subtitle = clm_subtitle;
		this.clm_del_check = clm_del_check;
	}

	@Override
	public String toString() {
		return "CityLayerMid [clm_no=" + clm_no + ", clt_no=" + clt_no + ", clm_name=" + clm_name + ", clm_address="
				+ clm_address + ", clm_img=" + clm_img + ", clm_content=" + clm_content + ", clm_type=" + clm_type
				+ ", clm_character=" + clm_character + ", clm_subtitle=" + clm_subtitle + ", clm_del_check="
				+ clm_del_check + "]";
	}

	public int getClt_no() {
		return clt_no;
	}

	public void setClt_no(int clt_no) {
		this.clt_no = clt_no;
	}

	public String getClm_name() {
		return clm_name;
	}

	public void setClm_name(String clm_name) {
		this.clm_name = clm_name;
	}

	public String getClm_address() {
		return clm_address;
	}

	public void setClm_address(String clm_address) {
		this.clm_address = clm_address;
	}

	public String getClm_img() {
		return clm_img;
	}

	public void setClm_img(String clm_img) {
		this.clm_img = clm_img;
	}

	public String getClm_content() {
		return clm_content;
	}

	public void setClm_content(String clm_content) {
		this.clm_content = clm_content;
	}

	public int getClm_type() {
		return clm_type;
	}

	public void setClm_type(int clm_type) {
		this.clm_type = clm_type;
	}

	public String getClm_character() {
		return clm_character;
	}

	public void setClm_character(String clm_character) {
		this.clm_character = clm_character;
	}

	public String getClm_subtitle() {
		return clm_subtitle;
	}

	public void setClm_subtitle(String clm_subtitle) {
		this.clm_subtitle = clm_subtitle;
	}

	public boolean isClm_del_check() {
		return clm_del_check;
	}

	public void setClm_del_check(boolean clm_del_check) {
		this.clm_del_check = clm_del_check;
	}

	public int getClm_no() {
		return clm_no;
	}
    
    
}

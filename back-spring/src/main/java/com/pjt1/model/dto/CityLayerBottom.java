package com.pjt1.model.dto;

import java.io.Serializable;

public class CityLayerBottom implements Serializable {
	private static final long serialVersionUID = -852712683676470564L;
	private int clb_no 			;//int NOT NULL KEY AUTO_INCREMENT,
    private int clm_no 			;//int NOT NULL,
    private String clb_name 	;//varchar(200) NOT NULL,
    private String clb_address 	;//varchar(500) NOT NULL,
	private String clb_img		;//varchar(500),
    private String clb_content 	;//varchar(3000) NOT NULL,
    private String clb_tag 		;//varchar(500),
    private String clb_character;//varchar(500),
    private String clb_subtitle ;//varchar(200),
    private String clb_fun 		;//varchar(200),
    private String clb_spot 	;//varchar(500),
//	FOREIGN KEY(clm_no) REFERENCES CITY_LAYER_MID(clm_no)
    
    public CityLayerBottom() {
    	super();
    }
    public CityLayerBottom(int clm_no, String clb_name, String clb_address, String clb_img, String clb_content,
    		String clb_tag, String clb_character, String clb_subtitle, String clb_fun, String clb_spot) {
    	super();
    	this.clm_no = clm_no;
    	this.clb_name = clb_name;
    	this.clb_address = clb_address;
    	this.clb_img = clb_img;
    	this.clb_content = clb_content;
    	this.clb_tag = clb_tag;
    	this.clb_character = clb_character;
    	this.clb_subtitle = clb_subtitle;
    	this.clb_fun = clb_fun;
    	this.clb_spot = clb_spot;
    }
    public CityLayerBottom(int clb_no, int clm_no, String clb_name, String clb_address, String clb_img, String clb_content,
    		String clb_tag, String clb_character, String clb_subtitle, String clb_fun, String clb_spot) {
    	super();
    	this.clb_no = clb_no;
    	this.clm_no = clm_no;
    	this.clb_name = clb_name;
    	this.clb_address = clb_address;
    	this.clb_img = clb_img;
    	this.clb_content = clb_content;
    	this.clb_tag = clb_tag;
    	this.clb_character = clb_character;
    	this.clb_subtitle = clb_subtitle;
    	this.clb_fun = clb_fun;
    	this.clb_spot = clb_spot;
    }
	@Override
	public String toString() {
		return "CityLayerBottom [clb_no=" + clb_no + ", clm_no=" + clm_no + ", clb_name=" + clb_name + ", clb_address="
				+ clb_address + ", clb_img=" + clb_img + ", clb_content=" + clb_content + ", clb_tag=" + clb_tag
				+ ", clb_character=" + clb_character + ", clb_subtitle=" + clb_subtitle + ", clb_fun=" + clb_fun
				+ ", clb_spot=" + clb_spot + "]";
	}
	public int getClb_no() {
		return clb_no;
	}
	public void setClb_no(int clb_no) {
		this.clb_no = clb_no;
	}
	public int getClm_no() {
		return clm_no;
	}
	public void setClm_no(int clm_no) {
		this.clm_no = clm_no;
	}
	public String getClb_name() {
		return clb_name;
	}
	public void setClb_name(String clb_name) {
		this.clb_name = clb_name;
	}
	public String getClb_address() {
		return clb_address;
	}
	public void setClb_address(String clb_address) {
		this.clb_address = clb_address;
	}
	public String getClb_img() {
		return clb_img;
	}
	public void setClb_img(String clb_img) {
		this.clb_img = clb_img;
	}
	public String getClb_content() {
		return clb_content;
	}
	public void setClb_content(String clb_content) {
		this.clb_content = clb_content;
	}
	public String getClb_tag() {
		return clb_tag;
	}
	public void setClb_tag(String clb_tag) {
		this.clb_tag = clb_tag;
	}
	public String getClb_character() {
		return clb_character;
	}
	public void setClb_character(String clb_character) {
		this.clb_character = clb_character;
	}
	public String getClb_subtitle() {
		return clb_subtitle;
	}
	public void setClb_subtitle(String clb_subtitle) {
		this.clb_subtitle = clb_subtitle;
	}
	public String getClb_fun() {
		return clb_fun;
	}
	public void setClb_fun(String clb_fun) {
		this.clb_fun = clb_fun;
	}
	public String getClb_spot() {
		return clb_spot;
	}
	public void setClb_spot(String clb_spot) {
		this.clb_spot = clb_spot;
	}
    
}

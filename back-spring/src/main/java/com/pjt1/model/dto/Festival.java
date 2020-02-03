package com.pjt1.model.dto;

import java.io.Serializable;

public class Festival implements Serializable{
	private static final long serialVersionUID = 9144830003212943493L;
	private int fval_no 			;//int NOT NULL KEY AUTO_INCREMENT,
    private int clm_no 				;//int NOT NULL,
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
    public Festival(int clm_no, String fval_name, String fval_address, String fval_img, String fval_content,
    		String fval_tag, String fval_startday, String fval_endday, String fval_mapImg, String fval_homepage,
    		String fval_host) {
    	super();
    	this.clm_no = clm_no;
    	this.fval_name = fval_name;
    	this.fval_address = fval_address;
    	this.fval_img = fval_img;
    	this.fval_content = fval_content;
    	this.fval_tag = fval_tag;
    	this.fval_start_day = fval_startday;
    	this.fval_end_day = fval_endday;
    	this.fval_map_img = fval_mapImg;
    	this.fval_homepage = fval_homepage;
    	this.fval_host = fval_host;
    }
    public Festival(int fval_no, int clm_no, String fval_name, String fval_address, String fval_img, String fval_content,
    		String fval_tag, String fval_startday, String fval_endday, int fval_fee, String fval_mapImg,
    		String fval_homepage, String fval_host) {
    	super();
    	this.fval_no = fval_no;
    	this.clm_no = clm_no;
    	this.fval_name = fval_name;
    	this.fval_address = fval_address;
    	this.fval_img = fval_img;
    	this.fval_content = fval_content;
    	this.fval_tag = fval_tag;
    	this.fval_start_day = fval_startday;
    	this.fval_end_day = fval_endday;
    	this.fval_fee = fval_fee;
    	this.fval_map_img = fval_mapImg;
    	this.fval_homepage = fval_homepage;
    	this.fval_host = fval_host;
    }
    @Override
    public String toString() {
    	return "Festival [fval_no=" + fval_no + ", clm_no=" + clm_no + ", fval_name=" + fval_name + ", fval_address="
    			+ fval_address + ", fval_img=" + fval_img + ", fval_content=" + fval_content + ", fval_tag=" + fval_tag
    			+ ", fval_startday=" + fval_start_day + ", fval_endday=" + fval_end_day + ", fval_fee=" + fval_fee
    			+ ", fval_mapImg=" + fval_map_img + ", fval_homepage=" + fval_homepage + ", fval_host=" + fval_host
    			+ "]";
    }
    
	public int getFval_no() {
		return fval_no;
	}
	public void setFval_no(int fval_no) {
		this.fval_no = fval_no;
	}
	public int getClm_no() {
		return clm_no;
	}
	public void setClm_no(int clm_no) {
		this.clm_no = clm_no;
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
	public String getFval_startday() {
		return fval_start_day;
	}
	public void setFval_startday(String fval_startday) {
		this.fval_start_day = fval_startday;
	}
	public String getFval_endday() {
		return fval_end_day;
	}
	public void setFval_endday(String fval_endday) {
		this.fval_end_day = fval_endday;
	}
	public int getFval_fee() {
		return fval_fee;
	}
	public void setFval_fee(int fval_fee) {
		this.fval_fee = fval_fee;
	}
	public String getFval_mapImg() {
		return fval_map_img;
	}
	public void setFval_mapImg(String fval_mapImg) {
		this.fval_map_img = fval_mapImg;
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
    
    
}

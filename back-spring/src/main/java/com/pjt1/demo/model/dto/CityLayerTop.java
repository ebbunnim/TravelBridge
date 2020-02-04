package com.pjt1.demo.model.dto;

import java.io.Serializable;

public class CityLayerTop implements Serializable {
	private static final long serialVersionUID = -4600359104701183291L;
	private int clt_no;// int NOT NULL KEY AUTO_INCREMENT,
	private String clt_name;// varchar(200) NOT NULL,
	private String clt_address;// varchar(500) NOT NULL,
	private String clt_img;// varchar(500) ,
	private String clt_content;// varchar(3000) NOT NULL,
	private int clt_type;// int NOT NULL # EX) 서울광역시/경기도/섬/해외
	private boolean clt_del_check;// clt_del_check boolean DEFAULT FALSE # 대도시 삭제여부

	public CityLayerTop() {
		super();
	}

	public CityLayerTop(String clt_name, String clt_address, String clt_img, String clt_content, int clt_type) {
		super();
		this.clt_name = clt_name;
		this.clt_address = clt_address;
		this.clt_img = clt_img;
		this.clt_content = clt_content;
		this.clt_type = clt_type;
	}

	public CityLayerTop(int clt_no, String clt_name, String clt_address, String clt_img, String clt_content,
			int clt_type, boolean clt_del_check) {
		super();
		this.clt_no = clt_no;
		this.clt_name = clt_name;
		this.clt_address = clt_address;
		this.clt_img = clt_img;
		this.clt_content = clt_content;
		this.clt_type = clt_type;
		this.clt_del_check = clt_del_check;
	}

	@Override
	public String toString() {
		return "CityLayerTop [clt_no=" + clt_no + ", clt_name=" + clt_name + ",clt_address=" + clt_address
				+ ", clt_img=" + clt_img + ", clt_content=" + clt_content + ", clt_type=" + clt_type
				+ ", clt_del_check=" + clt_del_check + "]";
	}

	public String getClt_name() {
		return clt_name;
	}

	public void setClt_name(String clt_name) {
		this.clt_name = clt_name;
	}

	public String getClt_address() {
		return clt_address;
	}

	public void setClt_address(String clt_address) {
		this.clt_address = clt_address;
	}

	public String getClt_img() {
		return clt_img;
	}

	public void setClt_img(String clt_img) {
		this.clt_img = clt_img;
	}

	public String getClt_content() {
		return clt_content;
	}

	public void setClt_content(String clt_content) {
		this.clt_content = clt_content;
	}

	public int getClt_type() {
		return clt_type;
	}

	public void setClt_type(int clt_type) {
		this.clt_type = clt_type;
	}

	public boolean isClt_del_check() {
		return clt_del_check;
	}

	public void setClt_del_check(boolean clt_del_check) {
		this.clt_del_check = clt_del_check;
	}

	public int getClt_no() {
		return clt_no;
	}

}

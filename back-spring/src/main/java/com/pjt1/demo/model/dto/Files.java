package com.pjt1.demo.model.dto;

import java.io.Serializable;

//이미지 파일을 위한 테이블
public class Files implements Serializable {
	
	private static final long serialVersionUID = 5132788879683171995L;
	private int files_no 			;//int NOT NULL KEY AUTO_INCREMENT,
	private int post_no				;//int NOT NULL,
	private String files_name		;//varchar(200) NOT NULL,
	private boolean files_thumbnail ;//boolean,
	private String files_url 		;//varchar(500) NOT NULL, #PATH
	private Boolean files_del_check ;//DEFAULT FAlSE, 			# 파일 삭제 여부
//	FOREIGN KEY(post_no) REFERENCES POST(post_no)
	public Files() {
		super();
	}
	public Files(int post_no, String files_name, String files_url, boolean files_thumbnail) {
		super();
		this.post_no = post_no;
		this.files_name = files_name;
		this.files_thumbnail = files_thumbnail;
		this.files_url = files_url;
	}
	public Files(int files_no, int post_no, String files_name, boolean files_thumbnail, String files_url,
			Boolean files_del_check) {
		super();
		this.files_no = files_no;
		this.post_no = post_no;
		this.files_name = files_name;
		this.files_thumbnail = files_thumbnail;
		this.files_url = files_url;
		this.files_del_check = files_del_check;
	}
	@Override
	public String toString() {
		return "Files [files_no=" + files_no + ", post_no=" + post_no +", files_name="
				+ files_name + ", files_thumbnail=" + files_thumbnail + ", files_url=" + files_url + ", files_del_check="
				+ files_del_check + "]";
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getFiles_name() {
		return files_name;
	}
	public void setFiles_name(String files_name) {
		this.files_name = files_name;
	}
	public boolean isFiles_thumbnail() {
		return files_thumbnail;
	}
	public void setFiles_thumbnail(boolean files_thumbnail) {
		this.files_thumbnail = files_thumbnail;
	}
	public String getFiles_url() {
		return files_url;
	}
	public void setFiles_url(String files_url) {
		this.files_url = files_url;
	}
	public Boolean getFiles_del_check() {
		return files_del_check;
	}
	public void setFiles_del_check(Boolean files_del_check) {
		this.files_del_check = files_del_check;
	}
	public int getFiles_no() {
		return files_no;
	}
		
}
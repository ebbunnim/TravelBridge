package com.pjt1.demo.model.dto;

import java.io.Serializable;

/* 코스 테이블
# 후기 게시물에 추가되는 코스로 장소명과 간단한 설명에 대해서 작성 할 수 있고, 한 게시물에 여러개가 추가될 수 있다.
*/
public class Course implements Serializable  {
	private static final long serialVersionUID = -7114763220475884387L;
	private int course_no							;// int PRIMARY KEY AUTO_INCREMENT, # 후기에 갔던 장소들 번호 기본키, 자동증가
	private int post_no			;// int NOT NULL, # 참조하는 게시물 번호
	private String course_spot		;// varchar(1000), # 장소명들을 직접 받아서 스트링 형태로 저장 ,로 구분하자.
	private boolean course_del_check		;// boolean DEFAULT FALSE, # 삭제 여부
//	FOREIGN KEY(post_no) REFERENCES POST(post_no)
	
	
	public Course() {
		super();
	}
	
	public Course(int post_no, String course_spot) {
		super();
		this.post_no = post_no;
		this.course_spot = course_spot;
	}
	public Course(int course_no, int post_no, String course_spot, boolean course_del_check) {
		super();
		this.course_no = course_no;
		this.post_no = post_no;
		this.course_spot = course_spot;
		this.course_del_check = course_del_check;
	}

	@Override
	public String toString() {
		return "Course [course_no=" + course_no + ", post_no=" + post_no + ", course_spot=" + course_spot
				+ ", course_del_check=" + course_del_check + "]";
	}

	public int getPost_no() {
		return post_no;
	}

	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}

	public String getCourse_spot() {
		return course_spot;
	}

	public void setCourse_spot(String course_spot) {
		this.course_spot = course_spot;
	}

	public boolean isCourse_del_check() {
		return course_del_check;
	}

	public void setCourse_del_check(boolean course_del_check) {
		this.course_del_check = course_del_check;
	}

	public int getCourse_no() {
		return course_no;
	}
	
	
		
}

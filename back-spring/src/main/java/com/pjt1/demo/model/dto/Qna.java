package com.pjt1.demo.model.dto;

import java.io.Serializable;
// Q&A 테이블

public class Qna implements Serializable {

	private static final long serialVersionUID = -2029554586934457509L;
	private int qna_no						;//int PRIMARY KEY AUTO_INCREMENT,	# Q&A 관리번호	기본키, 자동증가
	private int mem_no		;//int NOT NULL,	# 질문한 회원 번호	외래키
	private String qna_category		;//varchar(200)
	private String qna_title		;//varchar(200),	# Q&A 질문 제목	
	private String qna_content		;//varchar(3000),	# Q&A 질문 내용
	private String qna_answer		;//varchar(3000)
	private String qna_regtime		;//datetime DEFAULT NOW(),		# 등록 시간	
	private boolean qna_del_check	;//boolean DEFAULT FALSE,
//    FOREIGN KEY(mem_no) REFERENCES MEMBER(mem_no)
	public Qna() {
		super();
	}

	public Qna(int mem_no, String qna_category, String qna_title, String qna_content, String qna_answer) {
	super();
	this.mem_no = mem_no;
	this.qna_category = qna_category;
	this.qna_title = qna_title;
	this.qna_content = qna_content;
	this.qna_answer = qna_answer;
}

	public Qna(int qna_no, int mem_no, String qna_category, String qna_title, String qna_content, String qna_answer,
		String qna_regtime, boolean qna_del_check) {
		super();
		this.qna_no = qna_no;
		this.mem_no = mem_no;
		this.qna_category = qna_category;
		this.qna_title = qna_title;
		this.qna_content = qna_content;
		this.qna_answer = qna_answer;
		this.qna_regtime = qna_regtime;
		this.qna_del_check = qna_del_check;
	}

	@Override
	public String toString() {
		return "Qna [qna_no=" + qna_no + ", mem_no=" + mem_no + ", qna_category=" + qna_category + ", qna_title="
				+ qna_title + ", qna_content=" + qna_content + ", qna_answer=" + qna_answer + ", qna_regtime="
				+ qna_regtime + ", qna_del_check=" + qna_del_check + "]";
	}

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public String getQna_category() {
		return qna_category;
	}

	public void setQna_category(String qna_category) {
		this.qna_category = qna_category;
	}

	public String getQna_title() {
		return qna_title;
	}

	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}

	public String getQna_content() {
		return qna_content;
	}

	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}

	public String getQna_answer() {
		return qna_answer;
	}

	public void setQna_answer(String qna_answer) {
		this.qna_answer = qna_answer;
	}

	public String getQna_regtime() {
		return qna_regtime;
	}

	public void setQna_regtime(String qna_regtime) {
		this.qna_regtime = qna_regtime;
	}

	public boolean isQna_del_check() {
		return qna_del_check;
	}

	public void setQna_del_check(boolean qna_del_check) {
		this.qna_del_check = qna_del_check;
	}

	public int getQna_no() {
		return qna_no;
	}
	
		
}
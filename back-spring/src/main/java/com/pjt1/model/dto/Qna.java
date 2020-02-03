package com.pjt1.model.dto;

import java.io.Serializable;
import java.util.Objects;
// Q&A 테이블
public class Qna implements Serializable {

	private static final long serialVersionUID = -2029554586934457509L;
	private int qna_no				;//int PRIMARY KEY AUTO_INCREMENT,	# Q&A 관리번호	기본키, 자동증가
	private int mem_no				;//int NOT NULL,	# 질문한 회원 번호	외래키
	private String qna_title		;//varchar(200),	# Q&A 질문 제목	
	private String qna_content		;//varchar(3000),	# Q&A 질문 내용	
	private int qna_hits			;//int DEFAULT 0,	# 조회수	
	private String qna_regtime		;//datetime DEFAULT NOW(),		# 등록 시간	
	private boolean qna_secret		;//boolean DEFAULT FALSE,		# 비밀 게시글 여부
	private boolean qna_del_check	;//boolean DEFAULT FALSE,
//    FOREIGN KEY(mem_no) REFERENCES MEMBER(mem_no)

	public Qna() {
		super();
	}

	public Qna(int mem_no, String qna_title, String qna_content, boolean qna_secret) {
		super();
		this.mem_no = mem_no;
		this.qna_title = qna_title;
		this.qna_content = qna_content;
		this.qna_secret = qna_secret;
	}
	public Qna(int qna_no, int mem_no, String qna_title, String qna_content, int qna_hits, String qna_regtime,
		boolean qna_secret, boolean qna_del_check) {
		super();
		this.qna_no = qna_no;
		this.mem_no = mem_no;
		this.qna_title = qna_title;
		this.qna_content = qna_content;
		this.qna_hits = qna_hits;
		this.qna_regtime = qna_regtime;
		this.qna_secret = qna_secret;
		this.qna_del_check = qna_del_check;
	}
	@Override
	public String toString() {
		return "Qna [qna_no=" + qna_no + ", mem_no=" + mem_no + ", qna_title=" + qna_title + ", qna_content="
				+ qna_content + ", qna_hits=" + qna_hits + ", qna_regtime=" + qna_regtime + ", qna_secret=" + qna_secret
				+ ", qna_del_check=" + qna_del_check + "]";
	}

	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
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
	public int getQna_hits() {
		return qna_hits;
	}
	public void setQna_hits(int qna_hits) {
		this.qna_hits = qna_hits;
	}
	public String getQna_regtime() {
		return qna_regtime;
	}
	public void setQna_regtime(String qna_regtime) {
		this.qna_regtime = qna_regtime;
	}
	public boolean isQna_secret() {
		return qna_secret;
	}
	public void setQna_secret(boolean qna_secret) {
		this.qna_secret = qna_secret;
	}
	public boolean isQna_del_check() {
		return qna_del_check;
	}
	public void setQna_del_check(boolean qna_del_check) {
		this.qna_del_check = qna_del_check;
	}
	
	
	
}
package com.pjt1.model.dto;

import java.io.Serializable;
import java.util.Objects;
// FAQ 테이블
public class Faq implements Serializable {
	private static final long serialVersionUID = 1214365622536623852L;
	private int faq_no				;//int PRIMARY KEY AUTO_INCREMENT,		# 자주하는 질문 관리번호	기본키, 자동증가
	private String faq_title		;//varchar(200),			# 질문 제목	
	private String faq_content		;//varchar(3000),			# 질문 내용	
	private String faq_answer		;//varchar(3000),			# 답변 내용	
	private int faq_hits			;//int DEFAULT 0,			# 조회 수	
	private String faq_regtime		;//datetime DEFAULT NOW(),	# 등록 시간	
    private boolean faq_del_check 	;//boolean DEFAULT FALSE
    
	public Faq() {
		super();
	}
	
	public Faq(String faq_title, String faq_content, String faq_answer) {
		super();
		this.faq_title = faq_title;
		this.faq_content = faq_content;
		this.faq_answer = faq_answer;
	}

	public Faq(int faq_no, String faq_title, String faq_content, String faq_answer, int faq_hits, String faq_regtime,
			boolean faq_del_check) {
		super();
		this.faq_no = faq_no;
		this.faq_title = faq_title;
		this.faq_content = faq_content;
		this.faq_answer = faq_answer;
		this.faq_hits = faq_hits;
		this.faq_regtime = faq_regtime;
		this.faq_del_check = faq_del_check;
	}
	
	@Override
	public String toString() {
		return "Faq [faq_no=" + faq_no + ", faq_title=" + faq_title + ", faq_content=" + faq_content + ", faq_answer="
				+ faq_answer + ", faq_hits=" + faq_hits + ", faq_regtime=" + faq_regtime + ", faq_del_check="
				+ faq_del_check + "]";
	}

	public int getFaq_no() {
		return faq_no;
	}
	public void setFaq_no(int faq_no) {
		this.faq_no = faq_no;
	}
	public String getFaq_title() {
		return faq_title;
	}
	public void setFaq_title(String faq_title) {
		this.faq_title = faq_title;
	}
	public String getFaq_content() {
		return faq_content;
	}
	public void setFaq_content(String faq_content) {
		this.faq_content = faq_content;
	}
	public String getFaq_answer() {
		return faq_answer;
	}
	public void setFaq_answer(String faq_answer) {
		this.faq_answer = faq_answer;
	}
	public int getFaq_hits() {
		return faq_hits;
	}
	public void setFaq_hits(int faq_hits) {
		this.faq_hits = faq_hits;
	}
	public String getFaq_regtime() {
		return faq_regtime;
	}
	public void setFaq_regtime(String faq_regtime) {
		this.faq_regtime = faq_regtime;
	}
	public boolean isFaq_del_check() {
		return faq_del_check;
	}
	public void setFaq_del_check(boolean faq_del_check) {
		this.faq_del_check = faq_del_check;
	}
    
    
}
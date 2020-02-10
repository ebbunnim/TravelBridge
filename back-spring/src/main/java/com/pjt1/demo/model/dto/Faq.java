package com.pjt1.demo.model.dto;

import java.io.Serializable;

public class Faq implements Serializable {
	private static final long serialVersionUID = 1214365622536623852L;
	private int faq_no								;//int PRIMARY KEY AUTO_INCREMENT,			# 자주하는 질문 관리번호	기본키, 자동증가
	private String faq_category	;	//varchar(200),			# 질문 카테고리	
	private String faq_question		;//varchar(200),			# 질문 제목	
	private String faq_answer		;//varchar(3000),			# 답변 내용	
	private String faq_regtime				;//datetime DEFAULT NOW(),	# 등록 시간	
    private boolean faq_del_check 					;

    
    public Faq() {
		super();
	}


	public Faq(String faq_category, String faq_question, String faq_answer) {
		super();
		this.faq_category = faq_category;
		this.faq_question = faq_question;
		this.faq_answer = faq_answer;
	}


	public Faq(int faq_no, String faq_category, String faq_question, String faq_answer, String faq_regtime,
			boolean faq_del_check) {
		super();
		this.faq_no = faq_no;
		this.faq_category = faq_category;
		this.faq_question = faq_question;
		this.faq_answer = faq_answer;
		this.faq_regtime = faq_regtime;
		this.faq_del_check = faq_del_check;
	}


	@Override
	public String toString() {
		return "Faq [faq_no=" + faq_no + ", faq_category=" + faq_category + ", faq_question=" + faq_question
				+ ", faq_answer=" + faq_answer + ", faq_regtime=" + faq_regtime + ", faq_del_check=" + faq_del_check
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((faq_answer == null) ? 0 : faq_answer.hashCode());
		result = prime * result + ((faq_category == null) ? 0 : faq_category.hashCode());
		result = prime * result + (faq_del_check ? 1231 : 1237);
		result = prime * result + faq_no;
		result = prime * result + ((faq_question == null) ? 0 : faq_question.hashCode());
		result = prime * result + ((faq_regtime == null) ? 0 : faq_regtime.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faq other = (Faq) obj;
		if (faq_answer == null) {
			if (other.faq_answer != null)
				return false;
		} else if (!faq_answer.equals(other.faq_answer))
			return false;
		if (faq_category == null) {
			if (other.faq_category != null)
				return false;
		} else if (!faq_category.equals(other.faq_category))
			return false;
		if (faq_del_check != other.faq_del_check)
			return false;
		if (faq_no != other.faq_no)
			return false;
		if (faq_question == null) {
			if (other.faq_question != null)
				return false;
		} else if (!faq_question.equals(other.faq_question))
			return false;
		if (faq_regtime == null) {
			if (other.faq_regtime != null)
				return false;
		} else if (!faq_regtime.equals(other.faq_regtime))
			return false;
		return true;
	}


	public String getFaq_category() {
		return faq_category;
	}


	public void setFaq_category(String faq_category) {
		this.faq_category = faq_category;
	}


	public String getFaq_question() {
		return faq_question;
	}


	public void setFaq_question(String faq_question) {
		this.faq_question = faq_question;
	}


	public String getFaq_answer() {
		return faq_answer;
	}


	public void setFaq_answer(String faq_answer) {
		this.faq_answer = faq_answer;
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


	public int getFaq_no() {
		return faq_no;
	}
    
	
    
}
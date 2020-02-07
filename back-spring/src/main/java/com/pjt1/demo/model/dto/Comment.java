package com.pjt1.demo.model.dto;

import java.io.Serializable;

//댓글 테이블
public class Comment implements Serializable {

	private static final long serialVersionUID = -1148288769220271764L;
	private int cmt_no;// int PRIMARY KEY AUTO_INCREMENT, # 댓글 관리번호 기본키, 자동증가
	private int post_no;// int NOT NULL, # 게시물 번호 외래키
	private int mem_no;// int NOT NULL, # 게시글 작성자 번호 외래키
	private String cmt_regtime;// datetime, # 댓글 작성 일시
	private String cmt_content;// varchar(3000), # 댓글 내용
	private boolean cmt_del_check;// boolean DEFAULT FALSE,
	private String writer;
	// FOREIGN KEY(post_no) REFERENCES POST(post_no),
	// FOREIGN KEY(board_no) REFERENCES BOARD(board_no),
	// FOREIGN KEY(mem_no) REFERENCES MEMBER(mem_no)

	public Comment() {
		super();
	}

	public Comment(int post_no, int mem_no, String cmt_content, String writer) {
		super();
		this.post_no = post_no;
		this.mem_no = mem_no;
		this.cmt_content = cmt_content;
		this.writer = writer;
	}

	public Comment(int cmt_no, int post_no, int mem_no, String cmt_regtime, String cmt_content, boolean cmt_del_check,
			String writer) {
		super();
		this.cmt_no = cmt_no;
		this.post_no = post_no;
		this.mem_no = mem_no;
		this.cmt_regtime = cmt_regtime;
		this.cmt_content = cmt_content;
		this.cmt_del_check = cmt_del_check;
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "Comment [cmt_no=" + cmt_no + ", post_no=" + post_no + ", mem_no=" + mem_no + ", cmt_regtime="
				+ cmt_regtime + ", cmt_content=" + cmt_content + ", cmt_del_check=" + cmt_del_check + ", writer="
				+ writer + "]";
	}

	public int getPost_no() {
		return post_no;
	}

	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public String getCmt_regtime() {
		return cmt_regtime;
	}

	public void setCmt_regtime(String cmt_regtime) {
		this.cmt_regtime = cmt_regtime;
	}

	public String getCmt_content() {
		return cmt_content;
	}

	public void setCmt_content(String cmt_content) {
		this.cmt_content = cmt_content;
	}

	public boolean isCmt_del_check() {
		return cmt_del_check;
	}

	public void setCmt_del_check(boolean cmt_del_check) {
		this.cmt_del_check = cmt_del_check;
	}

	public int getCmt_no() {
		return cmt_no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

}
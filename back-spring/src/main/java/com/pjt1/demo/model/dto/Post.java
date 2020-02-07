package com.pjt1.demo.model.dto;

import java.io.Serializable;
import java.util.List;

/* 게시물 테이블
# 후기와 일정에 대한 게시물 테이블
# 후기는 다양한 이미지와 긴 글을 작성할 수 있고, 코스를 추가할 수 있다.
# 일정은 시작일과 종료일을 정해서 간단한 메모 형태로 작성할 수 있다.
*/
public class Post implements Serializable {
	private static final long serialVersionUID = -3681429445670649187L;
	private int post_no;// int PRIMARY KEY AUTO_INCREMENT, # 게시글 관리번호 기본키, 자동증가
	private int post_type;// int NOT NULL DEFAULT 0, # 후기(사진등 추가) : 0, 일정(양식) : 1
	private int board_no;// int NOT NULL, # 게시판 번호 외래키
	private int mem_no;// int NOT NULL, # 작성자 번호 외래키
	private String post_title;// varchar(200), # 게시글 제목
	private String post_content;// varchar(3000) NOT NULL, # 게시글 내용
	private String post_category;// varchar(300), # 게시글 카테고리, 태그
	private String post_regtime;// datetime DEFAULT NOW(), # 게시글 작성시간
	private int post_hits;// int DEFAULT 0, # 게시글 조회수
	private String post_city;// varchar(500),
	private String post_plan_start;// date, # 일정 시작날짜
	private String post_plan_end;// date, # 일정 끝 날짜
	private String post_plan_title;// varchar(300), # 일정 간단한 메모내용
	private boolean post_del_check;// boolean DEFAULT FALSE, # 삭제 여부
	private String writer; // # 작성자

	// FOREIGN KEY(board_no) REFERENCES BOARD(board_no),
	// FOREIGN KEY(mem_no) REFERENCES MEMBERS(mem_no)
	// FOREIGN KEY(writer) REFERENCES MEMBERS(mem_id)

	public Post() {
		super();
	}

	public String getPost_plan_title() {
		return post_plan_title;
	}

	public void setPost_plan_title(String post_plan_title) {
		this.post_plan_title = post_plan_title;
	}

	public String getPost_plan_end() {
		return post_plan_end;
	}

	public void setPost_plan_end(String post_plan_end) {
		this.post_plan_end = post_plan_end;
	}

	public String getPost_plan_start() {
		return post_plan_start;
	}

	public void setPost_plan_start(String post_plan_start) {
		this.post_plan_start = post_plan_start;
	}

	public String getPost_city() {
		return post_city;
	}

	public void setPost_city(String post_city) {
		this.post_city = post_city;
	}

	public Post(int post_type, int board_no, int mem_no, String post_title, String post_content, String post_category,
			String post_city, String post_plan_start, String post_plan_end, String post_plan_title, String writer) {
		super();
		this.post_type = post_type;
		this.board_no = board_no;
		this.mem_no = mem_no;
		this.post_title = post_title;
		this.post_content = post_content;
		this.post_category = post_category;
		this.post_city = post_city;
		this.post_plan_start = post_plan_start;
		this.post_plan_end = post_plan_end;
		this.post_plan_title = post_plan_title;
		this.writer = writer;
	}

	public Post(int post_no, int post_type, int board_no, int mem_no, String post_title, String post_content,
			String post_category, String post_regtime, int post_hits, String post_plan_start, String post_plan_end,
			String post_city, String post_plan_title, boolean post_del_check, List<Comment> commentList,
			String writer) {
		super();
		this.post_no = post_no;
		this.post_type = post_type;
		this.board_no = board_no;
		this.mem_no = mem_no;
		this.post_title = post_title;
		this.post_content = post_content;
		this.post_category = post_category;
		this.post_regtime = post_regtime;
		this.post_hits = post_hits;
		// this.commentList = commentList;
		this.post_city = post_city;
		this.post_plan_start = post_plan_start;
		this.post_plan_end = post_plan_end;
		this.post_plan_title = post_plan_title;
		this.post_del_check = post_del_check;
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "Post [post_no=" + post_no + ", post_type=" + post_type + ", board_no=" + board_no + ", mem_no=" + mem_no
				+ ", post_title=" + post_title + ", post_content=" + post_content + ", post_category=" + post_category
				+ ", post_regtime=" + post_regtime + ", post_hits=" + post_hits + ", post_city=" + post_city
				+ ", post_plan_start=" + post_plan_start + ", post_plan_end=" + post_plan_end + ", post_plan_title="
				+ post_plan_title + ", post_del_check=" + post_del_check + ", writer=" + writer + "]";
	}

	public int getPost_type() {
		return post_type;
	}

	public void setPost_type(int post_type) {
		this.post_type = post_type;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public String getPost_title() {
		return post_title;
	}

	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}

	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}

	public String getPost_category() {
		return post_category;
	}

	public void setPost_category(String post_category) {
		this.post_category = post_category;
	}

	public String getPost_regtime() {
		return post_regtime;
	}

	public void setPost_regtime(String post_regtime) {
		this.post_regtime = post_regtime;
	}

	public int getPost_hits() {
		return post_hits;
	}

	public void setPost_hits(int post_hits) {
		this.post_hits = post_hits;
	}

	public boolean isPost_del_check() {
		return post_del_check;
	}

	public void setPost_del_check(boolean post_del_check) {
		this.post_del_check = post_del_check;
	}

	public int getPost_no() {
		return post_no;
	}

	// public List<Comment> getCommentList() {
	// return commentList;
	// }

	// public void setCommentList(List<Comment> commentList) {
	// this.commentList = commentList;
	// }

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

}
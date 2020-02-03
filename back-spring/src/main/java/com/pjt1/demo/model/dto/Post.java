package com.pjt1.demo.model.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
/* 게시물 테이블
# 후기와 일정에 대한 게시물 테이블
# 후기는 다양한 이미지와 긴 글을 작성할 수 있고, 코스를 추가할 수 있다.
# 일정은 시작일과 종료일을 정해서 간단한 메모 형태로 작성할 수 있다.
*/
public class Post implements Serializable {
	private static final long serialVersionUID = -3681429445670649187L;
	private int post_no				;//int PRIMARY KEY AUTO_INCREMENT,	# 게시글 관리번호	기본키, 자동증가
    private int post_type			;//int NOT NULL DEFAULT 0,			# 후기(사진등 추가) : 0, 일정(양식) : 1 
    private int board_no			;//int NOT NULL,					# 게시판 번호	외래키
    private int mem_no				;//int NOT NULL,					# 작성자 번호	외래키
    private String post_title		;//varchar(200),					# 게시글 제목	
	private String post_content		;//varchar(3000) NOT NULL,			# 게시글 내용	
	private String post_category	;//varchar(300),					# 게시글 카테고리, 태그
	private String post_regtime		;//datetime DEFAULT NOW(),			# 게시글 작성시간	
	private int post_hits			;//int DEFAULT 0,					# 게시글 조회수	
	private boolean post_secret		;//boolean DEFAULT FALSE,			# 비밀 게시글 여부	
	private boolean post_notice		;//boolean DEFAULT FALSE,			# 공지사항 여부	
	private String post_start_day	;//date,							# 일정 시작날짜
	private String post_end_day		;//date,							# 일정 끝 날짜
	private String post_plan		;//varchar(300),					# 일정 간단한 메모내용
	private boolean post_del_check	;//boolean DEFAULT FALSE,			# 삭제 여부
//	FOREIGN KEY(board_no) REFERENCES BOARD(board_no),
//	FOREIGN KEY(mem_no) REFERENCES MEMBER(mem_no)
	public Post() {
		super();
	}
	public Post(int post_type, int board_no, int mem_no, String post_title, String post_content, String post_category,
			String post_start_day, String post_end_day, String post_plan) {
		super();
		this.post_type = post_type;
		this.board_no = board_no;
		this.mem_no = mem_no;
		this.post_title = post_title;
		this.post_content = post_content;
		this.post_category = post_category;
		this.post_start_day = post_start_day;
		this.post_end_day = post_end_day;
		this.post_plan = post_plan;
	}
	public Post(int post_no, int post_type, int board_no, int mem_no, String post_title, String post_content,
			String post_category, String post_regtime, int post_hits, boolean post_secret, boolean post_notice,
			String post_start_day, String post_end_day, String post_plan, boolean post_del_check) {
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
		this.post_secret = post_secret;
		this.post_notice = post_notice;
		this.post_start_day = post_start_day;
		this.post_end_day = post_end_day;
		this.post_plan = post_plan;
		this.post_del_check = post_del_check;
	}
	@Override
	public String toString() {
		return "Post [post_no=" + post_no + ", post_type=" + post_type + ", board_no=" + board_no + ", mem_no=" + mem_no
				+ ", post_title=" + post_title + ", post_content=" + post_content + ", post_category=" + post_category
				+ ", post_regtime=" + post_regtime + ", post_hits=" + post_hits + ", post_secret=" + post_secret
				+ ", post_notice=" + post_notice + ", post_start_day=" + post_start_day + ", post_end_day=" + post_end_day
				+ ", post_plan=" + post_plan + ", post_del_check=" + post_del_check + "]";
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
	public boolean isPost_secret() {
		return post_secret;
	}
	public void setPost_secret(boolean post_secret) {
		this.post_secret = post_secret;
	}
	public boolean isPost_notice() {
		return post_notice;
	}
	public void setPost_notice(boolean post_notice) {
		this.post_notice = post_notice;
	}
	public String getPost_start_day() {
		return post_start_day;
	}
	public void setPost_start_day(String post_start_day) {
		this.post_start_day = post_start_day;
	}
	public String getPost_end_day() {
		return post_end_day;
	}
	public void setPost_end_day(String post_end_day) {
		this.post_end_day = post_end_day;
	}
	public String getPost_plan() {
		return post_plan;
	}
	public void setPost_plan(String post_plan) {
		this.post_plan = post_plan;
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
		
}
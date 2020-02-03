package com.pjt1.demo.model.dto;

import java.io.Serializable;

//댓글 테이블
public class Comment implements Serializable {
	
	private static final long serialVersionUID = -1148288769220271764L;
	private int cmt_no								;//int PRIMARY KEY AUTO_INCREMENT,	# 댓글 관리번호	기본키, 자동증가
	private int board_no			;//int NOT NULL,					# 게시판 번호 외래키
	private int post_no			;//int	NOT NULL, 					# 게시물 번호 외래키
	private int mem_no				;//int NOT NULL,					# 게시글 작성자 번호 외래키
	private String cmt_regtime				;//datetime,						# 댓글 작성 일시	
	private int cmt_parent			;//int DEFAULT NULL,				# 기본 댓글은 부모가 없고, 대댓글들은 부모 번호 존재 //댓글에 댓글을 다는 버튼이면 해당 댓글번호 넣기
	private boolean cmt_secret				;//boolean DEFAULT FALSE,			# 비밀 댓글 여부		
	private String cmt_title				;//varchar(200),					# 댓글 제목	
	private String cmt_content				;//varchar(3000),					# 댓글 내용	
    private boolean cmt_del_check			;//boolean DEFAULT FALSE,
//	FOREIGN KEY(post_no) REFERENCES POST(post_no),
//	FOREIGN KEY(board_no) REFERENCES BOARD(board_no),
//    FOREIGN KEY(mem_no) REFERENCES MEMBER(mem_no)
    
	public Comment() {
		super();
	}
	public Comment(int board_no, int post_no, int mem_no, int cmt_parent, boolean cmt_secret, String cmt_title,
			String cmt_content) {
		super();
		this.board_no = board_no;
		this.post_no = post_no;
		this.mem_no = mem_no;
		this.cmt_parent = cmt_parent;
		this.cmt_secret = cmt_secret;
		this.cmt_title = cmt_title;
		this.cmt_content = cmt_content;
	}
	public Comment(int cmt_no, int board_no, int post_no, int mem_no, String cmt_regtime, int cmt_parent,
			boolean cmt_secret, String cmt_title, String cmt_content, boolean cmt_del_check) {
		super();
		this.cmt_no = cmt_no;
		this.board_no = board_no;
		this.post_no = post_no;
		this.mem_no = mem_no;
		this.cmt_regtime = cmt_regtime;
		this.cmt_parent = cmt_parent;
		this.cmt_secret = cmt_secret;
		this.cmt_title = cmt_title;
		this.cmt_content = cmt_content;
		this.cmt_del_check = cmt_del_check;
	}
	@Override
	public String toString() {
		return "Comment [cmt_no=" + cmt_no + ", board_no=" + board_no + ", post_no=" + post_no + ", mem_no=" + mem_no
				+ ", cmt_regtime=" + cmt_regtime + ", cmt_parent=" + cmt_parent + ", cmt_secret=" + cmt_secret
				+ ", cmt_title=" + cmt_title + ", cmt_content=" + cmt_content + ", cmt_del_check=" + cmt_del_check
				+ "]";
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
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
	public int getCmt_parent() {
		return cmt_parent;
	}
	public void setCmt_parent(int cmt_parent) {
		this.cmt_parent = cmt_parent;
	}
	public boolean isCmt_secret() {
		return cmt_secret;
	}
	public void setCmt_secret(boolean cmt_secret) {
		this.cmt_secret = cmt_secret;
	}
	public String getCmt_title() {
		return cmt_title;
	}
	public void setCmt_title(String cmt_title) {
		this.cmt_title = cmt_title;
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
    
    
    
}
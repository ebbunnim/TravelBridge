package com.pjt1.demo.model.dto;

import java.io.Serializable;

public class Likes implements Serializable {
	private static final long serialVersionUID = -4853668322449016469L;
	
	private int like_no				;//int PRIMARY KEY AUTO_INCREMENT,	# 좋아요 관리번호	기본키, 자동증가
	private int board_no			;//int NOT NULL,					# 게시판 위치 
	private int post_no				;//int NOT NUll,					# 게시물 번호
	private boolean cmt_check		;//boolean not null,				# 댓글 여부 (게시물이면 false, 댓글이면 true)
	private int cmt_no				;//int	default 0,					# 댓글 번호 (댓글이면 해당 번호 삽입)
	private int liker_mem_no		;//int NOT NULL,					# 좋아요 한 회원	외래키
	private int liking_mem_no		;//int NOT NULL,					# 좋아요 당한 회원	외래키
	private boolean like_del_check	;//boolean DEFAULT FALSE,			# 삭제 여부			
//    FOREIGN KEY(board_no) REFERENCES BOARD(board_no), 
//	FOREIGN KEY(post_no) REFERENCES POST(post_no),
//    FOREIGN KEY(liker_mem_no) REFERENCES MEMBER(mem_no),
//    FOREIGN KEY(liking_mem_no) REFERENCES MEMBER(mem_no)
	public Likes() {
		super();
	}
	public Likes(int board_no, int post_no, boolean cmt_check, int cmt_no, int liker_mem_no, int liking_mem_no) {
		super();
		this.board_no = board_no;
		this.post_no = post_no;
		this.cmt_check = cmt_check;
		this.cmt_no = cmt_no;
		this.liker_mem_no = liker_mem_no;
		this.liking_mem_no = liking_mem_no;
	}
	public Likes(int like_no, int board_no, int post_no, boolean cmt_check, int cmt_no, int liker_mem_no, int liking_mem_no,
			boolean like_del_check) {
		super();
		this.like_no = like_no;
		this.board_no = board_no;
		this.post_no = post_no;
		this.cmt_check = cmt_check;
		this.cmt_no = cmt_no;
		this.liker_mem_no = liker_mem_no;
		this.liking_mem_no = liking_mem_no;
		this.like_del_check = like_del_check;
	}
	@Override
	public String toString() {
		return "Likes [like_no=" + like_no + ", board_no=" + board_no + ", post_no=" + post_no + ", cmt_check=" + cmt_check
				+ ", cmt_no=" + cmt_no + ", liker_mem_no=" + liker_mem_no + ", liking_mem_no=" + liking_mem_no
				+ ", like_del_check=" + like_del_check + "]";
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
	public boolean isCmt_check() {
		return cmt_check;
	}
	public void setCmt_check(boolean cmt_check) {
		this.cmt_check = cmt_check;
	}
	public int getCmt_no() {
		return cmt_no;
	}
	public void setCmt_no(int cmt_no) {
		this.cmt_no = cmt_no;
	}
	public int getLiker_mem_no() {
		return liker_mem_no;
	}
	public void setLiker_mem_no(int liker_mem_no) {
		this.liker_mem_no = liker_mem_no;
	}
	public int getLiking_mem_no() {
		return liking_mem_no;
	}
	public void setLiking_mem_no(int liking_mem_no) {
		this.liking_mem_no = liking_mem_no;
	}
	public boolean isLike_del_check() {
		return like_del_check;
	}
	public void setLike_del_check(boolean like_del_check) {
		this.like_del_check = like_del_check;
	}
	public int getLike_no() {
		return like_no;
	}
	 
		
    
}
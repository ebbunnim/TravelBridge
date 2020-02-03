package com.pjt1.demo.model.dto;

import java.io.Serializable;

public class Follow implements Serializable {

	private static final long serialVersionUID = -7260038649937363377L;
	private int follow_no 				;// int PRIMARY KEY AUTO_INCREMENT, # 팔로우 관리번호
	private int follower_no 			;// int NOT NULL, # 팔로우 하는 회원 외래키
	private int following_no 			;// int NOT NULL, # 팔로우 당하는 회원 외래키
	private boolean follow_del_check 	;// boolean DEFAULT FALSE, # 삭제 여부
//    FOREIGN KEY(follower_no) REFERENCES MEMBER(mem_no),
//    FOREIGN KEY(following_no) REFERENCES MEMBER(mem_no)
	public Follow() {
		super();
	}
	public Follow(int follower_no, int following_no) {
		super();
		this.follower_no = follower_no;
		this.following_no = following_no;
	}
	public Follow(int follow_no, int follower_no, int following_no, boolean follow_del_check) {
		super();
		this.follow_no = follow_no;
		this.follower_no = follower_no;
		this.following_no = following_no;
		this.follow_del_check = follow_del_check;
	}
	@Override
	public String toString() {
		return "Follow [follow_no=" + follow_no + ", follower_no=" + follower_no + ", following_no=" + following_no
				+ ", follow_del_check=" + follow_del_check + "]";
	}
	public int getFollower_no() {
		return follower_no;
	}
	public void setFollower_no(int follower_no) {
		this.follower_no = follower_no;
	}
	public int getFollowing_no() {
		return following_no;
	}
	public void setFollowing_no(int following_no) {
		this.following_no = following_no;
	}
	public boolean isFollow_del_check() {
		return follow_del_check;
	}
	public void setFollow_del_check(boolean follow_del_check) {
		this.follow_del_check = follow_del_check;
	}
	public int getFollow_no() {
		return follow_no;
	}
		

}
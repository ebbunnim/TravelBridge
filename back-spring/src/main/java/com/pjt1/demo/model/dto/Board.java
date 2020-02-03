package com.pjt1.demo.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 게시판 테이블 
public class Board implements Serializable {
	
	private static final long serialVersionUID = -2583164618310746471L;
	private int board_no							;//int PRIMARY KEY AUTO_INCREMENT,	# 게시판 관리 번호 기본키, 자동증가	
	private String board_name		;//varchar(200) NOT NULL ,			# 게시판 이름
    private boolean board_del_check			;//boolean DEFAULT FALSE
    
       
	public Board() {
		super();
	}
	public Board(String board_name) {
		super();
		this.board_name = board_name;
	}
	public Board(int board_no, String board_name, boolean board_del_check) {
		super();
		this.board_no = board_no;
		this.board_name = board_name;
		this.board_del_check = board_del_check;
	}
	
	@Override
	public String toString() {
		return "Board [board_no=" + board_no + ", board_name=" + board_name + ", board_del_check=" + board_del_check
				+ "]";
	}
	
	public String getBoard_name() {
		return board_name;
	}
	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	public boolean isBoard_del_check() {
		return board_del_check;
	}
	public void setBoard_del_check(boolean board_del_check) {
		this.board_del_check = board_del_check;
	}
	public int getBoard_no() {
		return board_no;
	}
    
    
    
}
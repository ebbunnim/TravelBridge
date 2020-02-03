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
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString(exclude="serialVersionUID")
@EqualsAndHashCode
public class Board implements Serializable {
	
	private static final long serialVersionUID = -2583164618310746471L;
	@Getter private int board_no							;//int PRIMARY KEY AUTO_INCREMENT,	# 게시판 관리 번호 기본키, 자동증가	
	@Getter @Setter @NonNull private String board_name		;//varchar(200) NOT NULL ,			# 게시판 이름
    @Getter @Setter private boolean board_del_check			;//boolean DEFAULT FALSE
    
}
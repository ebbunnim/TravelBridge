package com.pjt1.demo.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
// 게시판 테이블
public class Board implements Serializable {

	private static final long serialVersionUID = -2583164618310746471L;
	@Getter
	private int board_no; // int PRIMARY KEY AUTO_INCREMENT, # 게시판 관리 번호 기본키, 자동증가
	@Getter
	@Setter
	private int mem_no; // int, # 해당 회원의 피드
	@NonNull
	@Getter
	@Setter
	private String board_name; // varchar(200) NOT NULL , # 게시판 이름(회원아이디로)
	@Getter
	@Setter
	private boolean board_del_check; // boolean DEFAULT FALSE
}
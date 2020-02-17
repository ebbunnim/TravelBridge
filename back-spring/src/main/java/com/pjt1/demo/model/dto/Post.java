package com.pjt1.demo.model.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Post implements Serializable {
	private static final long serialVersionUID = -3681429445670649187L;
	@Getter
	private int post_no;// int PRIMARY KEY AUTO_INCREMENT, # 게시글 관리번호 기본키, 자동증가
	@NonNull
	@Getter
	@Setter
	private int post_type;// int NOT NULL DEFAULT 0, # 후기(사진등 추가) : 0, 일정(양식) : 1
	@NonNull
	@Getter
	@Setter
	private int board_no;// int NOT NULL, # 게시판 번호 외래키
	@NonNull
	@Getter
	@Setter
	private int mem_no;// int NOT NULL, # 작성자 번호 외래키
	@Getter
	@Setter
	private String post_title;// varchar(200), # 게시글 제목
	@Getter
	@Setter
	private String post_content;// varchar(3000) NOT NULL, # 게시글 내용 플랜
	@Getter
	@Setter
	private String post_category;// varchar(300), # 게시글 카테고리, 태그
	@Getter
	@Setter
	private String post_regtime;// datetime DEFAULT NOW(), # 게시글 작성시간
	@Getter
	@Setter
	private int post_hits;// int DEFAULT 0, # 게시글 조회수
	@Getter
	@Setter
	private String post_city;// varchar(500),
	@Getter
	@Setter
	private String post_writer; // # 작성자
	@Getter
	@Setter
	private boolean post_del_check;// boolean DEFAULT FALSE, # 삭제 여부
	@Getter
	@Setter
	private String post_plan_date;// 일정 목표 날짜칸 추가
	@Getter
	@Setter
	private List<Comment> post_cmtList;
	@Getter
	@Setter
	private List<Files> post_filesList;
	@Getter
	@Setter
	private List<Course> post_courseList;

	// FOREIGN KEY(board_no) REFERENCES BOARD(board_no),
	// FOREIGN KEY(mem_no) REFERENCES MEMBERS(mem_no)
	// FOREIGN KEY(writer) REFERENCES MEMBERS(mem_id)
}
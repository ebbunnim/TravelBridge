package com.pjt1.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/* 게시물 테이블
# 후기와 일정에 대한 게시물 테이블
# 후기는 다양한 이미지와 긴 글을 작성할 수 있고, 코스를 추가할 수 있다.
# 일정은 시작일과 종료일을 정해서 간단한 메모 형태로 작성할 수 있다.
*/

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString(exclude="serialVersionUID")
@EqualsAndHashCode
public class Post implements Serializable {
	private static final long serialVersionUID = -3681429445670649187L;
	@Getter private int post_no				;//int PRIMARY KEY AUTO_INCREMENT,	# 게시글 관리번호	기본키, 자동증가
    @Getter @Setter @NonNull private int post_type			;//int NOT NULL DEFAULT 0,			# 후기(사진등 추가) : 0, 일정(양식) : 1 
    @Getter @Setter @NonNull private int board_no			;//int NOT NULL,					# 게시판 번호	외래키
    @Getter @Setter @NonNull private int mem_no				;//int NOT NULL,					# 작성자 번호	외래키
    @Getter @Setter private String post_title		;//varchar(200),					# 게시글 제목	
	@Getter @Setter @NonNull private String post_content		;//varchar(3000) NOT NULL,			# 게시글 내용	
	@Getter @Setter private String post_category	;//varchar(300),					# 게시글 카테고리, 태그
	@Getter @Setter private String post_regtime		;//datetime DEFAULT NOW(),			# 게시글 작성시간	
	@Getter @Setter private int post_hits			;//int DEFAULT 0,					# 게시글 조회수	
	@Getter @Setter private boolean post_secret		;//boolean DEFAULT FALSE,			# 비밀 게시글 여부	
	@Getter @Setter private boolean post_notice		;//boolean DEFAULT FALSE,			# 공지사항 여부	
	@Getter @Setter private String post_start_day	;//date,							# 일정 시작날짜
	@Getter @Setter private String post_end_day		;//date,							# 일정 끝 날짜
	@Getter @Setter private String post_plan		;//varchar(300),					# 일정 간단한 메모내용
	@Getter @Setter private boolean post_del_check	;//boolean DEFAULT FALSE,			# 삭제 여부
//	FOREIGN KEY(board_no) REFERENCES BOARD(board_no),
//	FOREIGN KEY(mem_no) REFERENCES MEMBER(mem_no)
    

}
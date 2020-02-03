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
// Q&A 테이블

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString(exclude="serialVersionUID")
@EqualsAndHashCode
public class Qna implements Serializable {

	private static final long serialVersionUID = -2029554586934457509L;
	@Getter private int qna_no				;//int PRIMARY KEY AUTO_INCREMENT,	# Q&A 관리번호	기본키, 자동증가
	@Getter @Setter @NonNull private int mem_no				;//int NOT NULL,	# 질문한 회원 번호	외래키
	@Getter @Setter private String qna_title		;//varchar(200),	# Q&A 질문 제목	
	@Getter @Setter private String qna_content		;//varchar(3000),	# Q&A 질문 내용	
	@Getter @Setter private int qna_hits			;//int DEFAULT 0,	# 조회수	
	@Getter @Setter private String qna_regtime		;//datetime DEFAULT NOW(),		# 등록 시간	
	@Getter @Setter private boolean qna_secret		;//boolean DEFAULT FALSE,		# 비밀 게시글 여부
	@Getter @Setter private boolean qna_del_check	;//boolean DEFAULT FALSE,
//    FOREIGN KEY(mem_no) REFERENCES MEMBER(mem_no)

	
}
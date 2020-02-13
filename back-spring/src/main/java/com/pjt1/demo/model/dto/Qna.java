package com.pjt1.demo.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
// Q&A 테이블
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Qna implements Serializable {

	private static final long serialVersionUID = -2029554586934457509L;
	@Getter private int qna_no		;//int PRIMARY KEY AUTO_INCREMENT,	# Q&A 관리번호	기본키, 자동증가
	@NonNull @Getter @Setter private int mem_no		;//int NOT NULL,	# 질문한 회원 번호	외래키
	@Getter @Setter private String qna_category		;//varchar(200)
	@Getter @Setter private String qna_title		;//varchar(200),	# Q&A 질문 제목	
	@Getter @Setter private String qna_content		;//varchar(3000),	# Q&A 질문 내용
	@Getter @Setter private String qna_answer		;//varchar(3000)
	@Getter @Setter private String qna_regtime		;//datetime DEFAULT NOW(),		# 등록 시간	
	@Getter @Setter private boolean qna_del_check	;//boolean DEFAULT FALSE,
//    FOREIGN KEY(mem_no) REFERENCES MEMBER(mem_no)
}
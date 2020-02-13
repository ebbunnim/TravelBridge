package com.pjt1.demo.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Faq implements Serializable {
	private static final long serialVersionUID = 1214365622536623852L;
	@Getter private int faq_no								;//int PRIMARY KEY AUTO_INCREMENT,			# 자주하는 질문 관리번호	기본키, 자동증가
	@Getter @Setter private String faq_category	;	//varchar(200),			# 질문 카테고리	
	@Getter @Setter private String faq_question		;//varchar(200),			# 질문 제목	
	@Getter @Setter private String faq_answer		;//varchar(3000),			# 답변 내용	
	@Getter @Setter private String faq_regtime				;//datetime DEFAULT NOW(),	# 등록 시간	
    @Getter @Setter private boolean faq_del_check 					;
}
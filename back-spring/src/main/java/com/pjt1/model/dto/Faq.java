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
// FAQ 테이블
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString(exclude="serialVersionUID")
@EqualsAndHashCode
public class Faq implements Serializable {
	private static final long serialVersionUID = 1214365622536623852L;
	@Getter private int faq_no				;//int PRIMARY KEY AUTO_INCREMENT,		# 자주하는 질문 관리번호	기본키, 자동증가
	@Getter @Setter @NonNull private String faq_title		;//varchar(200),			# 질문 제목	
	@Getter @Setter @NonNull private String faq_content		;//varchar(3000),			# 질문 내용	
	@Getter @Setter @NonNull private String faq_answer		;//varchar(3000),			# 답변 내용	
	@Getter @Setter private int faq_hits					;//int DEFAULT 0,			# 조회 수	
	@Getter @Setter private String faq_regtime				;//datetime DEFAULT NOW(),	# 등록 시간	
    @Getter private boolean faq_del_check 					;//boolean DEFAULT FALSE
    
}
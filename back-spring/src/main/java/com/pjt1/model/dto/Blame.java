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

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString(exclude="serialVersionUID")
@EqualsAndHashCode
public class Blame implements Serializable {
	private static final long serialVersionUID = 2909089837996493001L;
	@Getter private int blame_no					;//int PRIMARY KEY AUTO_INCREMENT,	#신고 관리번호	기본키,자동증가
	@Getter @NonNull private int mem_no				;//int NOT NULL,	#신고한 회원번호	외래키
	@Getter @NonNull private int target_mem_no		;//int NOT NULL,	#신고당한 회원번호	외래키
	@Getter private String blame_time				;//datetime DEFAULT NOW(),	#신고 일시	
    @Getter @Setter private boolean blame_del_check	;//boolean DEFAULT FALSE,
//	FOREIGN KEY(mem_no) REFERENCES MEMBER(mem_no),
//	FOREIGN KEY(target_mem_no) REFERENCES MEMBER(mem_no)
    
  
}
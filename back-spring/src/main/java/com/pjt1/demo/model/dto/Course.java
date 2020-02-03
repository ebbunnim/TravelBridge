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

/* 코스 테이블
# 후기 게시물에 추가되는 코스로 장소명과 간단한 설명에 대해서 작성 할 수 있고, 한 게시물에 여러개가 추가될 수 있다.
*/
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString(exclude="serialVersionUID")
@EqualsAndHashCode
public class Course implements Serializable  {
	private static final long serialVersionUID = -7114763220475884387L;
	@Getter private int course_no							;// int PRIMARY KEY AUTO_INCREMENT, # 후기에 갔던 장소들 번호 기본키, 자동증가
	@Getter @Setter @NonNull private int post_no			;// int NOT NULL, # 참조하는 게시물 번호
	@Getter @Setter @NonNull private String course_spot		;// varchar(1000), # 장소명들을 직접 받아서 스트링 형태로 저장 ,로 구분하자.
	@Getter @Setter private boolean course_del_check		;// boolean DEFAULT FALSE, # 삭제 여부
//	FOREIGN KEY(post_no) REFERENCES POST(post_no)

}

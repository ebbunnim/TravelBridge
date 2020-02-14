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
@EqualsAndHashCode
public class Comment implements Serializable {

	private static final long serialVersionUID = -1148288769220271764L;
	@Getter
	private int cmt_no;// int PRIMARY KEY AUTO_INCREMENT, # 댓글 관리번호 기본키, 자동증가
	@NonNull
	@Getter
	@Setter
	private int post_no;// int NOT NULL, # 게시물 번호 외래키
	@NonNull
	@Getter
	@Setter
	private int mem_no;// int NOT NULL, # 게시글 작성자 번호 외래키
	@Getter
	@Setter
	private String cmt_regtime;// datetime, # 댓글 작성 일시
	@Getter
	@Setter
	private String cmt_content;// varchar(3000), # 댓글 내용
	@Getter
	@Setter
	private String cmt_writer;
	@Getter
	@Setter
	private boolean cmt_del_check;// boolean DEFAULT FALSE,
	// FOREIGN KEY(post_no) REFERENCES POST(post_no),
	// FOREIGN KEY(board_no) REFERENCES BOARD(board_no),
	// FOREIGN KEY(mem_no) REFERENCES MEMBER(mem_no)

	@Override
	public String toString() {
		return "hello";
	}
}
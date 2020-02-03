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

//댓글 테이블
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString(exclude="serialVersionUID")
@EqualsAndHashCode
public class Comment implements Serializable {
	
	private static final long serialVersionUID = -1148288769220271764L;
	@Getter private int cmt_no								;//int PRIMARY KEY AUTO_INCREMENT,	# 댓글 관리번호	기본키, 자동증가
	@Getter @Setter @NonNull private int board_no			;//int NOT NULL,					# 게시판 번호 외래키
	@Getter @Setter @NonNull private int post_no			;//int	NOT NULL, 					# 게시물 번호 외래키
	@Getter @Setter @NonNull private int mem_no				;//int NOT NULL,					# 게시글 작성자 번호 외래키
	@Getter @Setter private String cmt_regtime				;//datetime,						# 댓글 작성 일시	
	@Getter @Setter @NonNull private int cmt_parent			;//int DEFAULT NULL,				# 기본 댓글은 부모가 없고, 대댓글들은 부모 번호 존재 //댓글에 댓글을 다는 버튼이면 해당 댓글번호 넣기
	@Getter @Setter private boolean cmt_secret				;//boolean DEFAULT FALSE,			# 비밀 댓글 여부		
	@Getter @Setter private String cmt_title				;//varchar(200),					# 댓글 제목	
	@Getter @Setter private String cmt_content				;//varchar(3000),					# 댓글 내용	
    @Getter @Setter private boolean cmt_del_check			;//boolean DEFAULT FALSE,
//	FOREIGN KEY(post_no) REFERENCES POST(post_no),
//	FOREIGN KEY(board_no) REFERENCES BOARD(board_no),
//    FOREIGN KEY(mem_no) REFERENCES MEMBER(mem_no)
    
    
}
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
//좋아요 테이블

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString(exclude="serialVersionUID")
@EqualsAndHashCode
public class Likes implements Serializable {
	private static final long serialVersionUID = -4853668322449016469L;
	
	@Getter private int like_no				;//int PRIMARY KEY AUTO_INCREMENT,	# 좋아요 관리번호	기본키, 자동증가
	@Getter @Setter @NonNull private int board_no			;//int NOT NULL,					# 게시판 위치 
	@Getter @Setter @NonNull private int post_no				;//int NOT NUll,					# 게시물 번호
	@Getter @Setter @NonNull private boolean cmt_check		;//boolean not null,				# 댓글 여부 (게시물이면 false, 댓글이면 true)
	@Getter @Setter private int cmt_no				;//int	default 0,					# 댓글 번호 (댓글이면 해당 번호 삽입)
	@Getter @Setter @NonNull private int liker_mem_no		;//int NOT NULL,					# 좋아요 한 회원	외래키
	@Getter @Setter @NonNull private int liking_mem_no		;//int NOT NULL,					# 좋아요 당한 회원	외래키
	@Getter @Setter private boolean like_del_check	;//boolean DEFAULT FALSE,			# 삭제 여부			
//    FOREIGN KEY(board_no) REFERENCES BOARD(board_no), 
//	FOREIGN KEY(post_no) REFERENCES POST(post_no),
//    FOREIGN KEY(liker_mem_no) REFERENCES MEMBER(mem_no),
//    FOREIGN KEY(liking_mem_no) REFERENCES MEMBER(mem_no)
 
    
}
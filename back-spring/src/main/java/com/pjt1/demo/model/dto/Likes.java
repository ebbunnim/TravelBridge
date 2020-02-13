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
@ToString
@EqualsAndHashCode
public class Likes implements Serializable {
	private static final long serialVersionUID = -4853668322449016469L;

	@Getter private int like_no;					//	int PRIMARY KEY AUTO_INCREMENT,	# 좋아요 관리번호	기본키, 자동증가
    @NonNull @Getter @Setter private int like_type;	//	int NOT NULL,					# 좋아요 위치(1:게시물,2:핫플,3:축제)
    @Getter @Setter private int post_no;			//	int DEFAULT 0,					# 게시물 번호
    @Getter @Setter private int hotplace_no;		//	int DEFAULT 0,					# 핫플 번호
    @Getter @Setter private int festival_nol;		//	int DEFAULT 0,					# 축제번호
    @Getter @Setter private int liker_mem_no;		//	int NOT NULL,					# 좋아요 한 회원 외래키
    @Getter @Setter private boolean like_del_check;	//	boolean DEFAULT FALSE,			# 삭제 여부
//    FOREIGN KEY(liker_mem_no) REFERENCES MEMBERS(mem_no)

}
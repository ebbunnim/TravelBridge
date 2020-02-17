package com.pjt1.demo.model.dto;

import java.io.Serializable;
import java.util.List;

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
public class Follow implements Serializable {

	private static final long serialVersionUID = -7260038649937363377L;

	@Getter
	private int follow_no; // int PRIMARY KEY AUTO_INCREMENT, # 팔로우 관리번호
	@NonNull
	@Getter
	@Setter
	private int follower_no; // int NOT NULL, # 팔로우 하는 회원 외래키
	@NonNull
	@Getter
	@Setter
	private int following_no; // int NOT NULL, # 팔로우 당하는 회원 외래키
	@Getter
	@Setter
	private boolean follow_del_check; // boolean DEFAULT FALSE, # 삭제 여부
	@Getter
	@Setter
	private List<Members> followList;
	// FOREIGN KEY(follower_no) REFERENCES MEMBER(mem_no),
	// FOREIGN KEY(following_no) REFERENCES MEMBER(mem_no)
}
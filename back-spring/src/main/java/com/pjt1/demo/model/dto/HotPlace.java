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

//핫플 테이블
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class HotPlace implements Serializable  {
	
	private static final long serialVersionUID = 5443973642661281888L;
	@Getter private int hp_no;// int NOT NULL KEY AUTO_INCREMENT,	# 핫플 관리번호
	@NonNull @Getter @Setter private int city_no;
	@NonNull @Getter @Setter private String hp_name;// varchar(200) NOT NULL,			# 핫플 이름
	@NonNull @Getter @Setter private String hp_address;// varchar(200) NOT NULL,		# 핫플 주소 //ex) 서울 강남구
	@NonNull @Getter @Setter private String hp_detail_adr;//_adr varchar(500) NOT NULL,	# 핫플 상세주소
	@NonNull @Getter @Setter private String hp_content;// varchar(3000) NOT NULL,		# 핫플 컨텐츠
	@Getter @Setter private String hp_tag;// varchar(1000) NOT NULL,			# 핫플 태그 
	@Getter @Setter private String hp_homepage;// varchar(500),				# 핫플 홈페이지
	@Getter @Setter private String hp_holiday;// varchar(200),				# 핫플 휴일
	@Getter @Setter private String hp_fee;// varchar(500),					# 핫플 요금
	@Getter @Setter private String hp_img;// varchar(500),
	@Getter @Setter private String hp_theme;// varchar(500),	# 핫플 테마# 핫플 이미지
	@Getter @Setter private boolean hp_del_check;// boolean DEFAULT FALSE		# 핫플 삭제 여부
//	@Getter @Setter private List<Integer> deleteLikeList;
	
}

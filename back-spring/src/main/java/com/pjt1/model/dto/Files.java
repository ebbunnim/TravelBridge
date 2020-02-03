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

//이미지 파일을 위한 테이블
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString(exclude="serialVersionUID")
@EqualsAndHashCode
public class Files implements Serializable {
	
	private static final long serialVersionUID = 7763176721893127276L;
	@Getter private int files_no 			;//int NOT NULL KEY AUTO_INCREMENT,
	@Getter @Setter @NonNull private int post_no 			;//int NOT NULL,
	@Getter @Setter @NonNull private String files_name		;//varchar(200) NOT NULL,
	@Getter @Setter private boolean files_thumbnail ;//boolean,
	@Getter @Setter @NonNull private String files_url 		;//varchar(500) NOT NULL, #PATH
	@Getter @Setter private Boolean files_del_check ;//DEFAULT FAlSE, 			# 파일 삭제 여부
//	FOREIGN KEY(post_no) REFERENCES POST(post_no)
	
	
}

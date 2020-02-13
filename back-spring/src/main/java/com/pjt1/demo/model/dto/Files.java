package com.pjt1.demo.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

//이미지 파일을 위한 테이블
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Files implements Serializable {

	private static final long serialVersionUID = 5132788879683171995L;
	@Getter private int files_no;// int NOT NULL KEY AUTO_INCREMENT,
	@NonNull @Getter @Setter private int post_no;// int NOT NULL,
	@NonNull @Getter @Setter private int mem_no;// int NOT NULL,
	@Getter @Setter private String files_url;// varchar(500), #PATH
	@Getter @Setter private Boolean files_del_check;// DEFAULT FAlSE, # 파일 삭제 여부
	// FOREIGN KEY(post_no) REFERENCES POST(post_no)
	// FOREIGN KEY(mem_no) REFERENCES MEMBERS(mem_no)
}
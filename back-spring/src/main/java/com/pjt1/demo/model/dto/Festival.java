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
public class Festival implements Serializable {
	private static final long serialVersionUID = 9144830003212943493L;
	@Getter private int fval_no;// int NOT NULL KEY AUTO_INCREMENT,
	@NonNull @Getter @Setter private int city_no;// int NOT NULL,
	@NonNull @Getter @Setter private String fval_name;// varchar(200) NOT NULL,
	@NonNull @Getter @Setter private String fval_address;// varchar(500) NOT NULL,
	@NonNull @Getter @Setter private String fval_detail_adr;// varchar(500) NOT NULL,
	@NonNull @Getter @Setter private String fval_content;// varchar(3000) NOT NULL,
	@Getter @Setter private String fval_tag;// varchar(500),
	@Getter @Setter private String fval_start_day;// date,
	@Getter @Setter private String fval_end_day;// date,
	@Getter @Setter private String fval_homepage;// varchar(300),
	@Getter @Setter private int fval_fee;// int DEFAULT 0,
	@Getter @Setter private String fval_img;// varchar(500),
	@Getter @Setter private String fval_host;// varchar(200),
	@Getter @Setter private String fval_theme; //varchar(500),						# 축제 테마
	@Getter @Setter private boolean fval_ended; //boolean DEFAULT FALSE,				# 축제 종료여부
	@Getter @Setter private boolean fval_del_check;// fval_del_check boolean DEFAULT FALSE, # 축제 삭제 여부
	// FOREIGN KEY(clm_no) REFERENCES CITY_LAYER_MID(clm_no)

}

package com.pjt1.demo.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

//도시 테이블
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class City implements Serializable  {
	
	private static final long serialVersionUID = -3618527702074684690L;
	@Getter private int city_no ;// int NOT NULL KEY AUTO_INCREMENT, # 도시 관리번호
    @NonNull @Getter @Setter private String city_name; // varchar(200) NOT NULL,		 # 도시 이름
    @NonNull @Getter @Setter private boolean city_is_overseas;// boolean NOT NULL,	 	 # 국내/해외 여부
    @NonNull @Getter @Setter private String city_address; // varchar(500) NOT NULL, 	 # 도시 주소 //ex) 대한민국 서울시
    @Getter @Setter private String city_img; // varchar(500),					 # 도시 이미지
    @Getter @Setter private boolean city_del_check;// boolean DEFAULT FALSE	 # 도시 삭제 여부
}

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
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString(exclude="serialVersionUID")
@EqualsAndHashCode
public class CityLayerMid implements Serializable {
	private static final long serialVersionUID = -632952727324054590L;
	
	@Getter private int clm_no 								;//int NOT NULL KEY AUTO_INCREMENT,
    @Getter @NonNull private int clt_no 					;//int NOT NULL,
    @Getter @Setter @NonNull private String clm_name 		;//varchar(200) NOT NULL,
    @Getter @Setter @NonNull private String clm_address 	;//varchar(500) NOT NULL,
    @Getter @Setter private String clm_img 					;//varchar(500),
    @Getter @Setter @NonNull private String clm_content 	;//varchar(3000) NOT NULL,
    @Getter @Setter @NonNull private int clm_type 			;//int NOT NULL,
    @Getter @Setter @NonNull private String clm_character	;//varchar(500),
    @Getter @Setter @NonNull private String clm_subtitle 	;//varchar(200),
    @Getter @Setter private boolean clm_del_check			;//clm_del_check boolean DEFAULT FALSE,			# 중도시 삭제여부
    
}

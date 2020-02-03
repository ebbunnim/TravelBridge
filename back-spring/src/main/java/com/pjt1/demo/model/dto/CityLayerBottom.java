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
public class CityLayerBottom implements Serializable {
	private static final long serialVersionUID = -852712683676470564L;
	@Getter private int clb_no 								;//int NOT NULL KEY AUTO_INCREMENT,
    @Getter @NonNull private int clm_no 					;//int NOT NULL,
    @Getter @Setter @NonNull private String clb_name 		;//varchar(200) NOT NULL,
    @Getter @Setter @NonNull private String clb_address		 ;//varchar(500) NOT NULL,
	@Getter @Setter private String clb_img					;//varchar(500),
    @Getter @Setter @NonNull private String clb_content 	;//varchar(3000) NOT NULL,
    @Getter @Setter @NonNull private String clb_tag 		;//varchar(500),
    @Getter @Setter @NonNull private String clb_character	;//varchar(500),
    @Getter @Setter @NonNull private String clb_subtitle 	;//varchar(200),
    @Getter @Setter @NonNull private String clb_fun 		;//varchar(200),
    @Getter @Setter @NonNull private String clb_spot 		;//varchar(500),
    @Getter @Setter private boolean clb_del_check			;//clb_del_check boolean DEFAULT FALSE,	# 소도시 삭제 여부
	//	FOREIGN KEY(clm_no) REFERENCES CITY_LAYER_MID(clm_no)
    
}

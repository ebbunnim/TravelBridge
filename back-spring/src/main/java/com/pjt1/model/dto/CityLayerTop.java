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
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString(exclude="serialVersionUID")
@EqualsAndHashCode
public class CityLayerTop implements Serializable {
	private static final long serialVersionUID = -4600359104701183291L;
	@Getter private int clt_no 								;//int NOT NULL KEY AUTO_INCREMENT,
    @Getter @Setter @NonNull private String clt_name 		;//varchar(200) NOT NULL,
    @Getter @Setter @NonNull private String clt_address 	;//varchar(500) NOT NULL,
    @Getter @Setter private String clt_img 					;//varchar(500) ,
    @Getter @Setter @NonNull private String clt_content 	;//varchar(3000) NOT NULL,
    @Getter @Setter @NonNull private int clt_type 			;//int NOT NULL				# EX) 서울광역시/경기도/섬/해외
    @Getter @Setter private boolean clt_del_check ;//clt_del_check boolean DEFAULT FALSE	# 대도시 삭제여부
    
}

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
public class Festival implements Serializable{
	private static final long serialVersionUID = 9144830003212943493L;
	@Getter private int fval_no 			;//int NOT NULL KEY AUTO_INCREMENT,
    @Getter @Setter private int clm_no 				;//int NOT NULL,
    @Getter @Setter @NonNull private String fval_name 		;//varchar(200) NOT NULL,
    @Getter @Setter @NonNull private String fval_address 	;//varchar(500) NOT NULL,
    @Getter @Setter private String fval_img 		;//varchar(500),
    @Getter @Setter @NonNull private String fval_content	 	;//varchar(3000) NOT NULL,
    @Getter @Setter @NonNull private String fval_tag 		;//varchar(500),
    @Getter @Setter @NonNull private String fval_start_day 	;//date,
    @Getter @Setter @NonNull private String fval_end_day 		;//date,
    @Getter @Setter private int fval_fee 			;//int DEFAULT 0,
    @Getter @Setter private String fval_map_img 		;//varchar(500),
    @Getter @Setter private String fval_homepage 	;//varchar(300),
	@Getter @Setter private String fval_host 		;//varchar(200),
	@Getter @Setter private boolean fval_del_check  ;//fval_del_check boolean DEFAULT FALSE, # 축제 삭제 여부
//    FOREIGN KEY(clm_no) REFERENCES CITY_LAYER_MID(clm_no)
    
}

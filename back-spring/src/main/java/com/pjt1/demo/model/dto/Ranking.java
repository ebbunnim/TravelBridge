package com.pjt1.demo.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

//랭킹 테이블
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Ranking implements Serializable {
	private static final long serialVersionUID = -6639844444532680547L;
	@Getter
	@Setter
    private int city_no;
    @Getter
    @Setter
    private String city_name; 
    @Getter
    @Setter
    private int mem_no;
    @Getter
    @Setter
    private String mem_name; 
    @Getter
    @Setter
    private int ranking; 
    @Getter
    @Setter
    private int city_visited;
}

package com.pjt1.demo.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PartyIn {
	@Getter 
	int partyin_no;
	@Getter
	@Setter
	private int party_no;
	@Getter
	@Setter
	private int mem_no;
	@Getter
	@Setter
	private String mem_name;
	@Getter
	@Setter
	private String mem_email;
	@Getter
	@Setter
	private String mem_phone;
	@Getter
	@Setter
	private String mem_interest;
	@Getter
	@Setter
	private boolean party_del_check;
}

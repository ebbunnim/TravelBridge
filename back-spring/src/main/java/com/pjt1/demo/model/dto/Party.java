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
public class Party {
	@Getter
	private int party_no;
	@Getter
	@Setter
	private int host_no;
	@Getter
	@Setter
	private String host_name;
	@Getter
	@Setter
	private String party_title;
	@Getter
	@Setter
	private String party_contents;
	@Getter
	@Setter
	private String party_regtime;
	@Getter
	@Setter
	private int party_num;
	@Getter
	@Setter
	private boolean party_del_check;
	@Getter
	@Setter
	private List<Comment> party_cmtList;
	@Getter
	@Setter
	private List<Members> party_inMemList;
}

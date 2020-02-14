package com.pjt1.demo.utils;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 최종적으로는 getPageStart()가 반환한 값과 perPageNum을 전달해야 한다.
@ToString
public class MorePageBean {
	@Getter
	@Setter
	private int perPageNum; // 한 페이지당 보여줄 게시글 개수
	@Getter
	@Setter
	private String searchOption; // 검색 조건
	@Getter
	@Setter
	private String word; // 검색단어
	@Getter
	@Setter
	private List<String> filters;// 태그필터링
	@Getter
	@Setter
	private int search_no; //조회하려는 번호
	public MorePageBean() {
		this.perPageNum = 4;
	}
}
package com.pjt1.demo.utils;

import java.util.List;

// 최종적으로는 getPageStart()가 반환한 값과 perPageNum을 전달해야 한다.

public class MorePageBean {
	private int perPageNum; // 한 페이지당 보여줄 게시글 개수
	private String keyword;
	private List<String> filters;
	public MorePageBean() {
		this.perPageNum = 4;
	}

	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "MorePageBean [perPageNum=" + perPageNum + ", keyword=" + keyword + ", filters=" + filters + "]";
	}

	public List<String> getFilters() {
		return filters;
	}

	public void setFilters(List<String> filters) {
		this.filters = filters;
	}
	
}
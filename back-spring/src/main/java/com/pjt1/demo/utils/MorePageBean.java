package com.pjt1.demo.utils;

// 최종적으로는 getPageStart()가 반환한 값과 perPageNum을 전달해야 한다.

public class MorePageBean {
	private int perPageNum; // 한 페이지당 보여줄 게시글 개수
	private String keyword;
	
	public MorePageBean() {
		this.perPageNum = 3;
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
		return "MorePageBean [perPageNum=" + perPageNum + ", keyword=" + keyword + "]";
	}
	
}
package com.pjt1.demo.utils;

// 최종적으로는 getPageStart()가 반환한 값과 perPageNum을 전달해야 한다.

public class PageBean {
	private int page; // 현재 페이지 번호( != 특정 페이지의 첫번째 게시글 번호(이건 getPageStart() 거쳐야 함) )
	private int perPageNum; // 한 페이지당 보여줄 게시글 개수
	public PageBean() {
		setPage(this.page);
		this.perPageNum = 12;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
		} else {
			this.page = page;
		}
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}
	@Override
	public String toString() {
		return "PageBean [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
}
package com.pjt1.demo.utils;

// 최종적으로는 getPageStart()가 반환한 값과 perPageNum을 전달해야 한다.

public class PerPageBean {
	private int page; // 현재 페이지 번호( != 특정 페이지의 첫번째 게시글 번호(이건 getPageStart() 거쳐야 함) )
	private int perPageNum; // 한 페이지당 보여줄 게시글 개수
	private int pageStart;
	
	public int getPageStart() { // 특정 페이지의 게시글 시작번호, 게시글 시작행 번호 리턴
		// pageStart를 이렇게 할당해서 sql문에 넣어야 되었음!
		// paging을 위해서는 swagger에서 page에만 파라미터 넘겨서 확인하기
		pageStart = (this.page - 1) * perPageNum;
		return pageStart;
	}

	public PerPageBean() {
		this.page = 1;
		this.perPageNum = 3;
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

//	public void setPerPageNum(int pageCount) {
//		int cnt = this.perPageNum;
//		if (pageCount != cnt) {
//			this.perPageNum = cnt;
//		} else {
//			this.perPageNum = pageCount;
//		}
//	}
	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}
	@Override
	public String toString() {
		return "PageBean [page=" + page + ", perPageNum=" + perPageNum + ", pageStart=" + pageStart + "]";
	}
	
}
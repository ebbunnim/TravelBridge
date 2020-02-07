package com.pjt1.demo.utils;

// 필요한 것 (특정 페이지의 첫번째 게시글 번호, 전체 게시글 수 )
// 1. setPageBean(PageBean pageBean) - 위에서 필요하다는 page, pagePerNum을 사용 가능하도록
// 2. setTotalCnt(int totalCnt) 
// 모두 void로 값을 넣어주는 역할만 수행

public class PerPageMaker {
	private PerPageBean pageBean; // 여기서 1. 메서드 통해 2. 속성 통해 원하는 조건값을 추출해야
	private int totalCnt;
	private int startPage;
	private int endPage;
	private boolean prev; // 이전 버튼(시작번호가 1이 아니면 생성)
	private boolean next; // 다음 버튼
	private int displayPageBtnNum = 5; // 화면하단에 보여지는 페이지 버튼의 수

	public PerPageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PerPageBean pageBean) {
		this.pageBean = pageBean;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
		calcData(); // 전체 게시글 개수를 센 후에 버튼 개수를 세주는 로직을 구현
	}

	// 총 게시글 수를 셋팅할때 calcData() 메서드를 호출하여 페이징 관련 버튼 계산을 한다.
	// 페이징의 버튼들을 생성하는 계산식을 만들었다. 끝 페이지 번호, 시작 페이지 번호, 이전, 다음 버튼들을 구한다.
	// (PageBean)pageBean.getPage() : 현재 페이지 번호
	// (PageBean)pageBean.getPerPageNum() : 한 페이지 마다 보여줄 게시글 개수
	// (int)totalCnt : 총 게시글 수 (service.getCountBoard() 로 int로 배출할 수 있다.)
	private void calcData() {
		endPage = (int) (Math.ceil(pageBean.getPage() / (double) displayPageBtnNum) * displayPageBtnNum);
		startPage = (endPage - displayPageBtnNum) + 1;
		if (startPage <= 0)
			startPage = 1;
		int tempEndPage = (int) (Math.ceil(totalCnt / (double) pageBean.getPerPageNum()));
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		prev = startPage == 1 ? false : true;
		next = endPage * pageBean.getPerPageNum() < totalCnt ? true : false;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageBtnNum;
	}

	public void setDisplayPageNum(int displayPageBtnNum) {
		this.displayPageBtnNum = displayPageBtnNum;
	}

}
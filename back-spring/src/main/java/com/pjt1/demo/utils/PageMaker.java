package com.pjt1.demo.utils;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 필요한 것 (특정 페이지의 첫번째 게시글 번호, 전체 게시글 수 )
// 1. setPageBean(PageBean pageBean) - 위에서 필요하다는 page, pagePerNum을 사용 가능하도록
// 2. setTotalCnt(int totalCnt) 
// 모두 void로 값을 넣어주는 역할만 수행
@ToString
public class PageMaker {
	private PageBean pageBean; // 여기서 1. 메서드 통해 2. 속성 통해 원하는 조건값을 추출해야
	private int startPage;
	private int endPage;
	private String searchOption;
	private String word;
	private int insert_no;
	private List<String> filters;// 태그필터링
	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = (startPage-1)*this.pageBean.getPerPageNum();
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int startPage) {
		this.endPage = startPage+this.pageBean.getPerPageNum();
	}

	public int getInsert_no() {
		return insert_no;
	}

	public void setInsert_no(int insert_no) {
		this.insert_no = insert_no;
	}
	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}

	public String getSearchOption() {
		return this.searchOption;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getWord() {
		return this.word;
	}

	public List<String> getFilters() {
		return filters;
	}

	public void setFilters(List<String> filters) {
		this.filters = filters;
	}

	@Override
	public String toString() {
		return "PageMaker [pageBean=" + pageBean + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", searchOption=" + searchOption + ", word=" + word + ", insert_no=" + insert_no + ", filters="
				+ filters + "]";
	}
}
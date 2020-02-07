package com.pjt1.demo.utils;

public class MorePageMaker {

	private MorePageBean pageBean;
	private int countBtn;
	public MorePageMaker() {
		super();
		this.countBtn =1;
	}
	public MorePageMaker(MorePageBean pageBean, int countBtn) {
		super();
		this.pageBean = pageBean;
		this.countBtn = 1;
	}
	
	public MorePageBean getMorePageBean() {
		return pageBean;
	}
	public void setMorePageBean(MorePageBean pageBean) {
		this.pageBean = pageBean;
	}
	public int getCountBtn() {
		return countBtn;
	}
	public void setCountBtn(int countBtn) {
		this.countBtn = countBtn;
	}
	@Override
	public String toString() {
		return "MorePage [pageBean=" + pageBean + ", countBtn=" + countBtn + "]";
	}
	
}

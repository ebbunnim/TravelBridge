package com.pjt1.demo.utils;

public class MorePageMaker {

	private MorePageBean pageBean;
	public MorePageMaker() {
		super();
	}
	public MorePageMaker(MorePageBean pageBean) {
		super();
		this.pageBean = pageBean;
	}
	
	public MorePageBean getMorePageBean() {
		return pageBean;
	}
	public void setMorePageBean(MorePageBean pageBean) {
		this.pageBean = pageBean;
	}
	@Override
	public String toString() {
		return "MorePage [pageBean=" + pageBean+ "]";
	}
	
}

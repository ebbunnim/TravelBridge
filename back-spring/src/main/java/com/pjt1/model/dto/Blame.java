package com.pjt1.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class Blame implements Serializable {
	private static final long serialVersionUID = 2909089837996493001L;
	private int blame_no			;//int PRIMARY KEY AUTO_INCREMENT,	#신고 관리번호	기본키,자동증가
	private int mem_no				;//int NOT NULL,	#신고한 회원번호	외래키
	private int target_mem_no		;//int NOT NULL,	#신고당한 회원번호	외래키
	private String blame_time		;//datetime DEFAULT NOW(),	#신고 일시	
    private boolean blame_del_check	;//boolean DEFAULT FALSE,
//	FOREIGN KEY(mem_no) REFERENCES MEMBER(mem_no),
//	FOREIGN KEY(target_mem_no) REFERENCES MEMBER(mem_no)
    
    public Blame() {
    	super();
    }
    public Blame(int mem_no, int target_mem_no) {
    	super();
    	this.mem_no = mem_no;
    	this.target_mem_no = target_mem_no;
    }
    public Blame(int blame_no, int mem_no, int target_mem_no, String blame_time, boolean blame_del_check) {
    	super();
    	this.blame_no = blame_no;
    	this.mem_no = mem_no;
    	this.target_mem_no = target_mem_no;
    	this.blame_time = blame_time;
    	this.blame_del_check = blame_del_check;
    }
    
	@Override
	public String toString() {
		return "Blame [blame_no=" + blame_no + ", mem_no=" + mem_no + ", target_mem_no=" + target_mem_no
				+ ", blame_time=" + blame_time + ", blame_del_check=" + blame_del_check + "]";
	}
	public int getBlame_no() {
		return blame_no;
	}
	public void setBlame_no(int blame_no) {
		this.blame_no = blame_no;
	}
	public int getMem_no() {
		return mem_no;
	}
	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}
	public int getTarget_mem_no() {
		return target_mem_no;
	}
	public void setTarget_mem_no(int target_mem_no) {
		this.target_mem_no = target_mem_no;
	}
	public String getBlame_time() {
		return blame_time;
	}
	public void setBlame_time(String blame_time) {
		this.blame_time = blame_time;
	}
	public boolean isBlame_del_check() {
		return blame_del_check;
	}
	public void setBlame_del_check(boolean blame_del_check) {
		this.blame_del_check = blame_del_check;
	}

    
  
}
package com.pjt1.demo.model.service;

import java.util.List;

import com.pjt1.demo.model.dto.Member;

public interface MemberService {
	public Member search(int no);
	public List<Member> searchAll();
	public void insert(Member Member);
	public void update(Member Member);
	public void delete(int no);
}

package com.pjt1.demo.model.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.demo.model.dto.Member;

@Mapper
public interface MemberDao {
	public Member search(int no);
	public List<Member> searchAll();
	public void insert(Member Member);
	public void update(Member Member);
	public void delete(int no);
}

package com.pjt1.model.dao;


import com.pjt1.model.dto.Member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
	public Member search(int no);
	public List<Member> searchAll();
	public void insert(Member Member);
	public void update(Member Member);
	public void delete(int no);
}

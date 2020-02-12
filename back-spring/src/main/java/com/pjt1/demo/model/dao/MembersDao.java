package com.pjt1.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.demo.model.dto.Follow;
import com.pjt1.demo.model.dto.Members;

@Mapper
public interface MembersDao {
	public Members search(int mem_no);

	public List<Members> searchAll();

	public void insert(Members Members);

	public void update(Members Members);

	public void delete(int mem_no);

	public Members searchMemberByEmail(String email);
	public Members searchMemberLikePost(int mem_no);
	public Members searchMemberLikeHotPlace(int mem_no);
	public Members searchMemberLikeFestival(int mem_no);
	public List<Follow> searchFollowMembers(int mem_no);
}

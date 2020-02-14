package com.pjt1.demo.model.service;

import java.util.List;
import java.util.Map;

import com.pjt1.demo.model.dto.Follow;
import com.pjt1.demo.model.dto.Members;

public interface MembersService {
	public Members search(int mem_no);

	public List<Members> searchAll();

	public void insert(Members Members);

	public void update(Members Members);

	public void delete(int mem_no);

	public Members searchMemberByEmail(String email);
	public Members searchMemberLikePost(int mem_no);
	public Members searchMemberLikeHotPlace(int mem_no);
	public Members searchMemberLikeFestival(int mem_no);
	public Members searchMyFollowPeople(int mem_no);
	public Members searchFollowMePeople(int mem_no);
//	public Members searchFollowingPeoplePost(int mem_no);
	public List<Map<String, Object>> findChildBoard(int no);
	public List<Map<String, Object>> findChildQna(int no);
	public List<Map<String, Object>> findChildFollow(int no);
	public List<Map<String, Object>> findChildLikes(int no);
	public List<Map<String, Object>> findChildPost(int no);
	public List<Map<String, Object>> findChildComment(int no);
	public List<Map<String, Object>> findChildFiles(int no);
	public void deleteChildBoard(List<Integer> list);
	public void deleteChildQna(List<Integer> list);
	public void deleteChildFollow(List<Integer> list);
	public void deleteChildLikes(List<Integer> list);
	public void deleteChildPost(List<Integer> list);
	public void deleteChildComment(List<Integer> list);
	public void deleteChildFiles(List<Integer> list);

}

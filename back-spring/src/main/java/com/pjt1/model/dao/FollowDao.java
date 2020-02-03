package com.pjt1.model.dao;

import java.util.List;

import com.pjt1.model.dto.Follow;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FollowDao {
	public Follow search(int no);
	public List<Follow> searchAll();
	public void insert(Follow Follow);
	public void update(Follow Follow);
	public void delete(int no);
}
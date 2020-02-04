package com.pjt1.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.demo.model.dto.Follow;

@Mapper
public interface FollowDao {
	public Follow search(int follow_no);

	public List<Follow> searchAll();

	public void insert(Follow Follow);

	public void update(Follow Follow);

	public void delete(int follow_no);
}
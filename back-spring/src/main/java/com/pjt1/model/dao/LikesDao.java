package com.pjt1.model.dao;

import java.util.List;

import com.pjt1.model.dto.Likes;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikesDao {
	public Likes search(int no);
	public List<Likes> searchAll();
	public void insert(Likes Likes);
	public void update(Likes Likes);
	public void delete(int no);
}
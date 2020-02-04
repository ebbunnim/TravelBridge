package com.pjt1.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.demo.model.dto.Likes;

@Mapper
public interface LikesDao {
	public Likes search(int like_no);

	public List<Likes> searchAll();

	public void insert(Likes Likes);

	public void update(Likes Likes);

	public void delete(int like_no);
}
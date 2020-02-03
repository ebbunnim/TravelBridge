package com.pjt1.model.dao;

import com.pjt1.model.dto.Post;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostDao {
	public Post search(int no);
	public List<Post> searchAll();
	public void insert(Post Post);
	public void update(Post Post);
	public void delete(int no);
}
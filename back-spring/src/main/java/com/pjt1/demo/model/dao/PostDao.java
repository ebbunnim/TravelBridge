package com.pjt1.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.demo.model.dto.Post;

@Mapper
public interface PostDao {
	public Post search(int no);
	public List<Post> searchAll();
	public void insert(Post Post);
	public void update(Post Post);
	public void delete(int no);
}
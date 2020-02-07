package com.pjt1.demo.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.demo.model.dto.Post;
import com.pjt1.demo.utils.MorePageBean;
import com.pjt1.demo.utils.PerPageBean;

@Mapper
public interface PostDao {
	public Post search(int post_no);

	public List<Post> searchAll();

	public void insert(Post Post);

	public void update(Post Post);

	public void delete(int post_no);

	public Post searchByCategory(String category);
	public void updatePostHits(int post_no);
	public int getCountPostAll();
	public int getCountReport();
	public int getCountPlan();
	public List<Map<String, Object>> searchPagePostAll(PerPageBean pageBean);
	public List<Map<String, Object>> searchPageReport(PerPageBean pageBean);
	public List<Map<String, Object>> searchPagePlan(PerPageBean pageBean);
	public List<Map<String, Object>> searchMorePostAll(MorePageBean pageBean);
	public List<Map<String, Object>> searchMoreReport(MorePageBean pageBean);
	public List<Map<String, Object>> searchMorePlan(MorePageBean pageBean);
}
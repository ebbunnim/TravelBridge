package com.pjt1.demo.model.service;

import java.util.List;
import java.util.Map;

import com.pjt1.demo.model.dto.Post;
import com.pjt1.demo.utils.MorePageBean;

public interface PostService {
	public Post search(int post_no);
	public List<Post> searchAll();
	public void insert(Post Post);
	public void update(Post Post);
	public void delete(int post_no);
	public List<Map<String, Object>> findChildLike(int no);
	public void deleteChildLike(List<Integer> list);
	public List<Map<String, Object>> findChildCmt(int no);
	public void deleteChildCmt(List<Integer> list);
	public List<Map<String, Object>> findChildFiles(int no);
	public void deleteChildFiles(List<Integer> list);
	public Post searchByCategory(String category);
	public void updatePostHits(int post_no);
	public List<Map<String, Object>> searchMorePostAll(MorePageBean pageBean);
	public List<Map<String, Object>> searchMoreReport(MorePageBean pageBean);
	public List<Map<String, Object>> searchMorePlan(MorePageBean pageBean);
	public Post searchWithCmtAndFiles(int post_no);
}

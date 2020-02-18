package com.pjt1.demo.model.service;

import java.util.List;
import java.util.Map;

import com.pjt1.demo.model.dto.Post;
import com.pjt1.demo.utils.MorePageBean;
import com.pjt1.demo.utils.PageBean;
import com.pjt1.demo.utils.PageMaker;

public interface PostService {
	public Post search(int post_no);

	public List<Post> searchAll();

	public List<Map<String, Object>> searchPagePostAll(PageMaker page);

	public List<Map<String, Object>> searchPagePost(PageMaker page);

	public List<Map<String, Object>> searchPagePlan(PageMaker page);

	public List<Post> searchFollowingPeoplePost(int mem_no);

	public List<Map<String, Object>> searchMorePostByOption(PageMaker pageMaker);

	public int getPostLikes(int post_no);

	public void updatePostHits(int post_no);

	public void insert(Post Post);

	public void update(Post Post);

	public void delete(int post_no);
	public List<Map<String, Object>> findChildLike(int no);

	public void deleteChildLike(List<Integer> list);

	public List<Map<String, Object>> findChildCmt(int no);

	public void deleteChildCmt(List<Integer> list);

	public List<Map<String, Object>> findChildFiles(int no);

	public void deleteChildFiles(List<Integer> list);

	public List<Post> searchFollowingPost(int following_no);
}

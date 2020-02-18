package com.pjt1.demo.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.demo.model.dto.Members;
import com.pjt1.demo.model.dto.Post;
import com.pjt1.demo.utils.MorePageBean;
import com.pjt1.demo.utils.PageBean;
import com.pjt1.demo.utils.PageMaker;

@Mapper
public interface PostDao {
	public Post search(int post_no);
<<<<<<< HEAD
	public List<Post> searchAll();
	public List<Map<String, Object>> searchPagePostAll(PageMaker page);
	public List<Map<String, Object>> searchPagePost(PageMaker page);
	public List<Map<String, Object>> searchPagePlan(PageMaker page);
	public List<Post> searchFollowingPeoplePost(int mem_no);
	public int getPostLikes(int post_no);
	public void updatePostHits(int post_no);
=======

	public List<Post> searchAll();

	public List<Map<String, Object>> searchPagePostAll(PageMaker page);

	public List<Map<String, Object>> searchPageReport(PageMaker page);

	public List<Map<String, Object>> searchPagePlan(PageMaker page);

	public List<Post> searchFollowingPeoplePost(int mem_no);

	public List<Map<String, Object>> searchMorePostByOption(PageBean pageBean);

	public int getPostLikes(int post_no);

	public void updatePostHits(int post_no);

>>>>>>> 6511ea245cbd2206eb958212e5fbf6cdd007d64c
	public void insert(Post Post);
	public void update(Post Post);
	public void delete(int post_no);

	public List<Map<String, Object>> findChildLike(int no);

	public void deleteChildLike(List<Integer> list);

	public List<Map<String, Object>> findChildCmt(int no);

	public void deleteChildCmt(List<Integer> list);

	public List<Map<String, Object>> findChildFiles(int no);

	public void deleteChildFiles(List<Integer> list);

<<<<<<< HEAD
	
}
=======
	public List<Post> searchFollowingPost(int following_no);

}
>>>>>>> 6511ea245cbd2206eb958212e5fbf6cdd007d64c

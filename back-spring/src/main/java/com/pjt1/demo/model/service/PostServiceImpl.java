package com.pjt1.demo.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.PostDao;
import com.pjt1.demo.model.dto.Post;
import com.pjt1.demo.utils.MorePageBean;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao repo;
	@Override
	public Post search(int post_no) {
		try {
			return repo.search(post_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Post> searchAll() {
		try {
			return repo.searchAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void insert(Post Post) {
		try {
			repo.insert(Post);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void update(Post Post) {
		try {
			repo.update(Post);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void delete(int post_no) {
		try {
			repo.delete(post_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Map<String, Object>> findChildLike(int no){
		try {
			return repo.findChildLike(no);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
	public void deleteChildLike(List<Integer> list) {
		try {
			repo.deleteChildLike(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
	public List<Map<String, Object>> findChildCmt(int no){
		try {
			return repo.findChildCmt(no);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
	public void deleteChildCmt(List<Integer> list) {
		try {
			repo.deleteChildCmt(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Map<String, Object>> findChildFiles(int no){
		try {
			return repo.findChildFiles(no);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
	public void deleteChildFiles(List<Integer> list) {
		try {
			repo.deleteChildFiles(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updatePostHits(int post_no) {
		try {
			repo.updatePostHits(post_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public Post searchByCategory(String category) {
		try {
			return repo.searchByCategory(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Map<String, Object>> searchMorePostAll(MorePageBean pageBean){
		try {
			return repo.searchMorePostAll(pageBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Map<String, Object>> searchMoreReport(MorePageBean pageBean){
		try {
			return repo.searchMoreReport(pageBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Map<String, Object>> searchMorePlan(MorePageBean pageBean){
		try {
			return repo.searchMorePlan(pageBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public Post searchWithCmtAndFiles(int post_no) {
		try {
			Post pos = repo.searchWithCmtAndFiles(post_no);
			return pos;
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
}

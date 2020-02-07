package com.pjt1.demo.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.PostDao;
import com.pjt1.demo.model.dto.Post;
import com.pjt1.demo.utils.MorePageBean;
import com.pjt1.demo.utils.PerPageBean;

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
			;
		}
		return null;
	}

	@Override
	public List<Post> searchAll() {
		try {
			return repo.searchAll();
		} catch (Exception e) {
			e.printStackTrace();
			;
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

	public List<Map<String, Object>> searchPagePostAll(PerPageBean pageBean){
		try {
			return repo.searchPagePostAll(pageBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Map<String, Object>> searchPageReport(PerPageBean pageBean){
		try {
			return repo.searchPageReport(pageBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Map<String, Object>> searchPagePlan(PerPageBean pageBean){
		try {
			return repo.searchPagePlan(pageBean);
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
	
	public int getCountPostAll() {
		try {
			int res = repo.getCountPostAll();
			return res;
		}catch(Exception e) {
			e.printStackTrace();
		}return 0;
	};
	public int getCountReport() {
		try {
			int res = repo.getCountReport();
			return res;
		}catch(Exception e) {
			e.printStackTrace();
		}return 0;
	};

	public int getCountPlan() {
		try {
			int res = repo.getCountPlan();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}

package com.pjt1.demo.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.PostDao;
import com.pjt1.demo.model.dto.Post;
import com.pjt1.demo.utils.PageBean;
import com.pjt1.demo.utils.PageMaker;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao repo;
	
	public Post search(int post_no) {
		try {
			return repo.search(post_no);
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}

	public List<Post> searchAll() {
		try {
			return repo.searchAll();
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<Map<String, Object>> searchPagePostAll(PageMaker page){
		try {
			return repo.searchPagePostAll(page);
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<Map<String, Object>> searchPagePost(PageMaker page){
		try {
			return repo.searchPagePost(page);
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<Map<String, Object>> searchPagePlan(PageMaker page){
		try {
			return repo.searchPagePlan(page);
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
	
	public List<Post> searchFollowingPeoplePost(int mem_no) {
		try {
			return repo.searchFollowingPeoplePost(mem_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getPostLikes(int post_no) {
		try {
			return repo.getPostLikes(post_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	};

	public void updatePostHits(int post_no) {
		try {
			repo.updatePostHits(post_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(Post Post) {
		try {
			repo.insert(Post);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Post Post) {
		try {
			repo.update(Post);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(int post_no) {
		try {
			repo.delete(post_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Map<String, Object>> searchMorePostByOption(PageBean pageBean) {
		try {
			return repo.searchMorePostByOption(pageBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Map<String, Object>> findChildLike(int no) {
		try {
			return repo.findChildLike(no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteChildLike(List<Integer> list) {
		try {
			repo.deleteChildLike(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Map<String, Object>> findChildCmt(int no) {
		try {
			return repo.findChildCmt(no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteChildCmt(List<Integer> list) {
		try {
			repo.deleteChildCmt(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Map<String, Object>> findChildFiles(int no) {
		try {
			return repo.findChildFiles(no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteChildFiles(List<Integer> list) {
		try {
			repo.deleteChildFiles(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Post> searchFollowingPost(int following_no) {
		try {
			return repo.searchFollowingPost(following_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	

}

package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.FollowDao;
import com.pjt1.demo.model.dto.Follow;
import com.pjt1.demo.model.dto.Members;

@Service
public class FollowServiceImpl implements FollowService {
	@Autowired
	private FollowDao repo;

	@Override
	public Follow search(int follow_no) {
		try {
			return repo.search(follow_no);
		} catch (Exception e) {
			e.printStackTrace();
			;
		}
		return null;
	}

	@Override
	public List<Follow> searchAll() {
		try {
			return repo.searchAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(Follow Follow) {
		try {
			repo.insert(Follow);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Follow Follow) {
		try {
			repo.update(Follow);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int follow_no) {
		try {
			repo.delete(follow_no);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Follow> searchMemberList(int follower_no) {
		try {
			return repo.searchMemberList(follower_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

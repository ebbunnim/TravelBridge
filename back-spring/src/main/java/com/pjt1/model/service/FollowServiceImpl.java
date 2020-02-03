package com.pjt1.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.model.dto.Follow;
@Service
public class FollowServiceImpl implements FollowService {
	@Autowired
	private FollowService repo;
	@Override
	public Follow search(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Follow> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Follow Follow) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Follow Follow) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int no) {
		// TODO Auto-generated method stub

	}

}

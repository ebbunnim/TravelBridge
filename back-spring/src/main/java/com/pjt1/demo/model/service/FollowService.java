package com.pjt1.demo.model.service;

import java.util.List;

import com.pjt1.demo.model.dto.Follow;

public interface FollowService {
	public Follow search(int follow_no);

	public List<Follow> searchAll();

	public void insert(Follow Follow);

	public void update(Follow Follow);

	public void delete(int follow_no);
}
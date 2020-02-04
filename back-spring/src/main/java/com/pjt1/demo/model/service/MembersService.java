package com.pjt1.demo.model.service;

import java.util.List;

import com.pjt1.demo.model.dto.Members;

public interface MembersService {
	public Members search(int mem_no);

	public List<Members> searchAll();

	public void insert(Members Members);

	public void update(Members Members);

	public void delete(int mem_no);
}

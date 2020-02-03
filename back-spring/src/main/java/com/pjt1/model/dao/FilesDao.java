package com.pjt1.model.dao;

import java.util.List;

import com.pjt1.model.dto.Files;

public interface FilesDao {
	public Files search(int no);
	public List<Files> searchAll();
	public void insert(Files Files);
	public void update(Files Files);
	public void delete(int no);
}

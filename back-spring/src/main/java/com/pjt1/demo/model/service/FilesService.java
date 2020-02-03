package com.pjt1.demo.model.service;

import java.util.List;

import com.pjt1.demo.model.dto.Files;

public interface FilesService {
	public Files search(int no);
	public List<Files> searchAll();
	public void insert(Files Files);
	public void update(Files Files);
	public void delete(int no);
}

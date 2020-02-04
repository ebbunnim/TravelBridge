package com.pjt1.demo.model.dao;

import java.util.List;

import com.pjt1.demo.model.dto.Files;

import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface FilesDao {
	public Files search(int files_no);

	public List<Files> searchAll();

	public void insert(Files Files);

	public void update(Files Files);

	public void delete(int files_no);
}

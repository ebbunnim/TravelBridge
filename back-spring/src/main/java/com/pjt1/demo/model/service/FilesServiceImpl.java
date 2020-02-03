package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dto.Files;

@Service
public class FilesServiceImpl implements FilesService {
	
	@Autowired 
	private FilesService repo;
	@Override
	public Files search(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Files> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Files Files) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Files Files) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int no) {
		// TODO Auto-generated method stub

	}

}

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
	public Files search(int files_no ) {
		// TODO Auto-generated method stub
		try {
			return repo.search(files_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Files> searchAll() {
		// TODO Auto-generated method stub
		try {
			return repo.searchAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(Files Files) {
		// TODO Auto-generated method stub
		try {
			repo.insert(Files);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Files Files) {
		// TODO Auto-generated method stub
		try {
			repo.update(Files);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int files_no ) {
		// TODO Auto-generated method stub
		try {
			repo.delete(files_no);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}

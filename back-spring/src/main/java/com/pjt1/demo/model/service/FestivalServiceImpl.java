package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.SneakyThrows;
import com.pjt1.demo.model.dto.Festival;


@Service
public class FestivalServiceImpl implements FestivalService {
	
	@Autowired
	private FestivalService repo;
	
	public Festival search(int fval_no) {
		try {
			return repo.search(fval_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public List<Festival> searchAll() {
		try {
			return repo.searchAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		

	}

	public void insert(Festival Festival) {
		try {
			repo.insert(Festival);
		} catch(Exception e) {
			e.printStackTrace();
		}
		

	}

	public void update(Festival Festival) {
		try {
			repo.update(Festival);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void delete(int fval_no) {
		try {
			repo.delete(fval_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

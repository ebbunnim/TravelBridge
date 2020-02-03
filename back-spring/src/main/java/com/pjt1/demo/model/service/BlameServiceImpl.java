package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.BlameDao;
import com.pjt1.demo.model.dto.Blame;


@Service
public class BlameServiceImpl implements BlameService {

	@Autowired
	private BlameDao repo;

	public Blame search(int blame_no) {
		try {
			return repo.search(blame_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Blame> searchAll() {
		try {
			return repo.searchAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

	public void insert(Blame Blame) {
		try {
			repo.insert(Blame);
		} 
		catch(Exception e) {
			e.printStackTrace();
		}

		
	}

	public void update(Blame Blame) {
		try {
			repo.update(Blame);
		} catch(Exception e) {
			e.printStackTrace();
		}

		
	}

	public void delete(int blame_no) {
		try {
			repo.delete(blame_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

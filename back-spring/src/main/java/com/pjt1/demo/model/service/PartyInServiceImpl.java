package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.PartyInDao;
import com.pjt1.demo.model.dto.PartyIn;

 
@Service
public class PartyInServiceImpl implements PartyInService {

	@Autowired
	private PartyInDao repo;
	
	public PartyIn search(int partyin_no) {
		try {
			return repo.search(partyin_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public List<PartyIn> searchAll() {
		try {
			return repo.searchAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public void insert(PartyIn partyin) {
		try {
			repo.insert(partyin);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void update(PartyIn partyin) {
		try {
			repo.update(partyin);
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}

	public void delete(int partyin_no) {
		try {
			repo.delete(partyin_no);
		} catch(Exception e) {
			e.printStackTrace();
		}	
		
	}
	public List<PartyIn> searchPartyList(int partyin_no){
		try {
			return repo.searchPartyList(partyin_no);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}

}

package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.PartyDao;
import com.pjt1.demo.model.dto.Party;

 
@Service
public class PartyServiceImpl implements PartyService {

	@Autowired
	private PartyDao repo;
	
	public Party search(int party_no) {
		try {
			return repo.search(party_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public List<Party> searchAll() {
		try {
			return repo.searchAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public void insert(Party party) {
		try {
			repo.insert(party);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void update(Party party) {
		try {
			repo.update(party);
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}

	public void delete(int party_no) {
		try {
			repo.delete(party_no);
		} catch(Exception e) {
			e.printStackTrace();
		}	
		
	}

}

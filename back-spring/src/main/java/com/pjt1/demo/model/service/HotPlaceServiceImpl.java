package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.HotPlaceDao;
import com.pjt1.demo.model.dto.HotPlace;

@Service
public class HotPlaceServiceImpl implements HotPlaceService {

	@Autowired
	private HotPlaceDao repo;

	public HotPlace search(int hp_no) {
		try {
			return repo.search(hp_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public List<HotPlace> searchAll() {
		try {
			return repo.searchAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public void insert(HotPlace HotPlace) {
		try {
			repo.insert(HotPlace);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void update(HotPlace HotPlace) {
		try {
			repo.update(HotPlace);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(int hp_no) {
		try {
			repo.delete(hp_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.CityDao;
import com.pjt1.demo.model.dto.City;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityDao repo;

	public City search(int City_no) {
		try {
			return repo.search(City_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public List<City> searchAll() {
		try {
			return repo.searchAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public void insert(City City) {
		try {
			repo.insert(City);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void update(City City) {
		try {
			repo.update(City);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(int City_no) {
		try {
			repo.delete(City_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

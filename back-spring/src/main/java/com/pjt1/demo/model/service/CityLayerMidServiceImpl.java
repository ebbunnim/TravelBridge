package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.CityLayerMidDao;
import com.pjt1.demo.model.dto.CityLayerMid;


@Service
public class CityLayerMidServiceImpl implements CityLayerMidService {

	@Autowired
	private CityLayerMidDao repo;
	
	public CityLayerMid search(int city_layer_mid_no) {
		try {
			return repo.search(city_layer_mid_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;	
		
	}

	public List<CityLayerMid> searchAll() {
		try {
			return repo.searchAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public void insert(CityLayerMid CityLayerMid) {
		try {
			repo.insert(CityLayerMid);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void update(CityLayerMid CityLayerMid) {
		try {
			repo.update(CityLayerMid);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void delete(int city_layer_mid_no) {
		try {
			repo.delete(city_layer_mid_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

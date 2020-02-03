package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dto.CityLayerTop;

import lombok.SneakyThrows;

@Service
public class CityLayerTopServiceImpl implements CityLayerTopService {

	@Autowired
	private CityLayerTopService repo;
	
	public CityLayerTop search(int city_layer_top_no) {
		try {
			return repo.search(city_layer_top_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public List<CityLayerTop> searchAll() {
		try {
			return repo.searchAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public void insert(CityLayerTop CityLayerTop) {
		try {
			repo.insert(CityLayerTop);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void update(CityLayerTop CityLayerTop) {
		try {
			repo.update(CityLayerTop);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void delete(int city_layer_top_no) {
		try {
			repo.delete(city_layer_top_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}

package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dto.CityLayerBottom;

import lombok.SneakyThrows;


@Service
public class CityLayerBottomServiceImpl implements CityLayerBottomService {

	@Autowired
	private CityLayerBottomService repo;
	
	public CityLayerBottom search(int city_layer_bottom_no) {
		try {
			return repo.search(city_layer_bottom_no);
		} catch(Exception e) {
			e.printStackTrace();
		}	
		return null;

		
	}

	public List<CityLayerBottom> searchAll() {
		try {
			return repo.searchAll();
		} catch(Exception e) {
			e.printStackTrace();
		}	
		return null;
		
	}

	public void insert(CityLayerBottom CityLayerBottom) {
		try {
			repo.insert(CityLayerBottom);
		} catch(Exception e) {
			e.printStackTrace();
		}	
		
	}

	public void update(CityLayerBottom CityLayerBottom) {
		try {
			repo.update(CityLayerBottom);
		} catch(Exception e) {
			e.printStackTrace();
		}	
		
	}

	public void delete(int city_layer_bottom_no) {
		try {
			repo.delete(city_layer_bottom_no);
		} catch(Exception e) {
			e.printStackTrace();
		}	
		
	}

}

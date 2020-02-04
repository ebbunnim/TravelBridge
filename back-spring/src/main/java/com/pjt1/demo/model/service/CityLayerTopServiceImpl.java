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
	
	@SneakyThrows(Exception.class)
	public CityLayerTop search(int city_layer_top_no) {
		return repo.search(city_layer_top_no);
	}

	@SneakyThrows(Exception.class)
	public List<CityLayerTop> searchAll() {
		return repo.searchAll();
	}

	@SneakyThrows(Exception.class)
	public void insert(CityLayerTop CityLayerTop) {
		repo.insert(CityLayerTop);
	}

	@SneakyThrows(Exception.class)
	public void update(CityLayerTop CityLayerTop) {
		repo.update(CityLayerTop);
	}

	@SneakyThrows(Exception.class)
	public void delete(int city_layer_top_no) {
		repo.delete(city_layer_top_no);
	}

}

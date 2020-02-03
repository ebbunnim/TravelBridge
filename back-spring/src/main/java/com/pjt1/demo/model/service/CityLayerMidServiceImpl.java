package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dto.CityLayerMid;

import lombok.SneakyThrows;

@Service
public class CityLayerMidServiceImpl implements CityLayerMidService {

	@Autowired
	private CityLayerMidService repo;
	
	@SneakyThrows(Exception.class)
	public CityLayerMid search(int city_layer_mid_no) {
		return repo.search(city_layer_mid_no);
	}

	@SneakyThrows(Exception.class)
	public List<CityLayerMid> searchAll() {
		return repo.searchAll();
	}

	@SneakyThrows(Exception.class)
	public void insert(CityLayerMid CityLayerMid) {
		repo.insert(CityLayerMid);
	}

	@SneakyThrows(Exception.class)
	public void update(CityLayerMid CityLayerMid) {
		repo.update(CityLayerMid);
	}

	@SneakyThrows(Exception.class)
	public void delete(int city_layer_mid_no) {
		repo.delete(city_layer_mid_no);
	}

}

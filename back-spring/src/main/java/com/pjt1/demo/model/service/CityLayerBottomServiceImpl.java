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
	
	@SneakyThrows(Exception.class)
	public CityLayerBottom search(int city_layer_bottom_no) {
		return repo.search(city_layer_bottom_no);
	}

	@SneakyThrows(Exception.class)
	public List<CityLayerBottom> searchAll() {
		return repo.searchAll();
	}

	@SneakyThrows(Exception.class)
	public void insert(CityLayerBottom CityLayerBottom) {
		repo.insert(CityLayerBottom);
	}

	@SneakyThrows(Exception.class)
	public void update(CityLayerBottom CityLayerBottom) {
		repo.update(CityLayerBottom);
	}

	@SneakyThrows(Exception.class)
	public void delete(int city_layer_bottom_no) {
		repo.delete(city_layer_bottom_no);
	}

}

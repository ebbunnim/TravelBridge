package com.pjt1.model.service;

import java.util.List;

import com.pjt1.model.dto.CityLayerBottom;

public interface CityLayerBottomService {
	public CityLayerBottom search(int city_layer_bottom_no);
	public List<CityLayerBottom> searchAll();
	public void insert(CityLayerBottom CityLayerBottom);
	public void update(CityLayerBottom CityLayerBottom);
	public void delete(int city_layer_bottom_no);
}

package com.pjt1.demo.model.service;

import java.util.List;

import com.pjt1.demo.model.dto.CityLayerMid;

public interface CityLayerMidService {
	public CityLayerMid search(int city_layer_mid_no);
	public List<CityLayerMid> searchAll();
	public void insert(CityLayerMid CityLayerMid);
	public void update(CityLayerMid CityLayerMid);
	public void delete(int city_layer_mid_no);
}

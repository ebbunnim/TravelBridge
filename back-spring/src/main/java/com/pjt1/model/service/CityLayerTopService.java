package com.pjt1.model.service;

import java.util.List;

import com.pjt1.model.dto.CityLayerTop;

public interface CityLayerTopService {
	public CityLayerTop search(int no);
	public List<CityLayerTop> searchAll();
	public void insert(CityLayerTop CityLayerTop);
	public void update(CityLayerTop CityLayerTop);
	public void delete(int no);
}

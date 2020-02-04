package com.pjt1.demo.model.service;

import java.util.List;

import com.pjt1.demo.model.dto.CityLayerTop;

public interface CityLayerTopService {
	public CityLayerTop search(int clt_no);

	public List<CityLayerTop> searchAll();

	public void insert(CityLayerTop CityLayerTop);

	public void update(CityLayerTop CityLayerTop);

	public void delete(int clt_no);
}

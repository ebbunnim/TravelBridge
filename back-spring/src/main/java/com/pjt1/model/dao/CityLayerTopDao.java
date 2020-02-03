package com.pjt1.model.dao;

import java.util.List;

import com.pjt1.model.dto.CityLayerTop;

public interface CityLayerTopDao {
	public CityLayerTop search(int no);
	public List<CityLayerTop> searchAll();
	public void insert(CityLayerTop CityLayerTop);
	public void update(CityLayerTop CityLayerTop);
	public void delete(int no);
}

package com.pjt1.model.dao;

import java.util.List;

import com.pjt1.model.dto.CityLayerBottom;

public interface CityLayerBottomDao {
	public CityLayerBottom search(int no);
	public List<CityLayerBottom> searchAll();
	public void insert(CityLayerBottom CityLayerBottom);
	public void update(CityLayerBottom CityLayerBottom);
	public void delete(int no);
}

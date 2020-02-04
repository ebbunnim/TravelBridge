package com.pjt1.demo.model.dao;

import java.util.List;

import com.pjt1.demo.model.dto.CityLayerBottom;

public interface CityLayerBottomDao {
	public CityLayerBottom search(int no);
	public List<CityLayerBottom> searchAll();
	public void insert(CityLayerBottom CityLayerBottom);
	public void update(CityLayerBottom CityLayerBottom);
	public void delete(int no);
}

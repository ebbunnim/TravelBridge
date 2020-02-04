package com.pjt1.demo.model.service;

import java.util.List;

import com.pjt1.demo.model.dto.CityLayerBottom;

public interface CityLayerBottomService {
	public CityLayerBottom search(int clb_no);

	public List<CityLayerBottom> searchAll();

	public void insert(CityLayerBottom CityLayerBottom);

	public void update(CityLayerBottom CityLayerBottom);

	public void delete(int clb_no);
}

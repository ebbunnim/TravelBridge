package com.pjt1.model.service;

import java.util.List;

import com.pjt1.model.dto.CityLayerMid;

public interface CityLayerMidService {
	public CityLayerMid search(int no);
	public List<CityLayerMid> searchAll();
	public void insert(CityLayerMid CityLayerMid);
	public void update(CityLayerMid CityLayerMid);
	public void delete(int no);
}

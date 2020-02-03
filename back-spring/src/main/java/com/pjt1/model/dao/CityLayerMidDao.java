package com.pjt1.model.dao;

import java.util.List;

import com.pjt1.model.dto.CityLayerMid;

public interface CityLayerMidDao {
	public CityLayerMid search(int no);
	public List<CityLayerMid> searchAll();
	public void insert(CityLayerMid CityLayerMid);
	public void update(CityLayerMid CityLayerMid);
	public void delete(int no);
}

package com.pjt1.demo.model.dao;

import java.util.List;

import com.pjt1.demo.model.dto.CityLayerTop;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CityLayerTopDao {
	public CityLayerTop search(int clt_no);

	public List<CityLayerTop> searchAll();

	public void insert(CityLayerTop CityLayerTop);

	public void update(CityLayerTop CityLayerTop);

	public void delete(int clt_no);
}

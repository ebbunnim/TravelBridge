package com.pjt1.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.demo.model.dto.City;

@Mapper
public interface CityDao {
	
	public City search(int city_no);
	public List<City> searchAll();
	public void insert(City City);
	public void update(City City);
	public void delete(int city_no);
}
package com.pjt1.demo.model.service;

import java.util.List;

import com.pjt1.demo.model.dto.City;


public interface CityService {
	
	public City search(int city_no);
	public List<City> searchAll();
	public void insert(City City);
	public void update(City City);
	public void delete(int city_no);
}
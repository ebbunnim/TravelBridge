package com.pjt1.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.model.dto.CityLayerTop;

@Service
public class CityLayerTopServiceImpl implements CityLayerTopService {

	@Autowired
	private CityLayerTopService repo;
	
	@Override
	public CityLayerTop search(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityLayerTop> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(CityLayerTop CityLayerTop) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CityLayerTop CityLayerTop) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int no) {
		// TODO Auto-generated method stub

	}

}

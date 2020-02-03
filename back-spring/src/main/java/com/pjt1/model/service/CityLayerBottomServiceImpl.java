package com.pjt1.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.model.dto.CityLayerBottom;


@Service
public class CityLayerBottomServiceImpl implements CityLayerBottomService {

	@Autowired
	private CityLayerBottomService repo;
	
	@Override
	public CityLayerBottom search(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityLayerBottom> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(CityLayerBottom CityLayerBottom) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CityLayerBottom CityLayerBottom) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int no) {
		// TODO Auto-generated method stub

	}

}

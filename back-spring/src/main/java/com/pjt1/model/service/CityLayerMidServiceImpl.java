package com.pjt1.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.model.dto.CityLayerMid;

@Service
public class CityLayerMidServiceImpl implements CityLayerMidService {

	@Autowired
	private CityLayerMidService repo;
	
	@Override
	public CityLayerMid search(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityLayerMid> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(CityLayerMid CityLayerMid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CityLayerMid CityLayerMid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int no) {
		// TODO Auto-generated method stub

	}

}

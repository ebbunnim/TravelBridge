package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.CityLayerBottomDao;
import com.pjt1.demo.model.dto.CityLayerBottom;

@Service
public class CityLayerBottomServiceImpl implements CityLayerBottomService {

	@Autowired
	private CityLayerBottomDao repo;

	public CityLayerBottom search(int clb_no) {
		try {
			return repo.search(clb_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<CityLayerBottom> searchAll() {
		try {
			return repo.searchAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public void insert(CityLayerBottom CityLayerBottom) {
		try {
			repo.insert(CityLayerBottom);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(CityLayerBottom CityLayerBottom) {
		try {
			repo.update(CityLayerBottom);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(int clb_no) {
		try {
			repo.delete(clb_no);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

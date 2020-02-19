package com.pjt1.demo.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.HotPlaceDao;
import com.pjt1.demo.model.dto.HotPlace;
import com.pjt1.demo.utils.MorePageBean;
import com.pjt1.demo.utils.PageMaker;

@Service
public class HotPlaceServiceImpl implements HotPlaceService {

	@Autowired
	private HotPlaceDao repo;

	public HotPlace search(int hp_no) {
		try {
			return repo.search(hp_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public List<HotPlace> searchAll() {
		try {
			return repo.searchAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public void insert(HotPlace HotPlace) {
		try {
			repo.insert(HotPlace);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void update(HotPlace HotPlace) {
		try {
			repo.update(HotPlace);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(int hp_no) {
		try {
			repo.delete(hp_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public int getCountHotPlaceAll() {
		try {
			return repo.getCountHotPlaceAll();
		}catch(Exception e) {
			e.printStackTrace();
		}return 0;
	}
	public int getCountHotPlaceByCityName(String cityName) {
		try {
			return repo.getCountHotPlaceByCityName(cityName);
		}catch(Exception e) {
			e.printStackTrace();
		}return 0;
	}
	public int getCountHotPlaceByTag(String tag) {
		try {
			return repo.getCountHotPlaceByTag(tag);
		}catch(Exception e) {
			e.printStackTrace();
		}return 0;	
	}
	public int getCountHotPlaceByAddress(String address) {
		try {
			return repo.getCountHotPlaceByAddress(address);
		}catch(Exception e) {
			e.printStackTrace();
		}return 0;
	}

	public List<Map<String, Object>> searchMoreHotPlaceAll(MorePageBean pageBean){
		try {
			return repo.searchMoreHotPlaceAll(pageBean);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<Map<String, Object>> searchMoreHotPlaceByCityName(MorePageBean pageBean){
		try {
			return repo.searchMoreHotPlaceByCityName(pageBean);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}

	public List<Map<String, Object>> searchMoreHotPlaceByTag(MorePageBean pageBean){
		try {
			return repo.searchMoreHotPlaceByTag(pageBean);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<Map<String, Object>> searchMoreHotPlaceByAddress(MorePageBean pageBean){
		try {
			return repo.searchMoreHotPlaceByAddress(pageBean);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}

	public List<Map<String, Object>> searchMoreHotPlaceByTheme(MorePageBean pageBean){
		try {
			return repo.searchMoreHotPlaceByTheme(pageBean);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<Map<String, Object>> searchMoreHotPlace(MorePageBean pageBean){
		try {
			return repo.searchMoreHotPlace(pageBean);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<HotPlace> searchPageHotPlaceAll(PageMaker page){
		try {
			return repo.searchPageHotPlaceAll(page);
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<HotPlace> searchPageHotPlaceByCityName(PageMaker page){
		try {
			return repo.searchPageHotPlaceByCityName(page);
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<HotPlace> searchPageHotPlaceByTag(PageMaker page){
		try {
			return repo.searchPageHotPlaceByTag(page);
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<HotPlace> searchPageHotPlaceByAddress(PageMaker page){
		try {
			return repo.searchPageHotPlaceByAddress(page);
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<HotPlace> searchPageHotPlaceByTheme(PageMaker page){
		try {
			return repo.searchPageHotPlaceByTheme(page);
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<HotPlace> searchPageHotPlace(PageMaker page){
		try {
			return repo.searchPageHotPlace(page);
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<Map<String, Object>> findChildLike(int no){
		try {
			return repo.findChildLike(no);
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
	public void deleteChildLike(List<Integer> list){
		try {
			repo.deleteChildLike(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.pjt1.demo.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.FestivalDao;
import com.pjt1.demo.model.dto.Festival;
import com.pjt1.demo.utils.MorePageBean;
import com.pjt1.demo.utils.PageMaker;


@Service
public class FestivalServiceImpl implements FestivalService {
	
	@Autowired
	private FestivalDao repo;
	
	public Festival search(int fval_no) {
		try {
			return repo.search(fval_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Festival> searchAll() {
		try {
			return repo.searchAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void insert(Festival Festival) {
		try {
			repo.insert(Festival);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void update(Festival Festival) {
		try {
			repo.update(Festival);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void delete(int fval_no) {
		try {
			repo.delete(fval_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int getCountFestivalAll() {
		try {
			return repo.getCountFestivalAll();
		}catch(Exception e) {
			e.printStackTrace();
		}return 0;
	}
	public int getCountFestivalByCityName(String cityName) {
		try {
			return repo.getCountFestivalByCityName(cityName);
		}catch(Exception e) {
			e.printStackTrace();
		}return 0;
	}
	public int getCountFestivalByTag(String tag) {
		try {
			return repo.getCountFestivalByTag(tag);
		}catch(Exception e) {
			e.printStackTrace();
		}return 0;	
	}
	public List<Map<String, Object>> searchMoreFestivalAll(MorePageBean pageBean){
		try {
			return repo.searchMoreFestivalAll(pageBean);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<Map<String, Object>> searchMoreFestivalByCityName(MorePageBean pageBean){
		try {
			return repo.searchMoreFestivalByCityName(pageBean);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<Map<String, Object>> searchMoreFestivalByTag(MorePageBean pageBean){
		try {
			return repo.searchMoreFestivalByTag(pageBean);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<Map<String, Object>> searchMoreFestivalByTheme(MorePageBean pageBean){
		try {
			return repo.searchMoreFestivalByTheme(pageBean);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<Map<String, Object>> searchMoreFestival(MorePageBean pageBean){
		try {
			return repo.searchMoreFestival(pageBean);
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
	public List<Festival> searchPageFestivalAll(PageMaker pageBean){
		try {
			return repo.searchPageFestivalAll(pageBean);
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<Festival> searchPageFestivalByCityName(PageMaker pageBean){
		try {
			return repo.searchPageFestivalByCityName(pageBean);
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<Festival> searchPageFestivalByTag(PageMaker pageBean){
		try {
			return repo.searchPageFestivalByTag(pageBean);
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<Festival> searchPageFestivalByTheme(PageMaker pageBean){
		try {
			return repo.searchPageFestivalByTheme(pageBean);
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<Festival> searchPageFestival(PageMaker pageBean){
		try {
			return repo.searchPageFestival(pageBean);
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
}

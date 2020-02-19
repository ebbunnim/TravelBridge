package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.RankingDao;
import com.pjt1.demo.model.dto.Ranking;

@Service
public class RankingServiceImpl implements RankingService {

	@Autowired
	private RankingDao repo;
	//#1 .전국 지역별 후기 개수랑 랭킹
	public List<Ranking> searchNationalReviewsRank(){
		try {
			return repo.searchNationalReviewsRank();
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
	//#2. 개인별 지역 후기 개수랑 랭킹
	public List<Ranking> searchMemberReviewsRank(int mem_no){
		try {
			return repo.searchMemberReviewsRank(mem_no);
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
	//#3. 도시의 지역 후기 랭킹 순위
	public List<Ranking> searchCityReviewsRank(String city_name){
		try {
			return repo.searchCityReviewsRank(city_name);
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
}

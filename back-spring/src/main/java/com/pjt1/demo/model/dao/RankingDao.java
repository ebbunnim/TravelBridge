package com.pjt1.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.pjt1.demo.model.dto.Ranking;

@Mapper
public interface RankingDao {
	
	//#1 .전국 지역별 후기 개수랑 랭킹
	public List<Ranking> searchNationalReviewsRank();
	//#2. 개인별 지역 후기 개수랑 랭킹
	public List<Ranking> searchMemberReviewsRank(int mem_no);
	//#3. 도시의 지역 후기 랭킹 순위
	public List<Ranking> searchCityReviewsRank(String city_name);
}
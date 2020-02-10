package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.QnaDao;
import com.pjt1.demo.model.dto.Qna;

@Service
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaDao repo;

	@Override
	public Qna search(int qna_no) {
		try {
			return repo.search(qna_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Qna> searchAll() {
		try {
			return repo.searchAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(Qna Qna) {
		try {
			repo.insert(Qna);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Qna Qna) {
		try {
			repo.update(Qna);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int qna_no) {
		try {
			repo.delete(qna_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Qna> searchForMember(int mem_no){
		try {
			return repo.searchForMember(mem_no);
		}catch(Exception e) {
			e.printStackTrace();
		} return null;
	}
	
	public void answerTheQuestion(Qna Qna) {
		try {
			repo.answerTheQuestion(Qna);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

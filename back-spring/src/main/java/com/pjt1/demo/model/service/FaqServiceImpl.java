package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dto.Faq;

import lombok.SneakyThrows;

@Service
public class FaqServiceImpl implements FaqService {

	@Autowired
	private FaqService repo;
<<<<<<< HEAD

=======
	
	@Override 
	@SneakyThrows(Exception.class)
>>>>>>> e57ab9a6cac732902812fd1bf137c489e5f4f09e
	public Faq search(int faq_no) {
		try {
			return repo.search(faq_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

<<<<<<< HEAD
	public List<Faq> searchAll() {
		try {
			return repo.searchAll();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

=======
	@Override
//	@SneakyThrows(Exception.class)
	public List<Faq> searchAll() {
		try {
		System.out.println("zzzzzzzzzzzzzzzzzzzzzzzz");
		List<Faq> faqList = repo.searchAll();
		System.out.println("########");
		System.out.println(faqList);
		return faqList;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	@SneakyThrows(Exception.class)
>>>>>>> e57ab9a6cac732902812fd1bf137c489e5f4f09e
	public void insert(Faq Faq) {
		try {
			repo.insert(Faq);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
<<<<<<< HEAD

=======
	
	@Override
	@SneakyThrows(Exception.class)
>>>>>>> e57ab9a6cac732902812fd1bf137c489e5f4f09e
	public void update(Faq Faq) {
		try {
			repo.update(Faq);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
<<<<<<< HEAD

=======
	
	@Override
	@SneakyThrows(Exception.class)
>>>>>>> e57ab9a6cac732902812fd1bf137c489e5f4f09e
	public void delete(int faq_no) {
		try {
			repo.delete(faq_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

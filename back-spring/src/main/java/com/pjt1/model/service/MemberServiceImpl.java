package com.pjt1.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.model.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberService repo;
	@Override
	public Member search(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Member Member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Member Member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int no) {
		// TODO Auto-generated method stub

	}

}

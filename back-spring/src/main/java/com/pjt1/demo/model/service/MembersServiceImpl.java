package com.pjt1.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.MembersDao;
import com.pjt1.demo.model.dto.Members;

@Service
public class MembersServiceImpl implements MembersService {

	@Autowired
	private MembersDao repo;

	@Override
	public Members search(int mem_no) {
		try {
			return repo.search(mem_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Members> searchAll() {
		try {
			return repo.searchAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(Members Members) {
		try {
			repo.insert(Members);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Members Members) {
		try {
			repo.update(Members);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int mem_no) {
		try {
			repo.delete(mem_no);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Members searchMemberByEmail(String email) {
        try {
            Members members = repo.searchMemberByEmail(email);
            return members;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

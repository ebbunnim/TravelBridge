package com.pjt1.demo.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjt1.demo.model.dao.MembersDao;
import com.pjt1.demo.model.dto.Follow;
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
	
	public Members searchMemberLikePost(int mem_no) {
		try {
			return repo.searchMemberLikePost(mem_no);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
	public Members searchMyFollowPeople(int mem_no) {
		try {
			return repo.searchMyFollowPeople(mem_no);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	};

	public Members searchFollowMePeople(int mem_no) {
		try {
			return repo.searchFollowMePeople(mem_no);
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
//	public Members searchFollowingPeoplePost(int mem_no) {
//		try {
//			return repo.searchFollowingPeoplePost(mem_no);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}return null;
//	}
	
	public Members searchMemberLikeHotPlace(int mem_no) {
		try {
			return repo.searchMemberLikeHotPlace(mem_no);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
	public Members searchMemberLikeFestival(int mem_no) {
		try {
			return repo.searchMemberLikeFestival(mem_no);
		} catch (Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<Map<String, Object>> findChildBoard(int no){
		try {
			return repo.findChildBoard(no);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<Map<String, Object>> findChildQna(int no){
		try {
			return repo.findChildQna(no);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<Map<String, Object>> findChildFollow(int no){
		try {
			return repo.findChildFollow(no);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<Map<String, Object>> findChildLikes(int no){
		try {
			return repo.findChildLikes(no);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<Map<String, Object>> findChildPost(int no){
		try {
			return repo.findChildPost(no);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<Map<String, Object>> findChildComment(int no){
		try {
			return repo.findChildComment(no);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
	public List<Map<String, Object>> findChildFiles(int no){
		try {
			return repo.findChildFiles(no);
		}catch(Exception e) {
			e.printStackTrace();
		}return null;
	}
	public void deleteChildBoard(List<Integer> list){
		try {
			repo.deleteChildBoard(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteChildQna(List<Integer> list){
		try {
			repo.deleteChildQna(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteChildFollow(List<Integer> list){
		try {
			repo.deleteChildFollow(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteChildLikes(List<Integer> list){
		try {
			repo.deleteChildLikes(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteChildPost(List<Integer> list){
		try {
			repo.deleteChildPost(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteChildComment(List<Integer> list){
		try {
			repo.deleteChildComment(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteChildFiles(List<Integer> list){
		try {
			repo.deleteChildFiles(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

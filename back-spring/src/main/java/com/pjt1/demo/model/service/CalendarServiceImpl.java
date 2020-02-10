package com.pjt1.demo.model.service;
import java.util.List;
import com.pjt1.demo.model.dao.CalendarDao;
import com.pjt1.demo.model.dto.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CalendarServiceImpl implements CalendarService {
    @Autowired
    private CalendarDao repo;
    // public Calendar search(int board_no) {
    // try {
    // return repo.search(board_no);
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // return null;
    // }
    public List<Calendar> searchAll() {
        try {
            return repo.searchAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void insert(Calendar Calendar) {
        try {
            repo.insert(Calendar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(Calendar Calendar) {
        try {
            repo.update(Calendar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // public void delete(int board_no) {
    // try {
    // repo.delete(board_no);
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // }
    public Calendar searchCalendarByMem_no(int mem_no) {
        try {
            return repo.searchCalendarByMem_no(mem_no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
package com.pjt1.demo.model.service;
import java.util.List;
import com.pjt1.demo.model.dto.Calendar;
public interface CalendarService {
    public List<Calendar> searchAll();
    public void insert(Calendar Calendar);
    public void update(Calendar Calendar);
    public Calendar searchCalendarByMem_no(int mem_no);
}
package com.pjt1.demo.model.dao;
import java.util.List;
import com.pjt1.demo.model.dto.Calendar;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface CalendarDao {
    public List<Calendar> searchAll();
    public void insert(Calendar Calendar);
    public void update(Calendar Calendar);
    public Calendar searchCalendarByMem_no(int mem_no);
}
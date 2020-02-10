package com.pjt1.demo.model.dto;
// import java.io.Serializable;
public class Calendar {
    private int _id;
    private String title;
    private String description;
    private String start;
    private String end;
    private String type;
    private int mem_no;
    private String backgroundColor;
    private String textColor;
    private boolean allDay;
    public Calendar() {
        // super();
    }
    public Calendar(int _id, String title, String description, String start, String end, String type, int mem_no,
            String backgroundColor, String textColor, boolean allDay) {
        // super();
        this._id = _id;
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
        this.type = type;
        this.mem_no = mem_no;
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        this.allDay = allDay;
    }
    public Calendar(int _id, String title, String description, String start, String end, int mem_no) {
        // super();
        this._id = _id;
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
        this.mem_no = mem_no;
    }
    @Override
    public String toString() {
        return "Calendar [_id=" + _id + ", title=" + title + ", description=" + description + ",start= " + start
                + ", end= " + end + ", type =" + type + ", mem_no" + mem_no + ", backgroundColor" + backgroundColor
                + ", textColor" + textColor + ", allDay=" + allDay + "]";
    }
    public int get_id() {
        return _id;
    }
    public void set_id(int _id) {
        this._id = _id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getStart() {
        return start;
    }
    public void setStart(String start) {
        this.start = start;
    }
    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getMem_no() {
        return mem_no;
    }
    public void setMem_no(int mem_no) {
        this.mem_no = mem_no;
    }
    public String getBackgroundColor() {
        return backgroundColor;
    }
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
    public String getTextColor() {
        return textColor;
    }
    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }
    public boolean getAllDay() {
        return allDay;
    }
    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }
}
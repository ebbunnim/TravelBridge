package com.pjt1.demo.model.service;


import java.util.List;

import com.pjt1.demo.model.dto.Blame;


public interface BlameService {
	public Blame search(int blame_no);
	public List<Blame> searchAll();
	public void insert(Blame Blame);
	public void update(Blame Blame);
	public void delete(int blame_no);
}
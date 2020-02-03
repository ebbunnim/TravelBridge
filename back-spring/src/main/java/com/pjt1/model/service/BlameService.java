package com.pjt1.model.service;


import java.util.List;

import com.pjt1.model.dto.Blame;


public interface BlameService {
	public Blame search(int no);
	public List<Blame> searchAll();
	public void insert(Blame Blame);
	public void update(Blame Blame);
	public void delete(int no);
}
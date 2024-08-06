package com.idm.dao;

import java.util.List;

import org.springframework.stereotype.Component;


import com.idm.entity.Locomotiva;


@Component
public interface LocomotivaDao {
	Locomotiva find(Integer id);
	Locomotiva create(Locomotiva ref);
	Locomotiva update(Locomotiva ref);
	void delete(Locomotiva ref);
	public void delete(int id);
	public List<Locomotiva> retrive();
}

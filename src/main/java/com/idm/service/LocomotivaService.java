package com.idm.service;

import java.util.List;

import com.idm.interfaces.Locomotiva;

public interface LocomotivaService {
	public Locomotiva find(Integer id);
	public Locomotiva createLocomotiva(Locomotiva locomotiva);
	public Locomotiva update(Locomotiva locomotiva,int id);
	public void delete(Locomotiva locomotiva);
	public void delete(Integer id);
	public List<Locomotiva> retrive();
}



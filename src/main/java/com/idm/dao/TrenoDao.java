package com.idm.dao;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.idm.dto.TrenoDTO;
import com.idm.entity.Treno;
import com.idm.entity.TrenoFilter;
import com.idm.vo.TrenoVO;
<<<<<<< HEAD
=======

>>>>>>> 859098ea02c0c0dc819e9f349dc1a788af7420f8

public interface TrenoDao {


	public Treno find(Integer id);
	
	@Transactional
	public Treno create(Treno ref);
	@Transactional
	public Treno update(Treno ref);
	@Transactional
	public void delete(Treno ref);
	@Transactional
	public void delete(int id);
	
	public List<Treno> retrive();
	public List<Treno> findByFilter(TrenoFilter filter);
	List<Treno> retriveWithOrder(String ordine, String direction);
	
}

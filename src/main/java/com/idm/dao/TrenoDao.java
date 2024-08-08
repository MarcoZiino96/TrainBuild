package com.idm.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.idm.entity.Treno;
import com.idm.entity.TrenoFilter;
import com.idm.vo.TrenoVO;


public interface TrenoDao {

	public Treno find(Integer id);
	public Treno create(Treno ref);
	public Treno update(Treno ref);
	public void delete(Treno ref);
	public void delete(int id);
	public List<Treno> retrive();
	public List<Treno> findByFilter(TrenoFilter filter);
	List<Treno> retriveWithOrder(String ordine, String direction);
	
	//public List<Treno> retriveBySigla(String sigla);
}

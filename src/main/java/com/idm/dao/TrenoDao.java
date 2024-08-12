package com.idm.dao;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.idm.dto.TrenoDTO;
import com.idm.entity.Treno;
import com.idm.entity.TrenoFilter;
import com.idm.vo.TrenoVO;

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

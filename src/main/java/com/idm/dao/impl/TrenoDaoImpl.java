package com.idm.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.idm.dao.TrenoDao;
import com.idm.entity.Treno;
import com.idm.entity.TrenoFilter;
import com.idm.entity.Utente;
import com.idm.service.impl.TrenoFilterServiceImpl;
import com.idm.vo.TrenoVO;

@Component
public class TrenoDaoImpl extends DaoImpl implements TrenoDao {

	@PersistenceContext
	EntityManager manager;
	
	@Autowired
    TrenoFilterServiceImpl trenoFilterService;

	@Override
	public Treno find(Integer id) {
		Treno t = manager.find(Treno.class,id);
		return t;
	}

	@Transactional
	@Override
	public Treno create(Treno ref) {
		manager.persist(ref);
		return ref;
	}

	@Transactional
	@Override
	public Treno update(Treno ref) {
		manager.merge(ref);
		return ref;
	}
	@Transactional
	@Override
	public void delete(Treno ref) {
		manager.remove(ref);
	}

	@Override
	public List<Treno> retrive() {
		Query q = manager.createQuery("select x from Treno x",Treno.class);
		List<Treno> l = q.getResultList();
		return l;
	}
	
    @Override
    public List<Treno> retriveWithOrder(String ordine, String direction) {
        String jpql = "SELECT t FROM Treno t ORDER BY t." + ordine + " " + direction;
        Query query = manager.createQuery(jpql, Treno.class);
        return query.getResultList();
    }
	

	@Transactional
	@Override
	public void delete(int id) {
		Treno c = this.find(id); 
		if (c!=null)
			manager.remove(c);
		
	}

	@Override
    public List<Treno> findByFilter(TrenoFilter filter) {
        return trenoFilterService.filterTreni(filter);
    }

	

}

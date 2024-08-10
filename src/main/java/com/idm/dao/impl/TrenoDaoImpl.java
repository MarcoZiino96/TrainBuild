package com.idm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.idm.dao.TrenoDao;
import com.idm.entity.Treno;
import com.idm.entity.TrenoFilter;

@Component
public class TrenoDaoImpl extends DaoImpl implements TrenoDao {

	@PersistenceContext
	EntityManager manager;

	@Override
	public Treno find(Integer id) {
		Treno t = manager.find(Treno.class,id);
	return	t;
	}

	@Transactional
	@Override
	public Treno create(Treno ref){
//		Treno treno = TrenoConverter.fromDtoToEntity(ref);
		manager.persist(ref);
		return ref;
	}

	@Transactional
	@Override
	public Treno update(Treno ref) {
//		Treno treno = TrenoConverter.fromDtoToEntity(ref);
		manager.merge(ref);
		return ref;
	}
	@Transactional
	@Override
	public void delete(Treno ref) {
//		Treno treno = TrenoConverter.fromDtoToEntity(ref);
		manager.remove(ref);
	}

	@Override
	public List<Treno> retrive() {
		Query q = manager.createQuery("select x from Treno x",Treno.class);
		List<Treno> l = q.getResultList();
		
//		List<TrenoDTO> listDto = new ArrayList();
//		
//		for(Treno entity : l) {
//			TrenoDTO dto = TrenoConverter.fromEntityToDto(entity);
//			listDto.add(dto);
//		}
	
		return l;
	}
	
    @Override
    public List<Treno> retriveWithOrder(String ordine, String direction) {
        String jpql = "SELECT t FROM Treno t ORDER BY t." + ordine + " " + direction;
        Query query = manager.createQuery(jpql, Treno.class);
        List<Treno> l = query.getResultList();
//        
//        List<TrenoDTO> listDto = new ArrayList();
//		
//		for(Treno entity : l) {
//			TrenoDTO dto = TrenoConverter.fromEntityToDto(entity);
//			listDto.add(dto);
//		}
	
		return l;
    }
	

	@Transactional
	@Override
	public void delete(int id) {
		
		Treno c = this.find(id); 
//		Treno treno = TrenoConverter.fromDtoToEntity(c);
		if (c!=null)
			manager.remove(c);
		
	}

	@Override
	public List<Treno> findByFilter(TrenoFilter filter) {
		
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		
		CriteriaQuery<Treno> criteriaQuery = criteriaBuilder.createQuery(Treno.class); 
		
		Root<Treno> criteriaRoot = criteriaQuery.from(Treno.class);
		
		return null;
	}

	

}

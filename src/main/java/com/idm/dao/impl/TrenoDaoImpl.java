package com.idm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.idm.dao.TrenoDao;
import com.idm.entity.Treno;
import com.idm.entity.TrenoFilter;
import com.idm.service.impl.TrenoFilterServiceImpl;

@Component
public class TrenoDaoImpl extends DaoImpl implements TrenoDao {

	@PersistenceContext
	EntityManager manager;
	
	@Autowired
    TrenoFilterServiceImpl trenoFilterService;

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
	
		return l;
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
	    CriteriaBuilder cb = manager.getCriteriaBuilder();
	    CriteriaQuery<Treno> cq = cb.createQuery(Treno.class);
	    Root<Treno> treno = cq.from(Treno.class);
	    List<Predicate> predicates = new ArrayList<>();
	    if (filter.getPrezzoMin() != null) {
	        predicates.add(cb.greaterThanOrEqualTo(treno.get("prezzo"), filter.getPrezzoMin()));
	    }
	    if (filter.getPrezzoMax() != null) {
	        predicates.add(cb.lessThanOrEqualTo(treno.get("prezzo"), filter.getPrezzoMax()));
	    }
	    if (filter.getPesoMin() != null) {
	        predicates.add(cb.greaterThanOrEqualTo(treno.get("peso"), filter.getPesoMin()));
	    }
	    if (filter.getPesoMax() != null) {
	        predicates.add(cb.lessThanOrEqualTo(treno.get("peso"), filter.getPesoMax()));
	    }
	    if (filter.getLunghezzaMin() != null) {
	        predicates.add(cb.greaterThanOrEqualTo(treno.get("lunghezza"), filter.getLunghezzaMin()));
	    }
	    if (filter.getLunghezzaMax() != null) {
	        predicates.add(cb.lessThanOrEqualTo(treno.get("lunghezza"), filter.getLunghezzaMax()));
	    }
	    if (filter.getSiglaContains() != null && !filter.getSiglaContains().isEmpty()) {
	        predicates.add(cb.like(treno.get("sigla"), "%" + filter.getSiglaContains() + "%"));
	    }

	    if (filter.getUtenteIds() != null && !filter.getUtenteIds().isEmpty()) {
	        predicates.add(treno.get("utente").get("id").in(filter.getUtenteIds()));
	    }

	    cq.where(predicates.toArray(new Predicate[0]));

	    List<Treno> result = manager.createQuery(cq).getResultList();
	    return result;
	}


	

}

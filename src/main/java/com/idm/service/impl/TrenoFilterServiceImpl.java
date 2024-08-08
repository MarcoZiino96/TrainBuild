package com.idm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.idm.dao.TrenoDao;
import com.idm.entity.Treno;
import com.idm.entity.TrenoFilter;
import com.idm.service.TrenoFilterService;
import com.idm.vo.TrenoVO;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


@Component
public class TrenoFilterServiceImpl implements TrenoFilterService {
	
	@Autowired
	private TrenoDao trenoDao;
    
    	
	@PersistenceContext
        private EntityManager entityManager;

        public List<Treno> filterTreni(TrenoFilter filter) {
        	
        	  System.out.println("Filter received: " + filter);
        	
        	// Crea un CriteriaBuilder
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            
         // Crea un CriteriaQuery per l'entità Treno
            CriteriaQuery<Treno> cq = cb.createQuery(Treno.class);
            
            // Specifica la radice della query (l'entità Employee)
            Root<Treno> treno = cq.from(Treno.class);
            
            // Crea una lista di Predicate per le condizioni di filtro
            List<Predicate> predicates = new ArrayList<>();
            
         // Aggiungi condizioni ai Predicate
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
            if (filter.getUtente() != null && !filter.getUtente().isEmpty()) {
                predicates.add(cb.equal(treno.get("utente"), filter.getUtente()));
            }  
            
            // Aggiungi le condizioni alla CriteriaQuery
            cq.where(predicates.toArray(new Predicate[0]));
            
            List<Treno> result = entityManager.createQuery(cq).getResultList();
            System.out.println("Filtered trains: " + result);

            // restituisce la lista di risultati filtrati
            return result;
 	
        }
	
        
        public List<TrenoVO> filterTreniVO(TrenoFilter filter){
        	List<Treno> treni = trenoDao.findByFilter(filter);
        	List<TrenoVO> trenoVOs = new ArrayList<>();
        	for (Treno treno : treni) {
        		TrenoVO vo = new TrenoVO();
                vo.setId(treno.getId());
                vo.setPrezzo(treno.getPrezzo());
                vo.setPeso(treno.getPeso());
                vo.setLunghezza(treno.getLunghezza());
                vo.setSigla(treno.getSigla());
                vo.setFoto(treno.getFoto());
                vo.setCompagnia(treno.getCompagnia());
                vo.setUtente(treno.getUtente());
        	
                trenoVOs.add(vo);
        	}    	
        	return trenoVOs;
        }
           
    }




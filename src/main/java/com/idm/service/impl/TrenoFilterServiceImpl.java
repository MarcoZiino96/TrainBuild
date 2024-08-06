package com.idm.service.impl;

import java.util.List;
import org.springframework.stereotype.Component;
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
    
    	
	@PersistenceContext
        private EntityManager entityManager;

        public List<TrenoVO> filterTreni(TrenoFilter filter) {
        	
        	// Crea un CriteriaBuilder
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            
         // Crea un CriteriaQuery per l'entità Treno
            CriteriaQuery<TrenoVO> cq = cb.createQuery(TrenoVO.class);
            
            // Specifica la radice della query (l'entità Employee)
            Root<TrenoVO> treno = cq.from(TrenoVO.class);
            
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

            // Crea e restituisci la lista di risultati filtrati
            return entityManager.createQuery(cq).getResultList();
 	
        }
    }




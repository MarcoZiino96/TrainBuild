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
    
        public List<Treno> filterTreni(TrenoFilter filter) {
        	List<Treno> u = trenoDao.findByFilter(filter);
        	return u;
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
                vo.setCompagnia(treno.getCompagnia());
                vo.setUtente(treno.getUtente());
        	
                trenoVOs.add(vo);
        	}    	
        	return trenoVOs;
        }
           
    }




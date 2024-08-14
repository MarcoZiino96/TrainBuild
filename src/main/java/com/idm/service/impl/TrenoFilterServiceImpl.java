package com.idm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.idm.dao.TrenoDao;
import com.idm.entity.Treno;
import com.idm.entity.TrenoFilter;
import com.idm.entity.Utente;
import com.idm.service.TrenoFilterService;
import com.idm.service.UtenteService;
import com.idm.vo.TrenoVO;

import java.util.ArrayList;
import java.util.Collections;

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

	@Autowired
	private UtenteService utenteService;

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


	public String validateAndBuildFilter(TrenoFilter filter, String utenteStr, Integer lunghezzaMin, Integer lunghezzaMax,
			Integer prezzoMin, Integer prezzoMax, Integer pesoMin, Integer pesoMax,
			String siglaContains) {
		if (utenteStr != null && !utenteStr.isEmpty()) {
			Utente utente = utenteService.findByUsername(utenteStr);
			if (utente == null) {
				return "Nessun utente trovato con l'username fornito.";
			} else {
				filter.setUtenteIds(Collections.singletonList(utente.getId()));
			}
		}

		if (lunghezzaMin != null && lunghezzaMin >= 0) {
			filter.setLunghezzaMin(lunghezzaMin);
		}
		if (lunghezzaMax != null && lunghezzaMax >= 0) {
			filter.setLunghezzaMax(lunghezzaMax);
		}
		if (prezzoMin != null && prezzoMin >= 0) {
			filter.setPrezzoMin(prezzoMin);
		}
		if (prezzoMax != null && prezzoMax >= 0) {
			filter.setPrezzoMax(prezzoMax);
		}
		if (pesoMin != null && pesoMin >= 0) {
			filter.setPesoMin(pesoMin);
		}
		if (pesoMax != null && pesoMax >= 0) {
			filter.setPesoMax(pesoMax);
		}
		if (siglaContains != null && !siglaContains.isEmpty()) {
			filter.setSiglaContains(siglaContains);
		}

		if (prezzoMin != null && prezzoMax != null && prezzoMin > prezzoMax) {
			return "Il prezzo minimo non può essere maggiore del prezzo massimo.";
		}
		if (pesoMin != null && pesoMax != null && pesoMin > pesoMax) {
			return "Il peso minimo non può essere maggiore del peso massimo.";
		}
		if (lunghezzaMin != null && lunghezzaMax != null && lunghezzaMin > lunghezzaMax) {
			return "La lunghezza minima non può essere maggiore della lunghezza massima.";
		}

		return null; // Nessun errore
	}
	
	public List<TrenoVO> filterTreniVOWithErrorHandling(TrenoFilter filter) {
        List<TrenoVO> treni = filterTreniVO(filter);
        return treni.isEmpty() ? null : treni;
    }


}




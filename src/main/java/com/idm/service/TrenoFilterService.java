package com.idm.service;

import java.util.List;

import com.idm.entity.Treno;
import com.idm.entity.TrenoFilter;
import com.idm.vo.TrenoVO;




public interface TrenoFilterService {

	public List<Treno> filterTreni(TrenoFilter filter);
	public List<TrenoVO> filterTreniVO(TrenoFilter filter);
	public String validateAndBuildFilter(TrenoFilter filter, String utenteStr, Integer lunghezzaMin, Integer lunghezzaMax,
			Integer prezzoMin, Integer prezzoMax, Integer pesoMin, Integer pesoMax,
			String siglaContains);
	public List<TrenoVO> filterTreniVOWithErrorHandling(TrenoFilter filter); 


}


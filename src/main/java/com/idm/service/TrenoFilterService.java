package com.idm.service;

import java.util.List;

import com.idm.entity.TrenoFilter;
import com.idm.vo.TrenoVO;




public interface TrenoFilterService {
	public List<TrenoVO> filterTreni(TrenoFilter filter);
}

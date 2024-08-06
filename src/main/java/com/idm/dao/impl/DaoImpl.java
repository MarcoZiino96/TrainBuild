package com.idm.dao.impl;

import java.util.List;
import javax.persistence.*;
import com.idm.dao.Dao;

public abstract class DaoImpl implements Dao {

	@PersistenceContext
	EntityManager manager;
	
	

	 public List<?> all(Class c) {
	        String jpql = "from " + c.getSimpleName();
	        Query q = manager.createQuery(jpql);
	        @SuppressWarnings("unchecked")
	        List<?> l = q.getResultList();
	        return l;
	    }

	 public Object find(Class c, Integer id) {
			Object o = manager.find(c, id);
			return o;
		}
	
}

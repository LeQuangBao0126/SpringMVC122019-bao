package com.laptrinhjavaweb.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.laptrinhjavaweb.repository.custom.CustomerRepositoryCustom;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {
	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findAllCustomerWithStaff() {
		String sql ="select c.id,c.name,c.sodt,u.fullname from customer c inner join user u on c.staffid =  u.id";				
		Query query = em.createNativeQuery(sql); 
		return query.getResultList();
	}
	
	
}

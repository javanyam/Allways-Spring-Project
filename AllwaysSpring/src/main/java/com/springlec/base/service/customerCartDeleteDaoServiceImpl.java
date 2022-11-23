package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.customerCartDeleteDao;

@Service
public class customerCartDeleteDaoServiceImpl implements customerCartDeleteDaoService {
	
	@Autowired
	customerCartDeleteDao dao;

	@Override
	public void optionDelete(HttpServletRequest request) throws Exception {
		
		String[] ordersId = request.getParameterValues("ordersId");
		
		for (int i = 0; i < ordersId.length; i++) {
			dao.optionDelete(ordersId[i]);
		}
		
	}

	@Override
	public void cartDelete(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
		String[] ordersId = request.getParameterValues("ordersId");
		
		for (int i = 0; i < ordersId.length; i++) {
			dao.cartDelete(ordersId[i]);
		}
	}

}

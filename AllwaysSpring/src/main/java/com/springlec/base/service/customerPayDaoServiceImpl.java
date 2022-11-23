package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.customerPayDao;

@Service
public class customerPayDaoServiceImpl implements customerPayDaoService {
	
	@Autowired
	customerPayDao dao;

	@Override
	public void pay(HttpServletRequest request, HttpSession session) throws Exception {
		
		String customerId = (String) session.getAttribute("ID");
		String[] ordersId = request.getParameterValues("ordersId");
		String[] cakeId = request.getParameterValues("cakeId");
		String[] ordersSalePrice = request.getParameterValues("ordersSalePrice");
		String[] ordersQuantity = request.getParameterValues("ordersQuantity");
		
		for (int i = 0; i < ordersId.length; i++) {
			
			int ordersPoint = (int) (Integer.parseInt(ordersSalePrice[i]) * Integer.parseInt(ordersQuantity[i]) * 0.05);
		
			dao.pay(ordersId[i], customerId, cakeId[i], ordersSalePrice[i], ordersQuantity[i], ordersPoint);
		}
	}

	@Override
	public void cartListUpdate(HttpServletRequest request) throws Exception {
		
		String[] ordersId = request.getParameterValues("ordersId");
		
		for (int i = 0; i < ordersId.length; i++) {
			
			dao.cartListUpdate(ordersId[i]);
		}
	}

}

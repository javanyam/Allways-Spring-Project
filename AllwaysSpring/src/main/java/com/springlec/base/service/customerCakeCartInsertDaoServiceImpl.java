package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.customerCakeCartInsertDao;

@Service
public class customerCakeCartInsertDaoServiceImpl implements customerCakeCartInsertDaoService {

	@Autowired
	customerCakeCartInsertDao dao;
	
	@Override
	public void cakeCartInsert(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		String o_customerId = request.getParameter("o_customerId");
		int o_cakeId = Integer.parseInt(request.getParameter("o_cakeId"));
		int ordersSalePrice = Integer.parseInt(request.getParameter("ordersSalePrice"));
		int ordersQuantity = Integer.parseInt(request.getParameter("ordersQuantity"));
		
		dao.cakeCartInsert(o_customerId, o_cakeId, ordersSalePrice, ordersQuantity);
	}

}

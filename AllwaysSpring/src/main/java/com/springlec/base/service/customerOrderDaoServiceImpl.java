package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.springlec.base.dao.customerOrderDao;
import com.springlec.base.model.customerOrderDto;

@Service
public class customerOrderDaoServiceImpl implements customerOrderDaoService {
	
	@Autowired
	customerOrderDao dao;

	@Override
	public void orderList(HttpSession session, HttpServletRequest request, Model model) throws Exception {
		
		String customerId = (String) session.getAttribute("ID");
		
		String[] ordersId = request.getParameterValues("ordersId");
		
		List<customerOrderDto> dto = null;
		
		for (int i = 0; i < ordersId.length; i++) {
			
		dto = dao.orderList(customerId, ordersId[i]);
		session.setAttribute("orderList", dto);
		
		}
	}

	@Override
	public List<customerOrderDto> customerInfo(HttpSession session) throws Exception {
		
		String customerId = (String) session.getAttribute("ID");
		
		return dao.customerInfo(customerId);
	}

}

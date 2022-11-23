package com.springlec.base.service;

import java.util.ArrayList;
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
		
		customerOrderDto dto = null;
		List<customerOrderDto> dtos  = new ArrayList<customerOrderDto>();

		for (int i = 0; i < ordersId.length; i++) {
			dto = (customerOrderDto)dao.orderList(customerId, ordersId[i]);
			dtos.add(dto);
		}
		model.addAttribute("orderList", dtos);
		
	}

	@Override
	public List<customerOrderDto> customerInfo(HttpSession session) throws Exception {
		
		String customerId = (String) session.getAttribute("ID");
		
		return dao.customerInfo(customerId);
	}

}

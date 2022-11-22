package com.springlec.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.customerCakeCartInsertDaoService;

@Controller
public class customerCakeCartInsertController {

	@Autowired
	customerCakeCartInsertDaoService service;
	
	@RequestMapping("/cakeCartInsert")
	public String cakeCartInsert(HttpServletRequest request, HttpSession session) throws Exception {
		
		service.cakeCartInsert(request, session);
		
		int ordersId = service.cakeOrdersInfo(session);
		
		service.detailOptionInsert(request, session, ordersId);
		
		int optionPrice = service.selectOptionPrice(ordersId);
		
		service.salePriceUpdate(ordersId, optionPrice, request);
		
		return "redirect:customerCakeList";
	}
}

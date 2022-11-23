package com.springlec.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.customerOrderDto;
import com.springlec.base.service.customerCakeBuyNowDaoService;

@Controller
public class customerCakeBuyNowController {

	@Autowired
	customerCakeBuyNowDaoService service;
	
	@RequestMapping("/customerCakeBuyNow")
	public String buyNow(HttpSession session, HttpServletRequest request, Model model) throws Exception {
		
		service.buyNow(session, request);
		
		int ordersId = service.buyNowInfo(session);
		
		service.detailOptionInsert(request, session, ordersId);
		
		int optionPrice = service.selectOptionPrice(ordersId);
		
		service.salePriceUpdate(ordersId, optionPrice, request);
		
		
		List<customerOrderDto> orderList = service.orderList(session, ordersId);
		model.addAttribute("orderList", orderList);
		
		List<customerOrderDto> customerInfo = service.customerInfo(session);
		model.addAttribute("customerInfo", customerInfo);
		
		return "customerOrder";
	}
	
}

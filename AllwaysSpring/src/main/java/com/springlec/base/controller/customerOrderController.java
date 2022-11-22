package com.springlec.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.customerOrderDto;
import com.springlec.base.service.customerOrderDaoService;

@Controller
public class customerOrderController {
	
	@Autowired
	customerOrderDaoService service;
	
	@RequestMapping("/customerOrderPage")
	public String orderPage(HttpSession session, HttpServletRequest request, Model model) throws Exception {
		
		service.orderList(session, request, model);
		
		List<customerOrderDto> customerInfo = service.customerInfo(session);
		model.addAttribute("customerInfo", customerInfo);
		
		return "customerOrder";
	}

}

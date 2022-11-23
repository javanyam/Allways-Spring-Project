package com.springlec.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.customerPayDaoService;

@Controller
public class customerPayController {
	
	@Autowired
	customerPayDaoService service;
	
	@RequestMapping("/customerPay")
	public String pay(HttpServletRequest request, HttpSession session) throws Exception {
		
		service.pay(request, session);
		
		service.cartListUpdate(request);
		
		return "redirect:customerAboutPage";
	}

}

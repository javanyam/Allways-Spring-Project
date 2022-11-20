package com.springlec.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.customerLoginDaoService;

@Controller
public class customerLoginController {

	@Autowired
	customerLoginDaoService service;
	
	@RequestMapping("/customer/customerLoginPage")
	public String loginpage() throws Exception{
		return "customerLogin";
	}
	
	@RequestMapping("/")
	public String usercheck(HttpServletRequest request, Model model) throws Exception{
		service.usecheckDao(request.getParameter("customerId"), request.getParameter("customerPw"));
		return "customerLogin";
	}
}

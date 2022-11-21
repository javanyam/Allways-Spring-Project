package com.springlec.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.customerCakeCartInsertDaoService;

@Controller
public class customerCakeCartInsertController {

	@Autowired
	customerCakeCartInsertDaoService service;
	
	@RequestMapping("/cakeCartInsert")
	public String cakeCartInsert(HttpServletRequest request) throws Exception {
		
		service.cakeCartInsert(request);
		
		return "redirect:customerCakeList";
	}
}

package com.springlec.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.customerCartDeleteDaoService;

@Controller
public class customerCartDeleteController {
	
	@Autowired
	customerCartDeleteDaoService service;
	
	@RequestMapping("/customerCartDelete")
	public String cartDelete(HttpServletRequest request) throws Exception {
		
		service.optionDelete(request);
		
		service.cartDelete(request);
		
		return "redirect:customerCartList";
	}

}

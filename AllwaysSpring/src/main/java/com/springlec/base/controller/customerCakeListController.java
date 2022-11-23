package com.springlec.base.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.customerCakeListDaoService;

@Controller
public class customerCakeListController {

	@Autowired
	customerCakeListDaoService service;

	@RequestMapping("/customerCakeList")
	public String customerCakeList(Model model, HttpServletRequest request) throws Exception {

		service.customerCakeList(model, request);

		return "customerCakeList";
	}
}

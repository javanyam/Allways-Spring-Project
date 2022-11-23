package com.springlec.base.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.managerMainDaoService;

@Controller
public class managerMainController {

	@Autowired
	managerMainDaoService service;
	@Autowired
	HttpSession session;
	
	// 메인 화면 출력
	@RequestMapping("managerMain")
	public String managerMain(Model model) throws Exception {
		
		service.managerMain(model);
		
		return "managermain";
	}
	
	
}

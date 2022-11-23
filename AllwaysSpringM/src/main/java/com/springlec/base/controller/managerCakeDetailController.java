package com.springlec.base.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springlec.base.service.managerCakeDetailDaoService;

@Controller
public class managerCakeDetailController {

	@Autowired
	managerCakeDetailDaoService service;
	@Autowired
	HttpSession session;
	
	// 케이크 검색
	@RequestMapping("cakeDetail")
	public String searchCake(HttpServletRequest request, Model model) throws Exception {
		
		service.cakeDetail(request, model);
		return "managerManageCake";
	}
	
	// 케이크 검색
	@RequestMapping("updateCake")
	public String updateCake(MultipartHttpServletRequest request, MultipartFile file, Model model) throws Exception {
		service.updateCake(request, file, model);
		return "redirect:searchCake";
	}
	
	// 케이크 검색
	@RequestMapping("checkName2")
	public String checkName2(HttpServletRequest request, Model model) throws Exception {
		
		service.checkName2(request, model);
		return "managerManageCake";
	}
	
	
}

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
	
	// 케이크 디테일
	@RequestMapping("cakeDetail")
	public String searchCake(HttpServletRequest request, Model model) throws Exception {
		
		service.cakeDetail(request, model);
		return "managerManageCake";
	}
	
	// 케이크 수정
	@RequestMapping("updateCake")
	public String updateCake(MultipartHttpServletRequest request, MultipartFile file, Model model) throws Exception {
		service.updateCake(request, file, model);
		return "redirect:searchCake";
	}
	
	// 케이크 이름 중복체크
	@RequestMapping("checkName2")
	public String checkName2(HttpServletRequest request, Model model) throws Exception {
		System.out.println("1");
		service.checkName2(request, model);
		return "managerManageCake";
	}
	
	// 케이크 삭제
	@RequestMapping("deleteCake")
	public String deleteCake(HttpServletRequest request, Model model) throws Exception {
		service.deleteCake(request, model);
		return "redirect:searchCake";
	}
	
	
}

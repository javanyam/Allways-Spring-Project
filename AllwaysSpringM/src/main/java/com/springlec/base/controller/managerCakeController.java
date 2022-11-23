package com.springlec.base.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springlec.base.service.managerCakeDaoService;

@Controller
public class managerCakeController {

	@Autowired
	managerCakeDaoService service;
	@Autowired
	HttpSession session;
	
	// 케이크 검색
	@RequestMapping("searchCake")
	public String searchCake(HttpServletRequest request, Model model) throws Exception {
		
		service.searchCake(request, model);
		return "managerViewMenu";
	}
	
	// 케이크 추가 페이지
	@RequestMapping("managerCreateCake")
	public String managerCreateCake(HttpServletRequest request, Model model) throws Exception {
		
		return "managerCreateCake";
	}
	
	// 케이크 생성 시 이름 중복확인
	@RequestMapping("checkName")
	public String cakeNameCheck(MultipartHttpServletRequest request, MultipartFile file, RedirectAttributes attributes, Model model) throws Exception {
		
		service.cakeNameCheck(request, file, model);
		return "managerCreateCake";
	}
	
	// 케이크 추가
	@RequestMapping("addCake")
	public String addCake(MultipartHttpServletRequest request, MultipartFile file) throws Exception {
		
		service.addCake(request, file);
		return "redirect:searchCake";
	}
	
}

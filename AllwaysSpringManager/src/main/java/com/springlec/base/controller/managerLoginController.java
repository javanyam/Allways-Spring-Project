package com.springlec.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springlec.base.service.managerLoginDaoService;

@Controller
public class managerLoginController {

	@Autowired
	managerLoginDaoService service;
	@Autowired
	HttpSession session;
	
	// 로그인 페이지
	@RequestMapping("managerLoginPage")
	public String managerLoginPage(HttpServletRequest request) throws Exception {
		request.setAttribute("CHECK", request.getParameter("CHECK"));
		return "managerLogin";
	}
	
	// 로그인 액션
	@RequestMapping("managerLogin")
	public String managerLogin(HttpServletRequest request, RedirectAttributes attributes) throws Exception {
		
		int check = service.managerLogin(request);
		if(check == 1) {
			return "redirect:managerMain";
		}
		attributes.addAttribute("CHECK", check);
		return "redirect:managerLoginPage";
	}
	
	// 로그아웃
	@RequestMapping("/")
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:managerLoginPage";
	}
	
	
}

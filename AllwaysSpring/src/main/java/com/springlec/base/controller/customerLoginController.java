package com.springlec.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.customerLoginDaoService;

@Controller
public class customerLoginController {

	@Autowired
	customerLoginDaoService service;
	
	// 로그인 페이지
	@RequestMapping("/customerLoginPage")
	public String loginpage() throws Exception{
		return "customerLogin";
	}
	
	// 로그인 액션
	@RequestMapping("/customerLogin")
	public String usercheck(HttpServletRequest request, Model model, HttpSession session) throws Exception{
		int chk = service.usercheckDao(request.getParameter("customerId"), request.getParameter("customerPw"));
		String name = service.usernameDao(request.getParameter("customerId"), request.getParameter("customerPw"));
		
		if(chk == 1) {
			session.setAttribute("NAME", name);
			session.setAttribute("ID", request.getParameter("customerId"));
			return "customerAbout";
		}else {
			model.addAttribute("CHECK", false);
			return "redirect:customerLoginPage";
		}
			
	}
	
	// 메인페이지
	@RequestMapping("/customerAboutPage")
	public String main() throws Exception{
		return "customerAbout";
	}
	
	// 로그아웃
		@RequestMapping("/customerLogout")
		public String logout(HttpSession session) throws Exception{
			session.invalidate();
			return "customerAbout";
		}

	// Header > Location 페이지 이동
		@RequestMapping("/customerLocationPage")
		public String location() throws Exception{
			return "customerLocation";
		}
		
	
	
	
} // End

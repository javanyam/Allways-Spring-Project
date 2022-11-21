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
	@RequestMapping("/customerAbout")
	public String main() throws Exception{
		return "customerLogin";
	}
	
	// 회원가입 페이지 이동
	@RequestMapping("/customerJoinPage")
	public String joinpage() throws Exception{
		return "customerJoin";
	}
	
	// 회원가입시 아이디 중복체크
	@RequestMapping("/idcheck")
	public String idcheck(HttpServletRequest request, Model model) throws Exception{
		String customerId = request.getParameter("customerId");
		boolean chk = service.idcheckDao(customerId);

		if(customerId.length() > 0) {
			model.addAttribute("CHECK", chk);
			model.addAttribute("CHECKID", customerId);
			model.addAttribute("NAME", request.getParameter("customerName"));
			model.addAttribute("PHONE", request.getParameter("customerPhone"));
			model.addAttribute("EMAIL", request.getParameter("customeremail1"));
			model.addAttribute("BIRTH", request.getParameter("customerBirth"));
		}else {
			request.setAttribute("CHECK", null);
		}
		return "customerJoin";
	}
	
	// 회원가입
	@RequestMapping("/customerJoin")
	public String join(HttpServletRequest request) throws Exception{
		
		return "customerLoginPage";
	}
	
	
	
} // End

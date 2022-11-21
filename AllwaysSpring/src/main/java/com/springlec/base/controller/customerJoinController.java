package com.springlec.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.customerJoinDaoService;

@Controller
public class customerJoinController {

	@Autowired
	customerJoinDaoService service;
	
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
		String customerId = request.getParameter("customerId");
		String customerPw = request.getParameter("customerPw");
		String customerName = request.getParameter("customerName");
		String customerGender = request.getParameter("customerGender");
		String customerPhone = request.getParameter("customerPhone");
		String customerEmail = request.getParameter("email1") + "@" + request.getParameter("email2");
		String customerBirthday= request.getParameter("customerBirth");
		String customerPostcode = request.getParameter("postcode");
		String customerAddress = request.getParameter("address");
		String customerAddressDetail = request.getParameter("addressDetail");
		
		service.joinDao(customerId, customerPw, customerName, customerGender, customerPhone, customerEmail, customerBirthday, customerPostcode, customerAddress, customerAddressDetail);
		
		return "redirect:customerLoginPage";
	}
	
} // End

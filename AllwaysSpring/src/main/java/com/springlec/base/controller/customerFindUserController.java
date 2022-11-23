package com.springlec.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.customerFindUserDaoService;

@Controller
public class customerFindUserController {
	
	@Autowired
	customerFindUserDaoService service;
	
	// 아이디 찾기 페이지 이동
		@RequestMapping("/customerFindIdPage")
		public String findidpage() throws Exception{
			return "customerFindId";
		}
		
	// 아이디 찾기
		@RequestMapping("/customerFindId")
		public String findid(HttpServletRequest request, Model model) throws Exception{
			service.findIdDao(request, model);
			return "customerShowId";
		}
		
	// 비밀번호찾기 페이지 이동
		@RequestMapping("/customerFindPwPage")
		public String findpwpage() throws Exception{
			return "customerFindPw";
		}
		
	// 비밀번호 찾기
		@RequestMapping("/customerFindPw")
		public String findpw(HttpServletRequest request, Model model) throws Exception{
			service.userCheckDao(request, model);
			return "customerShowPw";
		}
		
	// 비밀번호 재설정
		@RequestMapping("/customerResetPw")
		public String resetpw(HttpServletRequest request) throws Exception{
			service.resetPwDao(request);
			return "redirect:customerLogin";
		}
		

}

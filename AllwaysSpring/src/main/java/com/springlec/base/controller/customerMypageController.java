package com.springlec.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.customerMypageDaoService;

@Controller
public class customerMypageController {

	@Autowired
	customerMypageDaoService service;
	
	// 마이페이지
	@RequestMapping("/customerMypagePage")
	public String mypage() throws Exception{
		return "customerMypage";
	}
	
	// 회원 정보
	@RequestMapping("/customerRevisionPage")
	public String mypagerevision(HttpServletRequest request, Model model) throws Exception{
		service.mypageDao(request, model);
		service.userEmailDao(request, model);
		return "customerMypageRevision";
	}
	
	// 회원 정보 수정
	@RequestMapping("/mypageUpdate")
	public String update(HttpServletRequest request) throws Exception{
		service.updateDao(request);
		return "redirect:customerMypagePage";
	}
	
	// 회원 탈퇴
	@RequestMapping("/deleteAction")
	public String delete(HttpServletRequest request) throws Exception{
		service.deleteDao(request);
		return "redirect:customerLogout";
	}
	
	
	// 구매 내역 보기
	@RequestMapping("/customerOrders")
	public String orderlist(HttpServletRequest request, Model model) throws Exception{
		service.myOrderListDao(request, model);
		return "customerOrdersList";
	}
	
	// 포인트 적립 내역 보기
	@RequestMapping("/customerMyPointListPage")
	public String mypoint(HttpServletRequest request, Model model) throws Exception{
		service.myPointDao(request, model);
		return "customerMypoint";
	}

} // End

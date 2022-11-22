package com.springlec.base.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springlec.base.service.customerReviewDeleteDaoService;

@Controller
public class customerReviewDeleteController {

	@Autowired
	customerReviewDeleteDaoService service;
	
	// 게시판 or 게시판 답글 삭제
	@RequestMapping("/customerReviewDelete")
	public String customerBoardDelete(HttpServletRequest request, Model model, RedirectAttributes attributes) throws Exception {
		
		service.customerReviewDelete(request);
		attributes.addAttribute("index", Integer.parseInt(request.getParameter("index")));
		
		return "redirect:customerOrdersReview";
	}
	
}
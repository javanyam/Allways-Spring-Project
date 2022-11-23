package com.springlec.base.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.managerSearchReviewDaoService;

@Controller
public class managerSearchReviewController {

	@Autowired
	managerSearchReviewDaoService service;
	@Autowired
	HttpSession session;
	
	// 리뷰 리스트 출력
	@RequestMapping("searchReview")
	public String searchReview(HttpServletRequest request, Model model) throws Exception {
		
		service.searchReview(request, model);
		return "managerReviewList";
	}
	
	// 리뷰 상세 출력
	@RequestMapping("reviewDetail")
	public String reviewDetail(HttpServletRequest request, Model model) throws Exception {
		
		service.reviewDetail(request, model);
		return "maangerReviewDetail";
	}
	
	
}

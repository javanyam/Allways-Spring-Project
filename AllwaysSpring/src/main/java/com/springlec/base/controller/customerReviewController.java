package com.springlec.base.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springlec.base.model.customerPageDto;
import com.springlec.base.service.customerReviewDaoService;

@Controller
public class customerReviewController {

	@Autowired
	customerReviewDaoService service;
	
	// 리뷰 리스트 출력
	@RequestMapping("/customerOrdersReview")
	public String customerOrderReview(HttpServletRequest request, Model model) throws Exception {
		
		service.customerReviewListCount();
		customerPageDto page = new customerPageDto();
		service.customerReviewList(request, model, page);

		return "customerOrderReview";
	}
	
	@RequestMapping("/customerOrderList")
	public String customerOrderList(Model model) throws Exception {
		service.customerOrderList(model);
		
		return "customerOrderList";
	}
	
	// 리뷰작성 페이지
	@RequestMapping("/customerWriteReviewPage")
	public String customerWriteReviewPage() throws Exception {
		
		return "customerWriteReview";
	}
	
	// 리뷰작성하기
	@RequestMapping("/customerWriteReview")
	public String customerWriteReview(MultipartHttpServletRequest request, MultipartFile file, MultipartHttpServletRequest multi) throws Exception {
		service.customerWriteReview(request, file, multi);
		return "redirect:customerOrdersReview";
	}
	
}
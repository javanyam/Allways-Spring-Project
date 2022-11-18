package com.springlec.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.customerReviewDto;
import com.springlec.base.service.customerReviewDaoService;

@Controller
public class customerReviewController {

	@Autowired
	customerReviewDaoService service;
	
	// 리뷰 리스트 출력
	@RequestMapping("/customer/customerOrdersReview")
	public String list(HttpServletRequest request, Model model) throws Exception {

		List<customerReviewDto> dtos = service.customerReviewList(request);
		model.addAttribute("reviewList", dtos);

		return "customerOrderReview";
	}
	
}

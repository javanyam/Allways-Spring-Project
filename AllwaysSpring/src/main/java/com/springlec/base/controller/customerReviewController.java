package com.springlec.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.customerOrderListDto;
import com.springlec.base.model.customerReviewDto;
import com.springlec.base.service.customerReviewDaoService;

@Controller
public class customerReviewController {

	@Autowired
	customerReviewDaoService service;
	
	// 리뷰 리스트 출력
	@RequestMapping("/customerOrdersReview")
	public String customerOrderReview(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		
		List<customerReviewDto> dtos = service.customerReviewList(request, model);

		int index = 1; // 시작 페이지 번호
		int rowcount = 3; // 한 페이지에 출력할 리스트 개수
		int pagecount = 10; // 한 페이지에 출력할 페이지 개수
		int pagepage = 0; // ??
		
		int maxpage = (dtos.size() % rowcount) != 0 ? (dtos.size() / rowcount) + 1 : (dtos.size() / rowcount);

		if (request.getParameter("index")!=null) {
			index = (int)Float.parseFloat(request.getParameter("index"));
		}
		
		if (index % pagecount == 0) {
			pagepage = index / pagecount - 1;
		} else {
			pagepage = index / pagecount;
		}
		
		model.addAttribute("CUSTOMERID", session.getAttribute("ID"));
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("reviewList", dtos);
		model.addAttribute("arrsize", dtos.size());
		model.addAttribute("index", index);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("pagepage", pagepage);
		
		return "customerOrderReview";
	}
	
	@RequestMapping("/customerOrderList")
	public String customerOrderList(Model model, HttpSession session) throws Exception {
		List<customerOrderListDto> dtos = service.customerOrderList(session);
		model.addAttribute("orderList", dtos);
		return "customerOrderList";
	}
	
	// 리뷰작성 페이지
	@RequestMapping("/customerWriteReviewPage")
	public String customerWriteReviewPage() throws Exception {
		
		return "customerWriteReview";
	}
	
	// 리뷰작성하기
	@RequestMapping("/customerWriteReview")
	public String customerWriteReview(HttpServletRequest request, HttpSession session) throws Exception {
		service.customerWriteReview(request, session);
		return "redirect:customerOrdersReview";
	}
	
}

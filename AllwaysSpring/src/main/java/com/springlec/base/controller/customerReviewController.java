package com.springlec.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	@RequestMapping("/customerOrdersReview")
	public String customerOrderReview(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("CUSTOMERID", "gksquf");
		
		List<customerReviewDto> dtos = service.customerReviewList(request);
		model.addAttribute("reviewList", dtos);

		int index = 1; // 시작 페이지 번호
		int rowcount = 10; // 한 페이지에 출력할 리스트 개수
		int pagecount = 10; // 한 페이지에 출력할 페이지 개수
		int pagepage = 0; // ??
		
		int maxpage = (dtos.size() % rowcount) != 0 ? (dtos.size() / rowcount) + 1 : (dtos.size() / rowcount);

		if (request.getParameter("index")!=null) {
			index=(int)Float.parseFloat(request.getParameter("index"));
		}
		
		if (index % pagecount == 0) {
			pagepage = index / pagecount - 1;
		} else {
			pagepage = index / pagecount;
		}
		
		request.setAttribute("CUSTOMERID", session.getAttribute("ID"));
		request.setAttribute("writeList", dtos);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("arrsize", dtos.size());
		request.setAttribute("index", index);
		request.setAttribute("rowcount", rowcount);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("pagepage", pagepage);
		
		return "customerOrderReview";
	}
	
//	// 리뷰 리스트 출력
//	@RequestMapping("/customer/customerOrdersReview")
//	public String customerOrderReview(Model model) throws Exception {
//		
//		List<customerReviewDto> dtos = service.customerReviewList();
//		model.addAttribute("reviewList", dtos);
//		
//		return "customerOrderReview";
//	}
//	
}

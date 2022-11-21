package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.springlec.base.dao.customerReviewDao;
import com.springlec.base.model.customerOrderListDto;
import com.springlec.base.model.customerPageDto;
import com.springlec.base.model.customerReviewDto;

@Service
public class customerReviewDaoServiceImpl implements customerReviewDaoService {

	@Autowired
	customerReviewDao dao;
	
	@Autowired
	HttpSession session;
	
	@Override
	public void customerReviewList(HttpServletRequest request, Model model, customerPageDto page) throws Exception {

		String combo = request.getParameter("combo");
		String searchContent = request.getParameter("searchContent");
		String sort = request.getParameter("sort");

		if(sort == null) {
			sort = "oreviewInitdate";
		}
		if(combo == null) {
			combo = "or_customerId";
		}
		if(searchContent == null) {
			searchContent = '%' + "" + '%';
		}else {
			searchContent = '%' + searchContent + '%';
		}

		List<customerReviewDto> dtos = dao.customerReviewList(combo, searchContent, sort);
		
		model.addAttribute("CUSTOMERID", session.getAttribute("ID"));
		model.addAttribute("maxpage", page.getMaxpage());
		model.addAttribute("index", page.getIndex());
		model.addAttribute("rowcount", page.getRowcount());
		model.addAttribute("pagecount", page.getPagecount());
		model.addAttribute("pagepage", page.getPagepage());
		model.addAttribute("sort", sort);
		
		model.addAttribute("reviewList", dtos);
		model.addAttribute("arrsize", dtos.size());
		
	}

	@Override
	public customerPageDto customerReviewListCount() throws Exception {
		// TODO Auto-generated method stub
		return dao.customerReviewListCount();
	}
	
	@Override
	public void customerOrderList(Model model) throws Exception {

		String customerId = (String) session.getAttribute("ID");
		
		List<customerOrderListDto> dtos = dao.customerOrderList(customerId);
		
		model.addAttribute("orderList", dtos);
	}

	@Override
	public void customerWriteReview(HttpServletRequest request) throws Exception {

		String or_customerId = (String) session.getAttribute("ID");
		int or_ordersId = Integer.parseInt(request.getParameter("ordersId"));
		String oreviewContent = request.getParameter("oreviewContent");
		String oreviewStarRating = request.getParameter("oreviewStarRating");
		String oreviewImage = request.getParameter("oreviewImage");
		int or_cakeId = Integer.parseInt(request.getParameter("o_cakeId"));
		
		dao.customerWriteReview(or_customerId, or_ordersId, oreviewContent, oreviewStarRating, oreviewImage, or_cakeId);
		
	}

	



}

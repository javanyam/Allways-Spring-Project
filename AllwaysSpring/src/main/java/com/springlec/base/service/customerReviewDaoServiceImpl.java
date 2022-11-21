package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.springlec.base.dao.customerReviewDao;
import com.springlec.base.model.customerOrderListDto;
import com.springlec.base.model.customerReviewDto;

@Service
public class customerReviewDaoServiceImpl implements customerReviewDaoService {

	@Autowired
	customerReviewDao dao;
	
	@Override
	public List<customerReviewDto> customerReviewList(HttpServletRequest request, Model model) throws Exception {

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
		
		model.addAttribute("sort", sort);
		return dao.customerReviewList(combo, searchContent, sort);
	}

	@Override
	public List<customerOrderListDto> customerOrderList(HttpSession session) throws Exception {

		String customerId = (String) session.getAttribute("ID");
		
		return dao.customerOrderList(customerId);
	}

	@Override
	public void customerWriteReview(HttpServletRequest request, HttpSession session) throws Exception {

		String or_customerId = (String) session.getAttribute("ID");
		int or_ordersId = Integer.parseInt(request.getParameter("ordersId"));
		String oreviewContent = request.getParameter("oreviewContent");
		String oreviewStarRating = request.getParameter("oreviewStarRating");
		String oreviewImage = request.getParameter("oreviewImage");
		int or_cakeId = Integer.parseInt(request.getParameter("o_cakeId"));
		
		dao.customerWriteReview(or_customerId, or_ordersId, oreviewContent, oreviewStarRating, oreviewImage, or_cakeId);
		
	}



}

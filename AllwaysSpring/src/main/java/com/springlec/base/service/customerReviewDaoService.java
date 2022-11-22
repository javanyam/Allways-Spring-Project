package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.springlec.base.model.customerOrderListDto;
import com.springlec.base.model.customerReviewDto;

public interface customerReviewDaoService {

	public List<customerReviewDto> customerReviewList(HttpServletRequest request, Model model) throws Exception;
	public List<customerOrderListDto> customerOrderList(HttpSession session) throws Exception;
	public void customerWriteReview(HttpServletRequest request, HttpSession session) throws Exception;
	
}

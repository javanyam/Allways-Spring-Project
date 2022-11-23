package com.springlec.base.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;


public interface managerSearchReviewDaoService {

	public void searchReview(HttpServletRequest request, Model model) throws Exception;
	
	public void reviewDetail(HttpServletRequest request, Model model) throws Exception;
	
	
}

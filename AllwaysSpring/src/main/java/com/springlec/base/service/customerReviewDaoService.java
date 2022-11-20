package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.springlec.base.model.customerReviewDto;

public interface customerReviewDaoService {

	public List<customerReviewDto> customerReviewList(HttpServletRequest request) throws Exception;
//	public List<customerReviewDto> customerReviewList(HttpServletRequest request) throws Exception;
	
}

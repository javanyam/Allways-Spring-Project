package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.customerReviewDao;
import com.springlec.base.model.customerReviewDto;

@Service
public abstract class customerReviewDaoServiceImpl implements customerReviewDaoService {

	@Autowired
	customerReviewDao dao;
	
	@Override
	public List<customerReviewDto> customerReviewList(HttpServletRequest request) throws Exception {

		String combo = request.getParameter("combo");
		String searchContent = request.getParameter("searchContent");
		String sort = request.getParameter("sort");
		
		searchContent = '%' + searchContent + '%';
		if(sort == null) {
			sort = "oreviewInitdate";
		}
		
		return dao.customerReviewList(combo, searchContent, sort);
	}
	
}

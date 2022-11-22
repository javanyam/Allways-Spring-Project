package com.springlec.base.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springlec.base.dao.customerReviewDeleteDao;

@Service
public class customerReviewDeleteDaoServiceImpl implements customerReviewDeleteDaoService {

	@Autowired
	customerReviewDeleteDao dao;

	@Override
	public void customerReviewDelete(HttpServletRequest request) throws Exception {

		int oreviewId = Integer.parseInt(request.getParameter("oreviewId"));
		
		dao.customerReviewDelete(oreviewId);
	}


}
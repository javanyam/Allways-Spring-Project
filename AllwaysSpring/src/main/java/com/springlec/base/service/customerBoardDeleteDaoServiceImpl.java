package com.springlec.base.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springlec.base.dao.customerBoardDeleteDao;

@Service
public class customerBoardDeleteDaoServiceImpl implements customerBoardDeleteDaoService {

	@Autowired
	customerBoardDeleteDao dao;

	@Override
	public void customerBoardDelete(HttpServletRequest request) throws Exception {

		int writeId = Integer.parseInt(request.getParameter("writeId"));
		String result = request.getParameter("result");
		
		if(result.equals("1")) {
			result = "writeId";
		}else {
			result = "commentId";
		}
		dao.customerBoardDelete(writeId, result);
	}

	@Override
	public void customerBoardDetailCommentDelete(HttpServletRequest request) throws Exception {
		
		int commentId = Integer.parseInt(request.getParameter("commentId"));
		String result = request.getParameter("result");
		
		if(result.equals("commentId")) {
			result = "writeId";
		}else {
			result = "recommentId";
		}
		System.out.println("commentId: " + commentId);
		System.out.println("result: " + result);
		
		dao.customerBoardDetailCommentDelete(commentId, result);
		
	}
	



}
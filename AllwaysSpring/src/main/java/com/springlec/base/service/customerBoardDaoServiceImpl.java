package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.springlec.base.dao.customerBoardDao;
import com.springlec.base.model.customerBoardDto;

@Service
public class customerBoardDaoServiceImpl implements customerBoardDaoService {

	@Autowired
	customerBoardDao dao;
	
	@Override
	public int selectWriteId() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectWriteId();
	}
	
	@Override
	public List<customerBoardDto> customerBoardList(HttpServletRequest request, Model model) throws Exception {

		String combo = request.getParameter("combo");
		String searchContent = request.getParameter("searchContent");

		if(combo == null) {
			combo = "w_customerId";
		}
		if(searchContent == null) {
			searchContent = '%' + "" + '%';
		}else {
			searchContent = '%' + searchContent + '%';
		}
		
		return dao.customerBoardList(combo, searchContent);
	}

	@Override
	public void customerBoardWrite(HttpSession session, HttpServletRequest request, int writeId) throws Exception {

		String customerId = (String)session.getAttribute("ID");
		String writeTitle = request.getParameter("writeTitle");
		String writeContent = request.getParameter("writeContent");
		
		dao.customerBoardWrite(customerId, writeTitle, writeContent, writeId);
	}




}

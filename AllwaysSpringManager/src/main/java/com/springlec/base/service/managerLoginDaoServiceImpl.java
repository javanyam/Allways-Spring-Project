package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.managerLoginDao;

@Service
public class managerLoginDaoServiceImpl implements managerLoginDaoService {

	@Autowired
	managerLoginDao dao;
	@Autowired
	HttpSession session;
	
	@Override
	public int managerLogin(HttpServletRequest request) throws Exception {

		String managerId = request.getParameter("managerId");
		String managerPw = request.getParameter("managerPw");
		
		session.setAttribute("MANAGERID", managerId);
		return dao.managerLogin(managerId, managerPw);
		
		
	}
	
}

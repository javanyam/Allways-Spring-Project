package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.springlec.base.dao.customerFindUserDao;

@Service
public class customerFindUserDaoServiceImpl implements customerFindUserDaoService {

	@Autowired
	customerFindUserDao dao;
	
	@Override
	public void findIdDao(HttpServletRequest request, Model model) throws Exception {
		String customerName = request.getParameter("customerName");
		String customerBirthday = request.getParameter("customerBirth");
		String customerPhone = request.getParameter("customerPhone");
		String customerEmail = request.getParameter("email1") + "@" + request.getParameter("email2");
		String customerId = dao.findIdDao(customerName, customerBirthday, customerPhone, customerEmail);
		model.addAttribute("CUSTOMERID", customerId);
		
	}

	@Override
	public void userCheckDao(HttpServletRequest request, Model model) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

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
		if(customerId != null) {
			model.addAttribute("CUSTOMERID", customerId);
			model.addAttribute("CUSTOMERNAME", customerName);
		}else {
			model.addAttribute("CUSTOMERID", customerId);
		}
		
	}

	@Override
	public void userCheckDao(HttpServletRequest request, Model model) throws Exception {
		String customerId = request.getParameter("customerId");
		String customerName = request.getParameter("customerName");
		String customerBirthday = request.getParameter("customerBirth");
		String customerPhone = request.getParameter("customerPhone");
		String customerEmail = request.getParameter("email1") + "@" + request.getParameter("email2");
		int chk = dao.userCheckDao(customerId,customerName, customerBirthday, customerPhone, customerEmail);
		if(chk == 1) {
			model.addAttribute("USERCHECK", true);
			model.addAttribute("USERID", customerId);
		}else {
			model.addAttribute("USERCHECK", false);
		}
	}

	@Override
	public void resetPwDao(HttpServletRequest request) throws Exception {
		String customerId = request.getParameter("customerId");
		String customerPw = request.getParameter("customerPw");
		dao.resetPwDao(customerId, customerPw);
	}

}

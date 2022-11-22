package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.customerCartListDao;
import com.springlec.base.model.customerCartListDto;

@Service
public class customerCartListDaoServiceImpl implements customerCartListDaoService {
	
	@Autowired
	customerCartListDao dao;

	@Override
	public List<customerCartListDto> cakeCartList(HttpSession session) throws Exception {
		
		String customerId = (String) session.getAttribute("ID");
		
		return dao.cakeCartList(customerId);
	}

//	@Override
//	public List<customerCartListDto> optionCartList(HttpServletRequest request) throws Exception {
//
//		String customerId = request.getParameter("customerId");
//		
//		return dao.optionCartList(customerId);
//	}

}

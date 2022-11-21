package com.springlec.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.customerLoginDao;

@Service
public class customerLoginDaoServiceImpl implements customerLoginDaoService {

	@Autowired
	customerLoginDao dao;
	
	@Override
	public int usercheckDao(String customerId, String customerPw) throws Exception {
		return dao.usercheckDao(customerId, customerPw);
	}

	@Override
	public String usernameDao(String customerId, String customerPw) throws Exception {
		return dao.usernameDao(customerId, customerPw);
	}


}

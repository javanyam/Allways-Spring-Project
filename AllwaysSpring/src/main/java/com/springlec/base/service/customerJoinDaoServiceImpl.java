package com.springlec.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.customerJoinDao;

@Service
public class customerJoinDaoServiceImpl implements customerJoinDaoService {

	@Autowired
	customerJoinDao dao;
	
	@Override
	public boolean idcheckDao(String customerId) throws Exception {
		if(dao.idcheckDao(customerId) == 1) {
			return true;
		}else {
			return false; 
		}
	}

	@Override
	public void joinDao(String customerId, String customerPw, String customerName, String customerGender,
			String customerPhone, String customerEmail, String customerBirthday, String customerPostcode,
			String customerAddress, String customerAddressDetail) throws Exception {
		dao.joinDao(customerId, customerPw, customerName, customerGender, customerPhone, customerEmail, customerBirthday, customerPostcode, customerAddress, customerAddressDetail);
	}

}

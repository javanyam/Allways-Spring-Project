package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.customerCakeListDao;
import com.springlec.base.model.customerCakeListDto;

@Service
public class customerCakeListDaoServiceImpl implements customerCakeListDaoService {

	@Autowired
	customerCakeListDao dao;

	@Override
	public List<customerCakeListDto> customerCakeList() throws Exception {
		// TODO Auto-generated method stub
		return dao.customerCakeList();
	}

}

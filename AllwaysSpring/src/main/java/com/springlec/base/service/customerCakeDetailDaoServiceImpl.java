package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.customerCakeDetailDao;
import com.springlec.base.model.customerCakeDetailDto;

@Service
public class customerCakeDetailDaoServiceImpl implements customerCakeDetailDaoService {

	@Autowired
	customerCakeDetailDao dao;
	
	@Override
	public customerCakeDetailDto customerCakeDetail(HttpServletRequest request) throws Exception {
		
		int cakeId = Integer.parseInt(request.getParameter("cakeId"));
		
		return dao.customerCakeDetail(cakeId);
	}

	@Override
	public List<customerCakeDetailDto> customerCakeShape() throws Exception {
		// TODO Auto-generated method stub
		return dao.customerCakeShape();
	}

	@Override
	public List<customerCakeDetailDto> customerCakeSize() throws Exception {
		// TODO Auto-generated method stub
		return dao.customerCakeSize();
	}

	@Override
	public List<customerCakeDetailDto> customerCakeFlavor() throws Exception {
		// TODO Auto-generated method stub
		return dao.customerCakeFlavor();
	}

	@Override
	public void viewsUpdate(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
		int cakeId = Integer.parseInt(request.getParameter("cakeId"));
		
		dao.viewsUpdate(cakeId);
	}
	
}

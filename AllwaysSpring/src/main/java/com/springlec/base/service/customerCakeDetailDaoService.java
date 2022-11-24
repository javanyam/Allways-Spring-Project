package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.springlec.base.model.customerCakeDetailDto;

public interface customerCakeDetailDaoService {
	
	public customerCakeDetailDto customerCakeDetail(HttpServletRequest request) throws Exception;
	
	public List<customerCakeDetailDto> customerCakeShape() throws Exception;
	
	public List<customerCakeDetailDto> customerCakeSize() throws Exception;
	
	public List<customerCakeDetailDto> customerCakeFlavor() throws Exception;

	public void viewsUpdate(HttpServletRequest request) throws Exception;
}

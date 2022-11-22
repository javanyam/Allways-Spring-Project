package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.springlec.base.model.customerOrderDto;

public interface customerCakeBuyNowDaoService {

	public void buyNow(HttpSession session, HttpServletRequest request) throws Exception;

	public int buyNowInfo(HttpSession session) throws Exception;

	public void detailOptionInsert(HttpServletRequest request, HttpSession session, int ordersId) throws Exception;

	public int selectOptionPrice(int ordersId) throws Exception;

	public void salePriceUpdate(int ordersId, int optionPrice, HttpServletRequest request) throws Exception;
	
	public List<customerOrderDto> orderList (HttpSession session, int ordersId) throws Exception;
	
	public List<customerOrderDto> customerInfo (HttpSession session) throws Exception;

}

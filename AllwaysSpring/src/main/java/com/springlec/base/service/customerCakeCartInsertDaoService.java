package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface customerCakeCartInsertDaoService {

	public void cakeCartInsert(HttpServletRequest request, HttpSession session) throws Exception;

	public int cakeOrdersInfo(HttpSession session) throws Exception;

	public void detailOptionInsert(HttpServletRequest request, HttpSession session, int ordersId) throws Exception;
	
	public int selectOptionPrice(int ordersId) throws Exception;
	
	public void salePriceUpdate(int ordersId, int optionPrice, HttpServletRequest request) throws Exception;
}

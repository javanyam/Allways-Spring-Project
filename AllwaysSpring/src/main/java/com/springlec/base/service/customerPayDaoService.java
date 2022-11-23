package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface customerPayDaoService {
	
	public void pay(HttpServletRequest request, HttpSession session) throws Exception;
	
	public void cartListUpdate(HttpServletRequest request) throws Exception;

}

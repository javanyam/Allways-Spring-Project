package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface customerMypageDaoService {

	public void mypageDao(HttpServletRequest request, Model model) throws Exception;
	public void userEmailDao(HttpServletRequest request, Model model) throws Exception;
	public void updateDao(HttpServletRequest request) throws Exception;
	public void deleteDao(HttpServletRequest request) throws Exception;
	public void myOrderListDao(HttpServletRequest request, Model model) throws Exception;
	public void myPointDao(HttpServletRequest request, Model model) throws Exception;
	
}

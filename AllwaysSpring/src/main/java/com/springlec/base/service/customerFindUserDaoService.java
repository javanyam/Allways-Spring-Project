package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface customerFindUserDaoService {

	public void findIdDao(HttpServletRequest request, Model model) throws Exception;
	public void userCheckDao(HttpServletRequest request, Model model) throws Exception;
	public void resetPwDao(HttpServletRequest request) throws Exception;
	
}

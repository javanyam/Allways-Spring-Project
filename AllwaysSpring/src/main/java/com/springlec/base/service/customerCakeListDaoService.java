package com.springlec.base.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface customerCakeListDaoService {
	
	public void customerCakeList (Model model, HttpServletRequest request) throws Exception;

}

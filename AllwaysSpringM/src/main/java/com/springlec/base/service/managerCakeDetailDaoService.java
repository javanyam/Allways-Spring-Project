package com.springlec.base.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


public interface managerCakeDetailDaoService {

	public void cakeDetail(HttpServletRequest request, Model model) throws Exception;
	
	public void updateCake(MultipartHttpServletRequest request, MultipartFile file, Model model) throws Exception;
	
	public void checkName2(HttpServletRequest request, Model model) throws Exception;
	
	public void deleteCake(HttpServletRequest request, Model model) throws Exception;
	
}

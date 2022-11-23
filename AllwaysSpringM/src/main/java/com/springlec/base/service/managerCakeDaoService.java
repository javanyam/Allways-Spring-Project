package com.springlec.base.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


public interface managerCakeDaoService {

	public void searchCake(HttpServletRequest request, Model model) throws Exception;
	public void addCake(MultipartHttpServletRequest request, MultipartFile file) throws Exception; 
	public void cakeNameCheck(MultipartHttpServletRequest request, MultipartFile file, Model model) throws Exception; 
	
}

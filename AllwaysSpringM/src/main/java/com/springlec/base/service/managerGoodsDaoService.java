package com.springlec.base.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


public interface managerGoodsDaoService {

	public void searchGoods(HttpServletRequest request, Model model) throws Exception;
	
	public void addGoods(MultipartHttpServletRequest request, MultipartFile file, Model model) throws Exception;
	
	public void checkGoodsName(HttpServletRequest request, Model model) throws Exception;
	
}

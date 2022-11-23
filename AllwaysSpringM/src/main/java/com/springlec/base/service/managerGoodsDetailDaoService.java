package com.springlec.base.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


public interface managerGoodsDetailDaoService {

	public void viewGoodsDetail(HttpServletRequest request, Model model) throws Exception;
	
	public void checkGoodsName2(HttpServletRequest request, Model model) throws Exception;
	
	public void deleteGoods(HttpServletRequest request) throws Exception;
	
	public void updateGoods(MultipartHttpServletRequest request, MultipartFile file, Model model) throws Exception;
	
}

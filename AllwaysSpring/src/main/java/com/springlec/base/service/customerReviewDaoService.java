package com.springlec.base.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springlec.base.model.customerPageDto;

public interface customerReviewDaoService {

	public void customerReviewList(HttpServletRequest request, Model model, customerPageDto page) throws Exception;
	public customerPageDto customerReviewListCount() throws Exception;
	public void customerOrderList(Model model) throws Exception;
	public void customerWriteReview(MultipartHttpServletRequest request, MultipartFile file, MultipartHttpServletRequest multi) throws Exception;
	
}
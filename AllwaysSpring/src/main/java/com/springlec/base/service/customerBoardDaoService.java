package com.springlec.base.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


public interface customerBoardDaoService {

	public void customerBoardList(HttpServletRequest request, Model model) throws Exception;
	
	public int selectWriteId() throws Exception;
	
	public void customerBoardWrite(HttpServletRequest request, int writeId) throws Exception;
	
	public void customerBoardDetail(HttpServletRequest request, Model model) throws Exception;
	
	public void customerboardCommentList(HttpServletRequest request, Model model) throws Exception;
	
	public void customerwriteComment(HttpServletRequest request, RedirectAttributes attributes) throws Exception;
	
}
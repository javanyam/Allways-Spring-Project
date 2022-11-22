package com.springlec.base.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springlec.base.service.customerBoardDeleteDaoService;

@Controller
public class customerBoardDeleteController {

	@Autowired
	customerBoardDeleteDaoService service;
	
	// 게시판 or 게시판 답글 삭제
	@RequestMapping("/customerBoardDelete")
	public String customerBoardDelete(HttpServletRequest request, Model model, RedirectAttributes attributes) throws Exception {
		
		service.customerBoardDelete(request);
		attributes.addAttribute("index", Integer.parseInt(request.getParameter("index")));
		
		return "redirect:customerBoardList";
	}
	
	// 게시판 답글 or 대댓글 삭제
	@RequestMapping("/customerBoardDetailCommentDelete")
	public String customerBoardDetailCommentDelete(HttpServletRequest request, Model model, RedirectAttributes attributes) throws Exception {
		
		service.customerBoardDetailCommentDelete(request);
		attributes.addAttribute("writeId", Integer.parseInt(request.getParameter("writeId")));
		
		return "redirect:customerBoardDetail";
	}
	
	
}

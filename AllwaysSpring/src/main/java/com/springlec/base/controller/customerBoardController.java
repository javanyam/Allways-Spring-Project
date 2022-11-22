package com.springlec.base.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springlec.base.service.customerBoardDaoService;

@Controller
public class customerBoardController {

	@Autowired
	customerBoardDaoService service;
	@Autowired
	HttpSession session;
	
	// 게시판 리스트 출력
	@RequestMapping("/customerBoardList")
	public String customerBoardList(HttpServletRequest request, Model model) throws Exception {
		
		service.customerBoardList(request, model);

		return "customerBoardList";
	}
	
	// 게시판 작성 페이지
	@RequestMapping("/customerBoardWritePage")
	public String customerBoardWritePage() throws Exception {
		
		return "customerBoardWrite";
	}
	
	// 게시판 작성하기
	@RequestMapping("/customerBoardWrite")
	public String customerBoardWrite(HttpServletRequest request) throws Exception {
		
		int writeId = service.selectWriteId();
		service.customerBoardWrite(request, writeId);

		return "redirect:customerBoardList";
	}
	
	// 게시판 클릭
	@RequestMapping("/customerBoardDetail")
	public String customerBoardDetail(HttpServletRequest request, Model model) throws Exception {
		
		service.customerBoardDetail(request, model);
		service.customerboardCommentList(request, model);

		return "customerBoardDetail";
	}
	
	// 게시판 답글달기
	@RequestMapping("/customerWriteComment")
	public String customerWriteComment(HttpServletRequest request, RedirectAttributes attributes) throws Exception {
		
		service.customerwriteComment(request, attributes);
		
		return "redirect:customerBoardDetail";
	}
	
}

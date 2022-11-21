package com.springlec.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springlec.base.model.customerBoardDetailDto;
import com.springlec.base.model.customerBoardDto;
import com.springlec.base.service.customerBoardDaoService;

@Controller
public class customerBoardController {

	@Autowired
	customerBoardDaoService service;
	
	// 게시판 리스트 출력
	@RequestMapping("/customerBoardList")
	public String customerBoardList(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		
		List<customerBoardDto> dtos = service.customerBoardList(request);

		int index = 1; // 시작 페이지 번호
		int rowcount = 10; // 한 페이지에 출력할 리스트 개수
		int pagecount = 10; // 한 페이지에 출력할 페이지 개수
		int pagepage = 0; // ??
		
		int maxpage = (dtos.size() % rowcount) != 0 ? (dtos.size() / rowcount) + 1 : (dtos.size() / rowcount);

		if (request.getParameter("index")!=null) {
			index = (int)Float.parseFloat(request.getParameter("index"));
		}
		
		if (index % pagecount == 0) {
			pagepage = index / pagecount - 1;
		} else {
			pagepage = index / pagecount;
		}
		
		model.addAttribute("CUSTOMERID", session.getAttribute("ID"));
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("BoardList", dtos);
		model.addAttribute("arrsize", dtos.size());
		model.addAttribute("index", index);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("pagepage", pagepage);
		
		return "customerBoardList";
	}
	
	// 게시판 작성 페이지
	@RequestMapping("/customerBoardWritePage")
	public String customerBoardWritePage() throws Exception {
		
		return "customerBoardWrite";
	}
	
	// 게시판 작성하기
	@RequestMapping("/customerBoardWrite")
	public String customerBoardWrite(HttpSession session, HttpServletRequest request) throws Exception {
		
		int writeId = service.selectWriteId();
		service.customerBoardWrite(session, request, writeId);

		return "redirect:customerBoardList";
	}
	
	// 게시판 클릭
	@RequestMapping("/customerBoardDetail")
	public String customerBoardDetail(HttpSession session, HttpServletRequest request, Model model) throws Exception {
		
		customerBoardDetailDto dto = service.customerBoardDetail(request, session);
		List<customerBoardDetailDto> dtos = service.customerboardCommentList(request, model, session);
		
		model.addAttribute("boardDetail", dto);
		model.addAttribute("boardComment", dtos);
		model.addAttribute("boardlength", dtos.size());
		
		return "customerBoardDetail";
	}
	
	// 게시판 답글달기
	@RequestMapping("/customerWriteComment")
	public String customerWriteComment(HttpSession session, HttpServletRequest request, RedirectAttributes attributes) throws Exception {
		
		service.customerwriteComment(session, request);
		int writeId = Integer.parseInt(request.getParameter("writeId"));
		
		attributes.addAttribute("writeId", writeId);
		
		return "redirect:customerBoardDetail";
	}
	
}

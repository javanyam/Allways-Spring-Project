package com.springlec.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.cakeDto;
import com.springlec.base.service.customerDaoService;

@Controller
public class customerController {

	@Autowired
	customerDaoService service;

	// 게시판 검색
	@RequestMapping("/list")
	public String list(Model model) throws Exception {

		List<cakeDto> listDao = service.listDao();
		model.addAttribute("list", listDao);

		return "list";
	}

	@RequestMapping("/write_view")
	public String writeView() throws Exception {

		return "write_view";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) throws Exception {
		service.writeDao(request.getParameter("name"), request.getParameter("phone"), request.getParameter("address"),
				request.getParameter("email"), request.getParameter("relation"));
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content(HttpServletRequest request, Model model) throws Exception{
		
		cakeDto contentDto = service.contentDao(Integer.parseInt(request.getParameter("seq")));
		model.addAttribute("content_view", contentDto);
		
		return "content_view";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request) throws Exception {
		
		service.deleteDao(Integer.parseInt(request.getParameter("seq")));
		
		return "redirect:list";
	}
	
	@RequestMapping("/modify")
	public String update(HttpServletRequest request, Model model) throws Exception {
		
		service.updateDao(Integer.parseInt(request.getParameter("seq")), request.getParameter("name"), request.getParameter("phone"), request.getParameter("address"),
				request.getParameter("email"), request.getParameter("relation"));
		
		return "redirect:list";
	}
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request, Model model) throws Exception {
		
		List<cakeDto> searchDao = service.searchDao(request.getParameter("query"), request.getParameter("content"));
		model.addAttribute("list", searchDao);
		
		return "list";
	}

}

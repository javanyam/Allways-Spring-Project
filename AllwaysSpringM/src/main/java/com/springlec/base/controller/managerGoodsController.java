package com.springlec.base.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springlec.base.service.managerGoodsDaoService;

@Controller
public class managerGoodsController {

	@Autowired
	managerGoodsDaoService service;
	@Autowired
	HttpSession session;
	
	// 옵션 검색
	@RequestMapping("searchGoods")
	public String searchGoods(HttpServletRequest request, Model model) throws Exception {
		
		service.searchGoods(request, model);
		return "managerViewGoods";
	}
	
	// 옵션 검색
	@RequestMapping("managerCreateGoods")
	public String managercreategoods() throws Exception {
		return "managerCreateGoods";
	}
	
	// 옵션 추가
	@RequestMapping("addGoods")
	public String addGoods(MultipartHttpServletRequest request, MultipartFile file, Model model) throws Exception {
		
		service.addGoods(request, file, model);
		return "redirect:searchGoods";
	}
	
	// 옵션 이름 중복체크
	@RequestMapping("checkGoodsName")
	public String checkGoodsName(HttpServletRequest request, Model model) throws Exception {
		
		service.checkGoodsName(request, model);
		return "managerCreateGoods";
	}
	
	
	
}

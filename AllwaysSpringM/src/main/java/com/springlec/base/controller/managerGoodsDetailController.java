package com.springlec.base.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springlec.base.service.managerGoodsDetailDaoService;

@Controller
public class managerGoodsDetailController {

	@Autowired
	managerGoodsDetailDaoService service;
	@Autowired
	HttpSession session;
	
	// 추가상품 상세정보
	@RequestMapping("viewGoodsDetail")
	public String viewGoodsDetail(HttpServletRequest request, Model model) throws Exception {
		
		service.viewGoodsDetail(request, model);
		return "managerManageGoods";
	}
	
	// 추가상품 수정 시 이름 중복확인
	@RequestMapping("checkGoodsName2")
	public String checkGoodsName2(HttpServletRequest request, Model model) throws Exception {
		
		service.checkGoodsName2(request, model);
		return "managerManageGoods";
	}
	
	// 추가상품 삭제
	@RequestMapping("deleteGoods")
	public String deleteGoods(HttpServletRequest request) throws Exception {
		
		service.deleteGoods(request);
		return "redirect:searchGoods";
	}
	
	// 추가상품 수정
	@RequestMapping("updateGoods")
	public String updateGoods(MultipartHttpServletRequest request, MultipartFile file, Model model) throws Exception {
		
		service.updateGoods(request, file, model);
		return "redirect:searchGoods";
	}
	
	
}

package com.springlec.base.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.customerCartListDto;
import com.springlec.base.service.customerCartListDaoService;

@Controller
public class customerCartListController {

	@Autowired
	customerCartListDaoService service;
	
	@RequestMapping("/customerCartList")
	public String customerCartList(HttpSession session, Model model) throws Exception {
		
		List<customerCartListDto> cakeCartList = service.cakeCartList(session);
		model.addAttribute("cakeCartList", cakeCartList);

//		List<customerCartListDto> optionCartList = service.optionCartList(request);
//		model.addAttribute("optionCartList", optionCartList);
		
		return "customerCart";
	}
}

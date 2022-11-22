package com.springlec.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.customerCakeListDto;
import com.springlec.base.service.customerCakeListDaoService;

@Controller
public class customerCakeListController {

	@Autowired
	customerCakeListDaoService service;

	@RequestMapping("/customerCakeList")
	public String customerCakeList(Model model) throws Exception {

		List<customerCakeListDto> cakeList = service.customerCakeList();
		model.addAttribute("cakeList", cakeList);

		return "customerCakeList";
	}
}

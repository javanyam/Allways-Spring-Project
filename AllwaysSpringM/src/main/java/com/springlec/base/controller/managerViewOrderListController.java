package com.springlec.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.managerViewOrderListDto;
import com.springlec.base.service.managerViewOrderListDaoService;

@Controller
public class managerViewOrderListController {

	@Autowired
	managerViewOrderListDaoService service;

	@RequestMapping("/managerViewOrderList")
	public String managerViewOrderList(HttpServletRequest request, Model model) throws Exception {
		
		service.orderList1(request, model);

		List<managerViewOrderListDto> orderList2 = service.orderList2();
		model.addAttribute("orderList2", orderList2);
		
		return "managerViewOrderList";
	}

	@RequestMapping("/orderSelect")
	public String orderSelect(HttpServletRequest request, Model model) throws Exception {

		managerViewOrderListDto orderSelect = service.orderSelect(request);
		model.addAttribute("selectInfo", orderSelect);

		return "managerUpdateStatus";
	}

	@RequestMapping("/orderDelete")
	public String orderDelete(HttpServletRequest request) throws Exception {

		service.orderDelete(request);

		return "redirect:managerViewOrderList";
	}

	@RequestMapping("/orderUpdate")
	public String orderUpdate(HttpServletRequest request) throws Exception {
		
		service.orderUpdateToMaking(request);
		
		return "redirect:managerViewOrderList";
	}
	
}

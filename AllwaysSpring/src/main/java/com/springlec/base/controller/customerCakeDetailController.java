package com.springlec.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.model.customerCakeDetailDto;
import com.springlec.base.service.customerCakeDetailDaoService;

@Controller
public class customerCakeDetailController {

	@Autowired
	customerCakeDetailDaoService service;

	@RequestMapping("/customerCakeDetail")
	public String customerCakeDetail(HttpServletRequest request, Model model) throws Exception {

		customerCakeDetailDto cakeDetail = service.customerCakeDetail(request);
		model.addAttribute("cakeInfo", cakeDetail);
		
		List<customerCakeDetailDto> cakeShape = service.customerCakeShape();
		model.addAttribute("shapeList", cakeShape);
		
		List<customerCakeDetailDto> cakeSize = service.customerCakeSize();
		model.addAttribute("sizeList", cakeSize);
		
		List<customerCakeDetailDto> cakeFlavor = service.customerCakeFlavor();
		model.addAttribute("flavorList", cakeFlavor);
		
		service.viewsUpdate(request);
		
		return "customerCakeDetail";
	}

}

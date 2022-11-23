package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.springlec.base.dao.managerMainDao;
import com.springlec.base.model.managerOrderStatusDto;
import com.springlec.base.model.ordersReviewDto;


@Service
public class managerMainDaoServiceImpl implements managerMainDaoService {

	@Autowired
	managerMainDao dao;
	
	@Autowired
	HttpSession session;

	@Override
	public void managerMain(Model model) throws Exception {
		List<String> dates = dao.makeXAxis();
		List<Integer> price = dao.makeSalesPrice();
		List<Integer> quantity = dao.makeSalesQuantity();
		List<managerOrderStatusDto> ordersdtos = dao.orderStautsList();
		List<ordersReviewDto> dtos2 = dao.showOrdersReviewOnMain();
		
		String strDates = "";
		String strPrice = "";
		String strQuantity = "";

		if (dates.size() != 0 && price.size() != 0 && quantity.size() != 0) {
			for (int i = 0; i < dates.size(); i++) {
				strDates += dates.get(i);
				strPrice += price.get(i);
				strQuantity += quantity.get(i);
				if (i != dates.size() - 1) {
					strDates += ",";
					strPrice += ",";
					strQuantity += ",";
				}
			}
		}
		
		model.addAttribute("REVIEWDTO", dtos2);
		model.addAttribute("XAXIS", strDates);
		model.addAttribute("SALESPRICE", strPrice);
		model.addAttribute("SALESQUANTITY", strQuantity);
		model.addAttribute("ORDERS", ordersdtos);
		
	}
	
//	@Override
//	public void makeSalesPrice() throws Exception {
//	}
//	
//	@Override
//	public void makeSalesQuantity() throws Exception {
//	}
//
//	@Override
//	public void orderStautsList() throws Exception {
//	}
	
	
}

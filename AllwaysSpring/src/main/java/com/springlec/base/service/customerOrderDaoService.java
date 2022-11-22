package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.springlec.base.model.customerOrderDto;

public interface customerOrderDaoService {

	public void orderList(HttpSession session, HttpServletRequest request, Model model) throws Exception;

	public List<customerOrderDto> customerInfo(HttpSession session) throws Exception;

}

package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.customerCakeBuyNowDao;
import com.springlec.base.model.customerOrderDto;

@Service
public class customerCakeBuyNowDaoServiceImpl implements customerCakeBuyNowDaoService {

	@Autowired
	customerCakeBuyNowDao dao;

	@Override
	public void buyNow(HttpSession session, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		String customerId = (String) session.getAttribute("ID");
		int cakeId = Integer.parseInt(request.getParameter("cakeId"));
		int cakePrice = Integer.parseInt(request.getParameter("cakePrice"));
		int ordersQuantity = Integer.parseInt(request.getParameter("ordersQuantity"));

		dao.buyNow(customerId, cakeId, cakePrice, ordersQuantity);
	}

	@Override
	public int buyNowInfo(HttpSession session) throws Exception {
		String customerId = (String) session.getAttribute("ID");

		return dao.buyNowInfo(customerId);
	}

	@Override
	public void detailOptionInsert(HttpServletRequest request, HttpSession session, int ordersId) throws Exception {
		// TODO Auto-generated method stub

		int shape = Integer.parseInt(request.getParameter("shape"));
		int size = Integer.parseInt(request.getParameter("size"));
		int flavor = Integer.parseInt(request.getParameter("flavor"));
		int[] cakeoptionId = { shape, size, flavor };

		String customerId = (String) session.getAttribute("ID");
		int cakeId = Integer.parseInt(request.getParameter("cakeId"));
		String detailoptionLettering = request.getParameter("detailoptionLettering");
		String detailoptionPickupDate = request.getParameter("detailoptionPickupDate");

		for (int i = 0; i < cakeoptionId.length; i++) {
			dao.detailOptionInsert(ordersId, cakeoptionId[i], customerId, cakeId, detailoptionLettering,
					detailoptionPickupDate);
		}
	}

	@Override
	public int selectOptionPrice(int ordersId) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectOptionPrice(ordersId);
	}

	@Override
	public void salePriceUpdate(int ordersId, int optionPrice, HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub

		int cakePrice = Integer.parseInt(request.getParameter("cakePrice"));
		int ordersQuantity = Integer.parseInt(request.getParameter("ordersQuantity"));
		int ordersSalePrice = (optionPrice + cakePrice) * ordersQuantity;

		dao.salePriceUpdate(ordersId, optionPrice, cakePrice, ordersQuantity, ordersSalePrice);
	}

	@Override
	public List<customerOrderDto> orderList(HttpSession session, int ordersId) throws Exception {
		
		String customerId = (String) session.getAttribute("ID");
		
		return dao.orderList(customerId, ordersId);
	}

	@Override
	public List<customerOrderDto> customerInfo(HttpSession session) throws Exception {
		
		String customerId = (String) session.getAttribute("ID");
		
		return dao.customerInfo(customerId);
	}

}

package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.managerViewOrderListDao;
import com.springlec.base.model.managerViewOrderListDto;

@Service
public class managerViewOrderListDaoServiceImpl implements managerViewOrderListDaoService {
	
	@Autowired
	managerViewOrderListDao dao;

	@Override
	public List<managerViewOrderListDto> orderList1() throws Exception {
		return dao.orderList1();
	}

	@Override
	public List<managerViewOrderListDto> orderList2() throws Exception {
		return dao.orderList2();
	}

	@Override
	public List<managerViewOrderListDto> orderList3() throws Exception {
		return dao.orderList3();
	}

	@Override
	public managerViewOrderListDto orderSelect(HttpServletRequest request) throws Exception {
		
		int ordersId = Integer.parseInt(request.getParameter("ordersId"));
		
		return dao.orderSelect(ordersId);
	}

	@Override
	public void orderDelete(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		
		int ordersId = Integer.parseInt(request.getParameter("ordersId"));
		
		dao.orderDelete(ordersId);
	}

	@Override
	public void orderUpdateToMaking(HttpServletRequest request) throws Exception {
		
		int ordersId = Integer.parseInt(request.getParameter("ordersId"));
		String ordersStatus = request.getParameter("ordersStatus");
		String o_customerId = request.getParameter("o_customerId");
		int o_cakeId = Integer.parseInt(request.getParameter("o_cakeId"));
		int o_goodsId = Integer.parseInt(request.getParameter("o_goodsId"));
		int ordersSalePrice = Integer.parseInt(request.getParameter("ordersSalePrice"));
		int ordersQuantity = Integer.parseInt(request.getParameter("ordersQuantity"));
		
		String making = "제작중";
//		String done = "제작완료";
		
		if (ordersStatus.equals(making)) {
			dao.orderUpdateToMaking(ordersId, ordersStatus, o_customerId, o_cakeId, o_goodsId, ordersSalePrice, ordersQuantity);
			dao.orderUpdateMakedate(ordersId);
		}else {
			dao.orderUpdateToDone(ordersId, ordersStatus, o_customerId, o_cakeId, o_goodsId, ordersSalePrice, ordersQuantity);
			dao.orderUpdateDonedate(ordersId);
		}
	}

	@Override
	public void orderUpdateMakedate(int ordersId) throws Exception {
		
//		dao.orderUpdateMakedate(ordersId);
	}

	@Override
	public void orderUpdateToDone(HttpServletRequest request) throws Exception {
		
		int ordersId = Integer.parseInt(request.getParameter("ordersId"));
		String ordersStatus = request.getParameter("ordersStatus");
		String o_customerId = request.getParameter("o_customerId");
		int o_cakeId = Integer.parseInt(request.getParameter("o_cakeId"));
		int o_goodsId = Integer.parseInt(request.getParameter("o_goodsId"));
		int ordersSalePrice = Integer.parseInt(request.getParameter("ordersSalePrice"));
		int ordersQuantity = Integer.parseInt(request.getParameter("ordersQuantity"));
		
		
//		dao.orderUpdateToDone(ordersId, ordersStatus, o_customerId, o_cakeId, o_goodsId, ordersSalePrice, ordersQuantity);
	}

	@Override
	public void orderUpdateDonedate(int ordersId) throws Exception {
		
//		dao.orderUpdateDonedate(ordersId);
	}

}

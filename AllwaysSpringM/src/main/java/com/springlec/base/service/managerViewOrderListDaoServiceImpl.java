package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.springlec.base.dao.managerViewOrderListDao;
import com.springlec.base.model.managerViewOrderListDto;

@Service
public class managerViewOrderListDaoServiceImpl implements managerViewOrderListDaoService {

	@Autowired
	managerViewOrderListDao dao;

	@Override
	public void orderList1(HttpServletRequest request, Model model) throws Exception {

		int index = 1; // 시작 페이지 번호
		int rowcount = 10; // 한 페이지에 출력할 리스트 개수
		int pagecount = 10; // 한 페이지에 출력할 페이지 개수
		int pagepage = 0; // ??

		List<managerViewOrderListDto> dtos = dao.orderList1();
		List<managerViewOrderListDto> dtos2 = dao.orderList2();
		List<managerViewOrderListDto> dtos3 = dao.orderList3();
		int maxpage = (dtos.size() % rowcount) != 0 ? (dtos.size() / rowcount) + 1 : (dtos.size() / rowcount);

		if (request.getParameter("index") != null) {
			index = (int) Float.parseFloat(request.getParameter("index"));
		}

		if (index % pagecount == 0) {
			pagepage = index / pagecount - 1;
		} else {
			pagepage = index / pagecount;
		}
		
		model.addAttribute("orderList1", dtos);
		model.addAttribute("orderList2", dtos2);
		model.addAttribute("orderList3", dtos3);
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("arrsize", dtos.size());
		model.addAttribute("index", index);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("pagepage", pagepage);

	}

	@Override
	public List<managerViewOrderListDto> orderList2() throws Exception {

		return dao.orderList2();

	}

	@Override
	public void orderList3(HttpServletRequest request, Model model) throws Exception {
		int index = 1; // 시작 페이지 번호
		int rowcount = 10; // 한 페이지에 출력할 리스트 개수
		int pagecount = 10; // 한 페이지에 출력할 페이지 개수
		int pagepage = 0; // ??

		List<managerViewOrderListDto> dtos3 = dao.orderList3();

		int maxpage = (dtos3.size() % rowcount) != 0 ? (dtos3.size() / rowcount) + 1 : (dtos3.size() / rowcount);

		if (request.getParameter("index3") != null) {
			index = (int) Float.parseFloat(request.getParameter("index3"));
		}

		if (index % pagecount == 0) {
			pagepage = index / pagecount - 1;
		} else {
			pagepage = index / pagecount;
		}
		System.out.println(index);
		model.addAttribute("orderList3", dtos3);
		model.addAttribute("maxpage3", maxpage);
		model.addAttribute("arrsize3", dtos3.size());
		model.addAttribute("index3", index);
		model.addAttribute("rowcount3", rowcount);
		model.addAttribute("pagecount3", pagecount);
		model.addAttribute("pagepage3", pagepage);

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
			dao.orderUpdateToMaking(ordersId, ordersStatus, o_customerId, o_cakeId, o_goodsId, ordersSalePrice,
					ordersQuantity);
			dao.orderUpdateMakedate(ordersId);
		} else {
			dao.orderUpdateToDone(ordersId, ordersStatus, o_customerId, o_cakeId, o_goodsId, ordersSalePrice,
					ordersQuantity);
			dao.orderUpdateDonedate(ordersId);
		}
	}

	@Override
	public void orderUpdateMakedate(int ordersId) throws Exception {

//		dao.orderUpdateMakedate(ordersId);
	}

	@Override
	public void orderUpdateToDone(HttpServletRequest request) throws Exception {

//		int ordersId = Integer.parseInt(request.getParameter("ordersId"));
//		String ordersStatus = request.getParameter("ordersStatus");
//		String o_customerId = request.getParameter("o_customerId");
//		int o_cakeId = Integer.parseInt(request.getParameter("o_cakeId"));
//		int o_goodsId = Integer.parseInt(request.getParameter("o_goodsId"));
//		int ordersSalePrice = Integer.parseInt(request.getParameter("ordersSalePrice"));
//		int ordersQuantity = Integer.parseInt(request.getParameter("ordersQuantity"));

//		dao.orderUpdateToDone(ordersId, ordersStatus, o_customerId, o_cakeId, o_goodsId, ordersSalePrice, ordersQuantity);
	}

	@Override
	public void orderUpdateDonedate(int ordersId) throws Exception {

//		dao.orderUpdateDonedate(ordersId);
	}

}

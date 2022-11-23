package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.springlec.base.dao.customerMypageDao;
import com.springlec.base.model.customerMyPointDto;
import com.springlec.base.model.customerOrderListDto;
import com.springlec.base.model.customerUserinfoDto;

@Service
public class customerMypageDaoServiceImpl implements customerMypageDaoService {

	@Autowired
	customerMypageDao dao;
	@Autowired
	HttpSession session;
	
	@Override
	public void mypageDao(HttpServletRequest request, Model model) throws Exception {
		String customerId = (String)session.getAttribute("ID");
		customerUserinfoDto dto = dao.mypageDao(customerId);
		model.addAttribute("USERINFO", dto);
	}

	@Override
	public void userEmailDao(HttpServletRequest request, Model model) throws Exception {
		String customerId = (String)session.getAttribute("ID");
		String customerEmail = dao.userEmailDao(customerId);
		int idx = customerEmail.indexOf("@");
		String customerEmailId = customerEmail.substring(0,idx);
		String customerEmailDomain = customerEmail.substring(idx+1);
		model.addAttribute("EMAILID", customerEmailId);
		model.addAttribute("EMAILDOMAIN", customerEmailDomain);
		
	}

	@Override
	public void updateDao(HttpServletRequest request) throws Exception {
		String customerId = request.getParameter("customerId");
		String customerPw = request.getParameter("customerPw");
		String customerName = request.getParameter("customerName");
		String customerGender = request.getParameter("customerGender");
		String customerPhone = request.getParameter("customerPhone");
		String customerEmail = request.getParameter("email1") + "@" + request.getParameter("email2");
		String customerBirthday = request.getParameter("customerBirth");
		String customerPostcode = request.getParameter("postcode");
		String customerAddress = request.getParameter("address");
		String customerAddressDetail = request.getParameter("addressDetail");
		
		dao.updateDao(customerId, customerPw, customerName, customerGender, customerPhone, customerEmail, customerBirthday, customerPostcode, customerAddress, customerAddressDetail);
		
	}

	@Override
	public void deleteDao(HttpServletRequest request) throws Exception {
		String customerId = request.getParameter("customerId");
		dao.deleteDao(customerId);
	}

	@Override
	public void myOrderListDao(HttpServletRequest request, Model model) throws Exception {
		String customerId = (String)session.getAttribute("ID");	
		List<customerOrderListDto> dtos = dao.myOrderListDao(customerId);

		int index = 1; // 시작 페이지 번호
		int rowcount = 10; // 한 페이지에 출력할 리스트 개수
		int pagecount = 10; // 한 페이지에 출력할 페이지 개수
		int pagepage = 0; // ??
		
		int maxpage = (dtos.size() % rowcount) != 0 ? (dtos.size() / rowcount) + 1 : (dtos.size() / rowcount);

		if (request.getParameter("index")!=null) {
			index = (int)Float.parseFloat(request.getParameter("index"));
		}
		
		if (index % pagecount == 0) {
			pagepage = index / pagecount - 1;
		} else {
			pagepage = index / pagecount;
		}
		
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("arrsize", dtos.size());
		model.addAttribute("index", index);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("pagepage", pagepage);
		model.addAttribute("ordersList", dtos);
		model.addAttribute("customerId");
		
	}

	@Override
	public void myPointDao(HttpServletRequest request, Model model) throws Exception {
		String customerId = (String)session.getAttribute("ID");	
		List<customerMyPointDto> dtos = dao.myPointDao(customerId);
		
		int index = 1; // 시작 페이지 번호
		int rowcount = 10; // 한 페이지에 출력할 리스트 개수
		int pagecount = 10; // 한 페이지에 출력할 페이지 개수
		int pagepage = 0; // ??'
		int totalPoint = 0;
		
		int maxpage = (dtos.size() % rowcount) != 0 ? (dtos.size() / rowcount) + 1 : (dtos.size() / rowcount);
		
		for(int i = 0; i < dtos.size(); i++) {
			totalPoint += dtos.get(i).getOrdersPoint();
		}

		if (request.getParameter("index")!=null) {
			index = (int)Float.parseFloat(request.getParameter("index"));
		}
		
		if (index % pagecount == 0) {
			pagepage = index / pagecount - 1;
		} else {
			pagepage = index / pagecount;
		}
		
		model.addAttribute("totalPoint", totalPoint);
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("arrsize", dtos.size());
		model.addAttribute("index", index);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("pagepage", pagepage);
		model.addAttribute("customerId");
		model.addAttribute("myPointList", dtos);
		
	}

}

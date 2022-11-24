package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.springlec.base.dao.customerCakeListDao;
import com.springlec.base.model.customerCakeListDto;

@Service
public class customerCakeListDaoServiceImpl implements customerCakeListDaoService {

	@Autowired
	customerCakeListDao dao;

	@Override
	public void customerCakeList(Model model, HttpServletRequest request) throws Exception {
		
		String sort1 = request.getParameter("sort1");
		String sort2 = request.getParameter("sort2");
		
		System.out.println(sort1);
		System.out.println(sort2);
		
		if (sort1 == null) {
			sort1 = "cakeInitdate";
			sort2 = "desc";
		}
		
		int index = 1; // 시작 페이지 번호
		int rowcount = 8; // 한 페이지에 출력할 리스트 개수
		int pagecount = 10; // 한 페이지에 출력할 페이지 개수
		int pagepage = 0; // ??
		
		List<customerCakeListDto> dtos =  dao.customerCakeList(sort1, sort2);
		
		int maxpage = (dtos.size() % rowcount) != 0 ? (dtos.size() / rowcount) + 1 : (dtos.size() / rowcount);

		if (request.getParameter("index")!=null) {
			index=(int)Float.parseFloat(request.getParameter("index"));
		}
		
		if (index % pagecount == 0) {
			pagepage = index / pagecount - 1;
		} else {
			pagepage = index / pagecount;
		}
		
		model.addAttribute("cakeList", dtos);
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("arrsize", dtos.size());
		model.addAttribute("index", index);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("pagepage", pagepage);
		// TODO Auto-generated method stub
	}

}

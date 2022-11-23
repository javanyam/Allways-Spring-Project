package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.springlec.base.dao.managerSearchReviewDao;
import com.springlec.base.model.managerReviewDetailDto;
import com.springlec.base.model.managerReviewListDto;


@Service
public class managerSearchReviewDaoServiceImpl implements managerSearchReviewDaoService {

	@Autowired
	managerSearchReviewDao dao;
	
	@Autowired
	HttpSession session;

	@Override
	public void searchReview(HttpServletRequest request, Model model) throws Exception {

		String content = request.getParameter("content");
		String query = request.getParameter("query");
		
		if(content == null) {
			content = '%' + "" + '%';
		}else {
			content = '%' + content + '%';
		}
		if(query == null) {
			query = "or_customerId";
		}
		
		int index = 1;
		int rowcount = 7;
		int pagecount = 5;
		int pagepage = 0;

		if (request.getParameter("index") != null) {
			index = (int) Float.parseFloat(request.getParameter("index"));
		}

		if (index % pagecount == 0) {
			pagepage = index / pagecount - 1;
		} else {
			pagepage = index / pagecount;
		}
		
		List<managerReviewListDto> dtos = dao.searchReview(query, content);
		
		content = content.substring(1, content.length() - 1);
		
		model.addAttribute("Dtos", dtos);
		model.addAttribute("Size", dtos.size());
		model.addAttribute("index", index);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("pagepage", pagepage);
		model.addAttribute("QUERY", query);
		model.addAttribute("CONTENT", content);
		
	}

	@Override
	public void reviewDetail(HttpServletRequest request, Model model) throws Exception {

		int oreviewId = Integer.parseInt(request.getParameter("oreviewId"));
		
		managerReviewDetailDto dto = dao.reviewDetail(oreviewId);
		
		model.addAttribute("DTO", dto);
	}




		
	
	
	
}

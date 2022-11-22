package com.springlec.base.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springlec.base.dao.customerReviewDao;
import com.springlec.base.model.customerOrderListDto;
import com.springlec.base.model.customerPageDto;
import com.springlec.base.model.customerReviewDto;

@Service
public class customerReviewDaoServiceImpl implements customerReviewDaoService {

	@Autowired
	customerReviewDao dao;
	
	@Autowired
	HttpSession session;
	
	@Override
	public void customerReviewList(HttpServletRequest request, Model model, customerPageDto page) throws Exception {

		String combo = request.getParameter("combo");
		String searchContent = request.getParameter("searchContent");
		String sort = request.getParameter("sort");

		if(sort == null) {
			sort = "oreviewInitdate";
		}
		if(combo == null) {
			combo = "or_customerId";
		}
		if(searchContent == null) {
			searchContent = '%' + "" + '%';
		}else {
			searchContent = '%' + searchContent + '%';
		}

		List<customerReviewDto> dtos = dao.customerReviewList(combo, searchContent, sort);
		
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
		
		model.addAttribute("CUSTOMERID", session.getAttribute("ID"));
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("reviewList", dtos);
		model.addAttribute("arrsize", dtos.size());
		model.addAttribute("index", index);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("pagepage", pagepage);
		model.addAttribute("sort", sort);
		
	}

	@Override
	public customerPageDto customerReviewListCount() throws Exception {
		// TODO Auto-generated method stub
		return dao.customerReviewListCount();
	}
	
	@Override
	public void customerOrderList(Model model) throws Exception {

		String customerId = (String) session.getAttribute("ID");
		
		List<customerOrderListDto> dtos = dao.customerOrderList(customerId);
		
		model.addAttribute("orderList", dtos);
	}

	@Override
	public void customerWriteReview(MultipartHttpServletRequest request, MultipartFile file, MultipartHttpServletRequest multi) throws Exception {

		String or_customerId = (String) session.getAttribute("ID");
		int or_ordersId = Integer.parseInt(request.getParameter("ordersId"));
		String oreviewContent = request.getParameter("oreviewContent");
		String oreviewStarRating = request.getParameter("oreviewStarRating");
		int or_cakeId = Integer.parseInt(request.getParameter("o_cakeId"));
		String originalName = "";
		
		if (!(file == null)) {
			String path = System.getProperty("user.dir") + "//src//main//resources//static//reviewImageFile";
			// 파일을 uid로 만들기 위한 기초단계
			// 확장자 가져오기
			originalName = file.getOriginalFilename();
//			String extension = originalName.substring(originalName.indexOf("."), originalName.length());

			// 패스에 "name" 으로 saveFile을 만들 빈 껍데기를 생성해 준다.
			File saveFile = new File(path, originalName);
			// file을 saveFile이름과 path로 지어서 넣기
			file.transferTo(saveFile);

		}
		
		dao.customerWriteReview(or_customerId, or_ordersId, oreviewContent, oreviewStarRating, originalName, or_cakeId);
		dao.writeReviewUpdate(or_ordersId);
		
	}





}
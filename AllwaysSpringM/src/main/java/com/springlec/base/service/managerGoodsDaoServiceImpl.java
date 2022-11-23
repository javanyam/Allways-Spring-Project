package com.springlec.base.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springlec.base.dao.managerGoodsDao;
import com.springlec.base.model.managerGoodsDto;


@Service
public class managerGoodsDaoServiceImpl implements managerGoodsDaoService {

	@Autowired
	managerGoodsDao dao;
	
	@Autowired
	HttpSession session;

	@Override
	public void searchGoods(HttpServletRequest request, Model model) throws Exception {
		
		String goodsName = request.getParameter("query");
		String goodsCategory = request.getParameter("goodsCategory");
		
		List<managerGoodsDto> dtos = new ArrayList<managerGoodsDto>();
		
		int index = 1;
		int rowcount = 10;
		int pagecount = 5;
		int pagepage = 0;
		
		if (request.getParameter("index") != null) {
			index = (int)Float.parseFloat(request.getParameter("index"));
		}
		
		if (index % pagecount == 0) {
			pagepage = index / pagecount - 1;
		} else {
			pagepage = index / pagecount;
		}
		
		if (goodsName == null) {
			if (goodsCategory == null || goodsCategory.equals("all")) {
				dtos = dao.viewGoodsList1();
			} else {
				dtos = dao.viewGoodsList2(goodsCategory);
			}
		} else {
			if (goodsCategory == null || goodsCategory.equals("all")) {
				goodsName = '%' + goodsName + '%';
				dtos = dao.searchGoods1(goodsName);
				goodsName = goodsName.substring(1, goodsName.length() - 1);
			} else {
				goodsName = '%' + goodsName + '%';
				dtos = dao.searchGoods2(goodsName, goodsCategory);
				goodsName = goodsName.substring(1, goodsName.length() - 1);
			}
		}
		
		
		request.setAttribute("Dtos", dtos);
		request.setAttribute("goodsCategory", goodsCategory);
		request.setAttribute("Size", dtos.size());
		request.setAttribute("Query", goodsName);
		request.setAttribute("index", index);
		request.setAttribute("rowcount", rowcount);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("pagepage", pagepage);
		
	}

	@Override
	public void addGoods(MultipartHttpServletRequest request, MultipartFile file, Model model) throws Exception {

		String goodsName = request.getParameter("goodsName");
		String goodsCategory = request.getParameter("goodsCategory");
		int goodsPrice = Integer.parseInt(request.getParameter("goodsPrice"));
		String goodsDetail = request.getParameter("goodsDetail");
		
		String originalName = "";
		
		if (!(file == null)) {
			String path = System.getProperty("user.dir") + "//src//main//webapp//cakeGoodsImage";
			// 파일을 uid로 만들기 위한 기초단계
			// 확장자 가져오기
			originalName = file.getOriginalFilename();
//			String extension = originalName.substring(originalName.indexOf("."), originalName.length());

			// 패스에 "name" 으로 saveFile을 만들 빈 껍데기를 생성해 준다.
			File saveFile = new File(path, originalName);
			// file을 saveFile이름과 path로 지어서 넣기
			file.transferTo(saveFile);
		}
		
		dao.addGoods(goodsName, goodsCategory, goodsPrice, goodsDetail, originalName);
	}

	@Override
	public void checkGoodsName(HttpServletRequest request, Model model) throws Exception {

		String goodsName = request.getParameter("goodsName");
		String goodsPrice = request.getParameter("goodsPrice");
		String goodsDetail = request.getParameter("goodsDetail");
		
		boolean check = false;
		int count = dao.checkGoodsName(goodsName);
		
		if(count == 0) {
			check = true;
		}
		
		model.addAttribute("check", check);
		model.addAttribute("goodsName", goodsName);
		model.addAttribute("goodsPrice", goodsPrice);
		model.addAttribute("goodsDetail", goodsDetail);
		
	}




		
	
	
	
}

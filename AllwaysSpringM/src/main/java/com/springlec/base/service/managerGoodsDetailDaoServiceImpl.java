package com.springlec.base.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springlec.base.dao.managerGoodsDetailDao;
import com.springlec.base.model.managerGoodsDetailDto;


@Service
public class managerGoodsDetailDaoServiceImpl implements managerGoodsDetailDaoService {

	@Autowired
	managerGoodsDetailDao dao;
	
	@Autowired
	HttpSession session;

	@Override
	public void viewGoodsDetail(HttpServletRequest request, Model model) throws Exception {
		
		String goodsName = request.getParameter("goodsName");
		
		managerGoodsDetailDto dto = dao.viewGoodsDetail(goodsName);

		model.addAttribute("DTO", dto);
		model.addAttribute("goodsName", dto.getGoodsName());
		model.addAttribute("goodsOriginalName", dto.getGoodsName());
		model.addAttribute("goodsCategory", dto.getGoodsCategory());
		model.addAttribute("goodsPrice", dto.getGoodsPrice());
		model.addAttribute("goodsDetail", dto.getGoodsDetail());
		model.addAttribute("goodsImage",dto.getGoodsImage());

	}

	@Override
	public void checkGoodsName2(HttpServletRequest request, Model model) throws Exception {

		String goodsName = request.getParameter("goodsName");
		String goodsOriginalName = request.getParameter("goodsOriginalName");
		String goodsCategory = request.getParameter("goodsCategory");
		String goodsPrice = request.getParameter("goodsPrice");
		String goodsDetail = request.getParameter("goodsDetail");
		String goodsImage = request.getParameter("goodsImage");
		
		boolean check = false;
		
		int count = dao.checkGoodsName2(goodsName, goodsOriginalName);
		
		if(count == 0) {
			check = true;
		}
		
		model.addAttribute("check", check);
		model.addAttribute("goodsName", goodsName);
		model.addAttribute("goodsOriginalName", goodsOriginalName);
		model.addAttribute("goodsCategory", goodsCategory);
		model.addAttribute("goodsPrice", goodsPrice);
		model.addAttribute("goodsDetail", goodsDetail);
		model.addAttribute("goodsImage", goodsImage);
		
	}

	@Override
	public void deleteGoods(HttpServletRequest request) throws Exception {

		String goodsName = request.getParameter("goodsOriginalName");
		
		dao.deleteGoods(goodsName);
		
	}

	@Override
	public void updateGoods(MultipartHttpServletRequest request, MultipartFile file, Model model) throws Exception {

		String goodsName = request.getParameter("goodsName");
		String goodsCategory = request.getParameter("goodsCategory");
		int goodsPrice = Integer.parseInt(request.getParameter("goodsPrice"));
		String goodsDetail = request.getParameter("goodsDetail");
		String goodsOriginalname = request.getParameter("goodsOriginalName");
		
		String originalName = "";
		
		if (!(file == null)) {
			String path = System.getProperty("user.dir") + "//src//main//webapp//cakeGoodsImage";
			// 확장자 가져오기
			originalName = file.getOriginalFilename();

			// 패스에 "name" 으로 saveFile을 만들 빈 껍데기를 생성해 준다.
			File saveFile = new File(path, originalName);
			// file을 saveFile이름과 path로 지어서 넣기
			file.transferTo(saveFile);
		}
		
		dao.updateGoods(goodsName, goodsCategory, goodsPrice, goodsDetail, goodsOriginalname, originalName);
	}

	
	
}

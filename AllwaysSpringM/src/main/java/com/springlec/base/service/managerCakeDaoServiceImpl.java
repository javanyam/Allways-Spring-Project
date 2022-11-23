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

import com.springlec.base.dao.managerCakeDao;
import com.springlec.base.model.managerCakeListDto;


@Service
public class managerCakeDaoServiceImpl implements managerCakeDaoService {

	@Autowired
	managerCakeDao dao;
	
	@Autowired
	HttpSession session;

	@Override
	public void searchCake(HttpServletRequest request, Model model) throws Exception {

		String cakeName = request.getParameter("query");
		
		int index=1;
		int rowcount=7;
		int pagecount=5;
		int pagepage=0;
		
		if (request.getParameter("index")!=null) {
			index=(int)Float.parseFloat(request.getParameter("index"));
		}
		
		if (index%pagecount==0) {
			pagepage=index/pagecount-1;
		} else {
			pagepage=index/pagecount;
		}
		
		if(cakeName == null) {
			cakeName = '%' + "" + '%';
		}else {
			cakeName = '%' + cakeName + '%';
		}
		
		List<managerCakeListDto> dtos = dao.searchCake(cakeName);

		cakeName = cakeName.substring(1, cakeName.length() - 1);
		
		model.addAttribute("dtos", dtos);
		model.addAttribute("size", dtos.size());
		model.addAttribute("query", cakeName);
		model.addAttribute("index", index);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("pagepage", pagepage);
		
	}

	@Override
	public void addCake(MultipartHttpServletRequest request, MultipartFile file) throws Exception {
		
		file = request.getFile("cakeImage");
		String cakeName = request.getParameter("cakeName");
		int cakePrice = Integer.parseInt(request.getParameter("cakePrice"));
		String cakeDetail = request.getParameter("cakeDetail");
		
		String originalName = "";
		
		if (!(file == null)) {
			String path = System.getProperty("user.dir") + "//src//main//webapp//cakeListImage";
			// 파일을 uid로 만들기 위한 기초단계
			// 확장자 가져오기
			originalName = file.getOriginalFilename();
//			String extension = originalName.substring(originalName.indexOf("."), originalName.length());

			// 패스에 "name" 으로 saveFile을 만들 빈 껍데기를 생성해 준다.
			File saveFile = new File(path, originalName);
			// file을 saveFile이름과 path로 지어서 넣기
			file.transferTo(saveFile);
		}
		
		dao.addCake(cakeName, cakePrice, cakeDetail, originalName);
	}

	@Override
	public void cakeNameCheck(MultipartHttpServletRequest request, MultipartFile file, Model model) throws Exception {

		file = request.getFile("cakeImage");
		
		boolean check = true;
		
		String cakeName = request.getParameter("cakeName");
		String cakePrice = request.getParameter("cakePrice");
		String cakeDetail = request.getParameter("cakeDetail");
		String originalName = file.getOriginalFilename();
		
		int count = dao.cakeNameCheck(cakeName);
		
		if(count == 1) {
			check = false;
		}
		
		model.addAttribute("check", check);
		model.addAttribute("cakeName", cakeName);
		model.addAttribute("cakePrice", cakePrice);
		model.addAttribute("cakeDetail", cakeDetail);
		model.addAttribute("cakeImage", originalName);
		
	}



		
	
	
	
}

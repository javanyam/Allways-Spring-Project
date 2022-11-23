package com.springlec.base.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.springlec.base.dao.managerCakeDetailDao;
import com.springlec.base.model.managerCakeDetailDto;


@Service
public class managerCakeDetailDaoServiceImpl implements managerCakeDetailDaoService {

	@Autowired
	managerCakeDetailDao dao;
	
	@Autowired
	HttpSession session;

	@Override
	public void cakeDetail(HttpServletRequest request, Model model) throws Exception {
		
		String cakeName = request.getParameter("cakeName");
		
		managerCakeDetailDto dto = dao.cakeDetail(cakeName);
		
		model.addAttribute("DTO", dto);
		model.addAttribute("cakeOriginalName", dto.getCakeName());
		model.addAttribute("cakeName", dto.getCakeName());
		model.addAttribute("cakePrice", dto.getCakePrice());
		model.addAttribute("cakeDetail", dto.getCakeDetail());
		model.addAttribute("cakeImage", dto.getCakeImage());

	}

	@Override
	public void updateCake(MultipartHttpServletRequest request, MultipartFile file, Model model) throws Exception {

//		file = request.getFile("cakeImage");
		System.out.println("file : " + file);
		String cakeName = request.getParameter("cakeName");
		System.out.println("cakeName : " + cakeName);
		int cakePrice = Integer.parseInt(request.getParameter("cakePrice"));
		System.out.println("cakePrice : " + cakePrice);
		String cakeDetail = request.getParameter("cakeDetail");
		System.out.println("cakeDetail : " + cakeDetail);
		String cakeOriginalName = request.getParameter("cakeOriginalName");
		System.out.println("cakeOriginalName : " + cakeOriginalName);
		
		String cakeImage = "";
		String originalName = "";
		System.out.println("cakeImage1 : " + cakeImage);
		if (!(cakeImage == null)) {
			String path = System.getProperty("user.dir") + "//src//main//webapp//cakeListImage";
			System.out.println("path : " + path);
			// 파일을 uid로 만들기 위한 기초단계
			// 확장자 가져오기
			cakeImage = file.getOriginalFilename();
			System.out.println("cakeImage2 : " + cakeImage);
//			String extension = originalName.substring(originalName.indexOf("."), originalName.length());

			// 패스에 "name" 으로 saveFile을 만들 빈 껍데기를 생성해 준다.
			File saveFile = new File(path, originalName);
			// file을 saveFile이름과 path로 지어서 넣기
			file.transferTo(saveFile);
		}
		
		int cakeId = dao.findCakeId(cakeOriginalName);
		
		if(cakeImage == null) {
			System.out.println("1");
			dao.updateCake(cakeName, cakePrice, cakeDetail, cakeId);
			
		}else {
			System.out.println("2");
			dao.updateCake(cakeName, cakePrice, cakeDetail, cakeId, cakeImage);
			
		}
		
	}

	@Override
	public void checkName2(HttpServletRequest request, Model model) throws Exception {

		String cakeNewName = request.getParameter("cakeName");
		String cakeOriginalName = request.getParameter("cakeOriginalName");
		String cakePrice = request.getParameter("cakePrice");
		String cakeDetail = request.getParameter("cakeDetail");
		String cakeImage = request.getParameter("file");
		
		boolean check = false;
		
		int count = dao.checkName2(cakeNewName, cakeOriginalName);
		if(count == 0) {
			check = true;
		}
		
		model.addAttribute("check", check);
		model.addAttribute("cakeOriginalName", cakeOriginalName);
		model.addAttribute("cakeName", cakeNewName);
		model.addAttribute("cakePrice", cakePrice);
		model.addAttribute("cakeDetail", cakeDetail);
		model.addAttribute("cakeImage", cakeImage);
		
	}

	@Override
	public void deleteCake(HttpServletRequest request, Model model) throws Exception {

		String cakeName = request.getParameter("cakeOriginalName");
		dao.deleteCake(dao.findCakeId(cakeName));
	}

	
	
}

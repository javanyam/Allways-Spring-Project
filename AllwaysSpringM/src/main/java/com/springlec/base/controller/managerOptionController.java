package com.springlec.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base.service.managerOptionDaoService;

@Controller
public class managerOptionController {
	@Autowired
	managerOptionDaoService service;
	
	// 케이크 옵션 리스트
	@RequestMapping("Mlist")
	public String optionlist(HttpServletRequest request, Model model) throws Exception{
		service.optionlist(request, model);
		return "managerOptionList";
	}
	
	// 케이크 옵션 추가 페이지 이동
	@RequestMapping("addList")
	public String optionadd() throws Exception{
		return "managerOptionAdd";
	}
	
	// 케이크 옵션 이름 중복체크
	@RequestMapping("ONameCheck")
	public String optioncheck(HttpServletRequest request, Model model) throws Exception{
		service.optioncheck(request, model);
		return "managerOptionAdd";
	}
	
	// 케이크 옵션 추가
	@RequestMapping("addOption")
	public String optionadd(HttpServletRequest request, Model model) throws Exception{
		service.optionadd(request);
		return "redirect:Mlist";
	}
	
	// 케이크 리스트 검색
	@RequestMapping("Mselect")
	public String optionsearch(HttpServletRequest request, Model model) throws Exception{
		String Query = request.getParameter("Query");
		if (Query == "") {
			 return "redirect:Mlist";
		} else {
			service.optionsearch(request, model);
			return "managerOptionList";
		}
	}

	// 케이크 옵션 추가
	@RequestMapping("optionId")
	public String optiondetail(HttpServletRequest request, Model model) throws Exception{
		service.optiondetail1(request, model);
		service.optiondetail2(model);
		return "managerOptionUpdate";
	}
	
//	// 케이크 옵션 수정된 이름 중복체크
//		@RequestMapping("OUpdateCheck")
//		public String optionupdatechk(HttpServletRequest request, Model model) throws Exception{
//			service.optioncheck(request, model);
//			return "managerOptionUpdate";
//		}
		
	// 케이크 옵션 수정
	@RequestMapping("Update")
	public String optionupdate(HttpServletRequest request) throws Exception{
		service.optionupdate(request);
		return "redirect:Mlist";
	}
	
	// 케이크 옵션 삭제
	@RequestMapping("MO_Delete")
	public String optiondelete(HttpServletRequest request) throws Exception{
		service.optiondelete(request);
		return "redirect:Mlist";
	}
	
} // End

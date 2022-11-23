package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.springlec.base.dao.managerOptionDao;
import com.springlec.base.model.managerOptionDto;

@Service
public class managerOptionDaoServiceImpl implements managerOptionDaoService {

	@Autowired
	managerOptionDao dao;
	
	@Override
	public void optionlist(HttpServletRequest request, Model model) throws Exception {
		
		List<managerOptionDto> dtos = dao.optionlist();
		
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
		model.addAttribute("OptionList", dtos);
		model.addAttribute("Size", dtos.size());
		model.addAttribute("index", index);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("pagepage", pagepage);
		
		
		
	}

	@Override
	public void optioncheck(HttpServletRequest request, Model model) throws Exception {
		String optionName = request.getParameter("optionName");
		String option = request.getParameter("option");
		String optionPrice = request.getParameter("optionPrice");
		
		if(optionName.length() > 0) {
			int chk = dao.optioncheck(optionName, option);
			
			if (chk == 1) {
				model.addAttribute("check", true);
			}else{
				model.addAttribute("check", false);
			}
			
			model.addAttribute("optionName", optionName);
			model.addAttribute("option", option);
			model.addAttribute("optionPrice", optionPrice);
		}else {
			model.addAttribute("check",null);
		}
		
	}

	@Override
	public void optionadd(HttpServletRequest request) throws Exception {
		String cakeoptionCategory = request.getParameter("option");
		String cakeoptionValue = request.getParameter("optionName");
		String cakeoptionPrice = request.getParameter("optionPrice");
		dao.optionadd(cakeoptionCategory, cakeoptionValue, cakeoptionPrice);
	}

	@Override
	public void optionsearch(HttpServletRequest request, Model model) throws Exception {
		String Query = '%' + request.getParameter("Query") + '%';
		String option = request.getParameter("option");
		List<managerOptionDto> dtos = dao.optionsearch(option, Query);
		
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
		
		model.addAttribute("OptionList", dtos);
		model.addAttribute("Size", dtos.size());
		model.addAttribute("index", index);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("pagepage", pagepage);
		model.addAttribute("Query", Query);
		model.addAttribute("option", option);
		
	}

	@Override
	public void optiondetail1(HttpServletRequest request, Model model) throws Exception {
		String cakeoptionId = request.getParameter("cakeoptionId");
		managerOptionDto dto = dao.optiondetail1(cakeoptionId);
		model.addAttribute("cake_option", dto);
		
	}

	@Override
	public void optiondetail2(Model model) throws Exception {

		List<managerOptionDto> dtos = dao.optiondetail2();
		
		model.addAttribute("optiondetail", dtos);
	}
	
	@Override
	public void optionupdatechk(HttpServletRequest request, Model model) throws Exception {
		String optionId = request.getParameter("optionId");
		String optionName = request.getParameter("optionName");
		String option = request.getParameter("option");
		String optionPrice = request.getParameter("optionPrice");
		
		int check = dao.optionupdatechk(optionName, option);
		
		if(check == 1) {
			request.setAttribute("check", true);
		}else{
			request.setAttribute("check", false);
		}
		
		model.addAttribute("optionId", optionId);
		model.addAttribute("optionName", optionName);
		model.addAttribute("option", option);
		model.addAttribute("optionPrice", optionPrice);
		model.addAttribute("optionId", optionId);
		
		
	}

	@Override
	public void optionupdate(HttpServletRequest request) throws Exception {
		String cakeoptionCategory = request.getParameter("option");
		String cakeoptionId = request.getParameter("optionId");
		String cakeoptionValue = request.getParameter("optionName");
		String cakeoptionPrice = request.getParameter("optionPrice");
		
		dao.optionupdate(cakeoptionId, cakeoptionCategory, cakeoptionValue, cakeoptionPrice);
	}

	@Override
	public void optiondelete(HttpServletRequest request) throws Exception {
		String cakeoptionId = request.getParameter("optionId");
		dao.optiondelete(cakeoptionId);
	}

	

}

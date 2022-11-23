package com.springlec.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface managerOptionDaoService {
	public void optionlist(HttpServletRequest request, Model model) throws Exception;
	public void optioncheck(HttpServletRequest request, Model model) throws Exception;
	public void optionadd(HttpServletRequest request) throws Exception;
	public void optionsearch(HttpServletRequest request, Model model) throws Exception;
	public void optiondetail1(HttpServletRequest request, Model model) throws Exception;
	public void optiondetail2(Model model) throws Exception;
	public void optionupdatechk(HttpServletRequest request, Model model) throws Exception;
	public void optionupdate(HttpServletRequest request) throws Exception;
	public void optiondelete(HttpServletRequest request) throws Exception;
}

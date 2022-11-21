package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.springlec.base.model.customerBoardDetailDto;
import com.springlec.base.model.customerBoardDto;

public interface customerBoardDaoService {

	public int selectWriteId() throws Exception;
	public List<customerBoardDto> customerBoardList(HttpServletRequest request) throws Exception;
	public void customerBoardWrite(HttpSession session, HttpServletRequest request, int writeId) throws Exception;
	public customerBoardDetailDto customerBoardDetail(HttpServletRequest request, HttpSession session) throws Exception;
	public List<customerBoardDetailDto> customerboardCommentList(HttpServletRequest request, Model model, HttpSession session) throws Exception;
	public void customerwriteComment(HttpSession session, HttpServletRequest request) throws Exception;
	
}

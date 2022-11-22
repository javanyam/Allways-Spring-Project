package com.springlec.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springlec.base.dao.customerBoardDao;
import com.springlec.base.model.customerBoardDetailDto;
import com.springlec.base.model.customerBoardDto;

@Service
public class customerBoardDaoServiceImpl implements customerBoardDaoService {

	@Autowired
	customerBoardDao dao;
	@Autowired
	HttpSession session;
	
	// 게시판 리스트 출력
	@Override
	public void customerBoardList(HttpServletRequest request, Model model) throws Exception {

		String combo = request.getParameter("combo");
		String searchContent = request.getParameter("searchContent");

		if(combo == null) {
			combo = "w_customerId";
		}
		if(searchContent == null) {
			searchContent = '%' + "" + '%';
		}else {
			searchContent = '%' + searchContent + '%';
		}
		
		List<customerBoardDto> dtos = dao.customerBoardList(combo, searchContent);
		
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
		model.addAttribute("BoardList", dtos);
		model.addAttribute("arrsize", dtos.size());
		model.addAttribute("index", index);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("pagepage", pagepage);
		
	}

	// 게시판 작성할 때 필요한 writeId값 가져오기
	@Override
	public int selectWriteId() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectWriteId();
	}
	
	// 게시판 작성하기
	@Override
	public void customerBoardWrite(HttpServletRequest request, int writeId) throws Exception {

		String customerId = (String)session.getAttribute("ID");
		String writeTitle = request.getParameter("writeTitle");
		String writeContent = request.getParameter("writeContent");
		
		dao.customerBoardWrite(customerId, writeTitle, writeContent, writeId);
	}

	// 게시판 클릭( 게시판 디테일 )
	@Override
	public void customerBoardDetail(HttpServletRequest request, Model model) throws Exception {
		
		String customerId = (String)session.getAttribute("ID");
		int writeId = Integer.parseInt(request.getParameter("writeId"));
		
		customerBoardDetailDto dto = dao.customerBoardDetail(customerId, writeId);
		model.addAttribute("boardDetail", dto);
	}

	// 게시판 클릭( 해당 게시판의 답글, 댓글 가져오기 )
	@Override
	public void customerboardCommentList(HttpServletRequest request, Model model) throws Exception {

		String customerId = (String)session.getAttribute("ID");
		int writeId = Integer.parseInt(request.getParameter("writeId"));
		
		model.addAttribute("CUSTOMERID", customerId);
		List<customerBoardDetailDto> dtos = dao.customerboardCommentList(writeId);
		
		model.addAttribute("boardComment", dtos);
		model.addAttribute("boardlength", dtos.size());
	}

	// 게시판 답글달기
	@Override
	public void customerwriteComment(HttpServletRequest request, RedirectAttributes attributes) throws Exception {

		String customerId = (String)session.getAttribute("ID");
		int writeId = Integer.parseInt(request.getParameter("writeId"));
		String writeContent = request.getParameter("writeContent");
		
		attributes.addAttribute("writeId", writeId);
		
		dao.customerwriteComment(customerId, writeId, writeContent);
		
	}



}
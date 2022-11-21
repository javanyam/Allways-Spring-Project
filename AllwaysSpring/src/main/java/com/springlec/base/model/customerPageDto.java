package com.springlec.base.model;

import javax.servlet.http.HttpServletRequest;

public class customerPageDto {

	HttpServletRequest request;
	
	int index; // 시작 페이지 번호
	int rowcount; // 한 페이지에 출력할 리스트 개수
	int pagecount; // 한 페이지에 출력할 페이지 개수
	int pagepage; // ??

	int listCount;
	int maxpage;
	
	public customerPageDto() {
		// TODO Auto-generated constructor stub
	}

	public customerPageDto(int listCount) {
		super();
		this.listCount = listCount;
		
		setMaxpage(listCount);
		setPageIndex();
		
		if (request.getParameter("index") != null) {
			index = (int)Float.parseFloat(request.getParameter("index"));
		}
		
		if (index % pagecount == 0) {
			pagepage = index / pagecount - 1;
		} else {
			pagepage = index / pagecount;
		}
		
	}

	private void setPageIndex() {
		index = 1;
		rowcount = 10;
		pagecount = 10;
		pagepage = 0;		
	}


	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getRowcount() {
		return rowcount;
	}

	public void setRowcount(int rowcount) {
		this.rowcount = rowcount;
	}

	public int getPagecount() {
		return pagecount;
	}

	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}

	public int getPagepage() {
		return pagepage;
	}

	public void setPagepage(int pagepage) {
		this.pagepage = pagepage;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getMaxpage() {
		return maxpage;
	}

	public void setMaxpage(int listCount) {
		maxpage = (listCount % rowcount) != 0 ? (listCount / rowcount) + 1 : (listCount / rowcount);
	}
	
	
	
//	public static final int PAGE_SCALE = 10; // 페이지당 게시물 수
//	public static final int BLOCK_SCALE = 10; // 화면당 페이지 수
//	
//	int curPage; //현재 페이지수
//	int prevPage; // 이전 페이지
//	int nextPage; // 다음 페이지
//	int totPage; // 전체 페이지 갯수
//	int totBlock; // 전체 페이지 블록 갯수
//	int curBlock; // 현재 페이지 블록
//	int prevBlock; // 이전 페이지 블록
//	int nextBlock; // 다음 페이지 블록
//	int pageBegin;
//	int pageEnd;
//	int blockBegin; // 현재 페이지 블록의 시작번호
//	int blockEnd; // 현재 페이지 블록의 끝번호
//	
//	
//	public customerPageDto(int count, int curPage) {
//
//		curBlock = 1; // 현재 페이지 블록 번호
//		this.curPage = curPage; // 현재 페이지 설정
//		setTotPage(count); // 전체 페이지 갯수 계산
//		setPageRange();
//		setTotBlock(); // 전체 페이지 블록 갯수 계산
//		setBlockRange(); // 페이지 블록의 시작, 끝 번호 계산
//	}
//
//	private void setBlockRange() {
//		// 현재 페이지가 몇번째 페이지 블록에 속하는지 계산
//		curBlock = (int)Math.ceil((curPage - 1) / BLOCK_SCALE + 1);
//		
//		// 현재 페이지 블록의 시작
//		blockBegin = (curBlock - 1) * BLOCK_SCALE + 1;
//		
//		// 페이지 블록의 끝 번호
//		blockEnd = blockBegin + BLOCK_SCALE - 1;
//		
//		// 마지막 블록의 범위를 초과하지 않도록 계산
//		if(blockEnd > totPage) blockEnd = totPage;
//		
//		// 이전을 눌렀을 때 이동할 페이지 번호
//		prevPage = (curPage == 1)? 1:(curBlock - 1) * BLOCK_SCALE;
//		
//		// 다음을 눌렀을 때 이동할 페이지 번호
//		nextPage = curBlock > totBlock ? (curBlock * BLOCK_SCALE) : (curBlock * BLOCK_SCALE) + 1;
//		
//		// 마지막 페이지가 범위를 초과하지 않도록 처리
//		if(nextPage >= totPage) nextPage = totPage;
//		
//	}
//
//	private void setPageRange() {
//		pageBegin = (curPage - 1) * PAGE_SCALE + 1;
//		pageEnd = pageBegin + PAGE_SCALE - 1;
//	}
//	
//
//	public int getCurPage() {
//		return curPage;
//	}
//
//	public void setCurPage(int curPage) {
//		this.curPage = curPage;
//	}
//
//	public int getPrevPage() {
//		return prevPage;
//	}
//
//	public void setPrevPage(int prevPage) {
//		this.prevPage = prevPage;
//	}
//
//	public int getNextPage() {
//		return nextPage;
//	}
//
//	public void setNextPage(int nextPage) {
//		this.nextPage = nextPage;
//	}
//
//	public int getTotBlock() {
//		return totBlock;
//	}
//
//	public void setTotBlock() {
//		totBlock = (int)Math.ceil(totPage / BLOCK_SCALE);
//	}
//
//	public int getCurBlock() {
//		return curBlock;
//	}
//
//	public void setCurBlock(int curBlock) {
//		this.curBlock = curBlock;
//	}
//
//	public int getPrevBlock() {
//		return prevBlock;
//	}
//
//	public void setPrevBlock(int prevBlock) {
//		this.prevBlock = prevBlock;
//	}
//
//	public int getNextBlock() {
//		return nextBlock;
//	}
//
//	public void setNextBlock(int nextBlock) {
//		this.nextBlock = nextBlock;
//	}
//
//	public int getPageBegin() {
//		return pageBegin;
//	}
//
//	public void setPageBegin(int pageBegin) {
//		this.pageBegin = pageBegin;
//	}
//
//	public int getPageEnd() {
//		return pageEnd;
//	}
//
//	public void setPageEnd(int pageEnd) {
//		this.pageEnd = pageEnd;
//	}
//
//	public int getBlockBegin() {
//		return blockBegin;
//	}
//
//	public void setBlockBegin(int blockBegin) {
//		this.blockBegin = blockBegin;
//	}
//
//	public int getBlockEnd() {
//		return blockEnd;
//	}
//
//	public void setBlockEnd(int blockEnd) {
//		this.blockEnd = blockEnd;
//	}
//
//	public static int getPageScale() {
//		return PAGE_SCALE;
//	}
//
//	public static int getBlockScale() {
//		return BLOCK_SCALE;
//	}
//
//	public int getTotPage() {
//		return totPage;
//	}
//	
//	public void setTotPage(int count) {
//		totPage = (int)Math.ceil(count * 1.0 / PAGE_SCALE);
//	}
	
}

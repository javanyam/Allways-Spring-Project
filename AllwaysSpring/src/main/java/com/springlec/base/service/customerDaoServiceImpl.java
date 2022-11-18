package com.springlec.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlec.base.dao.customerDao;
import com.springlec.base.model.cakeDto;

@Service
public class customerDaoServiceImpl implements customerDaoService{
	
	@Autowired
	customerDao dao;

	@Override
	public List<cakeDto> listDao() throws Exception {

		return dao.listDao();
	}

	@Override
	public void writeDao(String name, String phone, String address, String email, String relation) throws Exception {
		
		dao.writeDao(name, phone, address, email, relation);
	}

	@Override
	public cakeDto contentDao(int seq) throws Exception {
		
		return dao.contentDao(seq);
	}

	@Override
	public void deleteDao(int seq) throws Exception {

		dao.deleteDao(seq);
	}

	@Override
	public void updateDao(int seq, String name, String phone, String address, String email, String relation) throws Exception {
		dao.updateDao(seq, name, phone, address, email, relation);
	}

	@Override
	public List<cakeDto> searchDao(String query, String content) throws Exception {
		
		if (query == null) {
			query = "";
			content = "";
		}
		content = '%' + content + '%';
		return dao.searchDao(query, content);
	}
}

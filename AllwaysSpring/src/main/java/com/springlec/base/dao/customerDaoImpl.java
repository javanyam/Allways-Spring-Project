package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.cakeDto;

public class customerDaoImpl implements customerDao {

	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.BDao";
	
	@Override
	public List<cakeDto> listDao() throws Exception {
		
		return sqlSession.selectList(nameSpace + ".listDao");
	}

	@Override
	public void writeDao(String name, String phone, String address, String email, String relation) throws Exception {
		
		sqlSession.insert(nameSpace + ".writeDao");
	}

	@Override
	public cakeDto contentDao(int seq) throws Exception {
		
		return (cakeDto) sqlSession.selectList(nameSpace + ".contentDao");
	}

	@Override
	public void deleteDao(int seq) throws Exception {
		
		sqlSession.delete(nameSpace + ".deleteDao");
	}

	@Override
	public void updateDao(int seq, String name, String phone, String address, String email, String relation) throws Exception {
		
		sqlSession.update(nameSpace + ".updateDao");
	}

	@Override
	public List<cakeDto> searchDao(String query, String content) throws Exception {
		
		return sqlSession.selectList(nameSpace + ".searchDao");
	}

}

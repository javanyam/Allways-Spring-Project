package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.managerCakeListDto;

public class managerCakeDaoImpl implements managerCakeDao {

	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.managerCakeDao";

	@Override
	public List<managerCakeListDto> searchCake(String cakeName) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".searchCake");
	}

	@Override
	public void addCake(String cakeName, int cakePrice, String cakeDetail, String originalName) throws Exception {
		sqlSession.insert(nameSpace + ".addCake");
	}

	@Override
	public int cakeNameCheck(String cakeName) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".cakeNameCheck");
		
	}

	
	
}

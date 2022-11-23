package com.springlec.base.dao;


import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.managerCakeDetailDto;

public class managerCakeDetailDaoImpl implements managerCakeDetailDao {

	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.managerCakeDetailDao";

	@Override
	public managerCakeDetailDto cakeDetail(String cakeName) throws Exception {
		return (managerCakeDetailDto) sqlSession.selectList(nameSpace + ".cakeDetail");
	}

	@Override
	public void updateCake(String cakeName, int cakePrice, String cakeDetail, int cakeId) throws Exception {
		sqlSession.update(nameSpace + ".updateCake1");
	}

	@Override
	public void updateCake(String cakeName, int cakePrice, String cakeDetail, int cakeId, String cakeImage)
			throws Exception {
		sqlSession.update(nameSpace + ".updateCake2");
	}

	@Override
	public int checkName2(String cakeNewName, String cakeOriginalName) throws Exception {

		return sqlSession.selectOne(nameSpace + ".checkName2");
	}

	@Override
	public int findCakeId(String cakeOriginalName) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".findCakeId");
	}

	@Override
	public void deleteCake(int cakeId) throws Exception {
		sqlSession.update(nameSpace + ".deleteCake");
	}

	
	
}

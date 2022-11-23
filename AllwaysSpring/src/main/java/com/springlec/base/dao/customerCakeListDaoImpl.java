package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.customerCakeListDto;

public class customerCakeListDaoImpl implements customerCakeListDao {

	SqlSession sqlSession;

	public static String namespace = "com.springlec.base.dao.customerCakeListDao";

	@Override
	public List<customerCakeListDto> customerCakeList(String sort1, String sort2) throws Exception {

		return sqlSession.selectList(namespace + ".customerCakeList");
	}

}

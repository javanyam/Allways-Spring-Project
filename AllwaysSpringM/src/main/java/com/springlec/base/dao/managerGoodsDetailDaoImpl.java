package com.springlec.base.dao;


import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.managerGoodsDetailDto;

public class managerGoodsDetailDaoImpl implements managerGoodsDetailDao {

	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.managerGoodsDetailDao";

	@Override
	public managerGoodsDetailDto viewGoodsDetail(String goodsName) throws Exception {
		return (managerGoodsDetailDto) sqlSession.selectList(nameSpace + ".viewGoodsDetail");
	}

	@Override
	public int checkGoodsName2(String goodsName, String goodsOriginalName) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".checkGoodsName2");
	}

	@Override
	public void deleteGoods(String goodsName) throws Exception {

		sqlSession.update(nameSpace + ".deleteGoods");
	}

	@Override
	public void updateGoods(String goodsName, String goodsCategory, int goodsPrice, String goodsDetail,
			String goodsOriginalname, String originalName) throws Exception {

		sqlSession.update(nameSpace + ".updateGoods");
	}


	
	
}

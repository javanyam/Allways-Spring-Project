package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.managerGoodsDto;

public class managerGoodsDaoImpl implements managerGoodsDao {

	SqlSession sqlSession;
	
	public static String nameSpace = "com.springlec.base.dao.managerGoodsDao";

	@Override
	public List<managerGoodsDto> viewGoodsList1() throws Exception {
		return sqlSession.selectList(nameSpace + ".viewGoodsList1");
	}

	@Override
	public List<managerGoodsDto> viewGoodsList2(String goodsCategory) throws Exception {
		return sqlSession.selectList(nameSpace + ".viewGoodsList2");
	}

	@Override
	public List<managerGoodsDto> searchGoods1(String goodsName) throws Exception {
		return sqlSession.selectList(nameSpace + ".searchGoods1");
	}

	@Override
	public List<managerGoodsDto> searchGoods2(String goodsName, String goodsCategory) throws Exception {
		return sqlSession.selectList(nameSpace + ".searchGoods2");
	}

	@Override
	public void addGoods(String goodsName, String goodsCategory, int goodsPrice, String goodsDetail, String goodsImage) throws Exception {

		sqlSession.insert(nameSpace + ".addGoods");
	}

	@Override
	public int checkGoodsName(String goodsName) throws Exception {

		return sqlSession.selectOne(nameSpace + ".checkGoodsName");
	}


	
	
}

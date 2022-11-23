package com.springlec.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.springlec.base.model.managerViewOrderListDto;

public class managerViewOrderListDaoImpl implements managerViewOrderListDao {
	
	SqlSession sqlSession;

	public static String namespace = "com.springlec.base.dao.managerViewOrderListDao";

	@Override
	public List<managerViewOrderListDto> orderList1() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".orderList1");
	}

	@Override
	public List<managerViewOrderListDto> orderList2() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".orderList2");
	}

	@Override
	public List<managerViewOrderListDto> orderList3() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".orderList3");
	}

	@Override
	public managerViewOrderListDto orderSelect(int ordersId) throws Exception {
		// TODO Auto-generated method stub
		return (managerViewOrderListDto) sqlSession.selectList(namespace + ".orderSelect");
	}

	@Override
	public void orderDelete(int ordersId) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".orderDelete");
	}

	@Override
	public void orderUpdateToMaking(int ordersId, String ordersStatus, String o_customerId, int o_cakeId, int o_goodsId,
			int ordersSalePrice, int ordersQuantity) throws Exception {

		sqlSession.insert(namespace + ".orderUpdateToMaking");
	}

	@Override
	public void orderUpdateMakedate(int ordersId) throws Exception {
		// TODO Auto-generated method stub
		
		sqlSession.update(namespace + ".orderUpdateMakedate");
	}

	@Override
	public void orderUpdateToDone(int ordersId, String ordersStatus, String o_customerId, int o_cakeId, int o_goodsId,
			int ordersSalePrice, int ordersQuantity) throws Exception {
		
		sqlSession.insert(namespace + ".orderUpdateToDone");
	}

	@Override
	public void orderUpdateDonedate(int ordersId) throws Exception {
		
		sqlSession.update(namespace + ".orderUpdateDonedate");
	}

}

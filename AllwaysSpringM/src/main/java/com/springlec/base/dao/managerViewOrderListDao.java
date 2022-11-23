package com.springlec.base.dao;

import java.util.List;

import com.springlec.base.model.managerViewOrderListDto;

public interface managerViewOrderListDao {

	public List<managerViewOrderListDto> orderList1() throws Exception;
	public List<managerViewOrderListDto> orderList2() throws Exception;
	public List<managerViewOrderListDto> orderList3() throws Exception;

	public managerViewOrderListDto orderSelect(int ordersId) throws Exception;

	public void orderDelete(int ordersId) throws Exception;

	public void orderUpdateToMaking(int ordersId, String ordersStatus, String o_customerId, int o_cakeId, int o_goodsId, int ordersSalePrice, int ordersQuantity) throws Exception;
	public void orderUpdateMakedate(int ordersId) throws Exception;
	
	public void orderUpdateToDone(int ordersId, String ordersStatus, String o_customerId, int o_cakeId, int o_goodsId, int ordersSalePrice, int ordersQuantity) throws Exception;
	public void orderUpdateDonedate(int ordersId) throws Exception;
	
}

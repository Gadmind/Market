package com.qhit.dao.impl;

import com.qhit.dao.OrderDao;
import com.qhit.entity.Order;
import com.qhit.util.BaseUtil;

public class OrderDaoImpl extends BaseUtil implements OrderDao {

	public int saveOrder(Order order) {
		String sql = "insert into easybuy_order(userId,loginName,userAddress,createTime,cost,serialNumber)values(?,?,?,?,?,?)";
		Object[] params = { order.getUserId(), order.getLoginName(), order.getUserAddress(), order.getCreatTime(),
				order.getCost(), order.getSerialNumber() };
		return DeleteInsertUpDate(sql, params);
	}

	
}

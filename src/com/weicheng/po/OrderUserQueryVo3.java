package com.weicheng.po;

import java.util.List;

/**查询每个用户下的所有订单，及订单所对应的商品*/
public class OrderUserQueryVo3 extends User{
	
	/**订单列表*/
	private List<MOrder> orderList;
	
	public List<MOrder> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<MOrder> orderList) {
		this.orderList = orderList;
	}

}

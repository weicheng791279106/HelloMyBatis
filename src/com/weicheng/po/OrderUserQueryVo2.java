package com.weicheng.po;

import java.util.List;

/**查询订单及关联用户，将User对象放在Order中进行查询*/
public class OrderUserQueryVo2 extends Order{

	private User user;
	
	private List<OrderDetail> orderDetailList;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}
	
}

package com.weicheng.po;

import java.util.List;

/**��ѯ�����������û�����User�������Order�н��в�ѯ*/
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

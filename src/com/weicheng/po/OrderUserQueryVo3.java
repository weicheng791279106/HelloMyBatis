package com.weicheng.po;

import java.util.List;

/**��ѯÿ���û��µ����ж���������������Ӧ����Ʒ*/
public class OrderUserQueryVo3 extends User{
	
	/**�����б�*/
	private List<MOrder> orderList;
	
	public List<MOrder> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<MOrder> orderList) {
		this.orderList = orderList;
	}

}

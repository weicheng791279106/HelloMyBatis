package com.weicheng.po;

/**查询订单及用户Vo*/
public class OrderUserQueryVo extends Order{

	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}

package com.weicheng.po;

import java.util.List;

/**
 * User查询条件封装
 * */
public class UserQueryVo {

	private User user;
	
	private List<Integer> idList;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Integer> getIdList() {
		return idList;
	}

	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}
	
}

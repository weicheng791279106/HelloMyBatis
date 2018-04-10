package com.weicheng.dao;

import com.weicheng.po.User;

/**
 * 原始方法写dao接口
 * 
 * */
public interface UserDao {

	/**根据Id查询用户信息*/
	public User findUserById(int id) throws Exception;
	
	/**插入用户*/
	public void insertUser(User user) throws Exception;
	
	/**删除用户*/
	public void deleteUser(int id) throws Exception;
	
}

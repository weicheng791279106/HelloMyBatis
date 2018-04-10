package com.weicheng.spring.mapper;

import java.util.List;

import com.weicheng.po.User;
import com.weicheng.po.UserQueryVo;

/**
 * Mapper代理方法实现dao层演示
 * 
 * */
public interface UserMapper {

	/**根据id查询用户*/
	public User findUserById(int id) throws Exception;
	
	/**根据名称查询用户*/
	public List<User> findUserByName(String name) throws Exception;
	
	/**添加用户*/
	public void insertUser(User user) throws Exception;
	
	/**删除用户*/
	public void deleteUser(int id) throws Exception;
	
}

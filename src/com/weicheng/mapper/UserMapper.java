package com.weicheng.mapper;

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
	
	/**更新用户*/
	public void updateUser(User user) throws Exception;
	
	/**综合查询用户信息*/
	public List<User> findUser(UserQueryVo userQueryVo) throws Exception;
	
	/**查询特定名称下的数据数量*/
	public int findUserCount(String name) throws Exception;
	
	/**根据id查询用户（演示ResultMap的使用）*/
	public User findUserByIdWithResultMap(int id) throws Exception;
	
	/**根据id查询用户，不使用二级缓存*/
	public User findUserByIdNoCache(int id) throws Exception;
	
}

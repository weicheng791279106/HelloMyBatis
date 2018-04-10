package com.weicheng.spring.mapper;

import java.util.List;

import com.weicheng.po.User;
import com.weicheng.po.UserQueryVo;

/**
 * Mapper������ʵ��dao����ʾ
 * 
 * */
public interface UserMapper {

	/**����id��ѯ�û�*/
	public User findUserById(int id) throws Exception;
	
	/**�������Ʋ�ѯ�û�*/
	public List<User> findUserByName(String name) throws Exception;
	
	/**����û�*/
	public void insertUser(User user) throws Exception;
	
	/**ɾ���û�*/
	public void deleteUser(int id) throws Exception;
	
}

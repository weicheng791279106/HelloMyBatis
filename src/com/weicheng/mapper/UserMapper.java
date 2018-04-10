package com.weicheng.mapper;

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
	
	/**�����û�*/
	public void updateUser(User user) throws Exception;
	
	/**�ۺϲ�ѯ�û���Ϣ*/
	public List<User> findUser(UserQueryVo userQueryVo) throws Exception;
	
	/**��ѯ�ض������µ���������*/
	public int findUserCount(String name) throws Exception;
	
	/**����id��ѯ�û�����ʾResultMap��ʹ�ã�*/
	public User findUserByIdWithResultMap(int id) throws Exception;
	
	/**����id��ѯ�û�����ʹ�ö�������*/
	public User findUserByIdNoCache(int id) throws Exception;
	
}

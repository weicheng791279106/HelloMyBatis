package com.weicheng.dao;

import com.weicheng.po.User;

/**
 * ԭʼ����дdao�ӿ�
 * 
 * */
public interface UserDao {

	/**����Id��ѯ�û���Ϣ*/
	public User findUserById(int id) throws Exception;
	
	/**�����û�*/
	public void insertUser(User user) throws Exception;
	
	/**ɾ���û�*/
	public void deleteUser(int id) throws Exception;
	
}

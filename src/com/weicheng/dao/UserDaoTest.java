package com.weicheng.dao;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.weicheng.po.User;

/**
 * ԭʼ��ʽ����dao�������
 * */
public class UserDaoTest {

	SqlSessionFactory sqlSessionFactory;
	
	/**
	 * �ڲ���dao֮ǰ��Ҫ�ȴ�����SqlSessionFactory����
	 * */
	@Before
	public void setUp() throws Exception{
		/*�õ������ļ�����*/
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		/*����sql�Ự����*/
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testFindUserById() throws Exception {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.findUserById(2);
		System.out.println(user);
	}

	@Test
	public void testInsertUser() throws Exception {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = new User();
		user.setName("�ײ�����");
		userDao.insertUser(user);
	}

	@Test
	public void testDeleteUser() throws Exception {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		userDao.deleteUser(7);
	}

}

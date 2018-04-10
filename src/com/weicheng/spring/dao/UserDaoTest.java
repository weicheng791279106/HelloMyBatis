package com.weicheng.spring.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.weicheng.po.User;

/**
 * ԭʼ��ʽ����dao�������
 * */
public class UserDaoTest {

	private ApplicationContext applicationContext;
	
	/**
	 * �ڲ���dao֮ǰ��Ҫ�ȴ�����applicationContext����
	 * */
	@Before
	public void setUp() throws Exception{
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}
	
	@Test
	public void testFindUserById() throws Exception {
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		User user = userDao.findUserById(2);
		System.out.println(user);
	}

	@Test
	public void testInsertUser() throws Exception {
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		User user = new User();
		user.setName("�ײ�������");
		userDao.insertUser(user);
	}

	@Test
	public void testDeleteUser() throws Exception {
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		userDao.deleteUser(17);
	}

}

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
 * 原始方式开发dao层测试类
 * */
public class UserDaoTest {

	SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 在测试dao之前需要先创建好SqlSessionFactory对象
	 * */
	@Before
	public void setUp() throws Exception{
		/*得到配置文件的流*/
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		/*创建sql会话工厂*/
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
		user.setName("白菜馍馍");
		userDao.insertUser(user);
	}

	@Test
	public void testDeleteUser() throws Exception {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		userDao.deleteUser(7);
	}

}

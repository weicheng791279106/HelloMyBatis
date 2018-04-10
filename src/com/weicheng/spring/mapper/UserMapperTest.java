package com.weicheng.spring.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.weicheng.po.User;
import com.weicheng.po.UserQueryVo;

/**
 * mapper代理方式开发dao层测试类
 * 
 * */
public class UserMapperTest {

private ApplicationContext applicationContext;
	
	/**
	 * 在测试dao之前需要先创建好applicationContext对象
	 * */
	@Before
	public void setUp() throws Exception{
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}
	
	@Test
	public void testFindUserById() throws Exception {
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		User user = userMapper.findUserById(2);
		System.out.println(user);
	}

	@Test
	public void testFindUserByName() throws Exception {
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		List<User> userList = userMapper.findUserByName("二货");
		System.out.println(userList);
	}

	@Test
	public void testInsertUser() throws Exception {
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		User user = new User();
		user.setName("嘻哈Boy二货");
		userMapper.insertUser(user);
	}

	@Test
	public void testDeleteUser() throws Exception {
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		userMapper.deleteUser(8);
	}

}

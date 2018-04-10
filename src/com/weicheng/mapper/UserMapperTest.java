package com.weicheng.mapper;

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

import com.weicheng.po.User;
import com.weicheng.po.UserQueryVo;

/**
 * mapper代理方式开发dao层测试类
 * 
 * */
public class UserMapperTest {

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
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*通过sqlSession对象去获取mapper代理*/
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(2);
		sqlSession.close();
		System.out.println(user);
	}

	@Test
	public void testFindUserByName() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*通过sqlSession对象去获取mapper代理*/
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = userMapper.findUserByName("二货");
		sqlSession.close();
		System.out.println(userList);
	}

	@Test
	public void testInsertUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*通过sqlSession对象去获取mapper代理*/
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setName("嘻哈Boy二货");
		userMapper.insertUser(user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testDeleteUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*通过sqlSession对象去获取mapper代理*/
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.deleteUser(8);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testFindUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*通过sqlSession对象去获取mapper代理*/
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		User user = new User();
		user.setId(2); /*id如果不传就只根据name条件去查询*/
		user.setName("二货");
		userQueryVo.setUser(user);
		List<User> userList = userMapper.findUser(userQueryVo);
		sqlSession.close();
		System.out.println(userList);
	}
	
	@Test
	public void testFindUserInId() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*通过sqlSession对象去获取mapper代理*/
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		UserQueryVo userQueryVo = new UserQueryVo();
		List<Integer> idList = new ArrayList<>();
		idList.add(2);
		idList.add(3);
		idList.add(4);
		userQueryVo.setIdList(idList);
		List<User> userList = userMapper.findUser(userQueryVo);
		sqlSession.close();
		System.out.println(userList);
	}
	
	@Test
	public void testFindUserCount() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*通过sqlSession对象去获取mapper代理*/
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int count = userMapper.findUserCount("二货");
		sqlSession.close();
		System.out.println(count);
	}
	
	@Test
	public void testFindUserByIdWithResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*通过sqlSession对象去获取mapper代理*/
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserByIdWithResultMap(2);
		sqlSession.close();
		System.out.println(user);
	}

}

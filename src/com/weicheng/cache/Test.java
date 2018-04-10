package com.weicheng.cache;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import com.weicheng.mapper.UserMapper;
import com.weicheng.po.User;

/**
 * 缓存相关测试演示类
 * 
 * */
public class Test {

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
	
	/**一级缓存测试*/
	@org.junit.Test
	public void testFirstCache() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user;
		/*第一次查询user会想数据库去查询*/
		user = userMapper.findUserById(2);
		System.out.println(user.getName());
		/*第二次查询同一id用户会使用缓存，不会发出sql请求*/
		user = userMapper.findUserById(2);
		System.out.println(user.getName());
		
		/*更新数据会触发sqlSession缓存的清空*/
		user.setName("二货二货老婆");
		userMapper.updateUser(user);
		/*调用commit()方法会清空sqlSession中的缓存*/
		sqlSession.commit();
		
		/*清空缓存之后再次查询数据也会向数据库中发起sql请求*/
		user = userMapper.findUserById(2);
		System.out.println(user.getName());
		
		sqlSession.close();
	}
	
	/**二级缓存测试
	 * @throws Exception */
	@org.junit.Test
	public void testSecondaryCache() throws Exception{
		SqlSession sqlSession;
		UserMapper userMapper;
		User user;
		
		sqlSession = sqlSessionFactory.openSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
		/*第一次查询，会向数据库发出sql查询请求*/
		user = userMapper.findUserById(2);
		System.out.println(user.getName());
		/*调用close()才能将SqlSession中的缓存写入到mapper的二级缓存中*/
		sqlSession.close();
		
		/*新建一个sqlSession*/
		sqlSession = sqlSessionFactory.openSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
		/*发起查询，会直接使用二级缓存中的数据*/
		user = userMapper.findUserById(2);
		System.out.println(user.getName());
		
		/*尝试修改数据触发缓存清空操作*/
		user.setName(user.getName() + "二");
		userMapper.updateUser(user);
		/*调用sqlSession.commit()会触发二级缓存清空*/
		sqlSession.commit();
		sqlSession.close();
		
		/*新建一个sqlSession*/
		sqlSession = sqlSessionFactory.openSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
		/*发起查询，由于之前的缓存已清空，这次会向数据库发出sql查询请求*/
		user = userMapper.findUserById(2);
		System.out.println(user.getName());
		
	}
	
	/**强制禁用二级缓存测试，在mapper.xml的<select>标签中使用userCache="false"强制禁用二级缓存演示*/
	@org.junit.Test
	public void testNoSecondaryCache() throws Exception{
		SqlSession sqlSession;
		UserMapper userMapper;
		User user;
		
		sqlSession = sqlSessionFactory.openSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
		/*第一次查询，会向数据库发出sql查询请求*/
		user = userMapper.findUserByIdNoCache(2);
		System.out.println(user.getName());
		/*第二次查询，因为只禁用了二级缓存，一级缓存还在，所以不需要向数据库发出查询sql*/
		user = userMapper.findUserByIdNoCache(2);
		System.out.println(user.getName());
		/*调用close()才能将SqlSession中的缓存写入到mapper的二级缓存中*/
		sqlSession.close();
		
		/*新建一个sqlSession*/
		sqlSession = sqlSessionFactory.openSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
		/*发起查询，由于强制禁用了二级缓存，所以不会使用二级缓存中的数据，需要向数据库发出查询sql*/
		user = userMapper.findUserByIdNoCache(2);
		System.out.println(user.getName());
		sqlSession.close();
		
	}
	
	/**ehcache框架二级缓存测试
	 * @throws Exception */
	@org.junit.Test
	public void testEhcache() throws Exception{
		SqlSession sqlSession;
		UserMapper userMapper;
		User user;
		
		sqlSession = sqlSessionFactory.openSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
		/*第一次查询，会向数据库发出sql查询请求*/
		user = userMapper.findUserById(2);
		System.out.println(user.getName());
		/*调用close()才能将SqlSession中的缓存写入到mapper的二级缓存中*/
		sqlSession.close();
		
		/*新建一个sqlSession*/
		sqlSession = sqlSessionFactory.openSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
		/*发起查询，会直接使用二级缓存中的数据*/
		user = userMapper.findUserById(2);
		System.out.println(user.getName());
	}

	
	
}

package com.weicheng.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.weicheng.po.User;

/**
 * 测试类
 * 
 * 所使用的表t_user建表语句：
 * CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

 * 
 * 
 * 
 * */
public class Test {

	@org.junit.Test
	/**根据用户Id查找用户*/
	public void findUserById() throws IOException{
		/*得到配置文件的流*/
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		/*创建sql会话工厂*/
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		/*获取session*/
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*操作数据库*/
		/*第一个参数：映射文件中的namespace + "." + 映射文件中的statement的id*/
		/*第二个参数：指定和映射文件中所匹配的parameterType类型的参数*/
		User user = sqlSession.selectOne("user.findUserById",2);
		
		System.out.println(user.getName());
		
		/*关闭会话，正常最好放在finally块中*/
		sqlSession.close();
	}
	
	
	@org.junit.Test
	/**根据用户名称查找用户*/
	public void findUserByName() throws IOException{
		/*得到配置文件的流*/
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		/*创建sql会话工厂*/
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		/*获取session*/
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*操作数据库*/
		/*第一个参数：映射文件中的namespace + "." + 映射文件中的statement的id*/
		/*第二个参数：指定和映射文件中所匹配的parameterType类型的参数*/
		List<User> userList = sqlSession.selectList("user.findUserByName", "胖");
		
		for(User user:userList) System.out.println(user.getName());
		
		/*关闭会话，正常最好放在finally块中*/
		sqlSession.close();
	}
	
	@org.junit.Test
	/**添加用户*/
	public void insertUser() throws IOException{
		/*得到配置文件的流*/
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		/*创建sql会话工厂*/
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		/*获取session*/
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*操作数据库*/
		/*第一个参数：映射文件中的namespace + "." + 映射文件中的statement的id*/
		User user = new User();
		user.setName("三丫子");
		sqlSession.insert("user.insertUser",user);
		sqlSession.commit();
		
		System.out.println(user.getId() + " " + user.getName());
		
		/*关闭会话，正常最好放在finally块中*/
		sqlSession.close();
	}
	
	@org.junit.Test
	/**删除用户*/
	public void deleteUser() throws IOException{
		/*得到配置文件的流*/
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		/*创建sql会话工厂*/
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		/*获取session*/
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*操作数据库*/
		/*第一个参数：映射文件中的namespace + "." + 映射文件中的statement的id*/
		sqlSession.insert("user.deleteUser",9);
		sqlSession.commit();
		
		/*关闭会话，正常最好放在finally块中*/
		sqlSession.close();
	}
	
	@org.junit.Test
	/**更新用户*/
	public void updateUser() throws IOException{
		/*得到配置文件的流*/
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		/*创建sql会话工厂*/
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		/*获取session*/
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*操作数据库*/
		/*第一个参数：映射文件中的namespace + "." + 映射文件中的statement的id*/
		User user = new User();
		user.setId(10);
		user.setName("唐玉宝宝");
		sqlSession.insert("user.updateUser",user);
		sqlSession.commit();
		
		System.out.println(user.getId() + " " + user.getName());
		
		/*关闭会话，正常最好放在finally块中*/
		sqlSession.close();
	}
	
	
}

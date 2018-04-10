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
 * ������
 * 
 * ��ʹ�õı�t_user������䣺
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
	/**�����û�Id�����û�*/
	public void findUserById() throws IOException{
		/*�õ������ļ�����*/
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		/*����sql�Ự����*/
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		/*��ȡsession*/
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*�������ݿ�*/
		/*��һ��������ӳ���ļ��е�namespace + "." + ӳ���ļ��е�statement��id*/
		/*�ڶ���������ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���*/
		User user = sqlSession.selectOne("user.findUserById",2);
		
		System.out.println(user.getName());
		
		/*�رջỰ��������÷���finally����*/
		sqlSession.close();
	}
	
	
	@org.junit.Test
	/**�����û����Ʋ����û�*/
	public void findUserByName() throws IOException{
		/*�õ������ļ�����*/
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		/*����sql�Ự����*/
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		/*��ȡsession*/
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*�������ݿ�*/
		/*��һ��������ӳ���ļ��е�namespace + "." + ӳ���ļ��е�statement��id*/
		/*�ڶ���������ָ����ӳ���ļ�����ƥ���parameterType���͵Ĳ���*/
		List<User> userList = sqlSession.selectList("user.findUserByName", "��");
		
		for(User user:userList) System.out.println(user.getName());
		
		/*�رջỰ��������÷���finally����*/
		sqlSession.close();
	}
	
	@org.junit.Test
	/**����û�*/
	public void insertUser() throws IOException{
		/*�õ������ļ�����*/
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		/*����sql�Ự����*/
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		/*��ȡsession*/
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*�������ݿ�*/
		/*��һ��������ӳ���ļ��е�namespace + "." + ӳ���ļ��е�statement��id*/
		User user = new User();
		user.setName("��Ѿ��");
		sqlSession.insert("user.insertUser",user);
		sqlSession.commit();
		
		System.out.println(user.getId() + " " + user.getName());
		
		/*�رջỰ��������÷���finally����*/
		sqlSession.close();
	}
	
	@org.junit.Test
	/**ɾ���û�*/
	public void deleteUser() throws IOException{
		/*�õ������ļ�����*/
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		/*����sql�Ự����*/
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		/*��ȡsession*/
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*�������ݿ�*/
		/*��һ��������ӳ���ļ��е�namespace + "." + ӳ���ļ��е�statement��id*/
		sqlSession.insert("user.deleteUser",9);
		sqlSession.commit();
		
		/*�رջỰ��������÷���finally����*/
		sqlSession.close();
	}
	
	@org.junit.Test
	/**�����û�*/
	public void updateUser() throws IOException{
		/*�õ������ļ�����*/
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		/*����sql�Ự����*/
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		/*��ȡsession*/
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*�������ݿ�*/
		/*��һ��������ӳ���ļ��е�namespace + "." + ӳ���ļ��е�statement��id*/
		User user = new User();
		user.setId(10);
		user.setName("���񱦱�");
		sqlSession.insert("user.updateUser",user);
		sqlSession.commit();
		
		System.out.println(user.getId() + " " + user.getName());
		
		/*�رջỰ��������÷���finally����*/
		sqlSession.close();
	}
	
	
}

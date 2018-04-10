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
 * ������ز�����ʾ��
 * 
 * */
public class Test {

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
	
	/**һ���������*/
	@org.junit.Test
	public void testFirstCache() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user;
		/*��һ�β�ѯuser�������ݿ�ȥ��ѯ*/
		user = userMapper.findUserById(2);
		System.out.println(user.getName());
		/*�ڶ��β�ѯͬһid�û���ʹ�û��棬���ᷢ��sql����*/
		user = userMapper.findUserById(2);
		System.out.println(user.getName());
		
		/*�������ݻᴥ��sqlSession��������*/
		user.setName("������������");
		userMapper.updateUser(user);
		/*����commit()���������sqlSession�еĻ���*/
		sqlSession.commit();
		
		/*��ջ���֮���ٴβ�ѯ����Ҳ�������ݿ��з���sql����*/
		user = userMapper.findUserById(2);
		System.out.println(user.getName());
		
		sqlSession.close();
	}
	
	/**�����������
	 * @throws Exception */
	@org.junit.Test
	public void testSecondaryCache() throws Exception{
		SqlSession sqlSession;
		UserMapper userMapper;
		User user;
		
		sqlSession = sqlSessionFactory.openSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
		/*��һ�β�ѯ���������ݿⷢ��sql��ѯ����*/
		user = userMapper.findUserById(2);
		System.out.println(user.getName());
		/*����close()���ܽ�SqlSession�еĻ���д�뵽mapper�Ķ���������*/
		sqlSession.close();
		
		/*�½�һ��sqlSession*/
		sqlSession = sqlSessionFactory.openSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
		/*�����ѯ����ֱ��ʹ�ö��������е�����*/
		user = userMapper.findUserById(2);
		System.out.println(user.getName());
		
		/*�����޸����ݴ���������ղ���*/
		user.setName(user.getName() + "��");
		userMapper.updateUser(user);
		/*����sqlSession.commit()�ᴥ�������������*/
		sqlSession.commit();
		sqlSession.close();
		
		/*�½�һ��sqlSession*/
		sqlSession = sqlSessionFactory.openSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
		/*�����ѯ������֮ǰ�Ļ�������գ���λ������ݿⷢ��sql��ѯ����*/
		user = userMapper.findUserById(2);
		System.out.println(user.getName());
		
	}
	
	/**ǿ�ƽ��ö���������ԣ���mapper.xml��<select>��ǩ��ʹ��userCache="false"ǿ�ƽ��ö���������ʾ*/
	@org.junit.Test
	public void testNoSecondaryCache() throws Exception{
		SqlSession sqlSession;
		UserMapper userMapper;
		User user;
		
		sqlSession = sqlSessionFactory.openSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
		/*��һ�β�ѯ���������ݿⷢ��sql��ѯ����*/
		user = userMapper.findUserByIdNoCache(2);
		System.out.println(user.getName());
		/*�ڶ��β�ѯ����Ϊֻ�����˶������棬һ�����滹�ڣ����Բ���Ҫ�����ݿⷢ����ѯsql*/
		user = userMapper.findUserByIdNoCache(2);
		System.out.println(user.getName());
		/*����close()���ܽ�SqlSession�еĻ���д�뵽mapper�Ķ���������*/
		sqlSession.close();
		
		/*�½�һ��sqlSession*/
		sqlSession = sqlSessionFactory.openSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
		/*�����ѯ������ǿ�ƽ����˶������棬���Բ���ʹ�ö��������е����ݣ���Ҫ�����ݿⷢ����ѯsql*/
		user = userMapper.findUserByIdNoCache(2);
		System.out.println(user.getName());
		sqlSession.close();
		
	}
	
	/**ehcache��ܶ����������
	 * @throws Exception */
	@org.junit.Test
	public void testEhcache() throws Exception{
		SqlSession sqlSession;
		UserMapper userMapper;
		User user;
		
		sqlSession = sqlSessionFactory.openSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
		/*��һ�β�ѯ���������ݿⷢ��sql��ѯ����*/
		user = userMapper.findUserById(2);
		System.out.println(user.getName());
		/*����close()���ܽ�SqlSession�еĻ���д�뵽mapper�Ķ���������*/
		sqlSession.close();
		
		/*�½�һ��sqlSession*/
		sqlSession = sqlSessionFactory.openSession();
		userMapper = sqlSession.getMapper(UserMapper.class);
		/*�����ѯ����ֱ��ʹ�ö��������е�����*/
		user = userMapper.findUserById(2);
		System.out.println(user.getName());
	}

	
	
}

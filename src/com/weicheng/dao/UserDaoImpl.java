package com.weicheng.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.weicheng.po.User;

public class UserDaoImpl implements UserDao{

	private SqlSessionFactory sqlSessionFactory;
	
	/**需要向dao中注入SqlSessionFactory对象用来创建SqlSession*/
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*调用selectOne()去使用mapper.xml文件对应方法，user是对应mapper.xml文件的namespace*/
		User user = sqlSession.selectOne("user.findUserById",id);
		sqlSession.close();
		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*调用selectOne()去使用mapper.xml文件对应方法，user是对应mapper.xml文件的namespace*/
		sqlSession.selectOne("user.insertUser",user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void deleteUser(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*调用selectOne()去使用mapper.xml文件对应方法，user是对应mapper.xml文件的namespace*/
		sqlSession.selectOne("user.deleteUser",id);
		sqlSession.commit();
		sqlSession.close();
	}

}

package com.weicheng.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.weicheng.po.User;

public class UserDaoImpl implements UserDao{

	private SqlSessionFactory sqlSessionFactory;
	
	/**��Ҫ��dao��ע��SqlSessionFactory������������SqlSession*/
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*����selectOne()ȥʹ��mapper.xml�ļ���Ӧ������user�Ƕ�Ӧmapper.xml�ļ���namespace*/
		User user = sqlSession.selectOne("user.findUserById",id);
		sqlSession.close();
		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*����selectOne()ȥʹ��mapper.xml�ļ���Ӧ������user�Ƕ�Ӧmapper.xml�ļ���namespace*/
		sqlSession.selectOne("user.insertUser",user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void deleteUser(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/*����selectOne()ȥʹ��mapper.xml�ļ���Ӧ������user�Ƕ�Ӧmapper.xml�ļ���namespace*/
		sqlSession.selectOne("user.deleteUser",id);
		sqlSession.commit();
		sqlSession.close();
	}

}

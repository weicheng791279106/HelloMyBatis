package com.weicheng.spring.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.weicheng.po.User;

/**
 * ��ʾspring����mybatis��ԭʼ��ʽ��dao�㿪��
 * ��Ҫ�̳�SqlSessionDaoSupport��
 * ��Ҫ��applicationContext.xml�ļ�������dao bean
 * ע�����ﲻ���ֶ��ر�sqlSession��spring�ᴦ��
 * */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	@Override
	public User findUserById(int id) throws Exception {
		/*ʹ��getSqlSession()������ȡsqlSession����*/
		SqlSession sqlSession = getSqlSession();
		User user = sqlSession.selectOne("user.findUserById",id);
		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {
		/*ʹ��getSqlSession()������ȡsqlSession����*/
		SqlSession sqlSession = getSqlSession();
		sqlSession.selectOne("user.insertUser",user);
		sqlSession.commit();
	}

	@Override
	public void deleteUser(int id) throws Exception {
		/*ʹ��getSqlSession()������ȡsqlSession����*/
		SqlSession sqlSession = getSqlSession();
		sqlSession.selectOne("user.deleteUser",id);
		sqlSession.commit();
	}

}

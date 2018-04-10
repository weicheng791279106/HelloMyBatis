package com.weicheng.spring.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.weicheng.po.User;

/**
 * 演示spring整合mybatis后原始方式的dao层开发
 * 需要继承SqlSessionDaoSupport类
 * 需要在applicationContext.xml文件中配置dao bean
 * 注意这里不用手动关闭sqlSession，spring会处理
 * */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	@Override
	public User findUserById(int id) throws Exception {
		/*使用getSqlSession()方法获取sqlSession对象*/
		SqlSession sqlSession = getSqlSession();
		User user = sqlSession.selectOne("user.findUserById",id);
		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {
		/*使用getSqlSession()方法获取sqlSession对象*/
		SqlSession sqlSession = getSqlSession();
		sqlSession.selectOne("user.insertUser",user);
		sqlSession.commit();
	}

	@Override
	public void deleteUser(int id) throws Exception {
		/*使用getSqlSession()方法获取sqlSession对象*/
		SqlSession sqlSession = getSqlSession();
		sqlSession.selectOne("user.deleteUser",id);
		sqlSession.commit();
	}

}

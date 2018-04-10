package com.weicheng.dao;

public class Hello {

	/**
	 * 
	 * 原始方法写dao演示
	 * 
	 * #步骤
	 * 	1、编写UserMapper.xml放入config/sqlmap下
	 * 	2、在sqlMapConfig.xml中加载Usermapper.xml文件
	 * 	3、编写dao接口和dao实现类 {@link com.weicheng.dao.UserDao}
	 * 	4、向dao实现类中注入SqlSessionFactory，在方法体内通过SqlSessionFactory创建SqlSession，并用SqlSession去操作数据库 {@link com.weicheng.dao.UserDaoImpl}
	 *  5、利用 {@link com.weicheng.dao.UserDaoTest}模拟service层调用UserDaoImpl
	 * 
	 * #原始dao开发方式缺陷
	 * 	1、出现大量重复代码
	 * 	2、调用sqlSession时需要将statement的id硬编码在代码中
	 * 	3、调用sqlSession时即使传入参数错误在编译阶段也不会报错
	 * 
	 * */
	
}

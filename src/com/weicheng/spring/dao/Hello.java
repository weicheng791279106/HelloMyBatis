package com.weicheng.spring.dao;

public class Hello {

	/**
	 * 演示spring整合mybatis后原始方式的dao层开发
	 * 
	 * #步骤：
	 * 	1、编写UserMapper.xml放入config/sqlmap下
	 * 	2、在sqlMapConfig.xml中加载Usermapper.xml文件
	 * 	3、编写dao接口和dao实现类 {@link com.weicheng.spring.dao.UserDaoImpl}
	 * 	4、需要在applicationContext.xml文件中配置dao bean
	 *  5、利用 {@link com.weicheng.spring.dao.UserDaoTest}模拟service层调用UserDaoImpl
	 * 
	 * */
	
}

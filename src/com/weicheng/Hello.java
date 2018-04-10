package com.weicheng;

public class Hello {
	
	/**
	 * 
	 * #相关知识点演示：
	 * 	1、普通的增删改查操作，见{@link com.weicheng.test.Test} 和 sqlmap/UserMapper.xml
	 *  2、原始方式开发dao层演示见 com.weicheng.dao包和sqlmap/UserMapper.xml
	 *  3、mapper代理方式开发dao层见com.weicheng.mapper包，其中的mapper.xml文件已包含在包中
	 * 
	 * 
	 * #传统jdbc操作数据库的缺点：
	 * 	1、数据库连接在使用前创建使用后释放，造成对数据库频繁开启和关闭，浪费数据库资源，影响数据库性能
	 * 	2、sql语句，占位符，参数，遍历结果集数据都硬编码在java代码中，不利于维护
	 * 
	 * #MyBatis是什么？
	 *  1、Apache下的持久层框架，让程序员将主要精力放在sql上，通过mybatis提供的映射方式，自由灵活生成（半自动化，大部分需要程序员编写sql）满足需求的sql语句
	 *  2、mybatis可以将输入参数进行输入映射，将查询结果进行输出映射转成java对象
	 *  
	 * #MyBatis框架：见doc/MyBatis框架.png 
	 * 
	 * #关于占位符#{}和${}：
	 * 	1、#{}接收的输入参数类型可以是简单类型，pojo，hashmap
	 * 		如果接收简单类型，#{}中可以写成value或其他名称
	 *      如果接收pojo对象值，通过OGNL读取对象中的属性，通过属性.属性.属性..的方式获取对象属性值
	 *      
	 *  2、 ${}表示一个拼接符号，会引起sql注入所以不建议使用
	 * 		${}接收的输入参数类型可以是简单类型，pojo，hashmap
	 * 		如果接收简单类型，${}中只能写成value
	 * 		如果接收pojo对象值，通过OGNL读取对象中的属性，通过属性.属性.属性..的方式获取对象属性值
	 * 
	 * #关于SqlSession：
	 * 	1、线程不安全，最佳应用场合在方法体内，定义成局部变量使用
	 * 
	 * #关于SqlSessionFactory：
	 * 	1、通过SqlSessionFactory来创建SqlSession，使用单例模式管理SqlSessionFactory较合适
	 *
	 * #MyBatis执行过程：
	 * 	1、配置SqlMapConfig.xml（名称不固定）
	 * 	2、通过配置文件加载MyBatis环境，创建SqlSessionFactory（通常使用单例）
	 * 	3、通过SqlSessionFactory创建SqlSession（数据库操作接口，非线程安全）
	 * 	4、调用SqlSession操作数据库
	 *  5、释放资源，关闭SqlSession
	 *  
	 * #MyBatis框架中有两种方式实现dao层 ：
	 * 	1、原始方式实现dao层，演示见com.weicheng.dao
	 *  2、利用mapper代理方式实现dao层，演示见com.weicheng.mapper（推荐）
	 *  
	 * #关于mapper.xml中的parameterType：
	 * 	1、可以是简单类型，pojo类型，HashMap  
	 *  
	 * #关于mapper.xml中的resultType 
	 *  1、可以是简单类型，pojo类型（返回List或是单个pojo对象resultType都一样声明为pojo路径），HashMap  
	 * 	2、使用resultType进行输出映射，只有查询出来的列名和pojo中的属性名一致，该列才可以映射成功。
	 * 		如果查询出来的列名和pojo中的属性名全部不一致，则不会创建pojo对象
	 * 		只要查询出来的列名和pojo中的属性有一个一致，就会创建pojo对象
	 *  
	 * 
	 * 
	 * */

}

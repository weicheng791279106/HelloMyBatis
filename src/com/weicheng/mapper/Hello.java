package com.weicheng.mapper;

public class Hello {

	/**
	 * mapper代理方法开发dao层演示
	 * 
	 * #步骤
	 * 	1、编写mapper.xml（需要遵循特定开发规范） {@link config/mapper/UserMapper.xml}
	 * 	2、编写mapper.java（需要遵循特定开发规范） {@link com.weicheng.mapper.UserMapper}
	 *  3、在SqlMapConfig.xml中加载mapper.xml
	 * 
	 * #开发规范：
	 * 	1、在mapper.xml中namespace等于mapper.java地址
	 *  2、mapper.java接口中的方法名和mapper.xml中statement的id一致
	 *  3、mapper.java接口中的方法输入参数类型和mapper.xml中statement的parameterType指定的类型一致
	 *  4、mapper.java接口中的方法返回值类型和mapper.xml中statement的resultType指定的类型一致
	 *  
	 * #对于关联查询：
	 * 	1、如果需要映射的pojo对象的属性都在第一层没有嵌套，可以使用resultType映射
	 * 	2、如果需要映射的pojo对象的属性有嵌套，则需要写resultMap去做复杂的映射，如果是一对一的映射需要使用<association>属性，如果是一对多的映射(List)需要使用<collection> 
	 * 
	 * */
	
}

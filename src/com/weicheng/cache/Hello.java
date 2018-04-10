package com.weicheng.cache;

public class Hello {

	/**
	 * #查询缓存：用于减轻数据库压力，提高数据库性能，MyBatis提供一级缓存和二级缓存
	 * 
	 * #一级缓存：
	 * 	1、SqlSession级别的缓存。在操作数据库时构造的SqlSession对象中有一个HashMap用于存储缓存数据，不同的SqlSession的缓存区是互不影响的
	 * 	2、一级缓存默认开启
	 * 	3、若调用sqlSesson.commit()或sqlSession.close()则会触发缓存的清空
	 * 
	 * #二级缓存：
	 * 	1、mapper级别的缓存，多个SqlSession可以去操作同一个mapper的sql语句，即多个SqlSession可以共用一个二级缓存，二级缓存是跨SqlSession的
	 * 	2、二级缓存按mapper的namespace做区分，多个mapper如有同一个namespace也是用同一缓存数据
	 * 	3、若调用sqlSesson.commit()则会触发缓存的清空
	 * 	4、二级缓存默认关闭，如需开启需要进行配置
	 * 
	 * #开启二级缓存步骤
	 * 	1、在sqlMapConfig.xml中开启二级缓存 <setting name="cacheEnabled" value="true"/>
	 * 	2、在需要使用二级缓存的mapper.xml文件中开启二级缓存 <cache/>
	 * 	3、在需要缓存的pojo类实现Serializable接口，因为缓存的数据不一定是在内存中，也可能是其他存储介质
	 * 
	 * #二级缓存应用场景
	 * 	对于访问多的查询请求且用户对查询结果实时性要求不高，此时可采用mybatis二级缓存技术降低数据库访问量，提高访问速度，
	 *  业务场景比如：耗时较高的统计分析sql、电话账单查询sql等。
	 *  实现方法如下：通过设置刷新间隔时间，由mybatis每隔一段时间自动清空缓存，根据数据变化频率设置缓存刷新间隔flushInterval，比如设置为30分钟、60分钟、24小时等，根据需求而定。
	 * 
	 * #二级缓存局限性
	 * 	mybatis二级缓存对细粒度的数据级别的缓存实现不好，比如如下需求：对商品信息进行缓存，由于商品信息查询访问量大，
	 * 	但是要求用户每次都能查询最新的商品信息，此时如果使用mybatis的二级缓存就无法实现当一个商品变化时只刷新该商品的缓存信息而不刷新其它商品的信息，
	 * 	因为mybaits的二级缓存区域以mapper为单位划分，当一个商品信息变化会将所有商品信息的缓存数据全部清空。解决此类问题需要在业务层根据需求对数据有针对性缓存。
	 * 
	 * #关于分布式缓存
	 * 	使用分布式缓存管理可以使缓存数据在多台服务器上共享，提高系统性能。MyBatis无法实现分布式缓存，需要和其他分布式缓存框架整合。
	 * 
	 * #MyBatis整合分布式缓存框架原理：重写Cahce接口。
	 * 	例如需要整合ehcahce框架，需要将org.mybatis.caches.ehcache.EhcacheCache类（实现了Cache接口）部署到mapper.xml文件的<cache/>配置中
	 * 
	 * 
	 * */
	
}

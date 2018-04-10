package com.weicheng.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.weicheng.po.OrderUserQueryVo;
import com.weicheng.po.OrderUserQueryVo2;
import com.weicheng.po.OrderUserQueryVo3;
import com.weicheng.po.User;
import com.weicheng.po.UserQueryVo;

/**
 * 订单查询dao测试类
 * 
 * */
public class OrderMapperTest {

	SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 在测试dao之前需要先创建好SqlSessionFactory对象
	 * */
	@Before
	public void setUp() throws Exception{
		/*得到配置文件的流*/
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		/*创建sql会话工厂*/
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testQueryOrderUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<OrderUserQueryVo> resultList = orderMapper.queryOrderUser();
		sqlSession.close();
		System.out.println(resultList);
	}
	
	@Test
	public void testQueryOrderUserRM() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<OrderUserQueryVo2> resultList = orderMapper.queryOrderUserRM();
		sqlSession.close();
		System.out.println(resultList);
	}
	
	@Test
	public void testQueryOrderDetail() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<OrderUserQueryVo2> resultList = orderMapper.queryOrderDetail();
		sqlSession.close();
		System.out.println(resultList);
	}
	
	@Test
	public void testQueryUserOrder() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<OrderUserQueryVo3> resultList = orderMapper.queryUserOrder();
		sqlSession.close();
		System.out.println(resultList);
	}
	
	/**
	 * 延迟加载测试
	 * 
	 * 测试方法：需要在orderMapper.queryOrderListLazy()和System.out.println(order.getUser())这两行打断点进行调试
	 * 			当运行到orderMapper.queryOrderListLazy()时只发出了查询order信息的sql，当运行到System.out.println(order.getUser())时才会发出查询user的sql
	 * 
	 * 注意：调试中运行完orderMapper.queryOrderListLazy()时不要将鼠标移动到resultList上去查看返回的结果，这样会在System.out.println(order.getUser())之前就触发查询user逻辑
	 * 
	 * */
	@Test
	public void testQueryOrderListLazy() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<OrderUserQueryVo2> resultList = orderMapper.queryOrderListLazy();
		for(OrderUserQueryVo2 order:resultList) System.out.println(order.getUser());
		sqlSession.close();
	}
	
}

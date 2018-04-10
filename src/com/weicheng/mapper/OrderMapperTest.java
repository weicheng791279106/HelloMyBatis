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
 * ������ѯdao������
 * 
 * */
public class OrderMapperTest {

	SqlSessionFactory sqlSessionFactory;
	
	/**
	 * �ڲ���dao֮ǰ��Ҫ�ȴ�����SqlSessionFactory����
	 * */
	@Before
	public void setUp() throws Exception{
		/*�õ������ļ�����*/
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		/*����sql�Ự����*/
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
	 * �ӳټ��ز���
	 * 
	 * ���Է�������Ҫ��orderMapper.queryOrderListLazy()��System.out.println(order.getUser())�����д�ϵ���е���
	 * 			�����е�orderMapper.queryOrderListLazy()ʱֻ�����˲�ѯorder��Ϣ��sql�������е�System.out.println(order.getUser())ʱ�Żᷢ����ѯuser��sql
	 * 
	 * ע�⣺������������orderMapper.queryOrderListLazy()ʱ��Ҫ������ƶ���resultList��ȥ�鿴���صĽ������������System.out.println(order.getUser())֮ǰ�ʹ�����ѯuser�߼�
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

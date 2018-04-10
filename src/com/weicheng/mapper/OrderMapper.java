package com.weicheng.mapper;

import java.util.List;

import com.weicheng.po.OrderUserQueryVo;
import com.weicheng.po.OrderUserQueryVo2;
import com.weicheng.po.OrderUserQueryVo3;

public interface OrderMapper {

	/**查询订单及关联用户（所有属性都在第一层没有嵌套）*/
	public List<OrderUserQueryVo> queryOrderUser();
	
	/**查询订单及关联用户（第一层属性是Order，第二层是user属性放在user对象中）*/
	public List<OrderUserQueryVo2> queryOrderUserRM();
	
	/**查询订单及关联用户及订单明细（第一层属性是Order，第二层是user属性放在user对象中，还有orderDetail放在orderDetailList中）*/
	public List<OrderUserQueryVo2> queryOrderDetail();
	
	/**查询每个用户下的所有订单，及订单所对应的商品*/
	public List<OrderUserQueryVo3> queryUserOrder();
	
	/**延时加载查询订单及关联用户*/
	public List<OrderUserQueryVo2> queryOrderListLazy();
	
}

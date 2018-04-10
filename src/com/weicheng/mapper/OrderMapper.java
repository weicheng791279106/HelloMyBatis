package com.weicheng.mapper;

import java.util.List;

import com.weicheng.po.OrderUserQueryVo;
import com.weicheng.po.OrderUserQueryVo2;
import com.weicheng.po.OrderUserQueryVo3;

public interface OrderMapper {

	/**��ѯ�����������û����������Զ��ڵ�һ��û��Ƕ�ף�*/
	public List<OrderUserQueryVo> queryOrderUser();
	
	/**��ѯ�����������û�����һ��������Order���ڶ�����user���Է���user�����У�*/
	public List<OrderUserQueryVo2> queryOrderUserRM();
	
	/**��ѯ�����������û���������ϸ����һ��������Order���ڶ�����user���Է���user�����У�����orderDetail����orderDetailList�У�*/
	public List<OrderUserQueryVo2> queryOrderDetail();
	
	/**��ѯÿ���û��µ����ж���������������Ӧ����Ʒ*/
	public List<OrderUserQueryVo3> queryUserOrder();
	
	/**��ʱ���ز�ѯ�����������û�*/
	public List<OrderUserQueryVo2> queryOrderListLazy();
	
}

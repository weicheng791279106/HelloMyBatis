package com.weicheng.mapper;

public class Hello {

	/**
	 * mapper����������dao����ʾ
	 * 
	 * #����
	 * 	1����дmapper.xml����Ҫ��ѭ�ض������淶�� {@link config/mapper/UserMapper.xml}
	 * 	2����дmapper.java����Ҫ��ѭ�ض������淶�� {@link com.weicheng.mapper.UserMapper}
	 *  3����SqlMapConfig.xml�м���mapper.xml
	 * 
	 * #�����淶��
	 * 	1����mapper.xml��namespace����mapper.java��ַ
	 *  2��mapper.java�ӿ��еķ�������mapper.xml��statement��idһ��
	 *  3��mapper.java�ӿ��еķ�������������ͺ�mapper.xml��statement��parameterTypeָ��������һ��
	 *  4��mapper.java�ӿ��еķ�������ֵ���ͺ�mapper.xml��statement��resultTypeָ��������һ��
	 *  
	 * #���ڹ�����ѯ��
	 * 	1�������Ҫӳ���pojo��������Զ��ڵ�һ��û��Ƕ�ף�����ʹ��resultTypeӳ��
	 * 	2�������Ҫӳ���pojo�����������Ƕ�ף�����ҪдresultMapȥ�����ӵ�ӳ�䣬�����һ��һ��ӳ����Ҫʹ��<association>���ԣ������һ�Զ��ӳ��(List)��Ҫʹ��<collection> 
	 * 
	 * */
	
}

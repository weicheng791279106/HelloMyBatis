package com.weicheng;

public class Hello {
	
	/**
	 * 
	 * #���֪ʶ����ʾ��
	 * 	1����ͨ����ɾ�Ĳ��������{@link com.weicheng.test.Test} �� sqlmap/UserMapper.xml
	 *  2��ԭʼ��ʽ����dao����ʾ�� com.weicheng.dao����sqlmap/UserMapper.xml
	 *  3��mapper����ʽ����dao���com.weicheng.mapper�������е�mapper.xml�ļ��Ѱ����ڰ���
	 * 
	 * 
	 * #��ͳjdbc�������ݿ��ȱ�㣺
	 * 	1�����ݿ�������ʹ��ǰ����ʹ�ú��ͷţ���ɶ����ݿ�Ƶ�������͹رգ��˷����ݿ���Դ��Ӱ�����ݿ�����
	 * 	2��sql��䣬ռλ����������������������ݶ�Ӳ������java�����У�������ά��
	 * 
	 * #MyBatis��ʲô��
	 *  1��Apache�µĳ־ò��ܣ��ó���Ա����Ҫ��������sql�ϣ�ͨ��mybatis�ṩ��ӳ�䷽ʽ������������ɣ����Զ������󲿷���Ҫ����Ա��дsql�����������sql���
	 *  2��mybatis���Խ����������������ӳ�䣬����ѯ����������ӳ��ת��java����
	 *  
	 * #MyBatis��ܣ���doc/MyBatis���.png 
	 * 
	 * #����ռλ��#{}��${}��
	 * 	1��#{}���յ�����������Ϳ����Ǽ����ͣ�pojo��hashmap
	 * 		������ռ����ͣ�#{}�п���д��value����������
	 *      �������pojo����ֵ��ͨ��OGNL��ȡ�����е����ԣ�ͨ������.����.����..�ķ�ʽ��ȡ��������ֵ
	 *      
	 *  2�� ${}��ʾһ��ƴ�ӷ��ţ�������sqlע�����Բ�����ʹ��
	 * 		${}���յ�����������Ϳ����Ǽ����ͣ�pojo��hashmap
	 * 		������ռ����ͣ�${}��ֻ��д��value
	 * 		�������pojo����ֵ��ͨ��OGNL��ȡ�����е����ԣ�ͨ������.����.����..�ķ�ʽ��ȡ��������ֵ
	 * 
	 * #����SqlSession��
	 * 	1���̲߳���ȫ�����Ӧ�ó����ڷ������ڣ�����ɾֲ�����ʹ��
	 * 
	 * #����SqlSessionFactory��
	 * 	1��ͨ��SqlSessionFactory������SqlSession��ʹ�õ���ģʽ����SqlSessionFactory�Ϻ���
	 *
	 * #MyBatisִ�й��̣�
	 * 	1������SqlMapConfig.xml�����Ʋ��̶���
	 * 	2��ͨ�������ļ�����MyBatis����������SqlSessionFactory��ͨ��ʹ�õ�����
	 * 	3��ͨ��SqlSessionFactory����SqlSession�����ݿ�����ӿڣ����̰߳�ȫ��
	 * 	4������SqlSession�������ݿ�
	 *  5���ͷ���Դ���ر�SqlSession
	 *  
	 * #MyBatis����������ַ�ʽʵ��dao�� ��
	 * 	1��ԭʼ��ʽʵ��dao�㣬��ʾ��com.weicheng.dao
	 *  2������mapper����ʽʵ��dao�㣬��ʾ��com.weicheng.mapper���Ƽ���
	 *  
	 * #����mapper.xml�е�parameterType��
	 * 	1�������Ǽ����ͣ�pojo���ͣ�HashMap  
	 *  
	 * #����mapper.xml�е�resultType 
	 *  1�������Ǽ����ͣ�pojo���ͣ�����List���ǵ���pojo����resultType��һ������Ϊpojo·������HashMap  
	 * 	2��ʹ��resultType�������ӳ�䣬ֻ�в�ѯ������������pojo�е�������һ�£����вſ���ӳ��ɹ���
	 * 		�����ѯ������������pojo�е�������ȫ����һ�£��򲻻ᴴ��pojo����
	 * 		ֻҪ��ѯ������������pojo�е�������һ��һ�£��ͻᴴ��pojo����
	 *  
	 * 
	 * 
	 * */

}

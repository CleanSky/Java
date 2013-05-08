package com.bisn.basic;

import java.lang.reflect.*;

/*
 * ��������ƻ����͡��ƻ���װ���Ӷ�������ĳ�Ա������������ʱװ���������ʵ�����������Ժͷ������Գ�����ж�̬�Ŀ��ơ�
 * ��������ʵ�еĿ�¡������
 * 
 * Class����һ���ر���࣬�����洢��һ�����йص�ȫ����Ϣ���࣬�����û�й�ϵ��
 * Class������java.lang������������ͼ�¼ĳһ�������Ϣ���繹�췽������������Ա�����ȡ�
 * ��Java�������й����У�ÿ���౻���ض��������ڴ�������һ����Ӧ��Class����
 * 
 * �Ѿ���һ���࣬�ø����Ӧ�ķ��������ȡ�����������Ϣ����������Щ��Ϣ���Կ�¡һ����Ķ���
 */

public class Reflect {

	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("com.bisn.basic.Pet");
			// ������������Ķ���
			Object obj = c.newInstance();// ���������ã�ֻ�ܵ����޲εĹ��췽��

			// ��Constructor������ʵ���������Ե���ָ�������Ĺ��췽��
			Constructor con = c.getDeclaredConstructor(String.class, int.class,
					String.class, double.class);
			Object obj2 = con.newInstance("����", 8, "��ɫ", 5.23);

			// ���ö�������name
			Field f = c.getDeclaredField("name");// ���ö�������name
			f.setAccessible(true);// ���ÿ��Է���˽�г�Ա
			String name = (String) f.get(obj2);// �õ�obj2������
			System.out.println("obj2��name�ǣ�" + name);
			f.set(obj2, "����");// �޸�����ֵ

			Method m = c.getDeclaredMethod("show", null);// ���ö���ķ���
			m.setAccessible(true);// �������з���Ȩ�ޣ������Է���˽�г�Ա
			Object o = m.invoke(obj2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

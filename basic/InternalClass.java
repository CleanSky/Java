package com.bisn.basic;

/*
 * Java�е�����԰�����������Ա���������飬���������԰����࣬���ֶ�������һ�����ڲ������Ϊ�ڲ��ࡣ
 * �ڲ������ʹ�������Ϊ4�֣���Ա�ڲ��ࡢ�ֲ��ڲ��ࡢ��̬�ڲ��ࡢ�����ڲ��ࡣ
 * 
 * 
 * ��Ա�ڲ���
 * ��Ա�ڲ��࣬��һ�����Կ������ⲿ��ķǾ�̬��Ա���ڲ��ࡣ
 * ��Ա�ڲ�����Է����ⲿ���˽�г�Ա�����ԡ�
 * �ⲿ�಻�ܷ��ʳ�Ա�ڲ����е�˽�����ԡ�
 * ��Ա�ڲ�����һ������ʱ�ĸ��һ������ɹ����ͻ��Ϊ���ⲿ����ȫ��ͬ���ࡣ
 * �ڲ�����ⲿ���ڱ���ʱ��������ͬ���࣬�ڲ�����ⲿ��û���κ�������
 * 
 * ���ⲿ����ڲ�����һ���ڲ���Ķ������ֱ��ʹ��inner i = new inner();(inner�����ڲ����������
 * ���ⲿ����ⲿ����һ���ڲ���Ķ�����Ҫ���Ƚ���һ���ⲿ�����Ȼ��������һ���ڲ������
 * 
 * 
 * �ֲ��ڲ���
 * �ֲ��ڲ��࣬��һ��ֻ���ھֲ���Ч���ڲ��ࡣ
 * �ֲ��ڲ��౻�����ڷ����С�
 * �ֲ��ڲ���ǰ�������η�public��private���䷶ΧΪ�������Ĵ���顣
 * �ֲ��ڲ�����Է����ⲿ���˽��ʵ�������;ֲ���������final�͵ģ���
 * ���ⲿ����ⲿ����ֱ�ӷ��ʾֲ��ڲ��࣬���ֲ��ڲ�������ǲ��ɼ��ġ�
 * Ϊ������ⲻ�ܷ��ʾֲ��ڲ�������⣬����ͨ���ֲ��ڲ���ͽӿڴﵽһ��ǿ�Ƶ�����Ϲ�ϵ���þֲ��ڲ�����ʵ�ֽӿڣ����ڷ����з��ؽӿ����ͣ������ȿ���ʹ�ֲ��ڲ��಻�ɼ�������ʵ����Ŀɼ��ԣ��ֿ���������ⲿ���ʵ��ڲ���ķ�����
 * 
 * 
 * ��̬�ڲ���
 * ��̬�ڲ��࣬��ʵ�Ѿ��������ⲿ�࣬ʵ����һ�������ڱ�����ڲ�����ͨ�࣬�ؼ���staticֻ��˵�����ڴ�������ʱ���������ⲿ�����Ĵ��ڣ�������˵����౾���Ǿ�̬�ġ�
 * ��̬�ڲ��಻������private���ж��壬���ڲ��������ǰ��Ҫ����static�ؼ��֡�
 * ��̬�ڲ���ֻ�ܷ����ⲿ��ľ�̬��Ա�����ܷ����ⲿ��ķǾ�̬��Ա��
 * ��̬�ڲ���Ķ������ֱ�����ɣ�������Ҫ�ⲿ��Ķ��������ɡ�
 * �Ǿ�̬�ڲ������ⲿ�������ɵ�һ���֣���Ҫ�Ǹ����ⲿ��������ģ����ⲿ���������ŶԳ�Ա�����Ĺ����ϵ��
 * 
 * 
 * �����ڲ���
 * �����ڲ��࣬��һ������ľֲ��ڲ��࣬�����ڲ���û������������������ֻʹ��һ���Ҳ���Ҫ��δ���������ࡣ
 * �����ڲ�����������ͬʱ�������������ڲ��������Ҫô�ǻ��ڼ̳У�Ҫô��ʵ�ֽӿڡ�
 * �����ڲ�����Ψһһ��û�й��췽�����ࡣ
 * �󲿷������ڲ������ڽӿڻص���
 * �����ڲ����ڱ���ʱ��ϵͳ�Զ�����ΪOut $1.class��
 * �����ڲ������ڼ̳����������ʵ�ֽӿڣ��Ҳ���Ҫ���Ӷ���ķ�����ֻ�ǶԼ̳з�����ʵ�ֻ�����д��
 */

public class InternalClass {

	private String name = "Сǿ";//�����ⲿ������name
	private static String address = "����";//���徲̬����address
	
	public void m1() {//�����ⲿ�෽��m1
		System.out.println("�ⲿ��ķ���m1");
	}
	
	//��Ա�ڲ���
	public class InnerA {
		public InnerA() {//���췽��
			
		}
		
		String name = "��";//�����Ա�ڲ��������name
		
		public void m2() {//�����Ա�ڲ���ķ���m2
			//�����ⲿ������ԣ�������д�������Ե���˽������
			System.out.println("�ⲿ���name = " + InternalClass.this.name);
			System.out.println("�ⲿ���address = " + address);
			//���ó�Ա�ڲ����������this.
			System.out.println("�ⲿ����ڲ����name = " + this.name);
		}
	}
	
	//��̬�ڲ���InnerC
	public static class InnerC {
		public void m3() {
			//��̬�ڲ���ֻ�ܵ����ⲿ��ľ�̬���ԣ����ܵ��÷Ǿ�̬����
			//System.out.println("name = " + name);
			System.out.println("��̬�ڲ���InnerC����InternalClass��address = " + address);
		}
	}
	
	public static void main(String[] args) {
		InternalClass out = new InternalClass();//�����ⲿ��Ķ���out
		out.m1();
		InternalClass.InnerA inn = out.new InnerA();//��out�Ķ��󴴽��ڲ���Inner�Ķ���
		inn.m2();
		
		OuterB outb = new OuterB();
		//ͨ���ⲿ�������÷���m1�����ؽӿ����ͣ��ﵽ���þֲ��ڲ��෽����Ŀ��
		MyInter obj = outb.m1();
		obj.m3();
		obj.m4();
		
		//��̬�ڲ�������ڲ������ⲿ�����������ֱ�������ڲ���Ķ���
		InternalClass.InnerC innc = new InternalClass.InnerC();
		innc.m3();
		
		//�����ڲ���
		AbstractFather af = new AbstractFather() {
			{
				count = (int)(100 * Math.random());//��������
			}
			
			public void m() {//ʵ�ָ���ķ���
				System.out.println("���ĺ����ǣ�" + count);
			}
		};
		
		af.m();
	}

}

class OuterB {
	private int a = 10;
	public MyInter m1() {
		int b = 20;
		final int c = 30;
		
		//�ֲ��ڲ���
		class InnerB implements MyInter {
			/*
			 * �ֲ��ڲ��࣬����ʵ����MyInter�ӿ�
			 * ʵ�ֽӿڵĳ��󷽷�m3��m4
			 */
			public void m3() {
				System.out.println("�ֲ��ڲ���InnerB��m3���������ⲿ��OuterB�ı���a = " + a);
				//��final�ľֲ��������ܷ���
				//System.out.println("�ڲ���InnerB��m3�������þֲ�����b = " + b);
			}
			
			public void m4() {
				System.out.println("�ֲ��ڲ���InnerB��m4�������þֲ�����c = " + c);
			}
		}
		
		return new InnerB();
	}
}

interface MyInter {//�ӿ�MyInter
	public void m3();
	public void m4();
}

abstract class AbstractFather {
	int count;
	abstract void m();
}

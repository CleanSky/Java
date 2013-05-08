package com.bisn.basic;

import java.io.IOException;

/*
 * Java���쳣��������Throwable��̳ж����ģ���ΪError��Exception���࣬Exception�ַ�ΪRuntimeException�쳣�ͷ�RuntimeException�쳣��
 * 
 * Error���εĽṹ��Ҫ������Java����ʱϵͳ���ڲ��������Դ�ľ��ȴ�����Ӳ����������������ݡ�ϵͳ�����ȡ�
 * RuntimeException���쳣ָ��������ʱ�쳣��Ҳ��Ϊδ����쳣��һ�������ڳ���Ա�Լ���������ɵģ�����������ת�����������Խ�硢���ʿ�ָ��ȡ�
 * ��RuntimeException�쳣��Ҳ��Ϊ�Ѽ���쳣���������Ѽ���쳣��Ҫ�����¼��֣�java.io.IOException(IO�쳣����������豸�����ڣ������ļ���ĩβ��ȡ����)��java.io.FileNotFoundException(�ļ�δ�ҵ��쳣)��java.lang.ClassNotFoundException(��̬��װ��ĳ����ʱ���Ҳ�������)��
 * 
 * �����Ѽ���쳣���봦��������δ����쳣��ɴ���Ҳ�ɲ�����
 * 
 * try/catch/finally
 * try���Ƶķ�ΧҪ���ݲ����������Ժ�����Խ��п��ƣ����ǰ��ĳ��������׳��Ĵ���Ӱ���������������У���ô��˵���������������ڹ�����Ӧ����ͬһ��try�С�
 * finally�����е����������ʲô����¶��ᱻִ�У�������дһЩ�ͷ���Դ����䡣
 * 
 * finally��catch�����ǿ�ѡ����䣬�������ǲ���ͬʱʡ�ԡ�
 * 
 * ������catch��������ָ�����쳣���ͼ�����ͬ����û���κ�������ϵ����catch��� ��������˳��
 * ������catch��������ָ�����쳣�����໥֮����������ϵ������뽫�����͵��쳣д�����棬�����͵��쳣д�����档
 * 
 * 
 * �����쳣֪ʶ�쳣�����һ�ַ�ʽ�������쳣��Ӧ�ں��ʵĵط����д�����δ�������쳣��Ҫ����Ҳ�����׳��쳣��
 * �����������������쳣��������try/catch��������ȥ����ʹ����쳣��
 * �������û��������쳣���������׳��쳣��ֱ���׵��ܴ����쳣��λ�ã������ھ߱����쳣���д���������λ�ã���
 * 
 * throws���������������п����׳����쳣���������׳����쳣����throws���棬�ö��Ÿ�����
 * throw�����׳��쳣���󣬵����ֻ�ܸ�һ���쳣��������ã���ͬһʱ��ֻ���׳�һ���쳣��
 * �쳣�����ŷ����ĵ��������򴫵ݵġ�
 */

public class ExceptionTest {

	public static void test(int num) throws IOException, BelowZeroException {
		if (num < 0) {
			throw new BelowZeroException(num + "С��0��");
		} else {
			System.out.println(num + "���ڵ���0��");
		}
	}

	
	public static void main(String[] args) throws IOException, BelowZeroException {
		//дforѭ����switch��֧��䣬�������л��׳��쳣�����
		for (int i = 0; i < 5; i++) {
			int j = 0;
			try {
				System.out.println("������������䣬û���쳣��");//�������
				//��֧��䣬ÿ������1����䣬ǰ4���׳��쳣�����һ��û�׳��쳣
				switch (i) {
				case 0:
					int zero = 0;//��ѧ�����쳣
					j = 1 / zero;
					break;
				case 1:
					int b[] = null;//��ָ���쳣
					j = b[0];
					break;
				case 2:
					int c[] = new int[2];//�����±�Խ���쳣
					j = c[3];
					break;
				case 3:
					char ch = "hello".charAt(9);//�ַ����±�Խ���쳣
					break;
				case 4:
					char cha = "abc".charAt(1);
					System.out.println("abc�ĵ�2����ĸ��" + cha);
					break;
				}
				System.out.println("ǰ�����䶼û���׳��쳣�Ż������ҡ�");//�������
			} catch (ArithmeticException e) {
				System.out.println("��������ѧ�����쳣��");
				e.printStackTrace();// ��ӡ�쳣��ջ��Ϣ
			} catch (NullPointerException e) {
				System.out.println("�����˿�ָ���쳣��");
				e.printStackTrace();
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("�����������±����Խ���쳣��");
				e.printStackTrace();
			} catch (StringIndexOutOfBoundsException e) {
				System.out.println("�������ַ����±�Խ���쳣��");
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("��" + (i + 1) + "�β����쳣");
				System.out.println("��ʾ���쳣��ϢΪ��" + e);
				e.printStackTrace();
			} finally {
				System.out.println("�����쳣�׳�û�׳�������û�����Ҷ�һ�����С�");
			}
		}
		
		test(10);// ����
		test(-10);// �׳�С��0���쳣
	}
	
}

//�Զ���һ��С��0���쳣
class BelowZeroException extends Exception {
	public BelowZeroException() {//�յĹ��췽��
		
	}
	
	public BelowZeroException(String msg) {//�Զ�����쳣��Ĺ��췽�������г�����Ϣʱ�����쳣����
		super(msg);
	}
}

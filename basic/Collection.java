package com.bisn.basic;

/*
 * ������6���ӿں�8��ʵ���ࡣ
 * ���ϵ�6���ӿڣ�
 * Collection:�����˴�ȡһ�����ķ������ӽӿ�Set��List�ֱ����˴洢��ʽ��
 * Set:Ԫ��û�д��򣬲������ظ���
 * SortedSet:��Set�ӿ���ͬ����Ԫ�ذ��������С�
 * List:Ԫ�ؼ��غ��Ƴ�ʱ����˳�������ظ���
 * Map:�Լ�ֵ(key-value)�Եķ�ʽ���������Ӧ��Ԫ�أ��޷���˳��key�����ظ���value�����ظ���
 * SortedMap:��Map��ͬ���������е�Ԫ�ذ������Ǽ�ֵ���������С�
 * 
 * ���ϵ�8��ʵ���ࣺ
 * LinkedList:��ɾ�졢���������ʶ����ڲ����ɾ�������ײ���˫��ѭ������
 * ArrayList:Ч�ʸߡ���ֱ��֧�ֲ����������ڲ�ѯ�����ײ�������
 * Vector:Ч�ʵ͡��̰߳�ȫ��ֱ��֧�ֲ��������������ڲ�ѯ��
 * HashSet:�洢Ч�ʸߡ���ѯЧ�ʵ͡�
 * TreeSet:�洢Ч�ʵ͡���ѯЧ�ʸߡ����ײ��Ƕ�����
 * HashMap:Ԫ���Լ�ֵ�Է�ʽ���档Ч�ʸߣ���֧�ֲ��У������ֵ�������ڹ�ϣ���Mapʵ�֣��ײ�������
 * HashTable:Ԫ���Լ�ֵ�Է�ʽ���档�̰߳�ȫ��key��value���������ֵ
 * TreeMap:Ԫ���Լ�ֵ�Է�ʽ���档��֧�ֲ��У�key��value���������ֵ�������ں����ʵ��
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.*;

public class Collection {

	public static void main(String[] args) {
		//ArrayList
		//��̬
		List list = new ArrayList();//������Ϊlist����ʼ����Ϊ10�Ŀռ�
		//List list1 = new ArrayList(20);//�������ָ����ʼ�����Ŀ��б�
		//ensureCapacity(int minCapacity)������ʹ��
		//list.ensureCapacity(1000);//ָ����ʼ���������������ʱ�������Ч��
		
		list.add("Jack");
		list.add("Jet");
		list.add("Jack");
		list.add("Mike");
		list.add("Kitty");
		list.add("Tom");
		list.add(5);//�Զ�װ�书��
		list.add(3.14);
		list.add(3, "hello");//������ֵΪ3��λ������ַ���hello
		list.remove("Kitty");
		list.remove(5);
		list.set(1, "coco");
		
		System.out.println(list.get(1));
		
		//ֱ��ͨ���±����
		System.out.println("******************************");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		//ʹ��Iterator�ķ�ʽ����
		System.out.println("******************************");
		Iterator it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		//ʹ��for-eachѭ������
		System.out.println("******************************");
		for (Object obj : list) {
			System.out.println(obj);
		}
		
		//LinkedList
		LinkedList<Student> list1 = new LinkedList<Student>();
		Student st1 = new Student(1.60, "lily");
		Student st2 = new Student(1.70, "jim");
		Student st3 = new Student(1.68, "beake");;
		Student st4 = new Student(1.78, "geoger");
		Student st5 = new Student(1.69, "andy");
		
		list1.add(st1);
		list1.add(st2);
		list1.addFirst(st3);
		list1.add(1, st4);//��geogerͬѧ��lily����
		list1.addLast(st5);
		
		for (int i = 0; i < list1.size(); i++) {
			System.out.println("��" + (i + 1) + "λͬѧ�ǣ�" + list1.get(i));
		}
		
		list1.remove(2);
		list1.remove(st4);
		list1.add(3, st2);
		
		System.out.println("**********************");
		ListIterator<Student> it1 = list1.listIterator(list1.size());
		while (it1.hasPrevious()) {
			System.out.println(it1.previous());
		}
		
		//HashSet
		Set<Student> set = new HashSet<Student>();
		
		//TreeSet
		Set<Student> set1 = new TreeSet<Student>();
		
		//HashMap
		HashMap<String, String> hm = new HashMap<String, String>();
		
		//TreeMap
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
	}

}

class Student {
	private double height;
	private String name;
	
	public Student() {
		
	}
	
	public Student(double height, String name) {
		this.height = height;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name + ", ����ǣ�" + height + "�ס�";
	}
}
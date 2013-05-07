package com.bisn.basic;

/*
 * 集合有6个接口和8个实现类。
 * 集合的6个接口：
 * Collection:定义了存取一组对象的方法，子接口Set和List分别定义了存储方式。
 * Set:元素没有次序，不允许重复。
 * SortedSet:和Set接口相同，但元素按升序排列。
 * List:元素加载和移出时按照顺序，允许重复。
 * Map:以键值(key-value)对的方式存放两个对应的元素，无放入顺序，key不能重复，value可以重复。
 * SortedMap:和Map相同，但集合中的元素按照它们键值的升序排列。
 * 
 * 集合的8个实现类：
 * LinkedList:增删快、查找慢，故多用于插入和删除——底层是双向循环链表
 * ArrayList:效率高、不直接支持并发，多用于查询——底层是数组
 * Vector:效率低、线程安全，直接支持并发操作，多用于查询。
 * HashSet:存储效率高、查询效率低。
 * TreeSet:存储效率低、查询效率高——底层是二叉树
 * HashMap:元素以键值对方式保存。效率高，不支持并行，允许空值——基于哈希表的Map实现，底层是数组
 * HashTable:元素以键值对方式保存。线程安全，key、value都不允许空值
 * TreeMap:元素以键值对方式保存。不支持并行，key、value都不允许空值——基于红黑树实现
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
		//多态
		List list = new ArrayList();//构造名为list，初始容量为10的空间
		//List list1 = new ArrayList(20);//构造具有指定初始容量的空列表
		//ensureCapacity(int minCapacity)方法的使用
		//list.ensureCapacity(1000);//指明初始容量，存大量数据时，能提高效率
		
		list.add("Jack");
		list.add("Jet");
		list.add("Jack");
		list.add("Mike");
		list.add("Kitty");
		list.add("Tom");
		list.add(5);//自动装箱功能
		list.add(3.14);
		list.add(3, "hello");//在索引值为3的位置添加字符串hello
		list.remove("Kitty");
		list.remove(5);
		list.set(1, "coco");
		
		System.out.println(list.get(1));
		
		//直接通过下标访问
		System.out.println("******************************");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		//使用Iterator的方式访问
		System.out.println("******************************");
		Iterator it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		//使用for-each循环访问
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
		list1.add(1, st4);//让geoger同学到lily后面
		list1.addLast(st5);
		
		for (int i = 0; i < list1.size(); i++) {
			System.out.println("第" + (i + 1) + "位同学是：" + list1.get(i));
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
		return name + ", 身高是：" + height + "米。";
	}
}
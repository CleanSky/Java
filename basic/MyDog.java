package com.bisn.basic;

public class MyDog {
	
	public static void main(String[] args) {
		Dog mydog = new Dog("����", 3, "�ɿ���", 3.80, "��߹��Ȯ");
		mydog.show();
		mydog.cosmetic();
		
		//��̬�������Ķ�̬����������д�����أ�+ ����Ķ�̬
		//������������������������ʱ����ֻ�ܵ��ø�����ԭ�ж�������Ժͷ����������Լ���չ�����Ժͷ����Ͳ��ܵ����ˡ�
		//������������������������ʱ�����������д�˸����еķ���������ø÷���ʱ���õ���������д��ķ�����
		Pet mydog2 = new Dog("����", 3, "�����", 3.50, "���͹�");
		mydog2.show();//show��������д�ˣ����Ե��õ���������д�ķ���
		//mydog2.cosmetic();//mydog2���ܵ����Լ����صķ������˴����൱�����࿴
		((Dog) mydog2).cosmetic();//ǿ��ת����ſ�ʹ���Լ����еķ���
		
		//instanceof�����
		if (mydog2 instanceof Dog) {
			System.out.println("mydog2��һ������");
		} else {
			System.out.println("mydog2����һ������");
		}
	}

}

//�̳�
class Dog extends Pet {
	public Dog(String name, int age, String color, double weight) {
		super(name, age, color, weight);
	}
	
	private String species;//������ﹷ��һ����չ������Ʒ��
	
	//���صĹ��췽���������ﹷ���е����Լӽ���
	public Dog(String name, int age, String color, double weight, String species) {
		super(name, age, color, weight);
		this.species = species;
	}
	
	//�����ﹷ������species���get��set����
	public String getSpecies() {
		return species;
	}
	
	public void setSpecies(String species) {
		this.species = species;
	}
	
	//д���ﹷ���еķ���
	public void cosmetic() {
		System.out.println(this.getName() + "��������ˡ�");
	}
	
	//��д�������е�show����
	//@Override����дע�ͣ����д�ķ�������û�У����ע������ʾ
	@Override
	public void show() {
		System.out.println(this.getName() + "������" + this.getAge() + "�꣬��" + this.getColor() + "��ɫ��" + this.getSpecies() + "�������ǣ�" + this.getWeight() + "���");
	}
}
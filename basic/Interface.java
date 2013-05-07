package com.bisn.basic;

/*
 * �ӿ���Ҫ������������Ӧ��ӵ��ʲô���Ĺ��ܣ��ɳ䵱ʲô���Ľ�ɫ������������ÿ�����ܵľ���ʵ�֣�����ʵ���ɽӿڵ�ʵ���������С�
 * �ӿڵ�ʵ����ֻҪ����ӿڵ�Ҫ�󼴿ɡ�
 * 
 * �ӿں�����������£�
 * �ӿ��еķ������ǹ����ĳ��󷽷���public abstract�������Ҳ���Ҫ�ṩpublic��abstract�ؼ��֡�
 * ���۱��ʱ�Ƿ���ϡ�public static final�����ӿ��е����Զ��ǹ�����̬������
 * �ӿ���û�й��췽����
 * ����ӿ�֮��Ĵ��븴�ù�ϵ��ʵ�ֶ����м̳С�ʵ����implements��������extends��
 * һ�������ʵ�ֶ���ӿڣ�ʵ�ֶ���ӿ�ʱ�á�,�����������Կ�����һ�ֱ���ļ̳С�
 * �����������ʱ����Ҫ����ӿڶ��󣬽ӿ�Ҳ���ܹ������
 * Java������ʹ�ýӿ����ﵽ��̳е�Ŀ�ĵġ�
 * 
 * ���һ���࣬���ĸ���Ҳ��һ���࣬��ô���Ǽ̳У����ұ����ǵ��̳С�
 * ���һ����ȥ�̳�һ���ӿڣ�Ҫ��implements�ؼ��֡�
 * ���һ���ӿڼ̳���һ���ӿڣ���ôҲ�Ǽ̳У�����һ���ӿڿ��Լ̳ж���ӿڣ��﷨����ļ̳��﷨��ͬ��
 * �ӿ�ֻ�ܼ̳нӿڣ������Լ̳��࣬���������ֹ�ϵ��
 * 
 * ����Java��˵���ӿڱ��ʵ�����ش��ͻ�ƣ��ڱ����Ӧ�þ������ڽӿڵı�̣���Ҫ����ʵ���ı�̡�
 * �ӿڱ�̵����壺
 * �ӿ�ʵ���˶�̳С�
 * �ýӿڿ���ʵ�ֻ�����ͣ������ͣ������ͣ���Java�п���ͨ���ӿڷֳ��������͡�������ʹ�ü̳У�������ʹ�ýӿڡ�
 * �ӿڽ�һ����˱�׼��˼�룬�ӿڱ������һ����׼��
 * �ӿڱ�����˽�������Ե����ã��ӿڿ���ʹ�����Ķ����ʵ������룬���ӿڵ��ƶ��ߺ�ʵ��������롣
 * �ӿڿ������ڽ���ģ����ϵͳ�������ԡ�
 * ��Խӿڱ�̿������β�ͬʵ�ּ�Ĳ��죬������֪ʶʵ�ֺõĹ��ܡ�
 * 
 * �ھۣ�ϵͳ����������ĳ�����������������Ҫ��ӹ���ĸ�Ԥ����������񣬳�Ϊ���ھۡ�
 * ������֮�䡢ģ����ģ��֮�������ϵ�ĸ��Ӷȣ���Ϊ��϶ȡ���϶�Ӧ�ý��ͣ���ʹϵͳ�����ȶ��͸���ά����
 * ������׷����Ǹ��ھۡ�����ϡ�
 * 
 */

public class Interface {

	public static void main(String[] args) {
		String[][] data = {{"����", "�Ա�", "����", "����"}, 
							{"����", "��", "24", "3000"}, 
							{"�Ի�", "��", "26", "3020"}, 
							{"����", "��", "23", "2780"}, 
							{"��", "��", "25", "4000"}, 
							{"չ��", "��", "30", "5999"}, 
							{"����", "��", "32", "100000"}};
		
		//����ʹ���˶�̬���ӿڱ�����������ʵ���˽ӿڵ���Ķ���
		TableModel model = new TableModelA(data);
		model.print();
	}

}

//�ӿڵ�����
interface TableModel {
	public int getColNumber();
	public int getRowNumber();
	public String getValue(int row, int col);
	public String getColName(int col);
	public void print();
}

//�ӿڵ�ʵ��
class TableModelA implements TableModel {
	String[][] data;//���崫������data
	
	public TableModelA(String[][] data) {//����TableModelA���췽��
		this.data = data;
	}
	
	//���ӿڵ�Ҫ��ʵ���䷽��
	public int getColNumber() {
		return data[0].length;
	}
	
	public int getRowNumber() {
		return data.length - 1;
	}
	
	public String getValue(int row, int col) {
		return data[row + 1][col];
	}
	
	public String getColName(int col) {
		return data[0][col];
	}
	
	public void print() {
		System.out.println("��0�����ƣ�" + this.getColName(0));
		System.out.println("��0�еĳ��ȣ�" + this.getColNumber());
		System.out.println("��0�е�0�е�ֵ��" + this.getValue(0, 0));
	}
}

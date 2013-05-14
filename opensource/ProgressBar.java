package com.bisn.opensource;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JProgressBar;

/*
 * ��������ǰ�������У����������������ͷ��ʼ��
 * ����ͣ��ֹͣǰ������ͣ���̰����ûص���㣩��
 * ��������ʼǰ����
 * ��������ǰ������ʱ���Զ��˳����򡣽����������Ӵ�Resize������С��
 */

public class ProgressBar extends Thread implements ActionListener, Runnable {
	// ������������ˮƽ����Сֵ0�����ֵ100����Ĭ��ֵ
	JProgressBar jpb = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
	boolean flag1 = true;// ��������ͣ��־
	boolean flag2 = false;// ���ñ�־

	public void run() {
		jpb.setStringPainted(true);// ���������ֽ����ַ���
		jpb.setBorderPainted(false);// ��������������߿�
		jpb.setForeground(new Color(0, 210, 40));// ���ý�������ǰ��ɫ
		jpb.setBackground(new Color(188, 190, 194));// ���ý������ı���ɫ
		for (int t = 0; t <= 100; t++) {
			while (flag1) {// ��ͣ����������
				if (flag2 == true) {
					t = 0;
					jpb.setValue(t);
					flag2 = false;
				}
			}
			jpb.setValue(t);// ���ý�������ֵ
			if (flag2 == true) {// ��������������
				t = 0;
				jpb.setValue(t);
				flag2 = false;
			}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.exit(0);// ���̽�����رմ����˳�����
	}

	public ProgressBar() {
		// JFrame ���ڵĴ�����
		JFrame frame = new JFrame("������");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 150);
		int WIDTH1 = Toolkit.getDefaultToolkit().getScreenSize().width;
		int HEIGHT1 = Toolkit.getDefaultToolkit().getScreenSize().height;
		int WIDTH2 = frame.getSize().width;
		int HEIGHT2 = frame.getSize().height;
		frame.setLocation((WIDTH1 - WIDTH2) / 2, (HEIGHT1 - HEIGHT2) / 2);
		frame.setVisible(true);
		// JLabel ��ǩ���
		JLabel jl = new JLabel("�������ؼ���ʹ��!", JLabel.CENTER);
		// JButton ��ť���
		JButton jb1 = new JButton("����");
		JButton jb2 = new JButton("��ͣ");
		JButton jb3 = new JButton("����");
		// JPanel �������,�����������������ϱߣ�Ҳ���Ի�ͼ��
		JPanel jp = new JPanel();
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		// ��GridLayout���ֹ��������в���
		GridLayout gl = new GridLayout(3, 1);// 3��1��
		frame.setLayout(gl);
		frame.add(jl);
		frame.add(jpb);
		frame.add(jp);
		// Ϊ��ť���ActionListener������
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// ÿ�β���һ���¼�����ֻ��һ����ť��action
		String ee = e.getActionCommand();
		if (ee.equals("����")) {
			flag1 = false;
		} else if (ee.equals("��ͣ")) {
			flag1 = true;
		} else if (ee.equals("����")) {
			flag2 = true;
		}
	}

	public static void main(String[] args) {
		ProgressBar a = new ProgressBar();
		new Thread(a).start();
	}

}

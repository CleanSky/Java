package com.bisn.opensource;

import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JFrame;

/*
 * �������ڴ�С�仯�¼�
 */

public class WinFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public WinFrame() {
		super("Window����״̬");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowStateListener(new WindowStateListener() {
			public void windowStateChanged(WindowEvent state) {
				if (state.getNewState() == 1 || state.getNewState() == 7) {
					System.out.println("������С��");
				} else if (state.getNewState() == 0) {
					System.out.println("���ڻָ�����ʼ״̬");
				} else if (state.getNewState() == 6) {
					System.out.println("�������");
				}
			}
		});
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new WinFrame();
	}
}

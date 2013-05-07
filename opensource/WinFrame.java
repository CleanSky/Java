package com.bisn.opensource;

import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JFrame;

/*
 * 监听窗口大小变化事件
 */

public class WinFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public WinFrame() {
		super("Window窗口状态");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowStateListener(new WindowStateListener() {
			public void windowStateChanged(WindowEvent state) {
				if (state.getNewState() == 1 || state.getNewState() == 7) {
					System.out.println("窗口最小化");
				} else if (state.getNewState() == 0) {
					System.out.println("窗口恢复到初始状态");
				} else if (state.getNewState() == 6) {
					System.out.println("窗口最大化");
				}
			}
		});
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new WinFrame();
	}
}

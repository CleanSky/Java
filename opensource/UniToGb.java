package com.bisn.opensource;

import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/*
 * 将GB编码转换为Unicode编码
 */

public class UniToGb {
	private static JFrame frame;// 窗体的定义
	private static JTextArea txtUni, txtChn;// 文本区
	private static JButton btnToUni, btnPaste, btnCopy;// 按钮
	private static LinkLabel ll;// 测试带链接的Label

	@SuppressWarnings("static-access")
	public static void main(String args[]) {
		frame = new JFrame(
				"\u6C49\u5B57\u0055\u006E\u0069\u0063\u006F\u0064\u0065\u8F6C\u6362\u5668\u0020\u0062\u0065\u0074\u0061\u0031\u002E\u0030");
		Container content = frame.getContentPane();// 初始化容器
		content.setLayout(null);// 没有固定的布局

		// 汉字文本域
		txtChn = new JTextArea();
		txtChn.setBounds(5, 5, 500, 100);// 文本域位置
		txtChn.setLineWrap(true);// 自动换行
		txtChn.setBackground(Color.lightGray);// 背景颜色
		
		// 转换为Unicode按钮
		btnToUni = new JButton(
				"\u8F6C\u4E3A\u0055\u006E\u0069\u0063\u006F\u0064\u0065");
		btnToUni.setBounds(5, 110, 110, 20);
		btnToUni.addActionListener(new ActionListener() {// 按钮对应的事件处理
			public void actionPerformed(ActionEvent e) {
				String chnStr = txtChn.getText();
				char[] c = chnStr.toCharArray();
				String resultStr = "";
				for (int i = 0; i < c.length; i++) {
					int tmpChar = (int) c[i];
					String tmpStr = "";
					tmpStr = Integer.toHexString(tmpChar).toUpperCase();
					if (tmpStr.length() < 4) {
						resultStr += "\\u00" + tmpStr;
					} else {
						resultStr += "\\u" + tmpStr;
					}
				}
				txtUni.setText(resultStr);
			}
		});
		
		// 粘贴按钮
		btnPaste = new JButton("\u7C98\u8D34\u2191");
		btnPaste.setBounds(335, 110, 80, 20);
		btnPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtChn.setText("");
				txtChn.paste();
			}
		});
		
		// 复制按钮
		btnCopy = new JButton("\u590D\u5236\u2193");
		btnCopy.setBounds(425, 110, 80, 20);
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Clipboard clipboard = toolkit.getSystemClipboard();
				StringSelection stringSel = new StringSelection(txtUni
						.getText());
				clipboard.setContents(stringSel, null);
			}
		});
		
		// Unicode文本域
		txtUni = new JTextArea();
		txtUni.setBounds(5, 135, 500, 100);
		txtUni.setLineWrap(true);
		txtUni.setBackground(Color.PINK);

		//测试带链接的Label
		ll = new LinkLabel("百度一下，你就知道", "http://www.baidu.com");
		ll.setBounds(165, 110, 150, 20);

		// 添加组件至面板
		content.add(txtChn);
		content.add(btnToUni);
		content.add(btnPaste);
		content.add(btnCopy);
		content.add(txtUni);
		content.add(ll);
		
		// frame属性
		frame.setVisible(true);//可见
		frame.setResizable(false);//窗口不能被改变大小
		frame.setSize(520, 270);//窗口大小
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);//关闭窗口
		frame.setLocationRelativeTo(frame.getOwner());//居中呈现窗口
	}
}

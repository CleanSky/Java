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
 * ��GB����ת��ΪUnicode����
 */

public class UniToGb {
	private static JFrame frame;// ����Ķ���
	private static JTextArea txtUni, txtChn;// �ı���
	private static JButton btnToUni, btnPaste, btnCopy;// ��ť
	private static LinkLabel ll;// ���Դ����ӵ�Label

	@SuppressWarnings("static-access")
	public static void main(String args[]) {
		frame = new JFrame(
				"\u6C49\u5B57\u0055\u006E\u0069\u0063\u006F\u0064\u0065\u8F6C\u6362\u5668\u0020\u0062\u0065\u0074\u0061\u0031\u002E\u0030");
		Container content = frame.getContentPane();// ��ʼ������
		content.setLayout(null);// û�й̶��Ĳ���

		// �����ı���
		txtChn = new JTextArea();
		txtChn.setBounds(5, 5, 500, 100);// �ı���λ��
		txtChn.setLineWrap(true);// �Զ�����
		txtChn.setBackground(Color.lightGray);// ������ɫ
		
		// ת��ΪUnicode��ť
		btnToUni = new JButton(
				"\u8F6C\u4E3A\u0055\u006E\u0069\u0063\u006F\u0064\u0065");
		btnToUni.setBounds(5, 110, 110, 20);
		btnToUni.addActionListener(new ActionListener() {// ��ť��Ӧ���¼�����
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
		
		// ճ����ť
		btnPaste = new JButton("\u7C98\u8D34\u2191");
		btnPaste.setBounds(335, 110, 80, 20);
		btnPaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtChn.setText("");
				txtChn.paste();
			}
		});
		
		// ���ư�ť
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
		
		// Unicode�ı���
		txtUni = new JTextArea();
		txtUni.setBounds(5, 135, 500, 100);
		txtUni.setLineWrap(true);
		txtUni.setBackground(Color.PINK);

		//���Դ����ӵ�Label
		ll = new LinkLabel("�ٶ�һ�£����֪��", "http://www.baidu.com");
		ll.setBounds(165, 110, 150, 20);

		// �����������
		content.add(txtChn);
		content.add(btnToUni);
		content.add(btnPaste);
		content.add(btnCopy);
		content.add(txtUni);
		content.add(ll);
		
		// frame����
		frame.setVisible(true);//�ɼ�
		frame.setResizable(false);//���ڲ��ܱ��ı��С
		frame.setSize(520, 270);//���ڴ�С
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);//�رմ���
		frame.setLocationRelativeTo(frame.getOwner());//���г��ִ���
	}
}

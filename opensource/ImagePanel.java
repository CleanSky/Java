package com.bisn.opensource;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 * һ�����Զ�̬����һ��ͼƬ��������Jpanel
 * @author liuxing
 *
 */
public class ImagePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	Image im;
	//���캯���ƶ�JPanel�Ĵ�С
	public ImagePanel(Image im) {
		this.im = im;
		//ϣ����Panel�Ĵ�С������Ӧ��
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(width,height);
	}
	//��������
	@Override
	protected void paintComponent(Graphics g) {
		// ����
		super.paintComponent(g);
		g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}


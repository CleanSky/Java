package com.bisn.opensource;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 * 一个可以动态加载一个图片做背景的Jpanel
 * @author liuxing
 *
 */
public class ImagePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	Image im;
	//构造函数制定JPanel的大小
	public ImagePanel(Image im) {
		this.im = im;
		//希望该Panel的大小事自适应的
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(width,height);
	}
	//画出背景
	@Override
	protected void paintComponent(Graphics g) {
		// 清屏
		super.paintComponent(g);
		g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}


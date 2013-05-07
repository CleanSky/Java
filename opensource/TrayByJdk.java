package com.bisn.opensource;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;

/**
 * 
 * @author Mr.LiuTao
 */
public class TrayByJdk extends JFrame implements ActionListener {

	private JPanel pane = null;
	private JButton button = null; // ��������ͼ��İ�ť
	private JLabel label = null; // ������ʾϵͳ�Ƿ�֧�����̵���Ϣ
	private TrayIcon trayIcon = null; // ����ͼ��
	private Timer shanshuo = null;
	private ImageIcon icon1 = null;
	private ImageIcon icon2 = null;
	private SystemTray tray = null; // ������ϵͳ���̵�ʵ��
	boolean gengai = false;

	// ����jdk1.6�����̼��� ʵ�ֿ�ƽ̨��Ӧ��
	public TrayByJdk() {
		// super("���̼�����ʾ");
		icon1 = new ImageIcon(
				"E:\\Pictures\\CIMG2145.jpg"); // ��Ҫ��ʾ�������е�ͼ��
		icon2 = new ImageIcon(
				"E:\\Pictures\\ͼƬ.jpg"); // ��Ҫ��ʾ�������е�ͼ��
		try {
			// ��LookAndFeel���ó�Windows��ʽ
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		pane = new JPanel();
		button = new JButton("��С������");
		button.setEnabled(false);
		label = new JLabel("������ϵͳ��֧������");
		pane.add(label);
		pane.add(button);
		// �ж��Ƿ�֧������
		if (SystemTray.isSupported()) {
			this.tray();
		}
		shanshuo = new Timer(1000, this);
		shanshuo.start();
		this.getContentPane().add(pane);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 200);
		this.addWindowStateListener(new WindowStateListener() {
			public void windowStateChanged(WindowEvent state) {
				if (state.getNewState() == 1 || state.getNewState() == 7) {
					yinca();
				}
			}
		});

		this.setVisible(false);
		System.out.println("==============" + this.isVisible());
	}

	/**
	 * ������ش���
	 */
	private void tray() {
		label.setText("������ϵͳ֧������");
		button.setEnabled(true);
		tray = SystemTray.getSystemTray(); // ��ñ�����ϵͳ���̵�ʵ��
		// ImageIcon icon = new ImageIcon("tray.gif"); // ��Ҫ��ʾ�������е�ͼ��

		PopupMenu pop = new PopupMenu(); // ����һ���Ҽ�����ʽ�˵�
		MenuItem show = new MenuItem("��ʾ����");
		MenuItem exit = new MenuItem("�˳���ʾ");
		MenuItem author = new MenuItem("Author");

		/**
		 * TrayIcon���������� TrayIcon(Image image) �á�ͼ�ꡱ������ TrayIcon(Image image,
		 * String tooltip) �á�ͼ�ꡱ�͡�ToolTip������ TrayIcon(Image image, String
		 * tooltip, PopupMenu popup) �á�ͼ�ꡱ����ToolTip�����������˵���������һ������ͼ��
		 */
		trayIcon = new TrayIcon(icon1.getImage(), "���̼�����ʾ", pop);
		// �������ť�󴰿ڱ��رգ�����ͼ�걻��ӵ�ϵͳ��������
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					tray.add(trayIcon); // ������ͼ����ӵ�ϵͳ������ʵ����
					setVisible(false); // ʹ���ڲ�����
				} catch (AWTException ex) {
					ex.printStackTrace();
				}
			}
		});
		
		/**
		 * ������������������������ͼ����˫��ʱ��Ĭ����ʾ����
		 */
		trayIcon.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) { // ���˫��
					tray.remove(trayIcon); // ��ϵͳ������ʵ�����Ƴ�����ͼ��
					setVisible(true); // ��ʾ����
				}
			}
		});
		show.addActionListener(new ActionListener() { // �������ʾ���ڡ��˵��󽫴�����ʾ����

			public void actionPerformed(ActionEvent e) {
				tray.remove(trayIcon); // ��ϵͳ������ʵ�����Ƴ�����ͼ��
				setVisible(true); // ��ʾ����
			}
		});
		exit.addActionListener(new ActionListener() { // ������˳���ʾ���˵����Ƴ�����

			public void actionPerformed(ActionEvent e) {
				System.exit(0); // �˳�����
			}
		});
		author.addActionListener(new ActionListener() { // ������˳���ʾ���˵����Ƴ�����

			public void actionPerformed(ActionEvent e) {
				showMessage();
			}
		});
		pop.add(show);
		pop.add(exit);
		pop.add(author);
	}

	/**
	 * ��ʾ��Ϣ
	 */
	private void showMessage() {
		JOptionPane.showMessageDialog(this, new JLabel("����һ��ϵͳ����"), "��Ϣ",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public static void main(String[] args) {
		new TrayByJdk().yinca();
	}

	public void yinca() {
		try {
			tray.add(trayIcon);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // ������ͼ����ӵ�ϵͳ������ʵ����
		setVisible(false); // ʹ���ڲ�����
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (!gengai) {
			trayIcon.setImage(icon2.getImage());
			gengai = true;
		} else {
			trayIcon.setImage(icon1.getImage());
			gengai = false;
		}
	}

}

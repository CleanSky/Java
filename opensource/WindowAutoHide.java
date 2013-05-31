package com.bisn.opensource;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.Timer;

/*
Swing中窗体移到屏幕边缘自动隐藏
使用方法：new WindowAutoHide(window);  //window为java.awt.Window或其子类

根据实际需要，有以下参数可调：
int step，每次移动的像素，可以间接控制速度，默认5，JDK7下与QQ中的隐藏速度相当，JDK6中要设成10，估计JDK7中对javax.swing.Timer做了优化
int rim，隐藏后暴露在屏幕中供鼠标移入后显示的区域的宽度或高度，默认2
int hideDelay，鼠标移出后隐藏窗体的延时毫秒数，默认230
int hideDirection，窗体在屏幕的左、右、上、下哪个方向可隐藏，默认左、右、上，HIDE_DIRECTION_LEFT、HIDE_DIRECTION_RIGHT、HIDE_DIRECTION_TOP、HIDE_DIRECTION_BOTTOM的任意一个或者多个的按位或
boolean limitLocation，为true时在hideDirection中所描述的方向，窗体不能移出屏幕外，默认true
 */

public class WindowAutoHide implements MouseMotionListener, ActionListener,
		ComponentListener, WindowStateListener {
	public static final int HIDE_DIRECTION_LEFT = 1;
	public static final int HIDE_DIRECTION_RIGHT = 1 << 1;
	public static final int HIDE_DIRECTION_TOP = 1 << 2;
	public static final int HIDE_DIRECTION_BOTTOM = 1 << 3;
	public static final int HIDE_DIRECTION_ALL = HIDE_DIRECTION_LEFT
			| HIDE_DIRECTION_RIGHT | HIDE_DIRECTION_TOP | HIDE_DIRECTION_BOTTOM;

	private Window window;
	private HiddenPosition hiddenPos;
	private Timer hideTimer, mouseTimer;
	private Point oldLocation, newLocation, tempLocation;
	private boolean mouseIn;
	private int step;
	private int rim;
	private int hideDelay;
	private int hideDirection;
	private boolean limitLocation;

	public WindowAutoHide(Window window) {
		this.window = window;
		this.step = 5;
		this.rim = 2;
		this.hideDelay = 230;
		this.hideDirection = HIDE_DIRECTION_LEFT | HIDE_DIRECTION_RIGHT
				| HIDE_DIRECTION_TOP;
		this.limitLocation = true;
		this.hideTimer = new Timer(0, this);
		this.mouseTimer = new Timer(0, this);
		this.newLocation = new Point();
		this.tempLocation = new Point();
		window.addMouseMotionListener(this);
		window.addComponentListener(this);
		window.addWindowStateListener(this);
	}

	private void hideOrShow() {
		Point location = window.getLocation();
		double deltaX = newLocation.getX() - oldLocation.getX();
		double deltaY = newLocation.getY() - oldLocation.getY();
		boolean finished = false;

		if (deltaX == 0) {
			if (deltaY < 0) {
				tempLocation.setLocation(location.getX(), location.getY()
						- step);

				if (tempLocation.getY() <= newLocation.getY()) {
					tempLocation.setLocation(newLocation);
					finished = true;
				}
			} else {
				tempLocation.setLocation(location.getX(), location.getY()
						+ step);

				if (tempLocation.getY() >= newLocation.getY()) {
					tempLocation.setLocation(newLocation);
					finished = true;
				}
			}

			window.setLocation(tempLocation);
		} else if (deltaY == 0) {
			if (deltaX < 0) {
				tempLocation.setLocation(location.getX() - step,
						location.getY());

				if (tempLocation.getX() <= newLocation.getX()) {
					tempLocation.setLocation(newLocation);
					finished = true;
				}
			} else {
				tempLocation.setLocation(location.getX() + step,
						location.getY());

				if (tempLocation.getX() >= newLocation.getX()) {
					tempLocation.setLocation(newLocation);
					finished = true;
				}
			}

			window.setLocation(tempLocation);
		}

		if (finished) {
			hideTimer.stop();
		}
	}

	private void mouseExited(Point mouseLocation) {
		checkTimer();
		hideTimer.setInitialDelay(hideDelay);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		if (window.getX() <= 0 && (hideDirection & HIDE_DIRECTION_LEFT) != 0) {
			oldLocation = window.getLocation();
			newLocation.setLocation(-window.getWidth() + rim, window.getY());
			hiddenPos = HiddenPosition.LEFT;
			hideTimer.start();
		} else if (window.getX() >= screenSize.getWidth() - window.getWidth()
				&& (hideDirection & HIDE_DIRECTION_RIGHT) != 0) {
			oldLocation = window.getLocation();
			newLocation.setLocation(screenSize.getWidth() - rim, window.getY());
			hiddenPos = HiddenPosition.RIGHT;
			hideTimer.start();
		} else if (window.getY() <= 0
				&& (hideDirection & HIDE_DIRECTION_TOP) != 0) {
			oldLocation = window.getLocation();
			newLocation.setLocation(window.getX(), -window.getHeight() + rim);
			hiddenPos = HiddenPosition.TOP;
			hideTimer.start();
		} else if (window.getY() >= screenSize.getHeight() - window.getHeight()
				&& (hideDirection & HIDE_DIRECTION_BOTTOM) != 0) {
			oldLocation = window.getLocation();
			newLocation
					.setLocation(window.getX(), screenSize.getHeight() - rim);
			hiddenPos = HiddenPosition.BOTTOM;
			hideTimer.start();
		}
	}

	private void mouseEntered(Point mouseLocation) {
		checkTimer();
		hideTimer.setInitialDelay(0);

		if (hiddenPos != null && hideDirection > 0) {
			oldLocation = window.getLocation();

			if (hiddenPos == HiddenPosition.LEFT
					&& (hideDirection & HIDE_DIRECTION_LEFT) != 0) {
				newLocation.setLocation(0, window.getY());
			} else if (hiddenPos == HiddenPosition.RIGHT
					&& (hideDirection & HIDE_DIRECTION_RIGHT) != 0) {
				Dimension screenSize = Toolkit.getDefaultToolkit()
						.getScreenSize();
				newLocation.setLocation(
						screenSize.getWidth() - window.getWidth(),
						window.getY());
			} else if (hiddenPos == HiddenPosition.TOP
					&& (hideDirection & HIDE_DIRECTION_TOP) != 0) {
				newLocation.setLocation(window.getX(), 0);
			} else if (hiddenPos == HiddenPosition.BOTTOM
					&& (hideDirection & HIDE_DIRECTION_BOTTOM) != 0) {
				Dimension screenSize = Toolkit.getDefaultToolkit()
						.getScreenSize();
				newLocation.setLocation(window.getX(), screenSize.getHeight()
						- window.getHeight());
			}

			hideTimer.start();
		}
	}

	private void checkTimer() {
		if (hideTimer.isRunning()) {
			hideTimer.stop();
		}
	}

	public int getStep() {
		return this.step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getRim() {
		return this.rim;
	}

	public void setRim(int rim) {
		this.rim = rim;
	}

	public int getHideDelay() {
		return this.hideDelay;
	}

	public void setHideDelay(int hideDelay) {
		this.hideDelay = hideDelay;
	}

	public int getHideDirection() {
		return this.hideDirection;
	}

	public void setHideDirection(int hideDirection) {
		this.hideDirection = hideDirection;
	}

	public boolean isLimitLocation() {
		return this.limitLocation;
	}

	public void setLimitLocation(boolean limitLocation) {
		this.limitLocation = limitLocation;
	}

	public void windowStateChanged(WindowEvent e) {
		mouseIn = false;
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (!window.isDisplayable()) {
			if (hideTimer.isRunning()) {
				hideTimer.stop();
			}

			mouseTimer.stop();
		} else if (window.isVisible()) {
			if (source == mouseTimer) {
				mouseMoved(null);
			} else if (source == hideTimer) {
				hideOrShow();
			}
		}
	}

	public void mouseDragged(MouseEvent e) {
		hiddenPos = null;
	}

	public void mouseMoved(MouseEvent e) {
		if (e == null) {
			if (window instanceof Frame
					&& ((Frame) window).getExtendedState() != Frame.NORMAL) {
				return;
			}

			Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
			boolean mouseIn = window.getBounds().contains(mouseLocation);

			if (this.mouseIn != mouseIn) {
				if (mouseIn) {
					this.mouseIn = mouseIn;
					mouseEntered(mouseLocation);
				} else if (!mouseIn) {
					this.mouseIn = mouseIn;
					mouseExited(mouseLocation);
				}
			}
		}
	}

	public void componentMoved(ComponentEvent e) {
		if (limitLocation && hiddenPos == null) {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int deltaWidth = screenSize.width - window.getWidth();
			int deltaHeight = screenSize.height - window.getHeight();

			if (window.getX() < 0 && (hideDirection & HIDE_DIRECTION_LEFT) != 0) {
				window.setLocation(0, window.getY());
			} else if (window.getX() > deltaWidth
					&& (hideDirection & HIDE_DIRECTION_RIGHT) != 0) {
				window.setLocation(deltaWidth, window.getY());
			} else if (window.getY() < 0
					&& (hideDirection & HIDE_DIRECTION_TOP) != 0) {
				window.setLocation(window.getX(), 0);
			} else if (window.getY() > deltaHeight
					&& (hideDirection & HIDE_DIRECTION_BOTTOM) != 0) {
				window.setLocation(window.getX(), deltaHeight);
			}
		}
	}

	public void componentShown(ComponentEvent e) {
		if (!mouseTimer.isRunning()) {
			mouseTimer.start();
		}
	}

	public void componentHidden(ComponentEvent e) {
	}

	public void componentResized(ComponentEvent e) {
	}

	private static enum HiddenPosition {
		LEFT, RIGHT, TOP, BOTTOM
	}
}
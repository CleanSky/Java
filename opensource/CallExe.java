package com.bisn.opensource;

/*
 * Java����CMD����
 */

public class CallExe {
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		Process p = null;
		String fileLac = "";
		try {
			fileLac = "D:\\Program Files\\kuwo\\KWMUSIC2013\\KwMusic.exe";// �����õĳ���·��
			p = rt.exec(fileLac);
		} catch (Exception e) {
			System.out.println("open failure");
		}
	}
}
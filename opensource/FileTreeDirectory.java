package com.bisn.opensource;

import java.io.File;

/*
 * ��java�ݹ�˼��ʵ��Ŀ¼������չʾ
 * �����η�ʽչ�ֳ���Ŀ¼�е�������Ŀ¼���ļ�
 */

public class FileTreeDirectory {

	public static int count = 0;

	public static void parse(File[] files) {
		if (files.length == 0) {
			FileTreeDirectory.count--;
			System.out.println();
			return;
		} else {
			for (File f : files) {
				if (f.isDirectory()) {
					FileTreeDirectory.count++;
					for (int i = 1; i <= FileTreeDirectory.count; i++) {
						System.out.print("\t");
					}

					System.out.println(f.getName());
					File[] files2 = f.listFiles();

					FileTreeDirectory.parse(files2);
				}

			}
			for (File f : files) {
				if (!f.isDirectory()) {
					for (int i = 0; i <= FileTreeDirectory.count; i++) {
						System.out.print("\t");
					}
					System.out.println(f.getName());
				}
			}
			FileTreeDirectory.count--;
		}
	}

	public static void main(String[] args) {
		File file = new File("C:\\Program Files\\Java\\jre6");
		File[] files = file.listFiles();
		FileTreeDirectory.parse(files);
	}

}

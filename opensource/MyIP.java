package com.bisn.opensource;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.Scanner;

/*
 * �ж�����IP��ַ������
 */

public class MyIP {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.println("����Ҫ�ж�IP��ַ������������վ����");
		String host = input.next();

		InetAddress address = InetAddress.getByName(host);
		System.out.println("IP: " + address.getHostAddress());
		
		//����byte���鳤���ж�
		switch (address.getAddress().length) {
		case 4:
			System.out.println("����byte���鳤���ж����IP��ַ��IPv4��ַ!");
			break;
		case 16:
			System.out.println("����byte���鳤���ж����IP��ַ��IPv6��ַ!");
			break;
		}

		//����instanceof�ж�
		if (address instanceof Inet4Address) {
			System.out.println("ʹ��instanceof�ж����IP��ַ��IPv4��ַ!");
		}
		if (address instanceof Inet6Address) {
			System.out.println("ʹ��instanceof�ж����IP��ַ��IPv6��ַ!");
		}
	}
}

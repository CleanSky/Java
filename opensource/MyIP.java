package com.bisn.opensource;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.Scanner;

/*
 * 判断主机IP地址及分类
 */

public class MyIP {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.println("输入要判断IP地址的主机名（网站）：");
		String host = input.next();

		InetAddress address = InetAddress.getByName(host);
		System.out.println("IP: " + address.getHostAddress());
		
		//根据byte数组长度判断
		switch (address.getAddress().length) {
		case 4:
			System.out.println("根据byte数组长度判断这个IP地址是IPv4地址!");
			break;
		case 16:
			System.out.println("根据byte数组长度判断这个IP地址是IPv6地址!");
			break;
		}

		//根据instanceof判断
		if (address instanceof Inet4Address) {
			System.out.println("使用instanceof判断这个IP地址是IPv4地址!");
		}
		if (address instanceof Inet6Address) {
			System.out.println("使用instanceof判断这个IP地址是IPv6地址!");
		}
	}
}

package com.bisn.opensource;

public class Simplified_Traditional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "�ҹ���,���,���";
		String encode = "GB2312";
		
		//Ԓ�f     BIG5
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                System.out.println("�Ǽ���");
            }else{
            	System.out.println("�Ƿ���");
            }
        } catch (Exception exception3) {
        }
	}

}

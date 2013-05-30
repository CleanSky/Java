package com.bisn.opensource;

public class Simplified_Traditional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "我哈哈,你好,香港";
		String encode = "GB2312";
		
		//話說     BIG5
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                System.out.println("是简体");
            }else{
            	System.out.println("是繁体");
            }
        } catch (Exception exception3) {
        }
	}

}

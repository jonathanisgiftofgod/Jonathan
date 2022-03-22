package com.interview;

public class Interview1 {
	public static void main(String[] args) {
		String s = "Bri*tto! Jose@ph&";
		int i = s.length();
		while (i>0) {
			char c = s.charAt(i-1);
			if (c<57&&c>32) {
				System.out.print(c);
			}			
			i--;
		}	
	}
}

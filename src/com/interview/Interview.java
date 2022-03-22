package com.interview;

public class Interview {
	public static void main(String[] args) {
		String s = "Britto Joseph";
		int i = s.length();
		while (i>0) {
			System.out.print(s.charAt(i-1));
			i--;
		}	
	}
}

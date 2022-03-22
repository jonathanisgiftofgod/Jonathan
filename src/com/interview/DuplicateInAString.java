package com.interview;

public class DuplicateInAString {
	public static void main(String[] args) {
		String s = "Britto is a good boy Britto is a handsome boy";
		String output = " ";
		String[] a = s.split(" ");
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if(a[i].equalsIgnoreCase(a[j])) {
					output = output + a[i];
				}
			}
		}
		System.out.println(output);
	}
}

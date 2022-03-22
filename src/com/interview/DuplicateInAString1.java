package com.interview;

import java.util.HashMap;

public class DuplicateInAString1 {
	public static void main(String[] args) {
		String s = "Britto is a good boy Britto is a handsome boy";
		String output = " ";
		String[] a = s.split(" ");
		HashMap<String, Integer> h = new HashMap<>();
		for (String x : a) {
			if (h.get(x)!=null) {
				h.put(x, h.get(x)+1);
			} else {
				h.put(x, 1);
			}
			if (h.get(x)>1) {
				System.out.println(h);
			}
		}
		
	}
}

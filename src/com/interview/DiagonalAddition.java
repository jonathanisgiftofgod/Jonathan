package com.interview;

import java.util.Scanner;

public class DiagonalAddition {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the size of the square matrix: ");
		int size = input.nextInt(), lsum=0, rsum=0;
		int a[][] = new int [size][size]; 
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				a[row][col] = input.nextInt();
			}
		}
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (row==col) {
					System.out.println("Left Diagonal Sum : " + a[row][col]);
					lsum = lsum + a[row][col];
				}
			}
		}
		
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if ((row+col)==(size-1)) {
					System.out.println("Right Diagonal Sum : " + a[row][col]);
					rsum = rsum + a[row][col];
				}
			}
		}
		System.out.println("Left Diagonal Sum : " + lsum);
		System.out.println("Right Diagonal Sum : " + rsum);
	}
}

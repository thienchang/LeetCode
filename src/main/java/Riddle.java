package main.java;

import java.util.Arrays;

public class Riddle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {9, 6, 3, 4, 5, 6};
		Arrays.toString(A);
		int n = A.length;
		System.out.println("De quy tim so nho nhat trong mang: " + Riddle(A, n));
	}
	
	private static int Riddle(int[] A, int n) {
		int temp;
		if (n == 1) {
			System.out.println("Temp = " + A[0]);
			return A[0];
		}
		System.out.println("Phan tu thu: " + A[n-1]);
		temp = Riddle(A, n - 1);
		if (temp <= A[n-1]) {
			System.out.println("if: Temp = " + temp);
			return temp;
		} else {
			System.out.println("else Temp = " + A[n-1]);
			return A[n-1];
		}
	}

}

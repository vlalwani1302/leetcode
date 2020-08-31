package leetcode.john.medium;

import java.io.IOException;

public class RotateImage {
	 public static void rotate(int[][] matrix) {
	        transpose(matrix);
	        flip(matrix); // flipping horizontally left to right (along y axis)
	    }
	 

	private static void transpose(int[][] matrix) {
		 int n = matrix.length;
		 for(int i=0; i<n; i++) {
	        	for(int j=i; j<n; j++) {
	        		int temp = matrix[i][j];
	        		matrix[i][j] = matrix[j][i];
	        		matrix[j][i] = temp;
	        	}
	        }
	}
	
	// flip horizontal using 2 pointers
	private static void flip(int[][] matrix) {
		int n = matrix.length;
		for(int i=0; i<n; i++) {
			int l = 0; int r = n-1;
			while(l<r) {
				int temp = matrix[i][l];
				matrix[i][l] = matrix[i][r];
				matrix[i][r] = temp;
				l++;
				r--;
			}
		}
	}

	public static void main(String[] args) throws IOException {

		 int[][] matrix = { 
				 				{1, 2, 3},
				 				{4, 5, 6},
				 				{7, 8, 9}
		 					};
		 rotate(matrix);
		 rotate(matrix);
		 System.out.println("\nRotated matrix1:");
		 for(int i=0; i<matrix.length; i++) {
			 for(int j=0; j< matrix[0].length; j++) {
				 System.out.print(matrix[i][j] + " ");
			 }
			 System.out.println();
		 }
		 
		 
		 int[][] matrix2 = { 
				 {5, 1, 9, 11},
				 {2, 4, 8, 10},
				 {13, 3, 6, 7},
				 {15, 14, 12, 16}
		 };
		 System.out.println("\nRotated matrix2:");
		 rotate(matrix2);
		 for(int i=0; i<matrix2.length; i++) {
			 for(int j=0; j< matrix2[0].length; j++) {
				 System.out.print(matrix2[i][j]+ " ");
			 }
			 System.out.println();
		 }

		}
}

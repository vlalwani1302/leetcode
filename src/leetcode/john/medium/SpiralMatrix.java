package leetcode.john.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		int size = matrix.length * matrix[0].length;
		int l = 0; int r = matrix[0].length;
		int top = 0; int bot = matrix.length;
		while(result.size() < size) {
			// left to right
			for(int i=l; i<r; i++) {
				result.add(matrix[top][i]);//top row
			}
			top++;
			// top to bottom
			for(int i=top; i<bot; i++) {
				result.add(matrix[i][r-1]);//right col
			}
			r--;
			// right to left
			for(int i=r-1; i>l; i--) {
				result.add(matrix[bot-1][i]);// bot row
			}
			bot--;
			// botton to top
			for(int i=bot; i>top; i--) {
				result.add(matrix[i][l]);//left col
			}
		}
		return result;
    }
	 


	public static void main(String[] args) {

		 int[][] matrix = { 
				 				{1, 2, 3},
				 				{4, 5, 6},
				 				{7, 8, 9}
		 					};
		 List<Integer> result1 = spiralOrder(matrix);
		 System.out.println("matrix1:");
		 for(int i=0; i<matrix.length; i++) {
			 for(int j=0; j< matrix[0].length; j++) {
				 System.out.print(matrix[i][j] + " ");
			 }
			 System.out.println();
		 }
		 System.out.println("Spiral matrix1:");
		 System.out.println(result1);
		 
		 int[][] matrix2 = { 
				 {1, 2, 3, 4},
				 {5, 6, 7, 8},
				 {9, 10, 11, 12},
				 {13, 14, 15, 16}
		 };
		 System.out.println("matrix2:");
		 List<Integer> result2 = spiralOrder(matrix2);
		 for(int i=0; i<matrix2.length; i++) {
			 for(int j=0; j< matrix2[0].length; j++) {
				 System.out.print(matrix2[i][j]+ " ");
			 }
			 System.out.println();
		 }
		 System.out.println("Spiral matrix2:");
		 System.out.println(result2);

		}
}

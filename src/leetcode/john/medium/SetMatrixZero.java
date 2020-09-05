package leetcode.john.medium;

public class SetMatrixZero {
	public static void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[] rows = new int[m];
		int[] cols = new int[n];
		for(int i=0; i<m; i++) {
	    	for(int j=0; j<n; j++) {
	    		if(matrix[i][j] == 0) {
	    			rows[i] = -1;
	    			cols[j] = -1;
	    		}
	    	}
	    }
		// Set zeroes
		for(int i=0; i<m; i++) {
	    	for(int j=0; j<n; j++) {
	    		if(rows[i] == -1 || cols[j] == -1) {
	    			matrix[i][j] = 0;
	    		}
	    	}
	    }
		 
    }
	 

	public static void main(String[] args) {

		 int[][] matrix = { 
				 				{1, 1, 1},
				 				{1, 0, 0},
				 				{1, 1, 1}
		 					};
		 setZeroes(matrix);
		 System.out.println("\nZero matrix1:");
		 for(int i=0; i<matrix.length; i++) {
			 for(int j=0; j< matrix[0].length; j++) {
				 System.out.print(matrix[i][j] + " ");
			 }
			 System.out.println();
		 }
		 
		 
//		 int[][] matrix2 = { 
//				 {5, 1, 9, 11},
//				 {2, 4, 8, 10},
//				 {13, 3, 6, 7},
//				 {15, 14, 12, 16}
//		 };
//		 System.out.println("\nRotated matrix2:");
//		 rotate(matrix2);
//		 for(int i=0; i<matrix2.length; i++) {
//			 for(int j=0; j< matrix2[0].length; j++) {
//				 System.out.print(matrix2[i][j]+ " ");
//			 }
//			 System.out.println();
//		 }

		}
}

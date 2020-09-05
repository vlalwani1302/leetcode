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
	
	public static void setZeroesConstantSpace(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean firstRowZero = false;
		boolean firstColZero = false;
		
		for(int i=0; i<n; i++) {
			if(matrix[0][i] == 0) {
				firstRowZero = true;
			}
		}
		for(int i=0; i<m; i++) {
			if(matrix[i][0] == 0) {
				firstRowZero = true;
			}
		}
		
		for(int i=1; i<m; i++) {
	    	for(int j=1; j<n; j++) {
	    		if(matrix[i][j] == 0) {
	    			matrix[i][0] = 0;
	    			matrix[0][j] = 0;
	    		}
	    	}
	    }
		// Set zeroes
		for(int i=1; i<m; i++) {
	    	for(int j=1; j<n; j++) {
	    		if(matrix[i][0] == 0 || matrix[0][j] == 0) {
	    			matrix[i][j] = 0;
	    		}
	    	}
	    }
		
		// finaly first row and col
		if(firstRowZero) {
			for(int i=0; i<n; i++) {
				matrix[0][i] = 0;
			}
		}
		if(firstColZero) {
			for(int i=0; i<m; i++) {
				matrix[i][0] = 0;
			}
		}
		 
    }
	 

	public static void main(String[] args) {

		 int[][] matrix = { 
				 				{1, 1, 1},
				 				{1, 0, 0},
				 				{1, 1, 1}
		 					};
		 setZeroesConstantSpace(matrix);
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

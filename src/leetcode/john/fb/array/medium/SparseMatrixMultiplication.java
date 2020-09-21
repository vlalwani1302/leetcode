package leetcode.john.fb.array.medium;

public class SparseMatrixMultiplication {
	
	//Brute Force - O(n3)
	public int[][] multiply1(int[][] A, int[][] B) {
	    int[][] C = new int[A.length][B[0].length];
	    for(int i=0; i<C.length; i++){
	        for(int j=0; j<C[0].length; j++){
	            int sum=0;
	            for(int k=0; k<A[0].length; k++){
	                sum += A[i][k]*B[k][j];
	            }
	            C[i][j] = sum;
	        }
	    }
	    return C;
	}
		
	// Using Sparse matrix property = most of the elements are zero
	// almost O(n2) in real time
	public int[][] multiply(int[][] A, int[][] B) {
	    int[][] C = new int[A.length][B[0].length];
	    for(int i=0; i<C.length; i++){
	        for(int k=0; k<A[0].length; k++){
	            if(A[i][k]!=0){
	                for(int j=0; j<C[0].length; j++){
	                    C[i][j] += A[i][k]*B[k][j];
	                }
	            }
	        }
	    }
	    return C;
	}

}
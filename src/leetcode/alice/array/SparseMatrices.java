package leetcode.alice.array;
class SparseMatrices {
    public int[][] multiply1(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        
        for(int i=0; i<result.length ; i++){
            for(int j=0; j<result[0].length; j++){
                int sum=0;
                
                for(int k=0; k<A[0].length;k++){
                    sum+= A[i][k] * B[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
    
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        
        for(int i=0; i<result.length ; i++){
            for(int k=0; k<A[0].length; k++){
                if(A[i][k] != 0){
                    for(int j=0; j<result[0].length;j++){
                        result[i][j]+= A[i][k] * B[k][j];
                    }
                    
                }                
            }
        }
        return result;
    }
}
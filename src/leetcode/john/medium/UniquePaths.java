package leetcode.john.medium;

public class UniquePaths {
	
	// unique paths recursion - time limit exceeded
	public static int uniquePathsRecursion(int m, int n) {
        if(m==1 || n==1) {
        	return 1;
        }
        return uniquePathsRecursion(m-1, n) + uniquePathsRecursion(m, n-1);
    }
	
	// Using dynamic programming
	public static int uniquePathsDp(int m, int n) {
        int dp[][] = new int[m][n];
        // fill first col = 1 since one way only for them to reach end
        for(int i=0; i<m; i++) {
        	dp[i][0] = 1;
        }
        // fill first row = 1 since one way only for them to reach end
        for(int i=0; i<n; i++) {
        	dp[0][i] = 1;
        }
        // add for each of the rest of places with box above + box to left
        for(int i=1; i<m; i++) {
        	for(int j=1; j<n; j++) {
        		dp[i][j] = dp[i-1][j] + dp[i][j-1];
        	}
        }
        return dp[m-1][n-1];
    }
	 


	public static void main(String[] args) {

		 Integer result1 = uniquePathsRecursion(51,9);
		 Integer result2 = uniquePathsDp(51,9);
		 System.out.println(result1);
		 System.out.println(result2);
		}
}

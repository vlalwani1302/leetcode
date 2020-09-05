package leetcode.john.easy;

import java.math.BigDecimal;

public class ClimbingStairs {
	public static int climbStairs(int n) {
        int result = 0;
        for(int y=0; y<=n/2; y++) {
        	//x = n-2*y
        	int x = n-2*y;
        	int total = x+y; // total items to arrange
        	result = result + nCr(total, y).intValue();
        }
		return result;
    }
	
	static BigDecimal nCr(int n, int r) 
	{ 
	    return fact(n).divide(fact(r).multiply(fact(n - r))); 
	} 
	  
	// Returns factorial of n 
	static BigDecimal fact(int n) 
	{ 
		BigDecimal res = BigDecimal.ONE; 
	    for (int i = 2; i <= n; i++) 
	        res = res.multiply(BigDecimal.valueOf(i)); 
	    return res; 
	} 
	
	// Dynamic Programming
	public static int climbStairsDP(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
        	dp[i] = dp[i-2] + dp[i-1];
        }
		return dp[n];
    }
	
	public static void main(String[] args) {
		System.out.println(climbStairs(35));
		System.out.println(climbStairsDP(35));
	}
}

package leetcode.john.easy;

import java.io.IOException;

public class MaxSubArray {
	public static int maxSubArray(int[] nums) {
		int maxSum = 0;
		int N = nums.length;
		
		for(int i=0; i < N; i++) {
			int currentSum = 0;
			for(int j=i; j<N; j++) {
				if(i==0 && j==0) {
					// very first sum, hence take maxSum as first number to handle if maximum sum is negative
					maxSum = nums[j];
				}
				currentSum = currentSum + nums[j];
				maxSum = Math.max(maxSum, currentSum);
			}
		}
		return maxSum;
    }
	
	public static void main(String[] args) throws IOException {
        int[] arrItems1 = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        int[] arrItems2 = new int[] {-1};

        int result = maxSubArray(arrItems1);
        System.out.println(result);
	}
}

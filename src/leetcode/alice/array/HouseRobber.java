package leetcode.alice.array;

class HouseRobber {
	
	public static void main(String[] args) {
		System.out.println(rob(new int[] {1,2,3,1}));
	}
	public static int rob(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return n;
		}
		if (n == 1) {
			return nums[0];
		}
		if (n == 2) {
			return Math.max(nums[0], nums[1]);
		}
		int[] dp = new int[n];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int j = 2; j < n; j++) {
			dp[j] = Math.max(nums[j] + dp[j - 2], dp[j - 1]);
		}
		return dp[n - 1];

	}

}
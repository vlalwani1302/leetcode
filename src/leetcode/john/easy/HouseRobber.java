package leetcode.john.easy;

class HouseRobber {
	
	public static void main(String[] args) {
		System.out.println(rob(new int[] {1,3,1,3,100}));
		System.out.println(robRecursive(new int[] {1,3,1,3,100}));
	}
	public static int rob(int[] nums) {
		int n = nums.length;
		if (nums == null || n == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
		}
		return dp[n-1];
	}
	
	public static int robRecursive(int[] nums) {
		return robRecursive(nums, 0);
	}
	
	public static int robRecursive(int[] nums, int i) {
		if (i >= nums.length) {
			return 0;
		}
		return Math.max(nums[i] + robRecursive(nums, i+2),robRecursive(nums, i+1));
	}

}
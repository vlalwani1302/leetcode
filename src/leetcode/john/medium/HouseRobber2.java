package leetcode.john.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HouseRobber2 {
	
	public static void main(String[] args) {
		System.out.println(rob(new int[] {2,3,2}));
	}
	
	public static int rob(int[] nums) {
		int n = nums.length;
		if (nums == null || n == 0) {
			return 0;
		}
		if (n == 1) {
			return nums[0];
		}
		if (n == 2) {
			return Math.max(nums[0], nums[1]);
		}
		List<Integer> startList = Arrays.stream(nums).boxed().collect(Collectors.toList());
		startList.remove(n-1);
		List<Integer> endList =Arrays.stream(nums).boxed().collect(Collectors.toList());
		endList.remove(0);
		return Math.max(houseRobber1(startList.toArray(new Integer[n-1])), houseRobber1(endList.toArray(new Integer[n-1])));
	}
	
	public static int houseRobber1(Integer[] nums) {
		int n = nums.length;
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
		}
		return dp[n-1];
	}
	
}
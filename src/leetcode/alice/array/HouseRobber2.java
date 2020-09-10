package leetcode.alice.array;
class HouseRobber2 {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int n = nums.length;
        int maxA = maxRob(nums, 0, n-2);
        int maxB = maxRob(nums, 1, n-1);
        
        return Math.max(maxA, maxB);
    }
    
    public int maxRob(int[] nums, int i, int j){
        if(i == j){
            return nums[i];
        }
        
        int[] dp = new int[nums.length];
        dp[i] = nums[i];
        dp[i+1] = Math.max(nums[i+1],dp[i]);
        
        for(int k=i+2; k <=j; k++){
            dp[k] = Math.max(nums[k] + dp[k-2], dp[k-1]);
        }
        return dp[j];
    }
}
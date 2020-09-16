package leetcode.john.easy;

public class MissingNumber {

	public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum +=nums[i];
        }
        int n = nums.length; // n natural numbers ( 1 missing in array hence n = length)
        int total = n * (n+1) / 2;
        return total-sum;
    }
}
package leetcode.alice.array;

import java.util.Arrays;

class MissingNumber {
    public int missingNumberOld(int[] nums) {
        
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(nums[i] != i){
                return i;
            }
        }
        
        return nums.length;
    }
    
    public int missingNumber(int[] nums) {
        
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum +=nums[i];
            
        }
        
        int n = nums.length -1;
        int total = n * (n+1) / 2;
        if( total != sum){
            int diff = sum - total;
            return nums.length > diff ? nums.length - diff : diff - nums.length;
        }
        return nums.length;
    }
}
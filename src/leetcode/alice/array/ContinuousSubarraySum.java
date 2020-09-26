package leetcode.alice.array;
class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        k = Math.abs(k);
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum = nums[i];
            for(int j=i+1; j<nums.length; j++){
                sum+=nums[j];
                if((k >0 && sum >= k && sum%k == 0) || (k==0 && sum == k) || sum == 0){
                    return true;
                }
            }
        }
        return false;
    }
}
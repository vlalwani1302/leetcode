package leetcode.alice.array;
class MaximumProductSubArray {
	public static void main(String[] args) {
		int[] arr = new int[] {2,3,-2,4};
		System.out.println(maxProduct(arr));
	}
    public static int maxProduct(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            int multiply=nums[i];
            for(int j=1; j<nums.length; j++){
                multiply = multiply*nums[j];
                max = Math.max(max, multiply);
            }
        }
        
        return max;
    }
    
}
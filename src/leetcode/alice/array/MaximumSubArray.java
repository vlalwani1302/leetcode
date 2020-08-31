package leetcode.alice.array;
class MaximumSubArray {
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for(int i=0; i<nums.length; i++){
            sum = nums[i];
            max = Math.max(sum,max);

            for(int j=i+1; j <nums.length; j++){
                sum = sum + nums[j];
                max = Math.max(sum,max);

            }
        }
        return max;
    }
    
    public static void main(String[] args) {
		int[] arr = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(arr));
		
		int[] arr1 = new int[] {-2,1};
		System.out.println(maxSubArray(arr1));
	}
}
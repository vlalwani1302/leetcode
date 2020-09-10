package leetcode.john.medium;

class MaximumProductSubArray {
	public static void main(String[] args) {
		int[] arr = new int[] {2,3,-2,4};
		System.out.println(maxProduct(arr));
	}
	
    public static int maxProduct(int[] nums) {
    	int maxProduct = 0;
		int N = nums.length;
		
		for(int i=0; i < N; i++) {
			int currentProduct = 1;
			for(int j=i; j<N; j++) {
				if(i==0 && j==0) {
					// very first sum, hence take maxProduct as first number to handle if maximum product is negative
					maxProduct = nums[j];
				}
				currentProduct = currentProduct * nums[j];
				maxProduct = Math.max(maxProduct, currentProduct);
			}
		}
		return maxProduct;
    }
}
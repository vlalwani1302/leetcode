package leetcode.john.medium;

public class ProductExceptSelf {
	
	public static int[] productExceptSelfExtraSpace(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        int[] l = new int[n]; l[0] = 1;
        int[] r = new int[n]; r[n-1] = 1;
        for (int i=1; i< n; i++) {
        	l[i] = l[i-1] * nums[i-1];
        	r[n-i-1] = r[n-i] * nums[n-i];
        }
        // Or write separate loop for right as below
//        for (int i=n-2; i>=0; i--) {
//        	r[i] = r[i+1] * nums[i+1];
//        }
        for (int i=0; i<n; i++) {
        	output[i] = l[i] * r[i];
        }
		return output;
    }
	
	public static int[] productExceptSelfConstantSpace(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        output[0] = 1;
        for (int i=1; i< n; i++) {
        	output[i] = output[i-1] * nums[i-1];
        }
        int R = 1;
        for (int i=n-1; i>=0; i--) {
        	output[i] = output[i] * R;
        	R = R * nums[i];
        }
		return output;
    }

    public static void main(String[] args) {
    	int[] arr = new int[] {4,5,6,7,8,0,1,2};
    	System.out.println(productExceptSelfExtraSpace(arr));
	}
}
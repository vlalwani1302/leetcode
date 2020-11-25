package leetcode.john.easy.array;

public class RotateArray {
	// extra space
	public static void rotate(int[] nums, int k) {
		int N = nums.length;
		if(k >= N)
			k = k%N;
		int[] result = new int[k];
        for(int i=0; i<k; i++) {
        	result[i] = nums[N-k+i];
        }
        for(int i=N-k-1; i>=0; i--) {
        	nums[i + k] = nums[i];
        }
        for(int i=0; i<k; i++) {
        	nums[i] = result[i];
        }
    }
	
	public static void main(String[] args) {
        int[] nums = new int[] {-1};
        rotate(nums, 3);
	}
}

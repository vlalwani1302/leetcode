package leetcode.john.fb.array.easy;


public class MoveZeroes {
    
    private static void moveZeroes(int[] nums) {
        int i=0; int j=0;
        while(j<nums.length) {
        	if(nums[j] != 0) {
        		nums[i] = nums[j];
        		i++;
        	}
        	j++;
        }
        while(i<nums.length) {
        	nums[i] = 0;
        	i++;
        }
    }
    

	public static void main(String[] args) {
		int[] nums1 = new int[] {0,1,3,0,2};
		moveZeroes(nums1);
	}
}
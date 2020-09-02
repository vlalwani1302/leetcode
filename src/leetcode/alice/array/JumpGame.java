package leetcode.alice.array;
public class JumpGame {
	public static void main(String[] args) {
		int[] nums = new int[] {2,0,0};
		canJump(nums);
		
		int[] nums1 = new int[] {2,5,0,0};
		canJump(nums1);
	}
    public static boolean canJump(int[] nums) {
        
        int i=0, j=nums.length;
        if(j == 1)
            return true;
        while(i < j-1){
            int value = nums[i];
            if(value == 0){
                return false;
            }
            i += value;
        }
        if(i >= j-1){
            return true;
        }
        return false;
    }
}
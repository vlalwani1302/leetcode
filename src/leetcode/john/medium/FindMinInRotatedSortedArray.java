package leetcode.john.medium;
public class FindMinInRotatedSortedArray {
    
    private static int findMin(int[] nums) {
    	if(nums == null || nums.length == 0) return -1;
    	int start = 0;
    	int end = nums.length-1;
    	while(start<end) {
    		int mid = start + (end-start)/2;
    		if(nums[mid]>nums[end]) {//pivot(min) is at right
    			start = mid+1;
    		}else {// pivot at left
    			end = mid;
    		}
    	}
    	return nums[start];
	}

    public static void main(String[] args) {
    	int[] arr = new int[] {4,5,6,7,8,0,1,2};
    	System.out.println(findMin(arr));
	}
}
package leetcode.john.fb.array.medium;
/*
 * Q.34
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstLastPosOfElementInSortedArray {
    
    private static int[] searchRange(int[] nums, int target) {
    	int[] result = new int[2];
    	result[0] = binarySearchFirstIndex(nums, target);
    	result[1] = binarySearchLastIndex(nums, target);
		return result;
	}
    
    public static int binarySearchFirstIndex(int[] nums, int target) {
    	if(nums == null || nums.length == 0) return -1;
    	int start = 0;
    	int end = nums.length-1;
    	int firstIndex = -1; // unchanged if not found
    	while (start<=end) {
    		int mid = start + (end-start)/2; // (start+end)/2 written as this to prevent integer overflow in case of large values
    		if(target == nums[mid]) {
    			firstIndex = mid;
    			end = mid-1;
    		}else if(target > nums[mid]) {
    			start = mid+1;
    		}else {
    			end = mid-1;
    		}
    	}
		return firstIndex;
    }
    
    public static int binarySearchLastIndex(int[] nums, int target) {
    	if(nums == null || nums.length == 0) return -1;
    	int start = 0;
    	int end = nums.length-1;
    	int LastIndex = -1; // unchanged if not found
    	while (start<=end) {
    		int mid = start + (end-start)/2; // (start+end)/2 written as this to prevent integer overflow in case of large values
    		if(target == nums[mid]) {
    			LastIndex = mid;
    			start = mid+1;
    		}else if(target > nums[mid]) {
    			start = mid+1;
    		}else {
    			end = mid-1;
    		}
    	}
		return LastIndex;
    }

    public static void main(String[] args) {
    	int[] arr = new int[] {5,7,7,8,8,10};
    	System.out.println(searchRange(arr, 8));
    	arr = new int[] {5,7,7,8,8,10};
    	System.out.println(searchRange(arr, 6));
	}
}
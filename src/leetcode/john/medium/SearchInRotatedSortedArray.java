package leetcode.john.medium;
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
    	int start = 0;
    	int end = nums.length-1;
    	int minIndex = findMin(nums);
    	// meaning left of pivot is sorted and right of pivot is sorted
    	// hence binary search on both sections separately
    	int bsLeft = binarySearch(nums, start, minIndex-1, target);
    	int bsRight = binarySearch(nums, minIndex, end, target);
    	
    	if(bsLeft>=0) return bsLeft;
    	if(bsRight>=0) return bsRight;
    	return -1;
    }
    
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
    	return start;
	}

	public static int binarySearch(int[] nums, int start, int end, int target) {
    	if(nums == null || nums.length == 0) return -1;
    	while (start<=end) {
    		int mid = start + (end-start)/2; // (start+end)/2 written as this to prevent integer overflow in case of large values
    		if(target == nums[mid]) {
    			return mid;
    		}else if(target > nums[mid]) {
    			start = mid+1;
    		}else {
    			end = mid-1;
    		}
    	}
		return -1;
    }
    
    public static void main(String[] args) {
    	int[] arr = new int[] {4,5,6,7,8,0,1,2};
    	System.out.println(search(arr, 8));
	}
}
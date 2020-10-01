package leetcode.john.fb.array.medium;

public class FindPeakElement {
	
	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[] {3,4,3,2,1}));
	}
	
	public static int findPeakElement(int[] nums) {
        int start =0; int end = nums.length-1;
        while (start<end) {
        	int mid = start + (end-start)/2;
        	if(mid > 0 && mid < nums.length-1 ) {
	        	if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]) {
	        		return mid;
	        	}
	        	else if(nums[mid] < nums[mid+1]){
	        		start = mid+1;
	        	}else {
	        		end = mid-1;
	        	}
        	}
        	else {
        		return nums[start] > nums[end] ? start : end;
        	}
        }
		return start;
     }
	
	
}
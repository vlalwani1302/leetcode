package leetcode.john.fb.array.easy;

public class MonotonicArray {
    
    private static boolean isMonotonic(int[] A) {
    	boolean isAsc = true;
    	boolean isDesc = true;
    	for (int i = 0; i < A.length-1; i++) { 
    	    if (A[i] <= A[i + 1]) {
    	        continue;
    	    }
    	    else {
    	        isAsc = false;
    	    }
    	}
    	if(isAsc) {
    		return true;
    	}else {
	    	for (int i = 0; i < A.length-1; i++) { 
	    	    if (A[i] >= A[i + 1]) {
	    	        continue;
	    	    }
	    	    else {
	    	        isDesc = false;
	    	    }
	    	}
    	}
    	return isAsc || isDesc;
    }
    
    public static void main(String[] args) {
    	int[] nums1 = new int[] {1,2,2,3};
    	int[] nums2 = new int[] {6,5,4,4};
    	int[] nums3 = new int[] {1,2,4,5};
    	int[] nums4 = new int[] {1,1,1};
    	int[] nums5 = new int[] {1,3,2};
    	System.out.println(isMonotonic(nums1));
    	System.out.println(isMonotonic(nums2));
    	System.out.println(isMonotonic(nums3));
    	System.out.println(isMonotonic(nums4));
    	System.out.println(isMonotonic(nums5));
	}
}
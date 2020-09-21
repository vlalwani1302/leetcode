package leetcode.john.fb.array.easy;

/* 278. First Bad Version
 */

public class FirstBadVersion {
    
    private static int firstBadVersion(int n) {
    	// binary search
    	int start = 1;
    	int end = n;
    	int result = n;
    	while(start<=end) {
    		int mid = start+(end-start)/2;
    		if(!isBadVersion(mid)) {// first bad version is at right
    			start = mid+1;
    		}else {// first bad version is at left
    			result = mid;
    			end = mid-1;
    		}
    	}
		return result;
    }
    
    private static boolean isBadVersion(int mid) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
	}
}
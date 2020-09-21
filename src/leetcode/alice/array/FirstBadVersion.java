package leetcode.alice.array;
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FirstBadVersion  {
    public static int firstBadVersion(int n) {
        int first = 1;
        int last = n;
        if(first == last)
            return last;
        int mid = 0;
        while(first <= last){
            mid = (first + last)/2;
            
            if(isBadVersion(mid)){
                last = mid-1;
            }else{
                first = mid+1;
            }
        }
        
        return mid;
    }

	private static boolean isBadVersion(int mid) {
		// TODO Auto-generated method stub
		return false;
	}
}
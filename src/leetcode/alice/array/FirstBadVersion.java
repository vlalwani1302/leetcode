package leetcode.alice.array;

import java.util.HashSet;
import java.util.Set;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FirstBadVersion  {
    public static int firstBadVersion(int n) {
    	int first = 1;
        int last = n;
        if(first == last)
            return last;
        int mid = 0;
        
        while(first < last){
             mid = first+(last-first)/2;
            
            if(isBadVersion(mid)){
                last = mid;
            }else{
                first = mid+1;
            }
        }
        
        return first;
    }

	private static boolean isBadVersion(int mid) {
		// TODO Auto-generated method stub
        Set<Integer> set = new HashSet<Integer>();
        set.toArray();
		return false;
	}
}
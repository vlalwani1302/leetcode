package leetcode.john.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonOverlappingIntervals {
	 public static int eraseOverlapIntervals(int[][] intervals) {
		 if(intervals.length <= 1) return 0;
		 // Sort the list
		 Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[1], arr2[1]));
		 int count = 0;
		 int endPrev = intervals[0][1];
		 for(int i=1; i<intervals.length; i++) {
			 int startNext = intervals[i][0];
			 if(startNext>=endPrev) {
				 endPrev = intervals[i][1];
				 continue;
			 }else {
				 count++;
			 }
		 }
		 return count;
	 }
	 


	public static void main(String[] args) {

		 int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		 int[][] intervals2 = {{1,4},{5,6}};
		 System.out.println(eraseOverlapIntervals(intervals));
		 
		 System.out.println(eraseOverlapIntervals(intervals2));
	}
}

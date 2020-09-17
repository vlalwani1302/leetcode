package leetcode.alice.array;

import java.util.Arrays;
import java.util.Comparator;

class NonOverlappingIntervals {
	public static void main(String[] args) {

		 int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		 int[][] intervals2 = {{1,4},{5,6}};
		 System.out.println(eraseOverlapIntervals(intervals));
		 
		 System.out.println(eraseOverlapIntervals(intervals2));
		 System.out.println(eraseOverlapIntervals(new int[][] {{1,100},{11,22},{1,11},{2,12}}));
	}
	
	public static int eraseOverlapIntervals(int[][] intervals) {

		if (intervals.length <= 1) {
			return 0;
		}
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] i1, int[] i2) {
				return i1[0] - i2[0];
			}
		});
		int count = 0;
		int endInterval = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= endInterval) {
				endInterval = intervals[i][1];
				continue;
			} else {
				count++;
			}
		}

		return count;
	}
}
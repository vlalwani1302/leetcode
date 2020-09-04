package leetcode.alice.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

class MergeIntervals {
	public static void main(String[] args) {
		int[][] intervals = new int[][] {{1,4},{0,2},{3,5}};
		merge(intervals);
		int[][] intervals1 = new int[][] {{2,3},{4,5},{6,7},{8,9},{1,10}};
		merge(intervals1);


	}
    public static int[][] merge(int[][] intervals) {
        LinkedList<int[]> merged = new LinkedList<>();
        if(intervals.length <= 1){
            return intervals;
        }
        
    Collections.sort(Arrays.asList(intervals), new IntervalComparator());
        for(int i =0; i <intervals.length; i++){
            int[] a = new int[2];
            a[0] = intervals[i][0];
            a[1] = intervals[i][1];
            while( i < intervals.length-1 && (a[1] >= intervals[i+1][0])) {
                if(a[0] > intervals[i+1][0])
                    a[0] = intervals[i+1][0];
          
                if(a[1] < intervals[i+1][1])
                    a[1] = intervals[i+1][1];
          
                i++;
            }
            merged.add(a);

        }
        
        return merged.toArray(new int[merged.size()][]);
    }
    
    private static class IntervalComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
      return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
    }
  }
}
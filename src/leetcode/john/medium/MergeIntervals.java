package leetcode.john.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	 public static int[][] mergeIntervals(int[][] intervals) {
		 if(intervals.length <= 1) return intervals;
		 // Sort the list
		 Arrays.parallelSort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
		 List<int[]> result = new ArrayList<>();
		 result.add(intervals[0]);//adding first interval to start comparing
		 int output_index = 0;
		 for(int i=1; i<intervals.length; i++) {
			 int[] arr1 = result.get(output_index);
			 int[] arr2 = intervals[i];
			 int start1 = arr1[0];
			 int end1 = arr1[1];
			 int start2 = arr2[0];
			 int end2 = arr2[1];
			 if(start2<=end1) {
				 //merge with result
				 result.get(output_index)[0] = Math.min(start1, start2);
				 result.get(output_index)[1] = Math.max(end1, end2);
			 }else {
				 // not overlapping - don't merge add to result
				 result.add(arr2);
				 output_index++;
			 }
		 }
		 return result.toArray(new int[result.size()][2]);
	 }
	 


	public static void main(String[] args) {

		 int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		 int[][] intervals2 = {{1,4},{5,6}};
		 System.out.println("Input1");
		 int[][] result1 = mergeIntervals(intervals);
		 for(int[] result : result1) {
			 System.out.println(result[0] + "," + result[1]);
		 }
		 
		 System.out.println("Input2");
		 int[][] result2 = mergeIntervals(intervals2);
		 for(int[] result : result2) {
			 System.out.println(result[0] + "," + result[1]);
		 }
		}
}

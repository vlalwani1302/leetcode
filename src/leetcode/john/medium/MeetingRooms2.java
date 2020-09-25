package leetcode.john.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {
	
	public static int minMeetingRooms(int[][] intervals) {
		 if(intervals.length <= 1) return 0;
		 // Sort the list
		 Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
		 PriorityQueue<int[]> minHeap = new PriorityQueue<>((arr1, arr2) -> arr1[1]-arr2[1]);
		 minHeap.add(intervals[0]);
		 for(int i=1; i<intervals.length; i++) {
			 int[] current = intervals[i];
			 int[] earliest = minHeap.remove();
			 if(current[0] >= earliest[1]) {
				 earliest[1] = current[1];
			 }else {
				 minHeap.add(current);
			 }
			 minHeap.add(earliest);
		 }
		 return minHeap.size();  
   }
	
	public static void main(String[] args) {
		 int[][] intervals = {{0,30},{5,10},{15,20}};
		 System.out.println(minMeetingRooms(intervals));
		 int[][] intervals2 = {{13,15},{1,13}};
		 System.out.println(minMeetingRooms(intervals2));
	}
}

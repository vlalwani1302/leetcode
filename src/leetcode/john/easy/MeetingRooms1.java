package leetcode.john.easy;

import java.util.Arrays;

public class MeetingRooms1 {
	public static boolean canAttendMeetings(int[][] intervals) {
		 if(intervals.length <= 1) return true;
		 // Sort the list
		 Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
		 for(int i=1; i<intervals.length; i++) {
			 int start2 = intervals[i][0];
			 int end1 = intervals[i-1][1];
			 if(start2<end1) {
				return false;
			 }
		 }
		 return true;  
    }
	
	public static void main(String[] args) {
		 int[][] intervals = {{0,30},{5,10},{15,20}};
		 System.out.println(canAttendMeetings(intervals));
		 int[][] intervals2 = {{13,15},{1,13}};
		 System.out.println(canAttendMeetings(intervals2));
	}
}

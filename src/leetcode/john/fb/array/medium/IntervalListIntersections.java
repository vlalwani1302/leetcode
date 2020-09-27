package leetcode.john.fb.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {
	 public static int[][] intervalIntersection(int[][] A, int[][] B) {
		 List<int[]> result = new ArrayList<>();
		 int i = 0 ; int j = 0;
		 while(i<A.length && j<B.length) {
			 if(B[j][0] > A[i][1]) {
				 i++;
			 }
			 else if(A[i][0] > B[j][1]) {
				 j++;
			 }
			 else {
				 int start = Math.max(A[i][0], B[j][0]);
				 int end = Math.min(A[i][1], B[j][1]);
				 result.add(new int[]{start,end});
				 if(A[i][1] < B[j][1])
					 i++;
				 else
					 j++;
			 }
		 }
		return result.toArray(new int[result.size()][2]);
	 }
	 


	public static void main(String[] args) {

		 int[][] A = {{1,3},{2,6},{8,10},{15,18}};
		 int[][] B = {{1,4},{5,6}};
		 int[][] result1 = intervalIntersection(A,B);
		 for(int[] result : result1) {
			 System.out.println(result[0] + "," + result[1]);
		 }
		 
	}
}

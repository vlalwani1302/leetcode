package leetcode.john.fb.array.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KthLargestElementInAnArray {
	
	public static void main(String[] args) {
		findKthLargest(new int[] {3,2,1,5,6,4}, 2);
		System.out.println(findKthLargest(new int[] {3,2,1,5,6,4}, 2));
	}
	
	public static int findKthLargest(int[] nums, int k) {
		if(nums == null || nums.length == 0) return 0;
		Arrays.sort(nums);
		int count = 1;
		for(int i = nums.length-1; i >=0 ; i--){
			if(count == k) {
				return nums[i];
			}else {
				count++;
			}
		}
		return 0;
	}
	
	public static int findKthLargestHeap(int[] nums, int k) {
		if(nums == null || nums.length == 0) return 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
		for(int i:nums){
			minHeap.add(i);
			if(minHeap.size() > k) {
				minHeap.remove();
			}
		}
		return minHeap.peek(); // return top element;
	}
	
}
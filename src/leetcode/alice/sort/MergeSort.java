package leetcode.alice.sort;

import leetcode.alice.Utility;

public class MergeSort {

	public static void main(String[] args) {
		Utility.printArray(mergeSort(new int[] {38,27,43,3,9,82,10}));
	}

	public static int[] mergeSort(int[] nums) {
		mergeSort(nums, 0, nums.length - 1);
		return nums;
	}
	
	private static void mergeSort(int[] nums, int left, int right) {
		if(left < right) {
			int mid = (left + right)/2;
			mergeSort(nums, left, mid);
			mergeSort(nums, mid+1, right);
			merge1(nums, left, mid, right);
		}
	}

	private static void merge(int[] nums, int left, int mid, int right) {
		int[] temp = new int[nums.length];
		int leftStart = left;
		int index = left;
		int rightStart = mid+1;
		
		while(leftStart <= mid && rightStart <= right) {
			if(nums[leftStart] <= nums[rightStart]) {
				temp[index] = nums[leftStart];
				leftStart++;
			}else {
				temp[index] = nums[rightStart];

				rightStart++;
			}
			index++;
		}
		
		if(leftStart > mid) {
			while(rightStart <= right) {
				temp[index] = nums[rightStart];
				index++; rightStart++;
			}
		}else if(rightStart > right) {
			while(leftStart <= mid) {
				temp[index] = nums[leftStart];
				leftStart++;
				index++;
			}
		}
		
		for(int i=left; i<=right; i++) {
			nums[i] = temp[i];
		}
	}
	
	private static void merge1(int[] nums, int left, int mid, int right) {
		int[] temp = new int[nums.length];
		int leftStart = left;
		int index = left;
		int rightStart = mid+1;
		
		while(leftStart <= mid && rightStart <= right) {
			if(nums[leftStart] <= nums[rightStart]) {
				temp[index] = nums[leftStart];
				leftStart++;
			}else {
				temp[index] = nums[rightStart];

				rightStart++;
			}
			index++;
		}
		
		System.arraycopy(nums, rightStart, temp, index, right - rightStart+1);
		System.arraycopy(nums, leftStart, temp, index, mid - leftStart+1);
		for(int i=left; i<=right; i++) {
			nums[i] = temp[i];
		}
		
	}
}

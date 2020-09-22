package leetcode.alice.sort;

import leetcode.alice.Utility;

public class QuickSort {

	public static void main(String[] args) {
		Utility.printArray(quickSort(new int[] { 38, 27, 43, 3, 9, 82, 10 }));
	}

	public static int[] quickSort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
		return nums;
	}

	private static void quickSort(int[] nums, int low, int high) {
		if (low < high) {
			int pivot = partition(nums, low, high);
			quickSort(nums, low, pivot - 1);
			quickSort(nums, pivot + 1, high);
		}
	}

	private static int partition(int[] nums, int low, int high) {
		int pivot = nums[high];
		int i = low-1;
		for(int j=low; j< high; j++) {
			if(nums[j] < pivot) {
				// swap
				i++;
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				
			}
		}
		
		//swap arr[i+1] and arr[high]
		int temp = nums[i+1];
		nums[i+1] = nums[high];
		nums[high] = temp;
		return i+1;
	}

}

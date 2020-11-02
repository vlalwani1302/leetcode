package leetcode.alice.array;

/*
 * Q.34
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstLastPosOfElementInSortedArray {

	static int[] result = new int[2];
	private static int[] searchRange(int[] nums, int target) {
		result[0] = binarySearchLeft(nums, target, 0, nums.length - 1);
		result[1] = binarySearchRight(nums, target, 0, nums.length - 1);
		return result;
	}

	private static int binarySearchLeft(int[] arr, int value, int low, int high) {
		int index = -1;
		while (low <= high) {

			int mid = (low + high) / 2;
			if (mid >= arr.length || mid < 0) {
				return -1;
			}
			if (arr[mid] == value) {
				index = mid;
				high = mid - 1;
			} else if (value > arr[mid]) {
				// search in right array
				low = mid + 1;
			} else {
				// search in left array
				high = mid - 1;
			}

		}
		return index;

	}

	private static int binarySearchRight(int[] arr, int value, int low, int high) {
		int index = -1;
		while (low <= high) {

			int mid = (low + high) / 2;
			if (mid >= arr.length || mid < 0) {
				return -1;
			}
			if (arr[mid] == value) {
				index = mid;
				low = mid + 1;
			} else if (value > arr[mid]) {
				// search in right array
				low = mid + 1;
			} else {
				// search in left array
				high = mid - 1;
			}

		}
		return index;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 7, 7, 8, 8, 10 };
		System.out.println(searchRange(arr, 8));
		arr = new int[] { 5, 7, 7, 8, 8, 10 };
		System.out.println(searchRange(arr, 6));
		
	}

}
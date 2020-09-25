package leetcode.alice.array;

import java.util.PriorityQueue;
import java.util.Queue;

class FindKthLargestElementInArray {
	static int[] nums;

	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[] { 1, 4, 5, 5, 6, 3, 2, 7, 2 }, 4));
		System.out.println(findKthLargestUsingPQ(new int[] { 1, 4, 5, 5, 6, 3, 2, 7, 2 }, 4));

	}

	public static int findKthLargest(int[] nums, int k) {
		FindKthLargestElementInArray.nums = nums;
		int size = nums.length;
		int kSmallest = size - k;
		return quickSelect(0, size - 1, kSmallest);
	}

	private static int quickSelect(int left, int right, int kSmallest) {
		int partition = partitions(left, right);
		if (partition == kSmallest) {
			return nums[partition];
		} else if (partition < kSmallest) {
			return quickSelect(partition + 1, right, kSmallest);
		} else {
			return quickSelect(left, partition - 1, kSmallest);
		}
	}

	private static int partitions(int left, int right) {
		int pivot = nums[right], pivotloc = left, temp;
		for (int i = left; i <= right; i++) {
			if (nums[i] < pivot) {
				temp = nums[i];
				nums[i] = nums[pivotloc];
				nums[pivotloc] = temp;
				pivotloc++;
			}
		}

		temp = nums[right];
		nums[right] = nums[pivotloc];
		nums[pivotloc] = temp;

		return pivotloc;
	}

	// O(NlogK)
	public static int findKthLargestUsingPQ(int[] nums, int k) {

		Queue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

		for (int i = 0; i < nums.length; i++) {
			heap.add(nums[i]);
			if (heap.size() > k) {
				heap.poll();
			}
		}

		return heap.poll();

	}

}

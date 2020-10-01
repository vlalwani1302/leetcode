package leetcode.alice.array;

class FindPeakElement {
	public int findPeakElement1(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			while (i + 1 < nums.length && nums[i] < nums[i + 1]) {
				i++;
			}

			return i;
		}
		return 0;
	}

	public static int findPeakElement(int[] nums) {
		return findPeak(nums, 0, nums.length - 1);
	}

	public static int findPeak(int[] nums, int low, int high) {
		if (low == high)
			return low;
		int mid = low + (high - low) / 2;

		if (mid > 0 && mid <= nums.length - 1) {
			if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
				return mid;
			} else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
				return findPeak(nums, mid + 1, high);
			} else {
				return findPeak(nums, low, mid - 1);
			}
		} else {
			return nums[low] > nums[high] ? low : high;
		}
	}

	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[] { 1, 2, 3 }));
	}
}
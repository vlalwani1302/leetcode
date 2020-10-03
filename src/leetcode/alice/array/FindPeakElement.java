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

	public static int findPivot(int arr[], int low, int high) {
		// base cases
		if (high < low)
			return -1;
		if (high == low)
			return low;

		/* low + (high - low)/2; */
		int mid = (low + high) / 2;
		if (mid < high && arr[mid] > arr[mid + 1])
			return mid;
		if (mid > low && arr[mid] < arr[mid - 1])
			return (mid - 1);
		if (arr[low] >= arr[mid])
			return findPivot(arr, low, mid - 1);
		return findPivot(arr, mid + 1, high);
	}
	
	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[] { 1, 2 }));
		System.out.println(findPivot(new int[] { 1, 2 }, 0, 1));
		
		int[] nums = new int[] {7,8,1,2,3,4,5,6};
		System.out.println(findPeakElement(nums));
		System.out.println(findPivot(nums,0,nums.length-1));

	}
}
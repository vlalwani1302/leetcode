package leetcode.alice.array;

class MergeSortedArrays {
	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = new int[] { 2, 5, 6 };
		merge(nums1, 3, nums2, 3);
		merge(new int[] { 1, 2, 4, 5, 6, 0 }, 5, new int[] { 3 }, 1);

	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int p1 = m - 1;
		int p2 = n - 1;
		int p = m + n - 1;

		while ((p1 >= 0) && (p2 >= 0))
			nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

		System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
	}
}
package leetcode.alice.array;

import java.util.Arrays;

class ProductOfArrayEsceptSelf {

	// brute force
	public static int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int m = 1;

			for (int j = 0; j < nums.length; j++) {
				if (i != j) {
					m = m * nums[j];
				}
			}

			result[i] = m;
		}

		return result;
	}

	// O(N)
	public static int[] productExceptSelf1(int[] nums) {
		int[] result = new int[nums.length];
		int m = 1;
		int countZero = 0;
		for (int i = 0; i < nums.length; i++) {
			if (countZero == 2) {
				m = 0;
				break;
			}
			if (nums[i] == 0) {
				countZero++;
			} else {
				m = m * nums[i];
			}

		}
		if (countZero == 2) {
			Arrays.fill(result, 0);
			return result;
		}
		for (int i = 0; i < nums.length; i++) {
			if (countZero == 1) {
				if (nums[i] == 0)
					result[i] = m;
				else
					result[i] = 0;

			} else {
				result[i] = m / nums[i];
			}

		}
		return result;
	}

	public static int[] productExceptSelf3(int[] nums) {
		int size = nums.length;
		int[] result = new int[size];

		int[] left = new int[size];
		left[0] = 1;
		for (int i = 1; i < size; i++) {
			left[i] = left[i - 1] * nums[i - 1];
		}

		int[] right = new int[size];
		right[size - 1] = 1;
		for (int i = size - 2; i >= 0; i++) {
			right[i] = right[i + 1] * nums[i + 1];
		}

		for (int i = 0; i < size; i++) {
			result[i] = left[i] * right[i];
		}
		return result;
	}

	public static int[] productExceptSelf2(int[] nums) {

		// The length of the input array
		int length = nums.length;

		// Final answer array to be returned
		int[] answer = new int[length];

		// answer[i] contains the product of all the elements to the left
		// Note: for the element at index '0', there are no elements to the left,
		// so the answer[0] would be 1
		answer[0] = 1;
		for (int i = 1; i < length; i++) {

			// answer[i - 1] already contains the product of elements to the left of 'i - 1'
			// Simply multiplying it with nums[i - 1] would give the product of all
			// elements to the left of index 'i'
			answer[i] = nums[i - 1] * answer[i - 1];
		}

		// R contains the product of all the elements to the right
		// Note: for the element at index 'length - 1', there are no elements to the
		// right,
		// so the R would be 1
		int R = 1;
		for (int i = length - 1; i >= 0; i--) {

			// For the index 'i', R would contain the
			// product of all elements to the right. We update R accordingly
			answer[i] = answer[i] * R;
			R *= nums[i];
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(productExceptSelf1(new int[] { 0, 0 }));
		System.out.println(productExceptSelf3(new int[] { 1,2,3,4,5}));

	}
}
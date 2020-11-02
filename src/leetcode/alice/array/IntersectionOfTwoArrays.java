package leetcode.alice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class IntersectionOfTwoArrays {
	public static void main(String[] args) {
		// System.out.println(intersect1(new int[] {1,2,2,1}, new int[] {2,2}));
		int[] nums1 = new int[] { 54, 93, 21, 73, 84, 60, 18, 84, 45, 33, 41 };
		int[] nums2 = new int[] { 17, 17, 87, 98, 18, 53, 2, 69, 74, 73, 20, 85, 59, 89, 84, 91, 84, 34, 44, 48, 20, 42,
				68, 84, 8, 54, 66, 62, 69, 52, 67, 27, 87, 49, 92, 14, 92, 53, 22, 90, 60, 14, 8, 71, 0, 61, 94, 1, 22,
				84, 10, 55, 55, 60, 98, 76, 27, 35, 84, 28, 4, 2, 9, 44, 86, 12, 17, 89, 35, 68, 17, 41, 21, 65, 59, 86,
				42, 53, 0, 33, 80, 20 };
		intersect1(nums1, nums2);
	}

	public static int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		if (nums1.length > nums2.length)
			intersect(nums2, nums1);

		for (int i = 0; i < nums2.length; i++) {
			map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
		}

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums1.length; i++) {
			if (map.containsKey(nums1[i])/* && map.get(nums1[i]) > 0 */) {
				list.add(nums1[i]);
				int value = map.get(nums1[i]);
				map.put(nums1[i], --value);
			}
		}
		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	public static int[] intersect1(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		if (nums1.length > nums2.length) // bigger length array is in nums2
			intersect1(nums2, nums1);

		for (int i = 0; i < nums1.length; i++) {
			int index = Arrays.binarySearch(nums2, nums1[i]);
			if (index >= 0) {

				if (!map.containsKey(index)) {
					map.put(index, nums1[i]);
				} else {

					int left = index - 1;
					int right = index + 1;
					boolean found = false;
					while (left > 0) {
						if (nums2[left] == nums1[i]) {
							if (!map.containsKey(left)) {
								map.put(left, nums1[i]);
								found = true;
								break;
							}
						}
						left--;
					}
					if (!found) {
						while (right < nums2.length) {
							if (nums2[right] == nums1[i]) {
								if (!map.containsKey(right)) {
									map.put(right, nums1[i]);
									break;
								}
							}
							right++;
						}
					}
				}
			}
		}
		
		return map.values().stream().mapToInt(Integer::intValue).toArray();
		// return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
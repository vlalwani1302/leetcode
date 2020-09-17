package leetcode.john.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentElements {
	
	public static void main(String[] args) {
		topKFrequent(new int[] {1,1,1,2,2,3,3}, 2);
		System.out.println(topKFrequent(new int[] {1,1,1,2,2,3,3}, 2));
	}
	
	public static int[] topKFrequent(int[] nums, int k) {
		if(nums == null || nums.length == 0) return new int[]{};
		int[] result = new int[k];
		Map<Integer, Integer> map = new HashMap<>();
		Arrays.sort(nums);
		int count = 0;
		int current = nums[0];
		for(int i = 0; i < nums.length; i++){
			if(current == nums[i]) {
				count++;
			}else {
				map.put(current, count);
				current = nums[i];
				count = 1;
			}
			if(i == nums.length-1)
				map.put(current, count);
		}
		int n = 0;
		map = map.entrySet()
		.stream()
		.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			if(n==k) {
				break;
			}else {
				result[n++] = entry.getKey();
			}
		}
		return result;
    }
	
}
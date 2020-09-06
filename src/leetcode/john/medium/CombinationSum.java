package leetcode.john.medium;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		if(candidates == null) {
			return null;
		}
		List<List<Integer>> result = new ArrayList<>();
		findCombinations(candidates, 0, target, new ArrayList<>(), result);
		return result;
	}
	
	private static void findCombinations(int[] candidates, int index, int target, List<Integer> tempList,
			List<List<Integer>> result) {
		if(target == 0) {
			result.add(new ArrayList<>(tempList));
			return;
		}
		for(int i = index; i< candidates.length; i++) {
			if(candidates[i] <= target) {
				tempList.add(candidates[i]);
				findCombinations(candidates, i, target - candidates[i], tempList, result);
				tempList.remove(Integer.valueOf(candidates[i]));
			}
		}
	}

	public static void main(String[] args) throws IOException {

        List<List<Integer>> result1 = combinationSum(new int[] {2,3,6,7}, 7);

        System.out.println(result1);


	}
}

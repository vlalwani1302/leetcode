package leetcode.alice.array;

import java.util.ArrayList;
import java.util.List;

class SubSets {
	public static void main(String[] args) {
		SubSets subSets = new SubSets();
		subSets.subsets(new int[] {1,2,3,});
	}
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        
        permutations(nums, 0, nums.length-1, new ArrayList<Integer>());
        return result;
    }
    
    public void permutations(int[] nums, int l, int h, List<Integer> current){
     result.add(new ArrayList<>(current));
        
        for(int i=l; i<=h; i++){
        	current.add(nums[i]);
        	permutations(nums, i+1, h, current);
        	current.remove(current.size()-1);
        }
    }
    
}
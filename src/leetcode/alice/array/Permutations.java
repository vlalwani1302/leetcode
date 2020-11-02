package leetcode.alice.array;

import java.util.ArrayList;
import java.util.List;

class Permutations {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        permutations(nums, 0, nums.length-1);
        return result;
    }
    
    void permutations(int[] nums, int l, int r){
        if(l == r){
            List<Integer> list = new ArrayList<>();
            for (Integer t:nums){  
                System.out.println("t - " + t); 
                list.add(t); 
            }  
            if(!result.contains(list))
                result.add(list);
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            nums = interchangeNum(nums, l, i);
            permutations(nums, l+1, r);
            nums = interchangeNum(nums, l, i);
        }
    }
    
    public int[] interchangeNum(int[] nums, int a, int b){
        
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
        return nums;
    }
}
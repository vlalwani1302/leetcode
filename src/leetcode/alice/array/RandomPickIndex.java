package leetcode.alice.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomPickIndex {

    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    public RandomPickIndex(int[] nums) {
        for(int i=0; i<nums.length; i++){
            map.putIfAbsent(nums[i], new ArrayList<Integer>());
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        if(map.get(target) != null){
            List<Integer> indices = map.get(target);
            if(indices.size() ==1)
                return indices.get(0);
            else{
                Random random = new Random();
                int randomIndex = random.nextInt(indices.size()); 
                return indices.get(randomIndex);
            }
        }
        return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
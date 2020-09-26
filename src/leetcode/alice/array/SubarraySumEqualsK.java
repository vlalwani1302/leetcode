package leetcode.alice.array;

import java.util.HashMap;

class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
     
        int sum;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            sum = nums[i];
            if(sum == k){
                count++;
            }
                
            for(int j=i+1; j<nums.length; j++){
                sum+=nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        
        return count;
    }
    
    //O(N)
    public static int subarraySum1(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    
    public static void main(String[] args) {
		System.out.println(subarraySum1(new int[] {1, 1,1,1,1,2,0,1,0}, 3));
	}
}
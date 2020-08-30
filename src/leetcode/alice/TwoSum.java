package leetcode.alice;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for(int i=0; i< nums.length; i++){
            int target2 = target - nums[i];
            Integer index1 = map.get(target2);
            if(index1 != null){
                result[0] = index1;
                result[1] = i;
                return result;
            }
             map.put( nums[i], i);  
        }
        
        
        
        return result;
    }
    
    // using two pointer technique
    public static int[] twoSum1(int[] nums, int target) {
        
    	int[] result = new int[2];
    	Arrays.sort(nums);
    	int i=0, j= nums.length - 1;
    	while(i <j) {
    		if(nums[i] + nums[j] < target) {
    			i++;
    		} else if(nums[i] + nums[j] > target) {
    			j--;
    		} else {
    			result[0] = i;
    			result[1] = j;
    			return result;
    		}
    		
    	}
        return result;
    }

    public static void main(String[] args) {
		
    	int target = 9;
    	int[] a = new int[] {2,7,11,15};
    	int[] result = twoSum(a, target);
    	Utility.printArray(result);
    	System.out.println();
    	Utility.printArray(twoSum1(a, target));
	}
}
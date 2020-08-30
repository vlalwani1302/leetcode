package leetcode.alice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {
    
    public static List<List<Integer>> threeSum(int[] nums) {
        int total = 0;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int a=0;
        for(int i=0; i< nums.length; i++){
            map.put(i, nums[i]);
            a = nums[i];
            int x = total - a;
            int b=-1,c=-2;
            for(int j=0; j !=i && j< nums.length; j++){
                map.put(j, nums[j]);
                if(j < nums.length -1){
                	map.put(j+1, nums[j+1]);
                }
                if(j < nums.length -1 && map.get(j) != null && map.get(j+1) != null ){
                	b = map.get(j);
                	c = map.get(j+1);
                    if(b + c == x && j > i && (j+1) > i){
	                    list.add(a);
	                    list.add(b);
	                    list.add(c);
	                    if(!ifListExists(result, list)) {
	                    	result.add(list);
	                    }
	                    list = new ArrayList<Integer>();
	                    continue;
                    }
                 
                   
                }
                

            }
        }
        return result;
    }
    
    public static boolean ifListExists(List<List<Integer>> result , List<Integer> list ) {
    	for(int i=0;i<result.size(); i++) {
    		List<Integer> l = result.get(i);
    		Collections.sort(l);
    		Collections.sort(list);
    		if(l.equals(list)) {
    			return true;
    		}

    	}
    	return false;
    }
    
    // using two point algorithm
    public static List<List<Integer>> threeSum1(int[] nums) {
        int total = 0;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        int a=0;
        for(int i=0; i< nums.length - 2; i++){
        	if(i > 0 && nums[i] == nums[i-1]) continue; // ignore element if already same as previous element(duplicates), and array is sorted so equal elements are adjacent
        	a = nums[i];
        	int target = total - a;
        	int twoNums[] = twoSum(nums, target, i+1);
        	if(twoNums[0] > 0 && twoNums[1] > 0) {
        		list.add(a);
        		list.add(nums[twoNums[0]]);
        		list.add(nums[twoNums[1]]);
        		result.add(list);
        		list = new ArrayList<Integer>();
        	}
        }
        return result;
    }
    
    public static int[] twoSum(int[] nums, int target, int i ) {
    	int j = nums.length - 1;
    	int[] result = new int[2];
    	while(i <j) {
    		if(nums[i] + nums[j] < target) {
    			i++;
    		} else if(nums[i] + nums[j] > target) {
    			j--;
    		} else {
    			result[0] = i;
    			result[1] = j;
    			while(i < j && nums[i] == nums[i+1]) // ignore element if same as previous on left
					i++;
				while(i < j && nums[j] == nums[j-1])
					j--; // ignore element is same as previous on right

				i++; // move left pointer to right since left no. should increase in sorted array
				j--; // move right pointer to left since right no. should decrease to keep currentSum same while finding other valid numbers
    			return result;
    		}
    		
    	}
        return result;
    }

    public static void main(String[] args) {
    	List<List<Integer>> result = threeSum1(new int[] {0,0,0,0});

        System.out.println(result);
        
        int[] arrItems = new int[] {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum1(arrItems));
        
        List<List<Integer>> result1 = threeSum1(new int[] {-1,0,1,0});

        System.out.println(result1);
        
        List<List<Integer>> result2 = threeSum1(new int[] {-2,0,1,1,2});

        System.out.println(result2);

	}
}
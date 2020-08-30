package leetcode.john.medium;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class ThreeSum {

		// Brute Force
	    static List<List<Integer>> threeSum2(int[] nums) {
	    	Map<String,List<Integer>> resultMap = new HashMap<>();
	    	int size = nums.length;
	        for(int i = 0; i < size -2; i++){
	        	for(int j = i+1; j < size -1; j++) {
	        		for(int k = j+1; k < size; k++) {
	        			if(nums[i] + nums[j] + nums[k] == 0) {
	        				List<Integer> set = new ArrayList<>();
	        				set.add(nums[i]);
	        				set.add(nums[j]);
	        				set.add(nums[k]);
	        				System.out.println(set);
	        				Collections.sort(set);
	        				String key = "";
	        				for(Integer value : set) {
	        					key = key + value.toString();
	        				}
	        				resultMap.put(key, set);
	        			}
	        		}
	        	}
	        }
	        new ArrayList<>(resultMap.values());
			return resultMap.values().stream().collect(Collectors.toList());
	    }
	    
	    // Complexity O(n2)
	    static List<List<Integer>> threeSum(int[] nums) {
	    	Arrays.sort(nums);
	    	List<List<Integer>> result = new ArrayList<List<Integer>>();
	    	int target = 0;
	    	int size = nums.length;
	    	// fix first element
	    	for(int i = 0; i < size-2; i++) {
	    		if(i > 0 && nums[i] == nums[i-1]) continue;// ignore element if already same as previous element(duplicates), and array is sorted so equal elements are adjacent
	    		
	    		int l = i+1;
	    		int r = size-1;
	    		while(l < r) {
	    			int currentSum = nums[i] + nums[l] + nums[r];
	    			if(currentSum == target) {
	    				List<Integer> list = new ArrayList<>();
	    				list.add(nums[i]);list.add(nums[l]);list.add(nums[r]);
	    				result.add(list);
	    				while(l < r && nums[l] == nums[l+1]) // ignore element if same as previous on left
	    					l++;
	    				while(l < r && nums[r] == nums[r-1])
	    					r--; // ignore element is same as previous on right

	    				l++; // move left pointer to right since left no. should increase in sorted array
	    				r--; // move right pointer to left since right no. should decrease to keep currentSum same while finding other valid numbers
	    			}
	    			else if(currentSum < target) {// we need to increase the sum :- By moving left pointer to right in sorted array
	    				l++;						// and not moving right pointer	
	    			}
	    			else if(currentSum > target) {// we need to decrease the sum :- By moving right pointer to left in sorted array
	    				r--;						// and not moving left pointer	
	    			}
	    		}
	    	}
			return result;
	    }
	    

	    public static void main(String[] args) throws IOException {
	            int[] arrItems = new int[] {-1,0,1,2,-1,-4};

	            List<List<Integer>> result = threeSum(arrItems);
	            System.out.println(result);
	            
	            List<List<Integer>> result1 = threeSum(new int[] {-1,0,1,0});

	            System.out.println(result1);

	            List<List<Integer>> result2 = threeSum(new int[] {-2,0,0,2,2});

	            System.out.println(result2);

	}

}

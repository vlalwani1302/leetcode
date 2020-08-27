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


	    static List<List<Integer>> threeSum(int[] nums) {
	    	Map<String,List<Integer>> resultMap = new HashMap<>();
	    	int size = nums.length;
	        for(int i = 0; i < size -2; i++){
	        	for(int j = i+1; j < size -1; j++) {
	        		for(int k = j+1; k < size; k++) {
	        			if(nums[i] + nums[j] + nums[k] == 0) {
	        				List<Integer> triplet = new ArrayList<>();
	        				triplet.add(nums[i]);
	        				triplet.add(nums[j]);
	        				triplet.add(nums[k]);
	        				System.out.println(triplet);
	        				Collections.sort(triplet);
	        				String key = "";
	        				for(Integer value : triplet) {
	        					key = key + value.toString();
	        				}
	        				resultMap.put(key, triplet);
	        			}
	        		}
	        	}
	        }
	        new ArrayList<>(resultMap.values());
			return resultMap.values().stream().collect(Collectors.toList());
	    }
	    

	    public static void main(String[] args) throws IOException {
	            int[] arrItems = new int[] {-1, 0, 1, 2, -1, -4};

	            List<List<Integer>> result = threeSum(arrItems);
	            System.out.println(result);

	}

}

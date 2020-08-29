package leetcode.john.medium;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class ContainerWithMostWater {

		// Brute Force
	    static int maxArea(int[] height) {
	    	int maxArea = 0;
	        int l = 0;
	        int r = height.length -1;
	        while(l < r) {
	        	if(height[l] < height[r]) {
		        	maxArea = Math.max(maxArea, height[l] * (r-l));
		        	l = l+1;
	        	}else {
	        		maxArea = Math.max(maxArea, height[r] * (r-l));
	        		r = r-1;
	        	}
	        }
			return maxArea;
	    }
	    
	    public static void main(String[] args) throws IOException {
	            int[] arrItems = new int[] {1,8,6,2,5,4,8,3,7};

	            int result = maxArea(arrItems);
	            System.out.println(result);

	}

}

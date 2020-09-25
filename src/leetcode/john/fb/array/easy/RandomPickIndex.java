package leetcode.john.fb.array.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPickIndex {
	 
	 	Random random;
	    private int[] a;
	    public RandomPickIndex(int[] nums) {
	        a = nums;
	        random = new Random();
	    }
	    
	    public int pick2(int target) {
	        List<Integer> list = new ArrayList<>();
	        for(int i=0;i<a.length;i++)
	            if(a[i]==target)
	                list.add(i);
	        return list.get(random.nextInt(list.size()));
	    }
    
	    public int pick(int target) {
	    	int count = 0;
	    	int res = 0;
	        for(int i=0;i<a.length;i++) {
	            if(a[i]==target) {
	                count++;
		            if(random.nextInt(count) == 0)
		            	res = i;
	            }
	        }
	        return res;
	    }
    
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,3,3};
		RandomPickIndex solution = new RandomPickIndex(nums);
		System.out.println(solution.pick(3));
	}
}
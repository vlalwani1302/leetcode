package leetcode.john.fb.array.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskSchedular {
	
	public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(Character c: tasks) {
        	freqMap.putIfAbsent(c, 0);
        	freqMap.put(c, freqMap.get(c) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        maxHeap.addAll(freqMap.values());
        int result = 0;
        while(!maxHeap.isEmpty()) {
        	List<Integer> list = new ArrayList<>();
        	 //run first 1st task plus next n tasks ( =since gap of n before same task) = n+1 total in one go
        	for(int i=0; i< n+1 ; i++) {
        		if(!maxHeap.isEmpty()) {// if max heap has new tasks to rum
	        		int top = maxHeap.remove(); // run first task
	        		top--; // reduce frequency
	        		if(top>0) { // if frequency still >0 add to a temp list
	        			list.add(top);
	        		}
	        		result++; // increment count
        		}else { // if max heap doesn't have tasks to run CPU idle time
        			if(!list.isEmpty()) // increment idle time only if temp list has pending tasks
        				result++;
        		}
        	}
        	maxHeap.addAll(list); // add pending tasks back to heap with remainig frequency
        }
        	
        return result;
	}
	
	public static void main(String[] args) {
		char[] tasks1 = {'A','A','A','B','B','B'};
		System.out.println(leastInterval(tasks1, 2));
		 char[] tasks2 = {'A','A','A','B','B','B'};
		 System.out.println(leastInterval(tasks2, 0));
		 char[] tasks3 = {'A','A','A','A','A','A','B','C','D','E','F','G'};
		 System.out.println(leastInterval(tasks3, 2));
	}
}

package leetcode.alice.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CoruseSchedule {
	
	public static void main(String[] args) {
		System.out.println(canFinish(3, new int[][] {{1,0},{1,2},{0,1}}));
	}
	
	public static void setGraph(int[][] prerequisites) {
        for(int i=0; i <prerequisites.length; i++){

        }
	}
	
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i=0; i <prerequisites.length; i++){
            if(prerequisites[i][1] > numCourses-1){
                    return false;
            }
            if(map.containsKey(prerequisites[i][1])){
            	// get dependencies of prerequisites[i][1]
            	List<Integer> list = map.get(prerequisites[i][1]);
            	for(Integer l : list) {
            		if(l == prerequisites[i][0])
            			return false;
            		
            	}
            		return false;
            }
            map.putIfAbsent(prerequisites[i][0], new ArrayList<Integer>());
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            
        }
        return true;
    }
    
   
}
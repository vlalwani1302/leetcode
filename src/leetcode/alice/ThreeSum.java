package leetcode.alice;
import java.util.ArrayList;
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
            for(int j=1; j< nums.length; j++){
                map.put(j, nums[j]);
                if(j < nums.length -1){
                	map.put(j+1, nums[j+1]);
                }
                if(j < nums.length -1 && map.get(j) != null && map.get(j+1) != null ){
                	 if(a==b && b==c) {
                     	break;
                     }
                	b = map.get(j);
                	c = map.get(j+1);
                    if(b + c == x && j > i && (j+1) > i){
	                    list.add(a);
	                    list.add(b);
	                    list.add(c);
	                    result.add(list);
	                    list = new ArrayList<Integer>();
	                    continue;
                    }
                 
                   
                }
                
                if(a==b && b==c) {
                	break;
                }

            }
        }
        return result;
    }
    
    public static void main(String[] args) {
    	List<List<Integer>> result1 = threeSum(new int[] {0,0,0,0});

    	System.out.println();
	}
}
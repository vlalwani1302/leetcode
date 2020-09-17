package leetcode.alice.array;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class TpKFrequentElements {
	public static void main(String[] args) {
		topKFrequent(new int[] {4,1,-1,2,-1,2,3}, 2);
	}
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            map.putIfAbsent(nums[i], 0);
            int count = map.get(nums[i]);
            map.put(nums[i], ++count);
        }
        
        /*Map<Integer, Integer> reverseSortedMap = new HashMap<Integer, Integer>();

        map.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
        .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        */
     
        map = map.entrySet()
        		.stream()
        		.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
        		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));		
        		
        int[] result = new int[k];
        int i=0;
        for(Entry<Integer, Integer> entry : map.entrySet()){
            if(i < k){
                result[i] = entry.getKey();
                i++;
            }
            
        }
        return result;  
    }
}

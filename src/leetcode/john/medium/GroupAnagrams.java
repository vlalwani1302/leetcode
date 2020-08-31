package leetcode.john.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static List<List<String>> groupAnagrams(String[] strs) {
		// map to store sorted string and list of anagrams as key value pairs
		Map<String, List<String>> map = new HashMap<>();
		for(String word : strs) {
			char[] charArr = word.toCharArray();
			Arrays.sort(charArr); // anagrams once sorted will result in same string
			map.putIfAbsent(String.valueOf(charArr), new ArrayList<>());
			map.get(String.valueOf(charArr)).add(word);
		}
		return new ArrayList<>(map.values());
    }
	
	 public static void main(String[] args) {
		 String[] arrItems1 = new String[] {"eat","tea","tan","ate","nat","bat"};
		 String[] arrItems2 = new String[] {""};
		 String[] arrItems3 = new String[] {"a"};

         List<List<String>> result1 = groupAnagrams(arrItems1);
         List<List<String>> result2 = groupAnagrams(arrItems2);
         List<List<String>> result3 = groupAnagrams(arrItems3);
         System.out.println(result1);
         System.out.println(result2);
         System.out.println(result3);
         
}
}

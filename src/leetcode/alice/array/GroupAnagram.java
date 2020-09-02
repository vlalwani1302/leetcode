package leetcode.alice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupAnagram {
	
	public static void main(String[] args) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		groupAnagrams(strs);
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> result = new ArrayList<List<String>>();

		Set<String> set = new HashSet<String>();
		for (int i = 0; i < strs.length; i++) {
			String s = strs[i];

			char[] sortedChar = s.toCharArray();
			Arrays.sort(sortedChar);
			boolean alone = false;
			if(!set.add(String.valueOf(sortedChar))) {
				continue;
			}else {
				alone = true;
			}
			
			boolean isAnagram = false;
			List<String> list = new ArrayList<String>();

			for (int j = 0; j < strs.length; j++) {
				if (i == j) {
					continue;
					
				}

				String str = strs[j];
				char[] arr = str.toCharArray();
				Arrays.sort(arr);
				if(String.valueOf(sortedChar).equals(String.valueOf(arr))) {
					isAnagram = true;
					list.add(strs[j]);
				}

			}
			if (isAnagram) {
				list.add(strs[i]);
				result.add(list);
			}
			if(alone && !isAnagram) {
				list.add(strs[i]);
				result.add(list);

			}
		}

		return result;
	}


	public static List<List<String>> groupAnagramsBetter(String[] strs) {
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
}
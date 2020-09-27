package leetcode.john.fb.array.easy;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAnAlienDictionary {
    
    private static boolean isAlienSorted(String[] words, String order) {
    	// map of order index
    	Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i< order.length(); i++) {
        	map.put(order.charAt(i), i);
        }
        for(int i = 0; i< words.length-1; i++) {
        	String s1 = words[i];
        	String s2 = words[i+1];
        	int end = Math.min(s1.length(), s2.length());
        	for(int j=0; j<end; j++) {
        		if(s1.charAt(j) != s2.charAt(j)) {
	        		if(map.get(s1.charAt(j)) > map.get(s2.charAt(j))) {
	        			return false;
	        		}
        		break;
        		}
        	}
        	if(s1.length() > s2.length()) {
        		return false;
        	}
        }
		return true;
    }
    
    public static void main(String[] args) {
    	String[] words1 = {"hello","leetcode"};
    	String[] words2 = {"word","world","row"};
    	String[] words3 = {"kuvp","q"};
    	String[] words4 = {"apple","app"};
    	System.out.println(isAlienSorted(words1, "hlabcdefgijkmnopqrstuvwxyz"));
    	System.out.println(isAlienSorted(words2, "worldabcefghijkmnpqstuvxyz"));
    	System.out.println(isAlienSorted(words3, "ngxlkthsjuoqcpavbfdermiywz"));
    	System.out.println(isAlienSorted(words4, "abcdefghijklmnopqrstuvwxyz"));
	}
}
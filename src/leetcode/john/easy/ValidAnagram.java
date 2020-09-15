package leetcode.john.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ValidAnagram {
	public static void main(String[] args) {
		System.out.println(isAnagram1("aacc", "ccac"));
	}
    public boolean isAnagramSorting(String s, String t) {
        if(s.length() != t.length())
            return false;
        char[] charS = s.toCharArray();
        Arrays.sort(charS);
        char[] charT = t.toCharArray();
        Arrays.sort(charT);
        
        return Arrays.equals(charS, charT);
    }
    
    public static boolean isAnagram1(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i <s.length(); i++){
        	map.putIfAbsent(s.charAt(i), 0);
        	map.put(s.charAt(i), map.get(s.charAt(i))+1);
        }
        
        for(int i=0; i <s.length(); i++){
            if(map.containsKey(t.charAt(i))){
                if(map.get(t.charAt(i)) <= 0){
                    return false;
                }else{
                    map.put(t.charAt(i), map.get(t.charAt(i)) -1);
                }
            }else{
                return false;
            }
        }
        
        return true;
    }
    
    // TC - O(N), SC - O(1)
    
    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        int[] counter = new int[26];
        for(int i=0; i<s.length(); i++){
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        
        for(int count : counter){
            if(count != 0)
                return false;
        }
        return true;
    }
}
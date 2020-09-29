package leetcode.john.fb.array.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    
    private static int romanToInt(String s) {
    	Map<Character, Integer> values = new HashMap<>();
        values.put('M', 1000);
        values.put('D', 500);
        values.put('C', 100);
        values.put('L', 50);
        values.put('X', 10);
        values.put('V', 5);
        values.put('I', 1);
        
        int result = 0;
        for	(int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	if(i< s.length()-1 && values.get(c) < values.get(s.charAt(i+1))) {
        		result = result - values.get(c);
        	}else {
        		result = result + values.get(c);
        	}
        }
		return result;
    }
    
	public static void main(String[] args) {
	}
}
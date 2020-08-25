package leetcode.john.medium;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestSubstring {

	// Brute Force
	public static int lengthOfLongestSubstring1(String s) {
		Set<String> charSet = new HashSet<>();
		int n = s.length();
		int max = 1;
		for(int i = 0; i < n-1; i++) {
			for(int j = i; j < n; j++) {
				String temp = String.valueOf(s.charAt(j));
				if(charSet.contains(temp)) {
					int size = charSet.size();
					if(size > max)
						max = size;
					charSet.clear();
					break;
				}else {
					charSet.add(temp);
				}
			}
		}
		return max;
    }
	// test
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str;
        
        while(true) {
        	str = in.nextLine();
        	int len = lengthOfLongestSubstring1(str);
        	System.out.println(len);
        }
	}
}

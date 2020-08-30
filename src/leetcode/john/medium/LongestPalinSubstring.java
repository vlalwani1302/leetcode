package leetcode.john.medium;

import java.util.Scanner;

public class LongestPalinSubstring {
	public String longestPalindrome(String s) {
		if (s.isEmpty()) return "";
		int start = 0, end = 0;

		for (int i = 0; i < s.length(); i++) {
			int len1 = expandFromMiddle(s, i, i); // for odd string
			int len2 = expandFromMiddle(s, i, i+1); // for even string
			int len = Math.max(len1, len2);
			// now find actual index positions
			if(len > end - start) {
				start = i - (len -1)/2;
				end = i + (len)/2;
			}
		}
		return s.substring(start, end + 1);
	}
	
	public static int expandFromMiddle(String s, int l, int r){
		if(s == null || l > r) return 0;
		while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		/* Normally it should be length = r - l + 1 but since in last iteration
		 * r will be 1 extra and l will be 1 less so first subtract  from both and 
		 * then add 1 i.e. (r-1) - (l-1) +1 = r - l - 1 
		 */
		return r - l - 1;
	}

	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LongestPalinSubstring o = new LongestPalinSubstring();
        String str;
        
        while(true) {
        	str = in.nextLine();
        	String len = o.longestPalindrome(str);
        	System.out.println(len);
        }
	}
}

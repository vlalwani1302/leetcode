package leetcode.john.fb.strings;

public class OneEditDistance {
	public static boolean isOneEditDistance(String s,String t){
		// if the input string are same
	    if (s.equals(t))
	        return false;
	    int len1 = s.length();
	    int len2 = t.length();
	    // If the length difference of the stings is more than 1, return false.
	    if ((len1 - len2) > 1 || (len2 - len1) > 1  ) {
	        return false;
	    }
	    int i = 0, j = 0;
	    int diff = 0;
	    while (i<len1 && j<len2) {
	        char c1 = s.charAt(i);
	        char c2 = t.charAt(j);
	        if (c1 != c2) {
	            diff++;
	            if (len1 > len2)
	                i++;
	            if (len2 > len1)
	                j++;
	            if (len1 == len2) {
	                i++; j++;
	            }
	        }
	        else{
	            i++; j++;
	        }
	        if (diff > 1) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public static void main(String[] args) {
        System.out.println(isOneEditDistance("ab", "ac"));
	}
}

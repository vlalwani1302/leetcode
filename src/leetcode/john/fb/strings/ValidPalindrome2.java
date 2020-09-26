package leetcode.john.fb.strings;

public class ValidPalindrome2 {
	
	public static boolean validPalindrome(String s) {
		if (s.isEmpty()) return true;
		int i = 0, j = s.length()-1;
		while(i<j) {
			if(s.charAt(i) != s.charAt(j)) {
				return isPalindrome(s.substring(i+1,j+1)) || isPalindrome(s.substring(i,j));
			}
			i++;
			j--;
		}
		return true;
    }
	public static boolean isPalindrome(String s) {
		if (s.isEmpty()) return true;
		int i = 0, j = s.length()-1;
		while(i<j) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
    }
	
	public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));
	}
}

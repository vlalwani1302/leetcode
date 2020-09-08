package leetcode.john.easy;

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		if (s.isEmpty()) return true;
		int l = 0, r = s.length()-1;
		
		while(l<r) {
			while(l<r && !Character.isLetterOrDigit(s.charAt(l))) {
				l++;
			}
			while(l<r && !Character.isLetterOrDigit(s.charAt(r))) {
				r--;
			}
			if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
				return false;
			l++;
			r--;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
	}
}

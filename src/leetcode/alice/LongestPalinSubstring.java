package leetcode.alice;

// Java implementation of O(n^2) 
// time and O(1) space method 
// to find the longest palindromic substring 
public class LongestPalinSubstring {
	public String longestPalindrome(String s) {
		if (s.isEmpty()) {
			return "";
		}
		int n = s.length();
		int low, high;
		int start = 0;
		int maxLength = 1;

		for (int i = 1; i < n; i++) {
			low = i - 1;
			high = i;

			while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
				if (high - low + 1 > maxLength) {
					start = low;
					maxLength = high - low + 1;
				}

				--low;
				++high;
			}

			low = i - 1;
			high = i + 1;
			while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {
				if (high - low + 1 > maxLength) {
					start = low;
					maxLength = high - low + 1;
				}

				--low;
				++high;
			}
		}

		return printSubStr(s, start, start + maxLength - 1);
	}

	public String printSubStr(String str, int low, int high) {
		return (str.substring(low, high + 1));
	}
}

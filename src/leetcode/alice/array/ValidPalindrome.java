package leetcode.alice.array;

class ValidPalindrome {
	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s));

		System.out.println(isPalindrome(".,"));
		System.out.println(isPalindrome("ab"));
	}

	public static boolean isPalindromeOld(String s) {
		if (s.isEmpty())
			return true;

		int i = 0;
		int j = s.length() - 1;

		while (i < j && i != j) {
			if (isValidAlphaChar(s.charAt(i)) && isValidAlphaChar(s.charAt(j))) {
				if (s.charAt(i) == s.charAt(j) || s.charAt(i) > 57 && s.charAt(i) > 57 && Math.abs(s.charAt(i) - s.charAt(j)) == 32) {
					i++;
					j--;
					continue;
				}else {
					return false;
				}
			} else if (!isValidAlphaChar(s.charAt(i)) && isValidAlphaChar(s.charAt(j))) {
				i++;
				while (!isValidAlphaChar(s.charAt(i)) && i != j) {
					i++;

				}
				if (s.charAt(i) == s.charAt(j) || s.charAt(i) > 57 && s.charAt(i) > 57 && Math.abs(s.charAt(i) - s.charAt(j)) == 32) {
					i++;
					j--;
					continue;

				} else {
					return false;
				}
			} else if (isValidAlphaChar(s.charAt(i)) && !isValidAlphaChar(s.charAt(j))) {
				j--;
				while (!isValidAlphaChar(s.charAt(j)) && i != j) {
					j--;

				}
				if (s.charAt(i) == s.charAt(j) || s.charAt(i) > 57 && s.charAt(i) > 57 && Math.abs(s.charAt(i) - s.charAt(j)) == 32) {
					i++;
					j--;
					continue;

				} else {
					return false;
				}
			} else {
				i++; j--;
			}
		}
		return true;
	}

	public static boolean isPalindrome(String s) {
		if (s.isEmpty())
			return true;
		int i = 0;
		int j = s.length() - 1;

		while (i < j && i != j) {
			while(!isValidAlphaChar(s.charAt(i)) && i < j) {
				i++;
			}
			while(!isValidAlphaChar(s.charAt(j)) && i <j) {
				j--;
			}
			if (s.charAt(i) == s.charAt(j) || 
					s.charAt(i) > 57 && s.charAt(i) > 57 
					&& Math.abs(s.charAt(i) - s.charAt(j)) == 32) {
				i++;
				j--;
			}else {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isValidAlphaChar(char c) {
		if (c >= 48 && c <= 57)
			return true;
		if (c >= 65 && c <= 90)
			return true;
		if (c >= 97 && c <= 122)
			return true;
		return false;
	}
}
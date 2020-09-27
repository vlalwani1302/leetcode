package leetcode.alice.string;

class ValidPalindrom2 {
	public static void main(String[] args) {
		System.out.println(validPalindrome2(
				"aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
		System.out.println(validPalindrome2("eeccccbebaeeabebccceea"));
		System.out.println(validPalindrome2("tcaac"));
	}

	public static boolean validPalindrome2(String s) {

		int start = 0;
		int end = s.length() - 1;
		boolean isDeleted = false;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				if (!isDeleted && start + 1 < s.length() && s.charAt(start + 1) == s.charAt(end)) {
					if (start + 1 == end)
						return true;
					String str1 = s.substring(start + 1, start + 3);
					StringBuilder str2 = new StringBuilder(s.substring(end - 1, end+1));

					if (str1.equals(str2.reverse().toString())) {
						start++;
						isDeleted = true;
						continue;
					}
				}
				if (!isDeleted && end - 1 >= 0 && s.charAt(end - 1) == s.charAt(start)) {
					if (end - 1 == start)
						return true;
					String str3 = s.substring(start, start + 2);
					StringBuilder str4 = new StringBuilder(s.substring(end - 2, end));

					if (str3.equals(str4.reverse().toString())) {
						end--;
						isDeleted = true;
						continue;
					}
				}
				return false;
			}
			start++;
			end--;
		}

		return true;
	}
}
package leetcode.alice.string;

import java.util.HashSet;
import java.util.Set;

class LOngestSubstringWithoutRepeatingCharacter {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}

	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			// try to extend the range [i, j]
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}
    public static int lengthOfLongestSubstring1(String s) {
        
        if(s.isEmpty()){
            return 0;
        }
		int n = s.length();
		int result = 1;
		
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n ; i++){
            if(sb.indexOf(String.valueOf(s.charAt(i))) < 0){
                sb.append(s.charAt(i));
            }else{
                result = Math.max(result, sb.length());
            	sb.delete(0, sb.indexOf(String.valueOf(s.charAt(i))) + 1);
            	sb.append(s.charAt(i));
                
            }
        }
        result = Math.max(result, sb.length());

		return result;
    
    
    }
}
package leetcode.john.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class WordBreak {
	static Map<String, Boolean> map = new HashMap<String, Boolean>();

	public static void main(String[] args) {
		System.out.println(wordBreak("leetcode", Arrays.asList("leet","code","apple","peach")));

		boolean result = wordBreak("abcd", Arrays.asList("a","abc","b","cd"));
		System.out.println(result);
		
		System.out.println(wordBreak("applepie", Arrays.asList("pie","pear","apple","peach")));
		System.out.println(wordBreak("cbca", Arrays.asList("bc","ca")));
//		System.out.println(wordBreakRecursion("catsandogcat", Arrays.asList("cats","dog","sand","and","cat","an")));
		
		System.out.println(wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));

	}
	

	public static boolean wordBreak(String s, List<String> wordDict) {
	        return wordBreakRecursion(s, wordDict, 0);
	    }
	 
    public static boolean wordBreakRecursion(String s, List<String> wordDict, int start){
        if(start == s.length()) 
            return true;
 
        for(String a: wordDict){
            int len = a.length();
            int end = start+len;
 
            //end index should be <= string length
            if(end > s.length()) 
                continue;
 
            if(s.substring(start, start+len).equals(a))
                if(wordBreakRecursion(s, wordDict, start+len))
                    return true;
        }
        return false;
    }
    
    // Slow if dict size large, O(string length * dict size)
    public boolean wordBreakDP(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true; //set first to be true
 
        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!dp[i]) 
                continue;
 
            for(String a: wordDict){
                int len = a.length();
                int end = i + len;
                if(end > s.length()) //end index should be <= string length
                    continue;
 
                if(dp[end]) 
                	continue;
 
                if(s.substring(i, end).equals(a)){
                    dp[end] = true;
                }
            }
        }
 
        return dp[s.length()];
    }
    
    // Better if dict size large, O(string length ^2)
    public static boolean wordBreakDP2(String s, List<String> wordDict) {
        int[] dp = new int[s.length()+1];
     
        Arrays.fill(dp, -1);
     
        dp[0]=0;
     
        for(int i=0; i<s.length(); i++){
            if(dp[i]!=-1){
                for(int j=i+1; j<=s.length(); j++){
                    String sub = s.substring(i, j);
                    if(wordDict.contains(sub)){
                        dp[j]=i;
                    }
                } 
            }
        }
        return dp[s.length()]!=-1;
    }
    
}

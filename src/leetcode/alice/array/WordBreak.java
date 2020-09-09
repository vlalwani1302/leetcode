package leetcode.alice.array;

import java.util.ArrayList;
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
		System.out.println(wordBreakRecursion("catsandogcat", Arrays.asList("cats","dog","sand","and","cat","an")));
		
		System.out.println(wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));

	}
	
	// Recursion - time limit exceeds
    public static boolean wordBreakRecursion(String s, List<String> wordDict) {
    	
    	if(s.isEmpty()) {
    		return true;
    	}
    	
    	for(int i=1; i<=s.length(); i++) {
    		if(wordDict.contains(s.substring(0, i)) && wordBreakRecursion(s.substring(i, s.length()), wordDict)) {
    			return true;
    		}
    	}
    	return false;
    }

    public static boolean wordBreakRecursion1(String s, List<String> wordDict) {

    	if(s.isEmpty()) {
    		return true;
    	}
    
    	if(map.containsKey(s) && map.get(s)) {
    		return true;
    	}
    	
    	for(int i=1; i<=s.length(); i++) {
    		if(wordDict.contains(s.substring(0, i)) && wordBreakRecursion1(s.substring(i, s.length()), wordDict)) {
    			map.put(s.substring(i, s.length()), true);
    			return true;
    		}
    	}
    	map.put(s, false);
    	return false;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {

    	return wordBreakRecursion1(s, wordDict);
    }
    
    // dynamic programming - worked and accepted
    public static boolean wordBreakRecursionDP(String s, List<String> wordDict) {
    	
    	int size = s.length();
    	if(s.isEmpty()) {
    		return true;
    	}
    	boolean[] dp = new boolean[size+1];
    	
    	for(int i=1; i<=size; i++) {
    		if(!dp[i] && wordDict.contains(s.substring(0, i))) {
    			dp[i] = true;
    		}
    		
    		if(dp[i]) {
    			if(i == size) {
    				return true;
    			}
    			for(int j=i+1; j <= size; j++) {
    				if(!dp[j] && wordDict.contains(s.substring(i, j))) {
    					dp[j] = true;
    				}
    				if(dp[j] && j == size) {
    					return true;
    				}
    			}
    		}
    	}
    	return false;
    }

    
    // basic approach - did not work for few testcases
	public static boolean wordBreakBF(String s, List<String> wordDict) {
        List<String> subString = new ArrayList<String>();
        for(String dict : wordDict){
            
            if(subString.size() > 0){
                for(int i=0; i<subString.size(); i++){      
                	String sub = subString.get(i);
                     if(sub.startsWith(dict)){
                         
                         sub = sub.replaceAll(dict,"");
                         
                         if(sub.isEmpty()){
                            return true;
                         }
                        subString.set(i, sub);
                     }
                }
            }
            if(s.startsWith(dict) || s.endsWith(dict)){
                String sub = s.replaceAll(dict,"");
                if(sub.isEmpty()){
                    return true;
                }
                subString.add(sub);
            }
        }
        return false;
    }
}

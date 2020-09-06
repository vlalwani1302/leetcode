package leetcode.john.medium;


public class DecodeWays {
	public static int numDecodings(String s) {
		int result = 1;
		if(s.length() <= 0 || Integer.valueOf(s) == 0 || s.charAt(0) == '0'
				|| s.contains("00")) 
			return 0;
		if(s.length() > 1 && Integer.valueOf(s.substring(0,s.length()-1)) == 0)
			return 0;
         for(int i=1; i<s.length(); i++) {
        	String sub = s.substring(i-1,i+1);
        	if((Integer.valueOf(sub) >= 10 && Integer.valueOf(sub) <= 26)
//        			&& s.charAt(i-1) != '0' && s.charAt(i) != '0' 
        			){
        		result = result+1;
        	}
        }
		return result;
    }
	
	public static int numDecodingsDp(String s) {
		int[] dp = new int[s.length()+1];
		dp[0]=1;
		dp[1]= s.charAt(0) == '0' ? 0 : 1;
		
		for(int i=2; i<=s.length(); i++) {
			int one = Integer.valueOf(s.substring(i-1,i));
			int two = Integer.valueOf(s.substring(i-2,i));
			if(one >=1) {
				dp[i]+= dp[i-1];
			}
			if(two >= 10 &&  two <=26) {
				dp[i]+=dp[i-2];
			}
		}
		return dp[s.length()];
    }
	
	
	public static void main(String[] args) {
        	System.out.println(numDecodings("12"));
        	System.out.println(numDecodingsDp("12"));
	}
}

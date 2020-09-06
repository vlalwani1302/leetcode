package leetcode.alice.array;
class DecodeWays {
	public static void main(String[] args) {
		System.out.println(numDecodings("27"));
		System.out.println(numDecodings("227"));

	}
	/*
	public static int numDecodings(String s) {
    	
		int count = 1;
    	if(s.length() == 0) {
    		return 0;
    	}
    	if(s.length() == 1) {
    		if(s.equals("0")){
    			return 0;
    		}
    		return 1;
    	}
    	if(s.length() == 2) {
    		int value = Integer.valueOf(s);
    		if(value > 0 && value < 27) {
    			return 2;
    		}
    		return 1;
    	}
    	for(int i=0; i <s.length()-1;i++) {
    		int subValue = Integer.valueOf(s.substring(i, i+1));
    		if(subValue > 0 && subValue < 27)
    			count++;
    	}
    	return count;
        
    }
	*/

	public static int numDecodings(String s) {
    	
    	return decode(s.toCharArray(), s.length());
        
    }
    
	static int decode(char[] digits, int n)  
	{ 
	    // base cases 
	    if (n == 0 || (n == 1 && digits[0] != '0')) 
	       return 1; 
	  
	    // for base condition "01123" should return 0    
	    if (digits[0]=='0')    
	         return 0; 
	  
	    // Initialize count 
	    int count = 0;  
	  
	    // If the last digit is not 0, then  
	    // last digit must add to 
	    // the number of words 
	    if (digits[n - 1] > '0') 
	    count = decode(digits, n - 1); 
	  
	    // If the last two digits form a number 
	    // smaller than or equal to 26, 
	    // then consider last two digits and recur 
	    if (digits[n - 2] == '1' ||  
	       (digits[n - 2] == '2' && digits[n - 1] < '7')) 
	    count += decode(digits, n - 2); 
	  
	    return count; 
	} 
}
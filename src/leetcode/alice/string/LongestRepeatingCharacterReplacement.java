package leetcode.alice.string;
class LongestRepeatingCharacterReplacement {
	
	public static void main(String[] args) {
		System.out.println(characterReplacement1("AABABBA" ,1));
		System.out.println(characterReplacement1("ABBB" ,1));
		System.out.println(characterReplacement1("BAAAB" ,2));
	}
    public static int characterReplacement(String s, int k) {
        int max = 0;
        for(int i=0; i<s.length(); i++){
            int counter = k;
            int j = i+1;
            while(j < s.length() && counter >= 0){
                if(s.charAt(j) == s.charAt(i)){
                    j++;
                    continue;
                }else{
                    if(counter == 0)
                        break;
                    counter--; j++;
                }
                
            }
            
            max = Math.max(max, j-i);
           
        }
        
        return max;
    }
    
    public static int characterReplacement1(String s, int k) {
        int max = 0;
        int left = 0;
        int right = s.length()-1;
        // two pointer loop
        
        while(left < right) {
        	int leftMoves = k;
        	int leftNext = left+1;
        	int rightMoves = k;
        	int rightNext = right-1;
        	
        	while(leftNext < s.length() && leftMoves >= 0){
                if(s.charAt(leftNext) == s.charAt(left)){
                	leftNext++;
                    continue;
                }else{
                    if(leftMoves == 0)
                        break;
                    leftMoves--; leftNext++;
                }
                
            }
        	if(leftMoves > 0 && left > 0) {
            	max = Math.max(max, leftNext - left + Math.min(leftMoves, left));
        	}else {
        		max = Math.max(max, leftNext - left);
        	}
        	
        	while(rightNext >=0 && rightMoves >= 0){
                if(s.charAt(rightNext) == s.charAt(right)){
                	rightNext--;
                    continue;
                }else{
                    if(rightMoves == 0)
                        break;
                    rightMoves--; rightNext--;
                }
                
            }
        	
        	if(rightMoves > 0 && right < s.length()-1) {
            	max = Math.max(max, right - rightNext + Math.min(rightMoves, s.length()-1-right ));
        	}else {
            	max = Math.max(max, right - rightNext);
        	}
        	
        	max = Math.max(max, right - rightNext);
        	
        	left++;
        	right--;

        }
        return max;
    }
}
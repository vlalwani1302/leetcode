package leetcode.john.fb.array.medium;

public class MaximumSwap {
	
	public static int maximumSwap(int num) {
		char[] s = Integer.toString(num).toCharArray();
		boolean swapped = false;
        for(int i=0; i<s.length-1; i++) {
        	for(int j = i+1; j<s.length; j++) {
        		if(Integer.valueOf(s[j]) > Integer.valueOf(s[i])) {
        			char temp = s[i];
        			s[i] = s[j];
        			s[j] = temp;
        			swapped = true;
        			break;
        		}
        		if(swapped) {
        			break;
        		}
        	}
        }
		return Integer.valueOf(new String(s));
    }
	
	public static void main(String[] args) {
		System.out.println(maximumSwap(2736));
		 System.out.println(maximumSwap(9963));
	}
}

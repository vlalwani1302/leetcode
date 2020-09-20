package leetcode.john.fb.strings;

/* Q 415. Add Strings
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 Note:
 The length of both num1 and num2 is < 5100.
 Both num1 and num2 contains only digits 0-9.
 Both num1 and num2 does not contain any leading zero.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/
	
public class AddStrings {
	public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        int iChar = 0;
        int jChar = 0;
        int lastBit = 0;
        while(i >=0 || j >=0) {
        	if(i >=0 && j >=0) {
        		iChar = num1.charAt(i--) - '0'; // OR alternately write Character.getNumericValue(num2.charAt(j--)) to get interger value of character
        		jChar = num2.charAt(j--) - '0';
        		lastBit = (iChar + jChar + carry) % 10;
        		carry = (iChar + jChar + carry) / 10;
        		sb.insert(0, lastBit);
        	}
        	else if(i >=0 && j <0) {
        		iChar = num1.charAt(i--) - '0';
        		jChar = 0;
        		lastBit = (iChar + jChar + carry) % 10;
        		carry = (iChar + jChar + carry) / 10;
        		sb.insert(0, lastBit);
        	}
        	else if(i <0 && j >=0) {
        		iChar = 0;
        		jChar = num2.charAt(j--) - '0';
        		lastBit = (iChar + jChar + carry) % 10;
        		carry = (iChar + jChar + carry) / 10;
        		sb.insert(0, lastBit);
        	}
        }
        sb = carry == 1 ? sb.insert(0, carry) : sb;
        return sb.toString();
    }
	
	 public static void main(String[] args) {
	    	System.out.println(addStrings("1", "111"));
		}
}
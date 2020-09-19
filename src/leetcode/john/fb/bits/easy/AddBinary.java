package leetcode.john.fb.bits.easy;

/* Q 67
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
	
public class AddBinary {
	public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        int iChar = 0;
        int jChar = 0;
        int lastBit = 0;
        while(i >=0 || j >=0) {
        	if(i >=0 && j >=0) {
        		iChar = Character.getNumericValue(a.charAt(i--));
        		jChar = Character.getNumericValue(b.charAt(j--));
        		lastBit = (iChar + jChar + carry) & 1;
        		carry = (iChar + jChar + carry) >>> 1;
        		sb.insert(0, lastBit);
        	}
        	else if(i >=0 && j <0) {
        		iChar = Character.getNumericValue(a.charAt(i--));
        		jChar = 0;
        		lastBit = (iChar + jChar + carry) & 1;
        		carry = (iChar + jChar + carry) >>> 1;
        		sb.insert(0, lastBit);
        	}
        	else if(i <0 && j >=0) {
        		iChar = 0;
        		jChar = Character.getNumericValue(b.charAt(j--));
        		lastBit = (iChar + jChar + carry) & 1;
        		carry = (iChar + jChar + carry) >>> 1;
        		sb.insert(0, lastBit);
        	}
        }
        sb = carry == 1 ? sb.insert(0, carry) : sb;
        return sb.toString();
    }
	
	 public static void main(String[] args) {
	    	System.out.println(addBinary("1", "111"));
		}
}
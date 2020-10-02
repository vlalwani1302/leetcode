package leetcode.john.easy.bits;
public class BitManipulation {

	// add 2 numbers
	public static int getSum(int a, int b) {
         while(b!=0) {
            int carry = a&b;
            a = a^b;
            b = carry<<1;
        }
        return a;
    }
	
	// subtract 2 numbers
	public static int getDifference(int a, int b) {
        while(b!=0) {
           int brw = (~a)&b;
           a = a^b;
           b = brw<<1;
       }
       return a;
   }
	
	public static int getDifference2(int a, int b) {
       int result = getSum(a, getSum(~b,1));
       return result;
   }
	
	// multiply 2 numbers
	public static int multiply(int a, int b) {
        // a*b == a+a+a...b times
		int result = 0;
		while(b>0) {
			result = getSum(result, a);
			b--;
		}
       return result;
   }
	
	// count no if 1 bits
	public int[] countBits(int num) {
        int[] bits = new int[num+1];
        for(int i=0; i<=num; i++){
            bits[i] =  hammingWeight(i);
        }
        return bits;
    }
    
	// hamming weight == no. of 1 bits
    public static int hammingWeight(int n) {
	    int sum = 0;
	    while (n != 0) {
	        sum++;
	        n &= (n - 1);
	    }
	    return sum;
    }
    
    // Reverse Bits
    public static int reverseBits(int n) {
		int result = 0;
		for(int i=0; i<32; i++) {
			result = result << 1;
			result += n%2;
			n = n>>>1;
		}
		return result;
        
    }
	
	public static int reverseBitsUsingAndOROperation(int n) {
		int result = 0;
		for(int i=0; i<32; i++) {
			result = (result<<1) | (n&1); 
						//  (n&1) gives the last bit of n. Ex--> (101 & 001 = 001)
						// after getting last bit OR that with left shifted result
						// to set it in result Ex. 110 | 001 = 111 
						// Ex2.110 | 000 = 110
			n = n>>>1;
		}
		return result;
    }
	
	public static void main(String[] args) {
		System.out.println(getSum(1,3));
		System.out.println(getDifference(3,1));
		System.out.println(getDifference2(3,1));
		System.out.println(multiply(200,2));
	}
}
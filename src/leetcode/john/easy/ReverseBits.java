package leetcode.john.easy;


public class ReverseBits {
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
		System.out.println(reverseBitsUsingAndOROperation(43261596));
	}
}

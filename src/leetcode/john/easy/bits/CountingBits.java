package leetcode.john.easy.bits;
public class CountingBits {
	public int[] countBits(int num) {
        int[] bits = new int[num+1];
        for(int i=0; i<=num; i++){
            bits[i] =  hammingWeight(i);
        }
        return bits;
    }
    
    public static int hammingWeight(int n) {
	    int sum = 0;
	    while (n != 0) {
	        sum++;
	        n &= (n - 1);
	    }
	    return sum;
    }
}
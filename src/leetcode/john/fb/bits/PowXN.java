package leetcode.john.fb.bits;

public class PowXN {

	public static double myPow(double x, int n) {
        double result = 1.0;
        long tempN = n;
        if(tempN<0) {
        	tempN = -1 * tempN;
        }
        while(tempN > 0) {
        	if(tempN%2 == 1) {// odd
        		result = result * x;
        		tempN = tempN-1;
        	}else {
        		x = x*x;
        		tempN = tempN/2;
        	}
        }
        if(n < 0) {
        	result = (double)1.0/(double)result;
        }
		return result;
    }
	
	
	public static void main(String[] args) {
		System.out.println(myPow(-2147483648,-1));
	}
}
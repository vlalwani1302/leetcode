package leetcode.john.easy.bits;
public class SumOfTwoNmbers {

	public static int getSum(int a, int b) {
         while(b!=0) {
            int carry = a&b;
            a = a^b;
            b = carry<<1;
        }
        return a;
    }
	
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
	
	public static void main(String[] args) {
		System.out.println(getSum(1,3));
		System.out.println(getDifference(3,1));
		System.out.println(getDifference2(3,1));
	}
}
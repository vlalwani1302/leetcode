package leetcode.alice.bits;
class CountingBits {
	public static void main(String[] args) {
		countBits(4);
	}
	public static int[] countBits(int num) {
        if(num == 0)
            return new int[]{0};
        
        int[] result = new int[num];
        result[0] = 0;
        for(int i=1; i<=num; i++){
            int count = 0;
            while(i != 0){
                count++;
                i = i & (i-1);
            }
            result[i] = count;
        }
        
        return result;
    }
}
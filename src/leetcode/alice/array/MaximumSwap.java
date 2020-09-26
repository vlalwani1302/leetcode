package leetcode.alice.array;
class MaximumSwap {
	public static void main(String[] args) {
		System.out.println(maximumSwap1(1993));
	}
    public static int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
              
        char firstHigh = 1;
        int highIndex = -1;
        for(int i=0; i<A.length; i++){
            if(A[i] == '9')
                continue;
            for(int j= i+1; j <A.length; j++){
                if(A[j] > A[i]){
                    if(A[j] >= firstHigh){
                        firstHigh = A[j];
                        highIndex = j;
                        
                    }
                }
            }
            
            if(highIndex > -1){
                char temp = A[highIndex];
                A[highIndex] = A[i];
                A[i] = temp;
                break;
            }
        }
     
        return Integer.valueOf(new String(A));
    }
    
    
    // O(N)
    public static int maximumSwap1(int num) {
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i;
        }

        for (int i = 0; i < A.length; i++) {
            for (int d = 9; d > A[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }
}
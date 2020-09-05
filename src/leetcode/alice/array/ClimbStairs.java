package leetcode.alice.array;
class ClimbStairs {
	public static void main(String[] args) {
		System.out.println(climbStairs(45));
		System.out.println(climbStairsDP(45));

	}
    public static int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return climbStairs(n-2) + climbStairs(n-1);
    }
    
    //dynamic programming
    public static int climbStairsDP(int n) {
    	int[] paths = new int[n+1];
    	paths[0] = 0;
    	if(n==0)
    		return paths[n];
    	paths[1] = 1;
    	if(n == 1){
    		return paths[n] ;
    	}
    	paths[2] = 2;
        if(n == 2){
            return paths[n];
        }
        
        for(int i=3; i< paths.length; i++) {
        	paths[i] = paths[i-1] + paths[i-2];
        }
        return paths[n];
    }
}
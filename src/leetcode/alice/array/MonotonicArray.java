package leetcode.alice.array;
class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        boolean increase = false;
        boolean decrease = false; 
        for(int i=0; i<A.length-1; i++){
            if(i+1 < A.length && A[i] == A[i+1]){
                continue;
            }
            
            if(!increase && !decrease){
                if(i+1 < A.length && A[i] >= A[i+1]){
                    increase = true;
                }else if(i+1 < A.length && A[i] <= A[i+1]){
                    decrease = true;
                }
                
            }
            
            if(increase){
                if(i+1 < A.length && A[i] < A[i+1]){
                    return false;
                }
            }else if(decrease){
                if(i+1 < A.length && A[i] > A[i+1]){
                    return false;
                }
            }
        }
        
        return true;
    }
}
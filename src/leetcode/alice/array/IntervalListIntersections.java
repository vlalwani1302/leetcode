package leetcode.alice.array;

import java.util.ArrayList;
import java.util.List;

class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        
        List<int[]> list = new ArrayList<int[]>();
        for(int i=0; i<A.length; i++){
            for(int j=0; j<B.length; j++){
                int[] intersection = new int[2];
                if(A[i][0] <= B[j][0] && B[j][0] <= A[i][1]){
                    intersection[0] = B[j][0];
                    intersection[1] = Math.min(A[i][1], B[j][1]);
                }else if(A[i][0] <= B[j][1] && B[j][1] <= A[i][1]){
                    intersection[0] = B[j][1];
                    intersection[1] = Math.max(A[i][0], B[j][0]);

                }else if(B[j][0] <= A[i][0] && A[i][0] <= B[j][1]){
                    intersection[0] = A[i][0];
                    intersection[1] = Math.min(A[i][1], B[j][1]);
                }else{
                    continue;
                }
                
                if(intersection[0] > intersection[1]){
                    int temp = intersection[1];
                    intersection[1] = intersection[0];
                    intersection[0] = temp;
                }
                list.add(intersection);   
            }
        }
        
        return list.toArray(new int[list.size()][]);
    }
}
//package leetcode.john.medium;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CombinationSum2 {
//	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        if (l > r) 
//        { 
//            Console.Write(sum + " "); 
//            return; 
//        } 
//      
//        // Subset including arr[l] 
//        subsetSums(arr, l+1, r, sum + arr[l]); 
//      
//        // Subset excluding arr[l] 
//        subsetSums(arr, l+1, r, sum); 
//	    }
//		return result;
//	}
//	
//
//	public static void main(String[] args) throws IOException {
//
//        List<List<Integer>> result1 = combinationSum(new int[] {2,3,6,7}, 7);
//
//        System.out.println(result1);
//
//
//	}
//}

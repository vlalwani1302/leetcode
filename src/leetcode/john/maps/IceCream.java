package leetcode.john.maps;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class IceCream {


	    // Complete the icecreamParlor function below.
	    static int[] icecreamParlor(int m, int[] cost) {
	    	Map<Integer, List<Integer>> priceIndexMap = new HashMap<>();
	    	for(int i = 0; i < cost.length; i++) {
	    		priceIndexMap.putIfAbsent(cost[i], new ArrayList<>());
	    		priceIndexMap.get(cost[i]).add(i);
	    	}
	    	int index1 = 0;
	    	int index2 = 0;
	    	int counter = 0;
	    	boolean found = false;
	    	while(counter < cost.length && !found) {
	    		int price2 = m - cost[counter];
	    		List<Integer> priceIndices = priceIndexMap.get(price2);
	    		if(priceIndices != null && !priceIndices.isEmpty()) {
	    			Integer max = Collections.max(priceIndices);
	    			found = true;
	    			if(counter < max) {
	    				index1 = counter;
	    				index2 = max;
	    			}
	    		}
	    		counter++;
	    	}
	    	return new int[] {index1 + 1, index2 + 1};
	    }
	    
	    static int[] icecreamParlor2(int m, int[] cost) {
	    	Map<Integer, Integer> map = new HashMap<>();
	    	for(int i = 0; i < cost.length; i++) {
	    		Integer price1 = cost[i];
	    		Integer price2 = m - price1;
	    		Integer index2 = map.get(price2); // index2 is lower since boy2 choosing from previous entries
	    		if(index2 != null) {
	    			return new int[] {index2 + 1, i + 1};
	    		}
	    		map.put(price1, i);
	    	}
			return new int[2];
	    }
	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
//	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int t = scanner.nextInt();
//	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int tItr = 0; tItr < t; tItr++) {
	            int m = scanner.nextInt();
//	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            int n = scanner.nextInt();
//	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            int[] cost = new int[n];

//	            String[] arrItems = new String[] {"1","4","5","3","2"};
	            String[] arrItems = new String[] {"2","2","4","3"};
//	            		scanner.nextLine().split(" ");
//	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            for (int i = 0; i < n; i++) {
	                int arrItem = Integer.parseInt(arrItems[i]);
	                cost[i] = arrItem;
	            }

	            int[] result = icecreamParlor(m, cost);

	            for (int i = 0; i < result.length; i++) {
//	                bufferedWriter.write(String.valueOf(result[i]));
	                System.out.print(result[i] + " ");

//	                if (i != result.length - 1) {
//	                    bufferedWriter.write(" ");
//	                }
	            }

//	            bufferedWriter.newLine();
	        }

//	        bufferedWriter.close();

	        scanner.close();
	}

}

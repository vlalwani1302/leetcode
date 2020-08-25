package leetcode.john.stack;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BalancedBracket {

    static String isBalanced(String s) {
    	int n = s.length();
    	if (n % 2 != 0) {// Not balanced of not an even numbered string length
    		return "NO";
    	}
    	Character[] c1 = new Character[n];
    	Character[] c2 = new Character[n];
    	int j = n-1;
    	
    	for(int i = 0; i < n/2 ; i++ ) {
    		if(s.charAt(i) == '{' && s.charAt(j) != '}') {
    			return "NO";
    		}else if(s.charAt(i) == '[' && s.charAt(j) != ']') {
    			return "NO";
    		}else if(s.charAt(i) == '(' && s.charAt(j) != ')') {
    			return "NO";
    		}else if(s.charAt(i) != '{' || s.charAt(i) != '[' || s.charAt(i) != '(') { 
    			return "NO";
    		}
    		j--;
    	}
    	
		return "YES";
    }
    
    static String isBalancedStack(String s) {
    	if (s.length() % 2 != 0) {// Not balanced of not an even numbered string length
    		return "NO";
    	}
    	Stack<Character> s1 = new Stack<>();
    	
    	for(int i = 0; i < s.length() ; i++ ) {
    		if(s.charAt(i) == '{' ) {
    			s1.push('}');
    		}else if(s.charAt(i) == '[') {
    			s1.push(']');
    		}else if(s.charAt(i) == '(') {
    			s1.push(')');
    		}else if(s1.isEmpty() || s1.pop() != s.charAt(i)) {
    			return "NO";
    		}
    	}
    	
		return "YES";
    }


    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//        int t = scanner.nextInt();
    	Scanner scanner = new Scanner(System.in);

        while(true) {
            String s = scanner.nextLine();

            String result1 = isBalanced(s);
            String result = isBalancedStack(s);
            System.out.println(result1);
            System.out.println(result);
//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

//        scanner.close();
    }
}

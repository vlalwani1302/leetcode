package leetcode.alice;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String str = scanner.nextLine();
		//isBalanced("{[()]}");
			System.out.println(isBalanced(str));/*
			 * isBalanced("[](){()}"); isBalanced("()"); isBalanced("({}([][]))[]()");
			 * isBalanced("{)[](}]}]}))}(())("); isBalanced("([[)");
			 */
		}
	}

	
	/*
	 * 40 ( 41 ) 91 [ 93 ] 123 { 125 }
	 */
	static String isBalanced(String s) {
		Stack<Character> stack = new Stack<>();
		char[] charArray = s.toCharArray();
		for (char c : charArray) {
			switch (c) {
			case '{':
			case '[':
			case '(':
				stack.push(c);
				break;
			case ')':
				if (!stack.isEmpty()) {
					char lastChar = (char) stack.peek();
					int lastIntVal = (int) lastChar;
					
					if (lastIntVal != 40) {
						return "NO";
					}
					stack.pop();
				}else {
					return "NO";
				}
				break;
			case ']':
				if (!stack.isEmpty()) {
					char lastChar = (char) stack.peek();
					int lastIntVal = (int) lastChar;
					if (lastIntVal != 91) {
						return "NO";
					}
					stack.pop();

				}else {
					return "NO";
				}
				break;
			case '}':
				if (!stack.isEmpty()) {
					char lastChar = (char) stack.peek();
					int lastIntVal = (int) lastChar;
					if (lastIntVal != 123) {
						return "NO";
					}
					stack.pop();

				}else {
					return "NO";
				}
				break;

			}
		}
		return "YES";
	}
}
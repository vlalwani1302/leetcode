package leetcode.alice.string;

import java.util.Stack;

class ValidParantheses {
	public static void main(String[] args) {
		System.out.println(isValid("()"));
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty())
					return false;
				if (c == ')' && stack.peek() != '(')
					return false;
				if (c == '}' && stack.peek() != '{')
					return false;
				if (c == ']' && stack.peek() != '[')
					return false;

				stack.pop();
			}
		}

		return stack.isEmpty() ? true : false;
	}
}
package leetcode.alice.string;

import java.util.Stack;

class BasicCalculator2 {
	static Stack<Integer> stack = new Stack<Integer>();
	public static void main(String[] args) {
		System.out.println(calculate("3+2*2"));
		System.out.println(calculate(" 3+5 / 2 "));
		System.out.println(calculate("42"));
		System.out.println(calculate("1 + 1"));
		System.out.println(calculate("0-2147483647"));

	}
	public static int calculate(String s) {
		s = s.replaceAll("\\s","");
		int prev;
		int curr;
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '+':
				i = getNumber(s, ++i, false);

				break;
			case '-':
				i = getNumber(s, ++i, true);
				break;
			case '*':
				i = getNumber(s, ++i, false);
				curr = stack.pop();
				prev = stack.pop();
				stack.add(prev*curr);
				break;
			case '/':
				i = getNumber(s, ++i, false);
				curr = stack.pop();
				prev = stack.pop();
				stack.add(prev/curr);
				break;
			default:
				i = getNumber(s, i, false);
			}
		}
		
		int result = 0;
		while(!stack.isEmpty()) {
			result+=stack.pop();
		}
		return result;
	}
	
	private static int getNumber(String s, int i, boolean isNegative) {
		StringBuilder sb = new StringBuilder();
		sb.append(s.charAt(i) - '0');

		while(i+1 <s.length() && s.charAt(i+1) >= 48 && s.charAt(i+1) <= 57) {
			sb.append(s.charAt(i+1) - '0');
			i++;
		}
		
		if(isNegative)
			stack.add(0 - Integer.valueOf(sb.toString()));
		else
			stack.add(Integer.valueOf(sb.toString()));
		return i;
	}
}
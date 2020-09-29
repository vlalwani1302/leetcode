package leetcode.alice.string;

import java.util.Stack;

class MinRemoveToMakeValidParentheses {
	public static void main(String[] args) {
		System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
	}
    public static String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder();
        
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
                result.append(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                if(!stack.isEmpty() && stack.peek() != null && stack.peek() == '('){
                	stack.pop();
                    result.append(s.charAt(i));
                }
            }else{
                result.append(s.charAt(i));
            }
        }
        
        while(!stack.isEmpty()){
            result = result.deleteCharAt(result.indexOf(String.valueOf(stack.pop())));
        }
        return result.toString();
    }
}
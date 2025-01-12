/*
20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

*/

package Stacks.LeetCode;

import java.util.Stack;

public class ValidParentheses {
	public static boolean isValid(String str) {
		if (str.length() % 2 != 0) {
			System.out.println("LOL!");
			return false;
		}
		
		Stack<Character> stack = new Stack<>();
		
		for (char c : str.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				} else if (stack.peek() == '(' && c == ')') {
					stack.pop();
				} else if (stack.peek() == '{' && c == '}') {
					stack.pop();
				} else if (stack.peek() == '[' && c == ']') {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String s = "()[]{()(]}}";
		System.out.println(isValid(s));
	}
}
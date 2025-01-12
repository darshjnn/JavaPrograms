package Stacks;

import java.util.Stack;

public class ReverseString {
	public static String reverseString(String str) {
		Stack<Character> stack = new Stack<>();
		StringBuilder reversed = new StringBuilder();
		
		int index = 0;
		while (index < str.length()) {
			stack.push(str.charAt(index));
			index++;
		}
		
		while (!stack.isEmpty()) {
			reversed.append(stack.pop());
		}
		
		return reversed.toString();
	}
	
	public static void main(String[] args) {
		String s = "java";
		System.out.println(reverseString(s));
	}
}
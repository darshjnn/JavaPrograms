package Strings;

public class ReverseStringUsingStringsBuilder {
	public static void main(String[] args) {
		
		StringBuilder str = new StringBuilder("Tony");
		
		for (int i = 0; i < str.length() / 2; i++) {
			
			char front = str.charAt(i);
			char back = str.charAt(str.length() - i - 1);
			
			str.setCharAt(i, back);
			str.setCharAt(str.length() - i - 1, front);
			
		}
		
		System.out.println(str);
		
	}
}

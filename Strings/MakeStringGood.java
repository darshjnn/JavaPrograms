/*
Make String Good

The task is to remove specific special characters (*, $, #) and also the character immediately
following it in the string.

Example 1:
Input: ab*cde$f
Output: abdef

*/

package Strings;

import java.util.Scanner;

public class MakeStringGood {
	public static String makeStringGood(String str) {
		StringBuilder sb = new StringBuilder();
		
		int len = str.length(), i = 0;
		while (i < len) {
			char c = str.charAt(i);
			if (c == '*' || c == '$' || c == '#') {
				++i;
				if (i < len) {
					++i;
				}
			} else {
				sb.append(c);
				++i;
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(makeStringGood(str));
	}
}

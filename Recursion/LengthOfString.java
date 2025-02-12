/*
Length of String using Recursion

*/

package Recursion;
public class LengthOfString {
	public static int length(String str) {
		if (str.isEmpty()) {
			return 0;
		}
		
		return length(str.substring(1)) + 1;
	}
	
	public static void main(String[] args) {
		String str = "MentosZindagi";
		System.out.println(length(str));
	}
}
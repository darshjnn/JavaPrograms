/*
Capitalize Each Word

For a given String, convert the first letter of each word to uppercase.

*/

package Strings;

public class CapitalizeEachWord {
	public static String capitalizeEachWord(String str) {
		if (str == null || str.isEmpty()) {
			System.out.println("Empty String...");
			return null;
		}
		
		StringBuilder result = new StringBuilder();
		int n = str.length();
		int firstChar = 0;
		
		while (!Character.isAlphabetic(str.charAt(firstChar)) && firstChar < n - 1) {
			++firstChar;
		}
		
		if (!Character.isAlphabetic(str.charAt(firstChar)) && firstChar == (n - 1)) {
			System.out.println("Invalid String...");
			return null;
		} else {
			result.append(Character.toUpperCase(str.charAt(firstChar)));
		}
		
		for (int i = firstChar + 1; i < n; i++) {
			if (str.charAt(i) == ' ' && i < n - 1) {
				result.append(' ');
				result.append(Character.toUpperCase(str.charAt(++i)));
			} else {
				result.append(str.charAt(i));
			}
		}
		
		return result.toString();
	}
	
	public static void main(String[] args) {
//		String str = "this world is lol! ";
		String str = "+,  /t";
		System.out.println(capitalizeEachWord(str));
	}
}
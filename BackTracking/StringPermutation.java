/*
All Permutations of a String

Time Complexity: O(n * n!).

*/

package BackTracking;

import java.util.ArrayList;

public class StringPermutation {
	public static void permute(String str, String result, ArrayList<String> arr) {
		if (str.isEmpty()) {
			arr.add(result);
			return;
		}
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			String temp = str.substring(0, i) + str.substring((i + 1));
			permute(temp, (result + c), arr);
		}
	}
	
	public static ArrayList<String> getPermutation(String str) {
		ArrayList<String> arr = new ArrayList<>();
		permute(str, "", arr);
		return arr;
	}
	
	public static void main(String[] args) {
		String str = "abc";
		System.out.println("\nString: " + str);
		
		ArrayList<String> arr = getPermutation(str);
		System.out.println("Total Permutations: " + arr.size());
		System.out.println(arr);
	}
}
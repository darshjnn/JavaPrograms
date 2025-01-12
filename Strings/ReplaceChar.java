/*
Replace Character of a given String

*/

package Strings;

import java.util.Scanner;

public class ReplaceChar {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int i;
			String str;
			
			System.out.print("Enter the String: ");
			str = sc.nextLine();
			
			System.out.print("Enter character to replace: ");
			char rep = sc.next().charAt(0);
			
			System.out.print("Enter character to replace with: ");
			char repWith = sc.next().charAt(0);
			
			for (i = 0; i < str.length(); i++) {
				if (str.charAt(i) == (rep)) {
					str = str.replace(str.charAt(i), repWith);
				}
			}
			
			System.out.println("String after replacement is: " + str);
			
		}
	}
}

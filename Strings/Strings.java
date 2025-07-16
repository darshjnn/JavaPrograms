/*
Strings are IMMUTABLE, because of Interning.

If a string is modified, then it takes O(n * m) time,
where n = length of string
	  m = number of times a character is added;
This is because, for each modification, a new string has to be created.

*/

package Strings;

import java.util.Scanner;

public class Strings {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String name1 = "Tony";
		String name2 = "Tony";
		
		if (name1.equals(name2)) {
			System.out.println("OMG!, Equal");
		} else {
			System.out.println("LOL!, Not Equal");
		}
		
		// DO NOT USE == to check for string equality
		// Gives the correct answer here
		if (name1 == name2) {
			System.out.println("OMG!, Equal");
		} else {
			System.out.println("LOL!, Not Equal");
		}
		
		// Gives incorrect answer here
		if ("Tony" == "Tony") {
			System.out.println("OMG!, Equal");
		} else {
			System.out.println("LOL!, Not Equal");
		}
		
		// Substring
		String name = "TonyStark";
		System.out.println(name.substring(0, 4));
		
		// ParseInt Method of Integer class
		String str = "123";
		int number = Integer.parseInt(str);
		System.out.println(number);
		
		// toString Method of String class
		int num1 = 123;
		String str2 = Integer.toString(num1);
		System.out.println(str2);
		
		// String Input
		System.out.print("Enter String 1: ");
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		System.out.print("Enter String 2: ");
		String s2 = sc.nextLine();
		
		// Length
		System.out.println("Length of String 1 is: " + s1.length());
		System.out.println("Length of String 2 is: " + s2.length());
		
		//String Concatenation
		String s3 = s1 + " " + s2;
		System.out.println("Concatenation of String 1 and String 2: " + s3);
		/*
		Another Method for Concatenation:
		String s4 = s1.concat(s2);
		*/
		
		// charAt()
		System.out.println("First char of concatenated String: " + s3.charAt(0) + " \n");
		
		// String Comparison
		String s5 = "LOL";
		String s6 = new String("LOL");
		if (s5.equals(s6)) {
			System.out.println("OMG!, Equal");
		} else {
			System.out.println("LOL!, Not Equal");
		}
		
		// Substring
		String s7 = s3.substring(0, 3);
		System.out.println( "Substring of s3 from index 0 to 3:  "+ s7 + " \n");
		
		// Comparing Strings in Lexicographical Order
		/*
		compareTo() treats 'a' & 'A' differently
		compareToIgnoreCase() treats 'a' & 'A' as same
		*/
		String[] strArr = {"apple", "banana", "mango", "strawberry"};
		String largest = strArr[0];
		/*
		Time Complexity: O(n * N)
			where,  n = length of largest string
				    N = length of the string array
		*/
		for (String s : strArr) {
			if (largest.compareToIgnoreCase(s) < 0) {
				largest = s;
			}
		}
		System.out.println("Largest Lexicographical string: " + largest + " \n");

		sc.close();
	}
}

package Strings;

import java.util.Scanner;

public class UsernameFromEmail {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String inp;
			StringBuilder userName = new StringBuilder();
			int p, i;
			System.out.print("Enter Email-id: ");
			inp = sc.nextLine();
			
			p = inp.indexOf('@');
			
			for (i = 0; i < p; i++) {
				userName.append(inp.charAt(i));
			}
			
			System.out.print("Your User Name is: " + userName);
			
		}
	}
}

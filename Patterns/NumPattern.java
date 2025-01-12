/*
Print Numeric Pattern similar to:
	4 4 4 4 4 4 4
	4 3 3 3 3 3 4
	4 3 2 2 2 3 4
	4 3 2 1 2 3 4
	4 3 2 2 2 3 4
	4 3 3 3 3 3 4
	4 4 4 4 4 4 4

*/

package Patterns;

public class NumPattern {
	public static void printPattern(int p) {
		int n = 2 * p - 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int min = Math.min(Math.min(n - 1 - i, n - 1 - j), Math.min(i, j));
				System.out.print(p - min + "  ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		printPattern(4);
	}
}
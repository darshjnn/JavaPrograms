/*
Print all possible pairs of elements in Array

Total n0. of pairs = n(n - 1) / 2
*/

package Arrays;

public class ArrayPairs {
	private static void printPairs(int[] arr) {
		int tp = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = (i + 1); j < arr.length; j++) {
				System.out.print("[" + arr[i] + " " + arr[j] + "]" + "\t");
				++tp;
			}
			System.out.println();
		}
		
		System.out.println("Total number of pairs: " + tp);
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		
		System.out.println();
		printPairs(arr);
	}
}
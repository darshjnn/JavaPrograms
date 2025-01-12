/*
Subset Sum

Given an array arr of integers, return the sums of all subsets in the list.
Return the sums in any order.

Examples:
Input: arr[] = [2, 3]
Output: [0, 2, 3, 5]
Explanation: When no elements are taken then Sum = 0.
			When only 2 is taken then Sum = 2.
			When only 3 is taken then Sum = 3.
			When elements 2 and 3 are taken then Sum = 2+3 = 5.
			
Input: arr[] = [1, 2, 1]
Output: [0, 1, 1, 2, 2, 3, 3, 4]
Explanation: The possible subset sums are 0 (no elements), 1 (either of the 1's),
			2 (the element 2), and their combinations.
			
Input: arr[] = [5, 6, 7]
Output: [0, 5, 6, 7, 11, 12, 13, 18]
Explanation: The possible subset sums are 0 (no elements), 5, 6, 7, and their combinations.

*/

package ArrayLists;

import java.util.ArrayList;

public class SubsetSum {
	public static void sums(int[] arr, ArrayList<Integer> sums, int i, int sum) {
		if (i == arr.length) {
			sums.add(sum);
			return;
		}
		sums(arr, sums, i + 1, sum + arr[i]);
		sums(arr, sums,  i + 1, sum);
	}
	
	public static ArrayList<Integer> subsetSum(int[] arr) {
		ArrayList<Integer> sums = new ArrayList<>();
		sums(arr, sums, 0, 0);
		return sums;
	}
	
	public static void main(String[] args) {
		int[] arr = {10, 89, 34};
		ArrayList<Integer> subsetSum = subsetSum(arr);
		System.out.println(subsetSum);
	}
}
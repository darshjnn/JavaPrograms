/*
Check if the Array is Sorted

*/

package Recursion;

import java.util.*;

public class CheckIfIncreasing {
	public static boolean isIncreasing(int[] arr, int index) {
		if (index < 0) {
			return false;
		}
		
		if (index >= arr.length - 1) {
			return true;
		}
		
		if (arr[index] <= arr[index + 1]) {
			return isIncreasing(arr, index + 1);
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 5, 6, 7, 7, 8, 9};
		System.out.println("\n" + Arrays.toString(arr) + " \n");
		System.out.println("Given array is in increasing order? : " + isIncreasing(arr, 0));
	}
}
/*
Merge Sort on an Array of Strings

Apply Merge sort to sort an array of Strings.
(Assume that all the characters in all the Strings are in lowercase.)

Input: arr = { "sun", "earth", "mars", "mercury" }
Output: arr = { "earth", "mars", "mercury", "sun"}

*/

package Sorting;

import java.util.Arrays;

public class MergeSortStrings {
	public static String[] conquer(String[] left, String[] right) {
		int l = left.length;
		int r = right.length;
		String[] aux = new String[l + r];
		
		int x = 0, y = 0, i = 0;
		
		while (x < l && y < r) {
			if (left[x].compareTo(right[y]) < 0) {
				aux[i++] = left[x++];
			} else {
				aux[i++] = right[y++];
			}
		}
		
		while (x < l) {
			aux[i++] = left[x++];
		}
		
		while (y < r) {
			aux[i++] = right[y++];
		}
		
		return aux;
	}
	
	public static String[] divide(String[] arr, int low, int high) {
		if (low >= high) {
			return new String[]{arr[low]};
		}
		
		int mid = low + (high - low) / 2;
		
		String[] arr1 = divide(arr, low, mid);
		String[] arr2 = divide(arr, (mid + 1), high);
		
		return conquer(arr1, arr2);
	}
	
	public static String[] sortStrings(String[] arr) {
		return divide(arr, (0), (arr.length - 1));
	}
	
	public static void main(String[] args) {
		String[] str = {"sun", "earth", "mars", "mercury"};
		System.out.println(Arrays.toString(str));
		
		String[] sorted = sortStrings(str);
		System.out.println(Arrays.toString(sorted));
	}
}
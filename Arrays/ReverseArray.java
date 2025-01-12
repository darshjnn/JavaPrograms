/*
Reverse an Array

*/

package Arrays;

import java.util.Arrays;

public class ReverseArray {
	public static void reverseArray(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		
		while (low < high) {
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			
			++low;
			--high;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(Arrays.toString(arr));
		reverseArray(arr);
		System.out.println(Arrays.toString(arr));
	}
}

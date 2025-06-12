/*
Inbuilt Sort

Arrays.sort(arr);
Arrays.sort(arr, si, ei);
Arrays.sort(arr, Collections.reverseOrder());
Arrays.sort(arr, si, ei, Collections.reverseOrder());
Time Complexity: O(nlogn)

reverseOrder() works on objects, and not on primitive datatypes.
Therefore, Integer array must be given as arguments.

*/

/*
Count Sort

It can give Time Complexity of O(n), for some case.

It is used for positive numbers, and where the range of elements in an array is small.

*/

package Sorting;

public class CountSort {
	@SuppressWarnings("JavaExistingMethodCanBeUsed")
	public static void countSort(int[] arr) {
		int max = arr[0];
		
		for (int i : arr) {
			max = Math.max(max, i);
		}
		
		int[] count = new int[max + 1];
		
		for (int i : arr) {
			++count[i];
		}
		
		int j = 0;
		for (int i = 0; i < count.length; i++) {
			while (count[i] > 0) {
				arr[j++] = i;
				--count[i];
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 6, 2, 7, 3, 1, 8};
		
		System.out.println("Original Array: ");
		for (int i : arr) {
			System.out.print(i + "  ");
		}
		System.out.println("\n");
		
		countSort(arr);
		
		System.out.println("Sorted Array: ");
		for (int i : arr) {
			System.out.print(i + "  ");
		}
	}
}
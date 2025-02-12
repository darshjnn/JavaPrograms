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
Insertion Sort

Pick an element from the unsorted part, place it at its correct position in the sorted part.

Time Complexity: O(n^2)

*/

package Sorting;

public class InsertionSort {
	public static void insertionSort(int[] arr) {
		int n = arr.length;
		
		for (int i = 1; i < n; i++) {
			int curr = arr[i];
			int prev = i - 1;
			
			while (prev >= 0 && arr[prev] > curr) {
				arr[prev + 1] = arr[prev];
				--prev;
			}
			
			arr[prev + 1] = curr;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 6, 2, 7, 3, 1, 8};
		
		System.out.println("Original Array: ");
		for (int i : arr) {
			System.out.print(i + "  ");
		}
		System.out.println("\n");
		
		insertionSort(arr);
		
		System.out.println("Sorted Array: ");
		for (int i : arr) {
			System.out.print(i + "  ");
		}
	}
}
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
Selection Sort

Pick the smallest (from unsorted), put it at the beginning.

Time Complexity: O(n^2).

*/

package Sorting;

public class SelectionSort {
	public static void selectionSort(int[] arr) {
		int n = arr.length;
		
		for (int i = 0; i < (n - 1); i++) {
			int smallest = i;
			
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[smallest]) {
					smallest = j;
				}
			}
			
			int temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 6, 2, 7, 3, 1, 8};
		
		System.out.println("Original Array: ");
		for (int i : arr) {
			System.out.print(i + "  ");
		}
		System.out.println("\n");
		
		selectionSort(arr);
		
		System.out.println("Sorted Array: ");
		for (int i : arr) {
			System.out.print(i + "  ");
		}
	}
}
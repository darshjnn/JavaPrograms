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
Bubble Sort

Large element come to the end of the array by swapping with adjacent element.

Time Complexity: O(n^2).

Swap variable inside the first loop optimizes the Bubble Sort for best case scenario, viz, for
the sorted array.

*/

package Sorting;

public class BubbleSort {
	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		
		for (int i = 0; i < n - 1; i++) {
			int swap = 0;
			
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					++swap;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			
			if (swap == 0) {
				return;
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
		
		bubbleSort(arr);
		
		System.out.println("Sorted Array: ");
		for (int i : arr) {
			System.out.print(i + "  ");
		}
		
	}
}
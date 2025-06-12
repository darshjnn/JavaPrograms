/*
Heap Sort

Time Complexity: O(nlogn)

Merge Sort & Quick Sort are in general more efficient than Heap Sort.

To sort the elements in Ascending order, max heap will be required.
For Descending order, min heap will be required.

Basic Logic: Call the heapify for all the non-leaf nodes.
			Call heapify for the swapped element also.

*/

package Sorting;

import java.util.Arrays;

public class HeapSort {
	// Heap Sort for Sorting in Ascending order
	public static void heapSort(int[] arr) {
		int n = arr.length;
		
		// Step 1: Building a Max heap for arranging in Ascending order
		// Call heapify for non-leaf elements or last complete nodes
		// Time complexity: O(nlogn)
		for (int i = n / 2; i >= 0; i--) {
			heapify(arr, i, n);
		}
		
		// Step 2: Push largest at the end and remove from heap
		// Time complexity: O(nlogn)
		for (int i = n - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			heapify(arr, 0, i);
		}
		
		// Final Time Complexity: O(nlogn) + O(nlogn) = O(nlogn)
	}
	
	// Heapify for creating a Max heap
	public static void heapify(int[] arr, int root, int len) {
		int left = (2 * root) + 1;
		int right = (2 * root) + 2;
		int maxInd = root;
		
		if (left < len && arr[left] > arr[maxInd]) {
			maxInd = left;
		}
		
		if (right < len && arr[right] > arr[maxInd]) {
			maxInd = right;
		}
		
		if (maxInd != root) {
			// Swap
			int temp = arr[maxInd];
			arr[maxInd] = arr[root];
			arr[root] = temp;
			
			heapify(arr, maxInd, len);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 1, 2, 4, 3};
		System.out.println(Arrays.toString(arr));
		
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}

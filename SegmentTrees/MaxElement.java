/*
Max Element from Array Queries
Given an arr[ ], answer few queries :
	a. Output Max for the subarray[i ... j]
	b. Update the element at idx

*/

package SegmentTrees;

import java.util.Arrays;
import java.util.Scanner;

public class MaxElement {
	static int[] segTree;
	
	public static void init(int n) {
		segTree = new int[4 * n];
	}
	
	// Segment Tree to find max element int the given range
	public static void buildST(int[] arr, int root, int segmentStart, int segmentEnd) {
		if (segmentStart == segmentEnd) {
			// Leaf Node
			segTree[root] = arr[segmentStart];
			return;
		}
		
		int mid = segmentStart + (segmentEnd - segmentStart) / 2;
		
		buildST(arr, (2 * root + 1), segmentStart, mid); // Left Sub-tree
		buildST(arr, (2 * root + 2), (mid + 1), segmentEnd); // Right Sub-tree
		
		segTree[root] = Math.max(segTree[2 * root + 1], segTree[2 * root + 2]);
	}
	
	// Query function to find max in the given range
	public static int getSubArrayMax(int[] arr, int queryStart, int queryEnd) {
		int n = arr.length;
		
		return getMax(0, 0, n - 1, queryStart, queryEnd);
	}
	
	public static int getMax(int root, int segmentStart, int segmentEnd, int qs, int qe) {
		if (qs > segmentEnd || qe < segmentStart) {
			// Case 1: No Overlap of the Query range with the Current range
			return Integer.MIN_VALUE;
		} else if (qs <= segmentStart && qe >= segmentEnd) {
			// Case 2: Complete Overlap of the Query range with the Current range
			return segTree[root];
		} else {
			// Case 3: Partial Overlap
			int mid = segmentStart + (segmentEnd - segmentStart) / 2;
			
			int left = getMax((2 * root + 1), segmentStart, mid, qs, qe);
			int right = getMax((2 * root + 2), (mid + 1), segmentEnd, qs, qe);
			
			return Math.max(left, right);
		}
	}
	
	// Updating sub-array max Segment tree if array is updated
	public static void updateSubArrayMax(int[] arr, int index, int newValue) {
		int n = arr.length;
		arr[index] = newValue;
		
		updateST(0, 0, n - 1, index, newValue);
	}
	
	public static void updateST(int root, int segmentStart, int segmentEnd, int idx, int newVal) {
		if (idx < segmentStart || idx > segmentEnd) {
			// Non-overlapping
			return;
		}
		
		if (segmentStart == segmentEnd) {
			// Leaf Node
			segTree[root] = newVal;
			return;
		}
		
		// Non-leaf Node
		int mid = segmentStart + (segmentEnd - segmentStart) / 2;
		
		updateST((2 * root + 1), segmentStart, mid, idx, newVal); // Left sub-tree
		updateST((2 * root + 2), (mid + 1), segmentEnd, idx, newVal); // Right sub-tree

		segTree[root] = Math.max(segTree[2 * root + 1], segTree[2 * root + 2]);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = {6, 8, -1, 2, 17, 1, 3, 2, 4};
		int n = arr.length;
		
		init(arr.length);
		buildST(arr, 0, 0, n - 1);
		
		System.out.println("Input Array: ");
		System.out.println(Arrays.toString(arr));
		
		init(arr.length);
		buildST(arr, 0, 0, arr.length - 1);
		
		System.out.println("Segment Tree for Max Element in the range: ");
		System.out.println(Arrays.toString(segTree));
		
		while (true) {
			System.out.println("1 for Sub-array Max ElementQuery");
			System.out.println("2 for Updating element");
			System.out.println("Any other Integer to exit...");
			
			System.out.print("Choice: ");
			int choice = sc.nextInt();
			
			if (choice == 1) {
				System.out.print("Enter range as: 'start end': ");
				
				sc.nextLine();
				String queryRange = sc.nextLine().trim();
				
				if (queryRange.isEmpty()) {
					break;
				}
				
				String[] range = queryRange.split(" ");
				System.out.println(getSubArrayMax(arr, Integer.parseInt(range[0]),
						Integer.parseInt(range[1])));
			} else if (choice == 2) {
				System.out.print("Index: ");
				int index = sc.nextInt();
				
				System.out.println("Array[" + index + "]: " + arr[index]);
				System.out.print("Update to: ");
				int newValue = sc.nextInt();
				updateSubArrayMax(arr, index, newValue);
				
				System.out.print("Array: ");
				System.out.println(Arrays.toString(arr));
				System.out.println(Arrays.toString(segTree));
			} else {
				break;
			}
		}
		
		sc.close();
		
	}
}

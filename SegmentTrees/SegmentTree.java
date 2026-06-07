/*
Segment Trees are used for Range Queries.

Total levels in the Segment Tree: log(n) {base of the log is 2}
Total nodes in the Segment Tree: (2n - 1)

Since Segment Trees are full binary trees, therefore, for safety purposes, total nodes in the
segment tree in considered to be (4n).

Time Complexity:
	Construction: O(n)
	Update: O(logn)
	Query: O(logn)

If root is at i:
	Left Child: (2i + 1)
	Right Child: (2i + 2)

*/

package SegmentTrees;

import java.util.Arrays;
import java.util.Scanner;

public class SegmentTree {
	static int[] segTree;
	
	// Initialize Segment Tree
	public static void init(int n) {
		segTree = new int[4 * n];
	}
	
	// Build Segment Tree for sub-array sum
	public static void buildST(int[] arr, int root, int segmentStart, int segmentEnd) {
		if (segmentStart == segmentEnd) {
			// Leaf Node
			segTree[root] = arr[segmentStart];
			return;
		}
		
		int mid = segmentStart + (segmentEnd - segmentStart) / 2;
		
		buildST(arr, (2 * root + 1), segmentStart, mid); // Left sub-tree
		buildST(arr, (2 * root + 2), mid + 1, segmentEnd); // Right sub-tree
		
		segTree[root] = segTree[2 * root + 1] + segTree[2 * root + 2];
	}
	
	// Query function to get sub-array sum
	public static int getSubArraySum(int[] arr, int queryStart, int queryEnd) {
		int n = arr.length;
		
		return getSum(0, 0, n - 1, queryStart, queryEnd);
	}
	
	public static int getSum(int root, int segmentStart, int segmentEnd, int qs, int qe) {
		if (segmentEnd < qs || segmentStart > qe) {
			// Case 1: No Overlap of the Query range with the Current range
			return 0;
		} else if (segmentStart >= qs && segmentEnd <= qe) {
			// Case 2: Complete Overlap of the Query range with the Current range
			return segTree[root];
		} else {
			// Case 3: Partial Overlap
			int mid = segmentStart + (segmentEnd - segmentStart) / 2;
			
			int left = getSum((2 * root + 1), segmentStart, mid, qs, qe); // Left sub-tree
			int right = getSum((2 * root + 2), (mid + 1), segmentEnd, qs, qe); // Right sub-tree
			
			return left + right;
		}
	}
	
	// Updating sub-array sum Segment tree if array is updated
	public static void updateSum(int[] arr, int index, int newValue) {
		int n = arr.length;
		int diff = newValue - arr[index];
		arr[index] = newValue;
		
		updateST(0, 0, n - 1, index, diff);
	}
	
	public static void updateST(int root, int segmentStart, int segmentEnd, int idx, int diff) {
		if (idx < segmentStart || idx > segmentEnd) {
			// Non-overlapping
			return;
		}
		
		segTree[root] += diff;
		
		if (segmentStart != segmentEnd) {
			// Non-leaf node
			int mid = segmentStart + (segmentEnd - segmentStart) / 2;
			
			updateST((2 * root + 1), segmentStart, mid, idx, diff); // Left sub-tree
			updateST((2 * root + 2), (mid + 1), segmentEnd, idx, diff); // Right sub-tree
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		
		System.out.print("Array: ");
		System.out.println(Arrays.toString(arr));
		
		init(arr.length);
		buildST(arr, 0, 0, arr.length - 1);
		
		System.out.println("Segment Tree for sub array sum: ");
		System.out.println(Arrays.toString(segTree));
		
		while (true) {
			System.out.println("1 for Sub-array sum Query");
			System.out.println("2 for Update");
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
				System.out.println(getSubArraySum(arr, Integer.parseInt(range[0]),
						Integer.parseInt(range[1])));
			} else if (choice == 2) {
				System.out.print("Index: ");
				int index = sc.nextInt();

				System.out.println("Array[" + index + "]: " + arr[index]);
				System.out.print("Update to: ");
				int newValue = sc.nextInt();
				updateSum(arr, index, newValue);
				
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

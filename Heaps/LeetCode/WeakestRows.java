/*
1337. The K Weakest Rows in a Matrix

You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's
(representing civilians). The soldiers are positioned in front of the civilians.
That is, all the 1's will appear to the left of all the 0's in each row.

A row i is weaker than a row j if one of the following is true:

The number of soldiers in row i is lower than the number of soldiers in row j.
Both rows have the same number of soldiers and i < j.
Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.

Example 1:

Input: mat =
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]],
k = 3
Output: [2,0,3]
Explanation:
The number of soldiers in each row is:
- Row 0: 2
- Row 1: 4
- Row 2: 1
- Row 3: 2
- Row 4: 5
The rows ordered from weakest to strongest are [2,0,3,1,4].

Example 2:
Input: mat =
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]],
k = 2
Output: [0,2]
Explanation:
The number of soldiers in each row is:
- Row 0: 1
- Row 1: 4
- Row 2: 1
- Row 3: 1
The rows ordered from weakest to strongest are [0,2,3,1].

*/

package Heaps.LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class WeakestRows {
	public static int[] kWeakestRows(int[][] mat, int k) {
		int[] res = new int[k];
		PriorityQueue<Row> pq = new PriorityQueue<>();
		
		for (int i = 0; i < mat.length; i++) {
			int left = 0, right = mat[0].length - 1;
			while (left <= right) {
				int mid = left + (right - left) / 2;
				if (mat[i][mid] == 1) {
					// More Soldiers are there on the Right.
					left = mid + 1;
				} else {
					// No More Soldiers are there on the Right.
					right = mid - 1;
				}
			}
			// The number of soldiers is the left pointer's position.
			pq.add(new Row(i, left));
		}
		
		int i = 0;
		while (!pq.isEmpty() && k > 0) {
			res[i++] = pq.poll().index;
			--k;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[][] mat = {
				{1, 1, 0, 0, 0},
				{1, 1, 1, 1, 0},
				{1, 0, 0, 0, 0},
				{1, 1, 0, 0, 0},
				{1, 1, 1, 1, 1}};
		
		int[] res = kWeakestRows(mat, 3);
		System.out.println(Arrays.toString(res));
		
	}
	
	static class Row implements Comparable<Row> {
		int index, count;
		
		public Row(int index, int count) {
			this.index = index;
			this.count = count;
		}
		
		@Override
		public int compareTo(Row r) {
			if (this.count == r.count) {
				return this.index - r.index;
			}
			
			return this.count - r.count;
		}
	}
}

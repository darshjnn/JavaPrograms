/*
1483. Kth Ancestor of a Tree Node

You are given a tree with n nodes numbered from 0 to n - 1 in the form of a
parent array parent where parent[i] is the parent of ith node. The root of the tree is node 0.
Find the kth ancestor of a given node.

The kth ancestor of a tree node is the kth node in the path from that node to the root node.

Implement the TreeAncestor class:

TreeAncestor(int n, int[] parent) Initializes the object with the number of nodes in the tree
and the parent array.
int getKthAncestor(int node, int k) return the kth ancestor of the given node .
If there is no such ancestor, return -1.

Example 1:

Input
["TreeAncestor", "getKthAncestor", "getKthAncestor", "getKthAncestor"]
[[7, [-1, 0, 0, 1, 1, 2, 2]], [3, 1], [5, 2], [6, 3]]
Output
[null, 1, 0, -1]

Explanation
TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);
treeAncestor.getKthAncestor(3, 1); // returns 1 which is the parent of 3
treeAncestor.getKthAncestor(5, 2); // returns 0 which is the grandparent of 5
treeAncestor.getKthAncestor(6, 3); // returns -1 because there is no such ancestor

Constraints:
	1 <= k <= n <= 5 * 104
	parent.length == n
	parent[0] == -1
	0 <= parent[i] < n for all 0 < i < n
	0 <= node < n
	There will be at most 5 * 10^4 queries.

*/

package BinaryTree.LeetCode;

import java.util.Arrays;

public class KthAncestor {
	public static void main(String[] args) {
		int[] parents = {-1, 0, 0, 1, 1, 2, 2};
		TreeAncestor obj = new TreeAncestor(7, parents);
		
		System.out.println(obj.getKthAncestorSimple(3, 1));
		System.out.println(obj.getKthAncestorBL(3, 1));
	}
	
	static class TreeAncestor {
		int[] parents;
		
		int[][] dp;
		
		int log;
		int[][] up;
		
		public TreeAncestor(int n, int[] parents) {
			this.parents = parents;
			
			// Initialization for Simple Approach
			this.dp = new int[n][n];
			for (int[] arr : dp) {
				Arrays.fill(arr, -2);
			}
			
			// Initialization for Binary Lifting Approach
			this.log = (int) (Math.log(n) / Math.log(2)) + 1; // Calculate log2(n)
			this.up = new int[n][log];
			
			// Initialize the base cases (2^0 = 1st ancestor)
			for (int i = 0; i < n; i++) {
				this.up[i][0] = this.parents[i];
			}
			
			// Fill the binary lifting table
			for (int j = 1; j < log; j++) {
				for (int i = 0; i < n; i++) {
					if (this.up[i][j - 1] == -1) {
						this.up[i][j] = -1;
					} else {
						this.up[i][j] = this.up[this.up[i][j - 1]][j - 1];
					}
				}
			}
		}
		
		// This will give Time Limit Exceeded error
		public int getKthAncestorSimple(int node, int k) {
			if (k > this.parents.length) {
				return -1;
			}
			
			for (int i = 0; i < k; i++) {
				if (this.dp[node][i] != -2) {
					return this.dp[node][i];
				}
				
				this.dp[node][i] = this.parents[node];
				node = this.dp[node][i];
				
				if (node == -1) {
					return -1;
				}
				
			}
			
			return node;
		}
		
		// Using Binary Lifting
		/*
		It is a technique that allows to find the k-th ancestor in O(log k) time after an initial
		preprocessing phase.
		
		Pre-computation:
		Define a 2D array up[i][j], representing the 2^j-th ancestor of node-i.
			Base Case: up[i][0] = parent[i] (2^0 = first ancestor).
			Recursive Step: The 2^j-th ancestor is the 2^(j-1)th ancestor of the
							2^(j-1)-th ancestor. (up[i][j] = up[up[i][j-1]][j-1])
							
		Querying:
		To find the k-th ancestor, decompose k into its binary representation.
		For example, if k = 13 (1101 in binary), jump by 8, then 4, then 1.
		*/
		public int getKthAncestorBL(int node, int k) {
			if (k > this.parents.length) {
				return -1;
			}
			
			for (int j = 0; j < this.log; j++) {
				// Check if the j-th bit of k is set
				if (((k >> j) & 1) == 1) {
					node = this.up[node][j];
					if (node == -1) {
						return -1;
					}
				}
			}
			
			return node;
		}
	}
}
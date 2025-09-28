/*
Another name of Disjoint Set is Union Find.

It is used to store and track non-overlapping sets.

Union is always done between the leaders of two groups.

Time Complexity of both, Union & Find are O(4k), where k is a constant.
But the value of k is such that maximum operation comes out to be O(4), viz, O(1).
Hence, constant time complexity.

*/

package Graph;

import java.util.Arrays;

public class DisjointSet {
	//	Initialising: Each element is a parent of itself
	public static void init(int n, int[] parent) {
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}
	
	// Find parent
	public static int find(int x, int[] parent) {
		if (x == parent[x]) {
			return x;
		}
		
		// Normal Zindagi: return find(parent[x]);
		// Mentos Zindagi: Using Path Compression Technique to Optimize searching of parent.
		return parent[x] = find(parent[x], parent);
	}
	
	// Union of two elements
	public static void union(int a, int b, int[] parent, int[] rank) {
		int parentA = find(a, parent);
		int parentB = find(b, parent);
		
		if (rank[parentA] > rank[parentB]) {
			parent[parentB] = parentA;
		} else if (rank[parentA] < rank[parentB]) {
			parent[parentA] = parentB;
		} else {
			parent[parentB] = parentA;
			++rank[parentA];
		}
	}
	
	public static void main(String[] args) {
		int n = 7;
		int[] parent = new int[n];
		int[] rank = new int[n];
		
		// Initialisation: Each element is a parent of itself
		init(n, parent);
		
		// Parent and Rank of each element before any operation
		System.out.println("Parent of all elements: " + Arrays.toString(parent));
		System.out.println("Rank of all elements: " + Arrays.toString(rank));
		System.out.println();
		
		// Union of 1 and 3
		union(1, 3, parent, rank);
		
		// Parent of 3 after Union(1,3)
		System.out.println("Parent of 3 after Union(1, 3): " + find(3, parent));
		
		// Union of 2 and 4
		union(2, 4, parent, rank);
		
		// Parent of 4 after Union(2,4)
		System.out.println("Parent of 4 after Union(2, 4): " +  find(4, parent));
		
		// Union of 3 and 6
		union(3, 6, parent, rank);

		// Union of 1 and 4
		union(1, 4, parent, rank);
		
		// Parent of 4 after Union(2,4)
		System.out.println("Parent of 4 after Union(1, 4): " +  find(4, parent));
		
		// Parent and Rank of each element after operations
		System.out.println("\nParent of all element: " + Arrays.toString(parent));
		System.out.println("Rank of all element: " + Arrays.toString(rank));
	}
}

/*
2685. Count the Number of Complete Components

You are given an integer n. There is an undirected graph with n vertices, numbered from
0 to n - 1.
You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an
undirected edge connecting vertices ai and bi.

Return the number of complete connected components of the graph.

A connected component is a subgraph of a graph in which there exists a path between any two
vertices, and no vertex of the subgraph shares an edge with a vertex outside the subgraph.

A connected component is said to be complete if there exists an edge between every pair of its
vertices.

Example 1:
Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
Output: 3
Explanation: From the picture above, one can see that all the components of this graph are
complete.

Example 2:
Input: n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
Output: 1
Explanation: The component containing vertices 0, 1, and 2 is complete since there is an
edge between every pair of two vertices. On the other hand, the component containing
vertices 3, 4, and 5 is not complete since there is no edge between vertices 4 and 5.
Thus, the number of complete components in this graph is 1.

Constraints:
	0 <= edges.length <= n * (n - 1) / 2
	edges[i].length == 2
	0 <= ai, bi <= n - 1
	ai != bi
	There are no repeated edges.

*/

/*

Hint 1:
Find the connected components of an undirected graph using depth-first search (DFS) or
breadth-first search (BFS).

Hint 2:
For each connected component, count the number of nodes and edges in the component.

Hint 3:
A connected component is complete if and only if the number of edges in the component is equal
to m*(m-1)/2, where m is the number of nodes in the component.

*/

package Graph.LeetCode;

import java.util.*;

public class CountTheNumberOfCompleteComponents {
	// Using BFS
	public static int countCompleteComponentsBFS(int n, int[][] edges) {
		// Build the Adjacency List
		ArrayList<Set<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new HashSet<>());
		}
		
		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		
		int completeComp = 0;
		boolean[] vis = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			if (!vis[i]) {
				// BFS Traversal
				Queue<Integer> q = new LinkedList<>();
				ArrayList<Integer> component = new ArrayList<>();
				
				q.offer(i);
				vis[i] = true;
				
				while (!q.isEmpty()) {
					int curr = q.poll();
					component.add(curr);
					for (int neighbor : graph.get(curr)) {
						if (!vis[neighbor]) {
							q.offer(neighbor);
							vis[neighbor] = true;
						}
					}
				}
				
				// Check if the component is complete
				int size = component.size();
				int edgeCount = 0;
				for (int node : component) {
					edgeCount += graph.get(node).size();
				}
				
				/*
				Since every edge is stored twice in the adjacency list (once for each vertex it
				connects), checking edgeCount = size * (size - 1) is mathematically correct.
				*/
				
				if (edgeCount == size * (size - 1)) {
					++completeComp;
				}
			}
		}
		
		return completeComp;
	}
	
	// Using Disjoint Set
	public static int findParent(int x, int[] parent) {
		if (parent[x] < 0) {
			return x;
		}
		
		return parent[x] = findParent(parent[x], parent);
	}
	
	public static void union(int u, int v, int[] edgeCount, int[] parent) {
		int parentU = findParent(u, parent);
		int parentV = findParent(v, parent);
		
		if (parentU != parentV) {
			if (parent[parentU] <= parent[parentV]) {
				parent[parentU] += parent[parentV];
				parent[parentV] = parentU;
				edgeCount[parentU] += 1 + edgeCount[parentV];
			} else {
				parent[parentV] += parent[parentU];
				parent[parentU] = parentV;
				edgeCount[parentV] += 1 + edgeCount[parentU];
			}
		} else {
			edgeCount[parentU]++;
		}
	}
	
	public static int countCompleteComponentsDS(int n, int[][] edges) {
		int[] parent = new int[n];
		int[] edgeCount = new int[n];
		
		Arrays.fill(parent, -1);
		
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			
			union(u, v, edgeCount, parent);
		}
		
		int ans = 0;
		
		for (int i = 0; i < n; i++) {
			if (parent[i] < 0) {
				int nodes = -parent[i];
				int requiredEdges = (nodes * (nodes - 1)) / 2;
				
				if (edgeCount[i] == requiredEdges) {
					ans++;
				}
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		int n = 6;
		int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {3, 4}};
		
		System.out.println(countCompleteComponentsBFS(n, edges));
		System.out.println(countCompleteComponentsDS(n, edges));
	}
}
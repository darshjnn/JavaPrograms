/*
785. Is Graph Bipartite?

There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1.
You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to.
More formally, for each v in graph[u], there is an undirected edge between node u and node v.
The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path
between them. A graph is bipartite if the nodes can be partitioned into two independent sets A
and B such that every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.

Example 1:
Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: There is no way to partition the nodes into two independent sets such that
every edge connects a node in one and a node in the other.

Example 2:
Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.

*/

package Graph.LeetCode;

import java.util.Arrays;

public class IsGraphBipartite {
	private static boolean checkBipartite(int[][] graph, int[] color, int curr) {
		if (color[curr] == -1) {
			color[curr] = 0;
		}
		for (int neighbor : graph[curr]) {
			if (color[neighbor] == -1) {
				color[neighbor] = color[curr] == 0 ? 1 : 0;
				if (checkBipartite(graph, color, neighbor)) {
					return true;
				}
			} else if (color[neighbor] == color[curr]) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isBipartite(int[][] graph) {
		int V = graph.length;
		int[] color = new int[V];
		Arrays.fill(color, -1);
		for (int i = 0; i < V; i++) {
			if (color[i] == -1 && checkBipartite(graph, color, i)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[][] graph = {{1, 2}, {0, 3}, {0, 4}, {1, 5, 4}, {2, 5, 3}, {3, 4, 6}, {5}};
		System.out.println("Is Graph Bipartite?: " + isBipartite(graph));
	}
}
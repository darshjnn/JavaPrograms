/*

Worst Case Time Complexity of printing All Paths from Source to Destination: O(V^V).

*/

package Graph;

import java.util.*;

public class AllPaths {
//	 Print All Paths From Source To Destination in Directed Graph
	static void allPathsDirected(ArrayList<Edge>[] graph, int src, int dest, String path) {
		if (src == dest) {
			System.out.println(path);
			return;
		}
		
		for (Edge e : graph[src]) {
			allPathsDirected(graph, e.dest, dest, (path + " -> " + e.dest));
		}
	}
	
//	Print All Paths From Source To Destination in Undirected Graph
	public static void allPathsUndirected(ArrayList<Edge>[] graph, int src, int dest,
	                                      String path, boolean[] vis) {
		if (src == dest) {
			System.out.println(path);
			return;
		}
		
		for (Edge e : graph[src]) {
			if (!vis[e.dest]) {
				vis[src] = true;
				allPathsUndirected(graph, e.dest, dest, path + " -> " + e.dest, vis);
				vis[src] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		
		/*
		 *   1 --- 3
		 *  /      | \
		 * 0       |  5 --- 6
		 *  \      | /
		 *   2 --- 4
		 */
		
		int V = 7;
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] undirectedGraph = new ArrayList[V];
		Graphs.createGraph(undirectedGraph, V);
		System.out.println("All Paths in Directed Graph: ");
		allPathsUndirected(undirectedGraph, 0, 5, "0", new boolean[V]);
		
		System.out.println();
		
		V = 6;
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] directedGraph = new ArrayList[V];
		TopologicalSortDFS.createDirectedGraph(directedGraph, V);
		System.out.println("All Paths in Directed Graph: ");
		allPathsDirected(directedGraph, 5, 1, "5");
	}
}
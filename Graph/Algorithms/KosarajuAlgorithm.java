/*
Kosaraju Algorithm

It is used to find the Strongly Connected Components in a Directed Graph.

Strongly Connected Component (SCC): in which every vertex of the component can be reached from
every other vertex of that component. It is only for Directed Graph.
Every vertex belongs to exactly one SCC (SCCs form a partition of the vertices).

The Algorithm follows 3 steps:
	1. Get nodes in the Stack (Topological Sort). {Time Complexity: O(V + E)}
	2. Transpose the Graph. {Time Complexity: O(V + E)}
	3. Perform DFS. {Time Complexity: O(V + E)}
	
Time Complexity of Kosaraju's Algorithm comes out to be  O(V + E).

Kosaraju's algorithm for strongly connected components requires two DFS traversals of a Graph.
Tarjan's algorithm requires only one DFS traversal.

*/

package Graph.Algorithms;

import Graph.Edge;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgorithm {
	public static void createGraph(ArrayList<Edge>[] graph, int V) {
		for (int i = 0; i < V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(new Edge(0, 2));
		graph[0].add(new Edge(0, 3));
		
		graph[1].add(new Edge(1, 0));
		
		graph[2].add(new Edge(2, 1));
		
		graph[3].add(new Edge(3, 4));
	}
	
	// Topological Sort
	static void topologicalSort(ArrayList<Edge>[] g, boolean[] vis,	Stack<Integer> s, int curr) {
		vis[curr] = true;
		
		for (Edge e : g[curr]) {
			if (!vis[e.dest]) {
				topologicalSort(g, vis, s, e.dest);
			}
		}
		
		s.push(curr);
	}
	
	// DFS Traversal
	public static void dfs(ArrayList<Edge>[] graph, boolean[] vis, int curr) {
		vis[curr] = true;
		
		System.out.print(curr + " ");
		
		for (Edge e : graph[curr]) {
			if (!vis[e.dest]) {
				dfs(graph, vis, e.dest);
			}
		}
	}
	
	public static int kosarajuAlgo(ArrayList<Edge>[] graph, int V) {
		// Step 1: Topological Sort
		Stack<Integer> s = new Stack<>();
		boolean[] vis = new boolean[V];
		
		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				topologicalSort(graph, vis, s, i);
			}
		}
		
		// Step 2: Transpose the Graph
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] transpose = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			transpose[i] = new ArrayList<>();
			vis[i] = false;
		}
		
		for (int i = 0; i < V; i++) {
			for (Edge e : graph[i]) {
				transpose[e.dest].add(new Edge(e.dest, e.src));
			}
		}
		
		// Step 3: DFS on Transposed Graph
		int components = 0;
		while (!s.isEmpty()) {
			int curr = s.pop();
			
			if (!vis[curr]) {
				++components;
				System.out.print("Strongly Connected Component " + components + ": ");
				dfs(transpose, vis, curr);
				System.out.println();
			}
		}
		System.out.println();
		
		return components;
	}
	
	public static void main(String[] args) {
		int V = 5;
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[V];
		createGraph(graph, V);
		System.out.println("Total Strongly Connected Components: " + kosarajuAlgo(graph, V));
	}
}
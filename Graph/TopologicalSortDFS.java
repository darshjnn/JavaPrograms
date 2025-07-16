/*
Directed Acyclic Graph(DAG) is a directed graph with no cycles.

Topological sorting is used only for DAGs (not for non-DAGs).

Topological Sort works on Dependency Graph.

It is a linear order of vertices such that every directed edge u -> v implies that the vertex u
comes before v in the order.

Time Complexity of Topological Sort: O(V + E).

For Topological Sort using BFS, Kahn's Algorithm is used.
The algorithm works on in-degree and out-degree of vertices.
It is based on the fact that, in Directed Acyclic Graph(DAG), there is at least one vertex with
in-degree = 0, and one vertex with out-degree = 0.

*/

package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS {
	public static void createDirectedGraph(ArrayList<Edge>[] graph, int V) {
		for (int i = 0; i < V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(new Edge(0, 3));
		
		graph[2].add(new Edge(2, 3));
		
		graph[3].add(new Edge(3, 1));
		
		graph[4].add(new Edge(4, 0));
		graph[4].add(new Edge(4, 1));
		
		graph[5].add(new Edge(5, 0));
		graph[5].add(new Edge(5, 2));
	}
	
	static void topSortUtil(ArrayList<Edge>[] g, boolean[] vis, Stack<Integer> s, int curr) {
		vis[curr] = true;
		
		for (Edge e : g[curr]) {
			if (!vis[e.dest]) {
				topSortUtil(g, vis, s, e.dest);
			}
		}
		
		s.push(curr);
	}
	
	public static void topologicalSortDFS(ArrayList<Edge>[] graph, int V) {
		boolean[] vis = new boolean[V];
		Stack<Integer> s = new Stack<>();
		
		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				topSortUtil(graph, vis, s, i);
			}
		}
		
		while (!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
	}
	
	public static void main(String[] args) {
		int V = 6;
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[V];
		createDirectedGraph(graph, V);
		topologicalSortDFS(graph, V);
	}
}
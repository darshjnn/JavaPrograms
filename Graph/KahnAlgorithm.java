/*
Kahn Algorithm

For Topological Sort using BFS, Kahn's Algorithm is used.

The algorithm works on in-degree and out-degree of vertices.

It is based on the fact that, in Directed Acyclic Graph(DAG), there is at least one vertex with
in-degree = 0, and one vertex with out-degree = 0.

For Topological Sort using BFS, boolean[] vis is not required because after popping out a
vertex, it decreases the in-degree of its neighbors by 1. Hence, only those vertices with
in-degree = 0 will be taken. In-degree = 0 implies that it cannot be visited again, hence no
boolean[] vis is required.

*/

package Graph;

import java.util.*;

public class KahnAlgorithm {
	public static void findIndegree(ArrayList<Edge>[] graph, int[] indegree) {
		for (ArrayList<Edge> edges : graph) {
			for (Edge edge : edges) {
				++indegree[edge.dest];
			}
		}
	}
	
	public static void topologicalSortBFS(ArrayList<Edge>[] graph, int V) {
		int[] indegree = new int[V];
		findIndegree(graph, indegree);
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 0; i < V; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			
			System.out.print(curr + " ");
			
			for (Edge e : graph[curr]) {
				--indegree[e.dest];
				if (indegree[e.dest] == 0) {
					q.offer(e.dest);
				}
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int V = 6;
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[V];
		TopologicalSortDFS.createDirectedGraph(graph, V);
		topologicalSortBFS(graph, V);
	}
}
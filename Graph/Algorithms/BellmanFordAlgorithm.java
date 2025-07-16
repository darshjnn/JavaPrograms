/*
Bellman Ford Algorithm

Bellman Ford algorithm works even for the cases where Dijkstra's Algorithm fails, i.e., for
negative weights of the edges.

It uses Dynamic Programming.

Time complexity of Bellman Ford Algorithm is more than Dijkstra Algorithm.

Time Complexity is O(E.V).

Bellman Ford fails for negative destination cycles, i.e., when the total destination of graph
cycle is negative.

*/

package Graph.Algorithms;

import Graph.Edge;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordAlgorithm {
	public static void createGraph(ArrayList<Edge>[] graph, int V) {
		for (int i = 0; i < V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(new Edge(0, 1, 2));
		graph[0].add(new Edge(0, 2, 4));
		
		graph[1].add(new Edge(1, 2, -4));
		
		graph[2].add(new Edge(2, 3, 2));
		
		graph[3].add(new Edge(3, 4, 4));
		
		graph[4].add(new Edge(4, 1, -1));
	}
	
	public static void bellmanFordAlgo(ArrayList<Edge>[] graph, int V, int src) {
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;

//	    Total Time Complexity: O(V*E)
//      Time Complexity of Outer most loop: O(V)
		for (int i = 0; i < V; i++) {
			for (ArrayList<Edge> edges : graph) {
//              Time Complexity of inner loop: O(E)
				for (Edge e : edges) {
					if (dist[e.src] != Integer.MAX_VALUE && dist[e.dest] > dist[e.src] + e.wt) {
						dist[e.dest] = dist[e.src] + e.wt;
					}
				}
			}
		}
		
		System.out.println("Node\tDistance");
		for (int i = 0; i < V; i++) {
			System.out.println(" " + i + "  \t  " + dist[i]);
		}
	}
	
	public static void main(String[] args) {
		int V = 5;
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[V];
		createGraph(graph, V);
		
		int src = 4;
		System.out.println("Minimum distance from " + src + " to all the nodes:");
		bellmanFordAlgo(graph, V, src);
	}
}
/*
Dijkstra's Algorithm: To find the shortest path in Weighted Graph (Directed/Undirected).

It works on BFS, and it is a Greedy Algorithm.

Time Complexity: O(E + E logV), where (E logV) is due to Priority Queue.
If Priority Queue is not used, then Time Complexity will be O(V^2).

*/

package Graph.Algorithms;

import Graph.Edge;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
	private static void createWeightedGraph(ArrayList<Edge>[] graph, int V) {
		for (int i = 0; i < V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(new Edge(0, 1, 2));
		graph[0].add(new Edge(0, 2, 4));
		
		graph[1].add(new Edge(1, 3, 7));
		graph[1].add(new Edge(1, 2, 1));
		
		graph[2].add(new Edge(2, 4, 3));
		
		graph[3].add(new Edge(3, 5, 1));
		
		graph[4].add(new Edge(4, 3, 2));
		graph[4].add(new Edge(4, 5, 5));
	}
	
	public static void dijkstraAlgo(ArrayList<Edge>[] graph, int V, int src) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		boolean[] vis = new boolean[V];
		int[] dist = new int[V];
		
		for (int i = 0; i < V; i++) {
			if (i != src) {
				dist[i] = Integer.MAX_VALUE;
			}
		}
		
		pq.offer(new Pair(src, 0));
		while (!pq.isEmpty()) {
			Pair curr = pq.poll();
			if (!vis[curr.node]) {
				vis[curr.node] = true;
				for (Edge e : graph[curr.node]) {
					if (dist[e.dest] > dist[curr.node] + e.wt) {
//						Relaxation
						dist[e.dest] = dist[curr.node] + e.wt;
						pq.offer(new Pair(e.dest, dist[e.dest]));
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
		int V = 6;
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[V];
		createWeightedGraph(graph, V);
		
		int src = 1;
		System.out.println("Distance of Source: " + src + " to all nodes: ");
		dijkstraAlgo(graph, V, src);
	}
	
	public static class Pair implements Comparable<Pair> {
		int node, distance;
		
		public Pair(int node, int distance) {
			this.node = node;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Pair p) {
			return this.distance - p.distance; // For Ascending
//			return p.distance - this.distance; // For Descending
		}
	}
}
/*
Prim Algorithm

A minimum spanning tree (MST) or minimum weight spanning tree is a subset of the edges of a
connected, edge-weighted undirected graph that connects all the vertices, without any cycles and
with the minimum possible total-edge weight.

Time Complexity: E(logE)

*/

package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimAlgorithm {
	public static void createGraph(ArrayList<Edge>[] graph, int V) {
		for (int i = 0; i < V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(new Edge(0, 1, 10));
		graph[0].add(new Edge(0, 2, 15));
		graph[0].add(new Edge(0, 3, 30));
		
		graph[1].add(new Edge(1, 0, 10));
		graph[1].add(new Edge(1, 3, 5));
		
		graph[2].add(new Edge(2, 0, 15));
		graph[2].add(new Edge(2, 3, 50));
		
		graph[3].add(new Edge(3, 1, 5));
		graph[3].add(new Edge(3, 2, 50));
	}
	
	public static void primAlgo(ArrayList<Edge>[] graph, int V) {
		int cost = 0;
		boolean[] vis = new boolean[V];
		ArrayList<Edge> mst = new ArrayList<>();
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.offer(new Node(0, 0, 0));
		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (!vis[curr.dest]) {
				vis[curr.dest] = true;
				
				cost += curr.wt;
				mst.add(new Edge(curr.src, curr.dest, curr.wt));
				
				for (Edge e : graph[curr.dest]) {
					if (!vis[e.dest]) {
						pq.offer(new Node(e.src, e.dest, e.wt));
					}
				}
			}
		}
		
		System.out.println("Minimum Spanning Tree:");
		System.out.println("Source Destination Weight");
		for (Edge e : mst) {
			System.out.println("\t" + e.src + "\t\t" + e.dest + "\t\t" + e.wt);
		}
		System.out.println("Minimum cost: " + cost);
	}
	
	public static void main(String[] args) {
		int V = 4;
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[V];
		createGraph(graph, V);
		
		primAlgo(graph, V);
	}
	
	public static class Node implements Comparable<Node> {
		int src, dest, wt;
		
		public Node(int src, int dest, int wt) {
			this.src = src;
			this.dest = dest;
			this.wt = wt;
		}
		
		public int compareTo(Node p) {
			return this.wt - p.wt;  // For ascending sorting
		}
	}
}
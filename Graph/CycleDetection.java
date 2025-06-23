/*
For Cycle Detection in Undirected Graph, the following can be used:
	1. DFS
	2. BFS
	3. DSU (Disjoint Set Union)

For Cycle Detection in Directed Graph, the following can be used:
	1. DFS
	2. BFS
	3. Topological Sort (Kahn's Algorithm)

*/

package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetection {
	// Create Directed Graph
	public static void createGraphDirected(ArrayList<Edge>[] graph, int V) {
		for (int i = 0; i < V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(new Edge(0, 2));
		
		graph[1].add(new Edge(1, 0));
		
		graph[2].add(new Edge(2, 3));
		
		graph[3].add(new Edge(3, 0));
	}
	
	// Cycle Detection for Undirected Graph using DFS
	public static boolean hasCycleUndDFS(ArrayList<Edge>[] graph, int V) {
		boolean[] vis = new boolean[V];
		
		for (int i = 0; i < V; i++) {
			if (!vis[i] && hasCycleUndDFSUtil(graph, vis, i, -1)) {
				return true;
			}
		}
		
		return false;
	}
	
	static boolean hasCycleUndDFSUtil(ArrayList<Edge>[] g, boolean[] vis, int curr, int par) {
		vis[curr] = true;
		
		for (Edge e : g[curr]) {
			if (!vis[e.dest]) {
				hasCycleUndDFSUtil(g, vis, e.dest, curr);
			} else if (vis[e.dest] && e.dest != par) {
				return true;
			}
		}
		
		return false;
	}
	
	// Cycle Detection for Undirected Graph using BFS
	public static boolean hasCycleUndBFS(ArrayList<Edge>[] graph, int V) {
		boolean[] vis = new boolean[V];
		
		for (int i = 0; i < V; i++) {
			if (!vis[i] && hasCycleUndBFSUtil(graph, vis, i)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean hasCycleUndBFSUtil(ArrayList<Edge>[] graph, boolean[] vis, int src) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(src);
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			if (vis[curr]) {
				return true;
			}
			vis[curr] = true;
			for (Edge e : graph[curr]) {
				if (!vis[e.dest]) {
					q.offer(e.dest);
				}
			}
		}
		
		return false;
	}
	
	// Cycle Detection for Directed Graph using DFS
	public static boolean hasCycleDirDFS(ArrayList<Edge>[] graph, int V) {
		boolean[] vis = new boolean[V];
		boolean[] stack = new boolean[V];
		
		for (int i = 0; i < V; i++) {
			if (!vis[i] && hasCycleDirDFSUtil(graph, vis, stack, i)) {
				return true;
			}
		}
		
		return false;
	}
	
	static boolean hasCycleDirDFSUtil(ArrayList<Edge>[] g, boolean[] vis, boolean[] stack,
	                                  int curr) {
		vis[curr] = true;
		stack[curr] = true;
		
		for (Edge e : g[curr]) {
			if (stack[e.dest]) {
				return true;
			}
			if (!vis[e.dest] && hasCycleDirDFSUtil(g, stack, vis, e.dest)) {
				return true;
			}
		}
		
		stack[curr] = false;
		return false;
	}
	
	// Cycle Detection for Directed Graph using BFS
	public static boolean hasCycleDirBFS(ArrayList<Edge>[] graph, int V) {
		boolean[] vis = new boolean[V];
		
		for (int i = 0; i < V; i++) {
			if (!vis[i] && hasCycleDirBFSUtil(graph, V, vis, i)) {
				return true;
			}
		}
		
		return false;
	}
	
	static boolean hasCycleDirBFSUtil(ArrayList<Edge>[] g, int V, boolean[] vis, int src) {
		boolean[] stack = new boolean[V];
		Queue<Integer> q = new LinkedList<>();
		q.offer(src);
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			if (!vis[curr]) {
				vis[curr] = true;
				stack[curr] = true;
				for (Edge e : g[curr]) {
					if (stack[e.dest]) {
						return true;
					}
					if (!vis[e.dest]) {
						q.offer(e.dest);
					}
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		// Cycle Detection for Undirected graph
		/*
		 *   1 --- 3
		 *  /      | \
		 * 0       |  5 --- 6
		 *  \      | /
		 *   2 --- 4
		 */
		
		// Create Undirected Graph
		int V = 7;
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[V];
		Graphs.createGraph(graph, V);
		
		System.out.println("\nDetect Cycle in Undirected Graph:");
		System.out.println("\tUsing DFS: " + hasCycleUndDFS(graph, V));
		System.out.println("\tUsing BFS: " + hasCycleUndBFS(graph, V));
		
		// Cycle Detection for Directed graph
		// Create Directed Graph
		V = 4;
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graphDirected = new ArrayList[V];
		createGraphDirected(graphDirected, V);
		
		System.out.println("\nDetect Cycle in Directed Graph:");
		System.out.println("\tUsing DFS: " + hasCycleDirDFS(graphDirected, V));
		System.out.println("\tUsing BFS: " + hasCycleDirBFS(graphDirected, V));
	}
}
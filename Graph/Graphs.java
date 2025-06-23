/*
Storing a Graph:
	1. Adjacency List (Optimized for finding neighbors)
	2. Adjacency Matrix
    3. Edge List
    4. 2-D Matrix (Implicit Graph)
    5. Disjoint Set Union

Adjacency Lists are optimized in terms of time and space. It is easier to find information about
neighbors in an adjacency-list as compared to other methods.

Time Complexity of Graph Traversal: O(V + E).

Breadth First Traversal in Graph is similar to Level Order traversal in Tree.
In BFS, go to an immediate neighbor first.

Depth-First Traversal is similar to recursive traversal (i.e., Inorder, Preorder & Postorder).
In DFS, keep going to the first neighbor.

Time Complexity for Cycle Detection: O(V + E).

For Cycle Detection in Undirected Graph, the following can be used:
	1. DFS
	2. BFS
	3. DSU (Disjoint Set Union)

For Cycle Detection in Directed Graph, the following can be used:
	1. DFS
	2. BFS
	3. Topological Sort (Kahn's Algorithm)

A Bipartite Graph is a graph whose vertices can be divided into two independent sets, U and V,
such that every edge (u, v) either connects a vertex from U to V or a vertex from V to U.
In other words, for every edge (u, v), either u belongs to U and v to V, or u belongs to V and v
to U. We can also say that there is no edge that connects vertices of the same set.

Directed Acyclic Graph(DAG) is a directed graph with no cycles.

Topological sorting is used only for DAGs (not for non-DAGs).

Topological Sort works on Dependency Graph.

It is a linear order of vertices such that every directed edge u -> v,
the vertex u comes before v in the order.

Time Complexity of Topological Sort: O(V + E).

For Topological Sort using BFS, Kahn's Algorithm is used.
The algorithm works on in-degree and out-degree of vertices.
It is based on the fact that, in Directed Acyclic Graph(DAG), there is at least one vertex with
in-degree = 0, and one vertex with out-degree = 0.
For Topological Sort using BFS, boolean[] vis is not required because after popping out a
vertex, it decreases the in-degree of its neighbors by 1. Hence, only those vertices with
in-degree = 0 will be taken. In-degree = 0 implies that it cannot be visited again, hence no
boolean[] vis is required.

Worst Case Time Complexity of printing All Paths from Source to Destination: O(V^V).

Dijkstra's Algorithm: To find the shortest path in Weighted Graph (Directed/ Undirected).
It works on BFS, and it is a Greedy Algorithm.
Time Complexity: O(E + E logV), where (E logV) is due to Priority Queue.
If Priority Queue is not used, then Time Complexity will be O(V^2).

Bellman Ford algorithm works even for the cases where Dijkstra's Algorithm fails, i.e., for
negative weights of the edges.
It uses Dynamic Programming.
Time complexity of Bellman Ford Algorithm is more than Dijkstra Algorithm.
Time Complexity is O(E.V).
Bellman Ford fails for negative destination cycles, i.e., when the total destination of graph
cycle is negative.

A minimum spanning tree (MST) or minimum weight spanning tree is a subset of the edges of a
connected, edge-weighted undirected graph that connects all the vertices, without any cycles
and with the minimum possible total-edge weight.
Time Complexity: E(logE)

Other name of Disjoint Set is Union Find. It is used to store and track non-overlapping sets.
Time Complexity of both, Union & Find are O(4k), where k is a constant.
But the value of k is such that maximum operation comes out to be O(4), viz, O(1).
Hence, constant time complexity.

Kruskal's algorithm is used to find Minimum Spanning Tree.
It is a Greedy algorithm.

*/

package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graphs {
	// Undirected Weighted Graph
	public static void createGraph(ArrayList<Edge>[] graph, int V) {
		for (int i = 0; i < V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 2));
		
		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 3));
		
		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 4));
		
		graph[3].add(new Edge(3, 1));
		graph[3].add(new Edge(3, 4));
		graph[3].add(new Edge(3, 5));
		
		graph[4].add(new Edge(4, 2));
		graph[4].add(new Edge(4, 3));
		graph[4].add(new Edge(4, 5));
		
		graph[5].add(new Edge(5, 3));
		graph[5].add(new Edge(5, 4));
		graph[5].add(new Edge(5, 6));
		
		graph[6].add(new Edge(6, 5));
	}
	
	// BFS Traversal
	public static void bfs(ArrayList<Edge>[] graph, boolean[] vis, int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			if (!vis[curr]) {
				vis[curr] = true;
				System.out.print(curr + " ");
				for (Edge e : graph[curr]) {
					q.offer(e.dest);
				}
			}
		}
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
	
	// Is there a Path from Source to Destination using DFS?
	// Time Complexity: O(V + E)
	static boolean hasPathDFS(ArrayList<Edge>[] graph, boolean[] vis, int src, int dest) {
		if (src == dest) {
			return true;
		}
		
		vis[src] = true;
		
		for (Edge e : graph[src]) {
			if (!vis[e.dest] && hasPathDFS(graph, vis, e.dest, dest)) {
				return true;
			}
		}
		
		return false;
	}
	
	// Is there a Path from Source to Destination using BFS?
	static boolean hasPathBFS(ArrayList<Edge>[] graph, boolean[] vis, int src, int dest) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(src);
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			if (!vis[curr]) {
				vis[curr] = true;
				if (curr == dest) {
					return true;
				}
				for (Edge e : graph[curr]) {
					q.offer(e.dest);
				}
			}
		}
		
		return false;
	}
	
	// Count the Connected Components
	public static int connectedComponents(ArrayList<Edge>[] graph, int V) {
		boolean[] vis = new boolean[V];
		int count = 0;
		
		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				++count;
				countComponentsUtil(graph, vis, i);
			}
		}
		
		return count;
	}
	
	public static void countComponentsUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr) {
		vis[curr] = true;
		
		for (Edge e : graph[curr]) {
			if (!vis[e.dest]) {
				countComponentsUtil(graph, vis, e.dest);
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
		ArrayList<Edge>[] graph = new ArrayList[V];
		createGraph(graph, V);
		
		boolean[] vis = new boolean[V];
		System.out.print("BFS Traversal: ");
		bfs(graph, vis, 0);
		System.out.println();
		
		System.out.print("BFS Traversal for Disconnected Graphs: ");
		vis = new boolean[V];
		for (int i = 0; i < V; i++) {
			bfs(graph, vis, i);
		}
		System.out.println("\n");
		
		System.out.print("DFS Traversal: ");
		vis = new boolean[V];
		dfs(graph, vis, 0);
		System.out.println();
		
		// Is there a Path from Source to Destination?
		int src = 1, dest = 5;
		vis = new boolean[V];
		System.out.println("\nIs there path using BFS: " + hasPathDFS(graph, vis, src, dest));
		vis = new boolean[V];
		System.out.println("Is there path using DFS: " + hasPathBFS(graph, vis, src, dest));
		
		System.out.println("\nCount Connected Components: " + connectedComponents(graph, V));
	}
}

/*
Bridge in a Graph: It is an edge, whose deletion increases number of Graph's number of connected
					components. It is generally used in Undirected Graphs.

Articulation Point or Cut Vertex: A vertex in an Undirected Graph is an Articulation point
									(or cut vertex) if removing it (and edges through it)
									disconnects the Graph.

Tarjan's Algorithm is based on DFS.
Time Complexity: O(V + E)

Tarjan's Algorithm can be used for:
	1. Topological sort
	2. To find Bridge in graph
	3. To find Articulation Point [Time Complexity: O(V+E)]
	4. To find Strongly connected components

Ancestor: A node A that was discovered before the current node in DFS.

A node may or maybe Articulation point, if it falls under the following two cases:
	Case 1: parent == -1, i.e. DFS starts with this node, then, this node must have more than 1
			child nodes & they must be disconnected from each other, i.e., no direct or indirect
			Edge must be there.

	Case 2: parent != -1, two subcases arise for this condition:
			Subcase 1: The next node is not visited, then, for Articulation point, there must
						not be any Back-edge for the child node.

			Subcase 2: The current node is the root of a cycle.

*/

package Graph.Algorithms;

import Graph.Edge;

import java.util.ArrayList;

public class TarjanAlgorithm {
	public static void createGraph(ArrayList<Edge>[] graph, int V) {
		for (int i = 0; i < V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 2));
		graph[0].add(new Edge(0, 3));
		
		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 2));
		
		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 1));
		
		graph[3].add(new Edge(3, 0));
		graph[3].add(new Edge(3, 4));
		graph[3].add(new Edge(3, 5));
		
		graph[4].add(new Edge(4, 3));
		graph[4].add(new Edge(4, 5));
		
		graph[5].add(new Edge(5, 3));
		graph[5].add(new Edge(5, 4));
	}
	
	// Bridge
	public static void getBridge(ArrayList<Edge>[] graph, int V) {
		boolean[] vis = new boolean[V];
		int[] dt = new int[V]; // Discovery Time
		int[] lt = new int[V]; // Lowest Discovery Time
		int time = 0;
		
		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				dfsBridge(graph, i, -1, vis, dt, lt, time);
			}
		}
	}
	
	@SuppressWarnings("UnnecessaryContinue")
	static void dfsBridge(ArrayList<Edge>[] graph, int curr, int par, boolean[] vis, int[] dt,
	                      int[] lt, int time) {
		vis[curr] = true;
		dt[curr] = lt[curr] = ++time;
		
		for (Edge e : graph[curr]) {
			if (e.dest == par) {
				continue;
			} else if (!vis[e.dest]) {
				dfsBridge(graph, e.dest, curr, vis, dt, lt, time);
				lt[curr] = Math.min(lt[curr], lt[e.dest]);
				
				// Note: (dt[curr] == lt[e.dest]) is the condition for Cycle
				
				if (lt[curr] < lt[e.dest]) {
					System.out.println("Bridge found from: " + curr + " --- " + e.dest);
				}
			} else {
				lt[curr] = Math.min(lt[curr], dt[e.dest]);
			}
		}
	}
	
	// Articulation Point
	public static void getAP(ArrayList<Edge>[] graph, int V) {
		boolean[] vis = new boolean[V];
		int[] dt = new int[V]; // Discovery Time
		int[] lt = new int[V]; // Lowest Discovery Time
		boolean[] ap = new boolean[V];
		int time = 0;
		
		for (int i = 0; i < V; i++) {
			if (!vis[i]) {
				dfsAP(graph, i, -1, vis, dt, lt, time, ap);
			}
		}
		
		System.out.print("Articulation Points are: ");
		for (int i = 0; i < V; i++) {
			if (ap[i]) {
				System.out.print(i + "  ");
			}
		}
	}
	
	@SuppressWarnings("UnnecessaryContinue")
	public static void dfsAP(ArrayList<Edge>[] graph, int curr, int par, boolean[] vis, int[] dt,
	                         int[] lt, int time, boolean[] ap) {
		vis[curr] = true;
		dt[curr] = lt[curr] = ++time;
		int children = 0;
		
		for (Edge e : graph[curr]) {
			if (e.dest == par) {
				continue;
			} else if (!vis[e.dest]) {
				dfsAP(graph, e.dest, curr, vis, dt, lt, time, ap);
				lt[curr] = Math.min(lt[curr], lt[e.dest]);
				
				// NOTE: (dt[curr] == lt[e.dest]) is the condition for Cycle
				
				if (par != -1 && dt[curr] <= lt[e.dest]) {
					ap[curr] = true;
				}
				
				++children;
			} else {
				lt[curr] = Math.min(lt[curr], dt[e.dest]);
			}
		}
		
		if (par == -1 && children > 1) {
			ap[curr] = true;
		}
	}
	
	public static void main(String[] args) {
		int V = 6;
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[V];
		
		createGraph(graph, V);
		
		System.out.println();
		
		getBridge(graph, V);
		getAP(graph, V);
	}
}

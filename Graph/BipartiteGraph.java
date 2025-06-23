/*
A Bipartite Graph is a graph whose vertices can be divided into two independent sets, U and V,
such that every edge (u, v) either connects a vertex from U to V or a vertex from V to U.
In other words, for every edge (u, v), either u belongs to U and v to V, or u belongs to V and v
to U. We can also say that there is no edge that connects vertices of the same set.

The Graph can be both, either directed or undirected.

If the Graph has multiple parts, then all its parts must be bipartite for the Graph to be a
Bipartite Graph.

Graph Coloring Technique is used to find if the Graph is Bipartite or not. Each vertex is
assigned a unique color. If the color of two adjacent vertices is same, then the graph is not
Bipartite, else it is.

Time Complexity: O(V + E), since it is modified BFS only.
Space Complexity: O(V) (for Queue of BFS) + O(V) (for Color Array) = O(V)

*/

package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
	// Bipartite Graph using BFS
	public static boolean isBipartiteBFS(ArrayList<Edge>[] graph, int V) {
		Queue<Integer> q = new LinkedList<>();
		
		int[] color = new int[V];
		Arrays.fill(color, -1);
		
		for (int i = 0; i < V; i++) {
			if (color[i] == -1) {
				q.offer(i);
				color[i] = 0;
				while (!q.isEmpty()) {
					int curr = q.poll();
					for (Edge e : graph[curr]) {
						if (color[e.dest] == -1) {
							int nextColor = color[curr] == 0 ? 1 : 0;
							color[e.dest] = nextColor;
							q.offer(e.dest);
						} else if (color[e.dest] == color[curr]) {
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}
	
	// Bipartite Graph using DFS
	public static boolean isBipartiteDFS(ArrayList<Edge>[] graph, int V) {
		int[] color = new int[V];
		Arrays.fill(color, -1);
		
		for (int i = 0; i < V; i++) {
			if (color[i] == -1 && isBipartiteDFSUtil(graph, color, i)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isBipartiteDFSUtil(ArrayList<Edge>[] graph, int[] color, int curr) {
		if (color[curr] == -1) {
			color[curr] = 0;
		}
		
		for (Edge e : graph[curr]) {
			if (color[e.dest] == -1) {
				int nextColor = color[curr] == 0 ? 1 : 0;
				color[e.dest] = nextColor;
				if (isBipartiteDFSUtil(graph, color, e.dest)) {
					return true;
				}
			} else if (color[e.dest] == color[curr]) {
				return true;
			}
		}
		
		return false;
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
		Graphs.createGraph(graph, V);
		System.out.println("\nIs Graph Bipartite: ");
		System.out.println("\tUsing BFS: " + isBipartiteBFS(graph, V));
		System.out.println("\tUsing DFS: " + isBipartiteDFS(graph, V));
	}
}
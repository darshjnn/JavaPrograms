/*
Kruskal's algorithm is used to find Minimum Spanning Tree.

It is a Greedy algorithm.

Time Complexity:
	O(V), for loop on edges for MST
	O(ElogE), for sorting
	O(1), for Union Find
Therefore, Time Complexity of Kruskal's Algorithm is: O(V + ElogE)

*/

package Graph.Algorithms;

import Graph.Edge;

import java.util.ArrayList;
import java.util.Collections;

public class KruskalAlgorithm {
	// Create ArrayList of Edges for the Weighted Graph
	public static void createGraph(ArrayList<Edge> graph) {
		graph.add(new Edge(0, 1, 10));
		graph.add(new Edge(0, 2, 15));
		graph.add(new Edge(0, 3, 30));
		graph.add(new Edge(1, 3, 40));
		graph.add(new Edge(2, 3, 50));
	}
	
	// Initialization for Union-find
	public static void init(int[] parents, int V) {
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	
	// Find parent
	public static int find(int a, int[] parents) {
		if (a == parents[a]) {
			return a;
		}
		
		return parents[a] = find(parents[a], parents);
	}
	
	// Union
	public static void union(int a, int b, int[] parents, int[] ranks) {
		int parentA = find(a, parents);
		int parentB = find(b, parents);
		
		if (ranks[parentA] == ranks[parentB]) {
			parents[parentA] = parentB;
			++ranks[parentA];
		} else if (ranks[parentA] < ranks[parentB]) {
			parents[parentA] = parentB;
		} else {
			parents[parentB] = parentA;
		}
	}
	
	public static int kruskalAlgo(ArrayList<Edge> graph, int V) {
		int cost = 0;
		int[] parents = new int[V];
		int[] ranks = new int[V];
		
		// Sort Edges according to weights
		Collections.sort(graph);
		
		// Initialization for Union-find
		init(parents, V);
		
		// Kruskal's Algorithm
		int count = 0;
		for (int i = 0; count < V - 1; i++) {
			Edge e = graph.get(i);
			
			// Find Parents of src and dest
			int parentSrc = find(e.src, parents);
			int parentDest = find(e.dest, parents);
			
			// Check for Cycle
			if (parentSrc == parentDest) {
				continue;
			}
			
			union(parentSrc, parentDest, parents, ranks);
			cost += e.wt;
			++count;
		}
		
		return cost;
	}
	
	public static void main(String[] args) {
		ArrayList<Edge> graph = new ArrayList<>();
		createGraph(graph);
		
		int V = 4;
		System.out.println("MST Cost: " + kruskalAlgo(graph, V));
	}
}
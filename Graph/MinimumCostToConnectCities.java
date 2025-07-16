/*
Minimum Cost To Connect All Cities

There are n cities and there are roads in between some cities. Somehow, all the roads are damaged
simultaneously. We have to repair the roads to connect the cities again. There is a fixed cost to
repair a particular road.

Input is in the form of edges {u, v, w} where, u and v are city indices. W is the cost to rebuild
the road between u and v. Print out the minimum cost to connect all the cities by repairing roads.

Example:
Input: cities[][] = {{0, 1, 2, 3, 4},
				     {1, 0, 5, 0, 7},
					 {2, 5, 0, 6, 0},
					 {3, 0, 6, 0, 0},
					 {4, 7, 0, 0, 0}}
Output: 10

*/

package Graph;

import java.util.PriorityQueue;

public class MinimumCostToConnectCities {
	//	Time Complexity: O(V + E)
	public static int minCost(int n, int[][] cities) {
		int cost = 0;
		boolean[] vis = new boolean[n];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0, 0));
		
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (!vis[curr.dest]) {
				vis[curr.dest] = true;
				cost += curr.cost;
				
				for (int i = 0; i < n; i++) {
					if (cities[curr.dest][i] != 0) {
						pq.offer(new Edge(i, cities[curr.dest][i]));
					}
				}
			}
		}
		
		return cost;
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[][] cities = {
				{0, 1, 2, 3, 4},
				{1, 0, 5, 0, 7},
				{2, 5, 0, 6, 0},
				{3, 0, 6, 0, 0},
				{4, 7, 0, 0, 0}};
		
		System.out.println("Minimum cost to connect cities is: " + minCost(n, cities));
	}
	
	static class Edge implements Comparable<Edge> {
		int dest, cost;
		
		public Edge(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
		
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}
	}
}

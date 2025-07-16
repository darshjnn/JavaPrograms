/*
787. Cheapest Flights Within K Stops

There are n cities connected by some number of flights. You are given an array of flights where
flights[i] = [from_i, to_i, price_i] indicates that there is a flight from city from_i to city
to_i with cost price_i.

You are also given three integers src, dst, and k, return the lowest price from src to dst
with at most k stops. If there is no such route, return -1.

Example 1:
Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0,
dst = 3, k = 1
Output: 700
Explanation:
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost
100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.

Example 2:
Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost
100 + 100 = 200.

Example 3:
Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.

*/

package Graph.LeetCode;

import Graph.Edge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlight {
	// Normal Zindagi Approach
	public static void createGraph(ArrayList<Edge>[] graph, int[][] flights, int n) {
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int[] flight : flights) {
			graph[flight[0]].add(new Edge(flight[0], flight[1], flight[2]));
		}
	}
	
	public static int cheapestFlight(int n, int[][] flights, int src, int dest, int k) {
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[n];
		createGraph(graph, flights, n);
		
		Queue<Node> q = new LinkedList<>();
		int[] cost = new int[n];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[src] = 0;
		
		q.offer(new Node(0, 0, 0));
		while (!q.isEmpty()) {
			Node curr = q.poll();
			
			if (curr.stops > k) {
				break;
			}
			
			for (Edge e : graph[curr.dest]) {
				if (cost[e.src] != Integer.MAX_VALUE && cost[e.dest] > curr.cost + e.wt) {
					cost[e.dest] = curr.cost + e.wt;
					q.offer(new Node(e.dest, cost[e.dest], ++curr.stops));
				}
			}
		}
		
		return cost[dest] == Integer.MAX_VALUE ? -1 : cost[dest];
	}
	
	// Mentos Zindagi Approach
	public static int cheapestFlightOpt(int n, int[][] flights, int src, int dest, int k) {
		int[] cost = new int[n];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[src] = 0;
		
		for (int i = 0; i <= k; i++) {
			int[] temp = cost.clone();
			
			for (int[] flight : flights) {
				if (cost[flight[0]] == Integer.MAX_VALUE) {
					continue;
				}
				
				temp[flight[1]] = Math.min(temp[flight[1]], cost[flight[0]] + flight[2]);
			}
			
			cost = temp.clone();
		}
		
		return cost[dest] == Integer.MAX_VALUE ? -1 : cost[dest];
	}
	
	public static void main(String[] args) {
		int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
		int n = 4;
		int src = 0, dest = 3, k = 1;
		
		/*
		Test Case to try:
		int[][] flights = { { 0, 1, 1 }, { 0, 2, 5 }, { 1, 2, 1 }, { 2, 3, 1 } };
        int n = 4;
        int src = 0, dest = 3, k = 1;
        */
		
		int cost1 = cheapestFlight(n, flights, src, dest, k);
		System.out.println(cost1);
		
		int cost2 = cheapestFlightOpt(n, flights, src, dest, k);
		System.out.println(cost2);
	}
	
	static class Node {
		int dest, cost, stops;
		
		public Node(int dest, int cost, int stops) {
			this.dest = dest;
			this.cost = cost;
			this.stops = stops;
		}
	}
}
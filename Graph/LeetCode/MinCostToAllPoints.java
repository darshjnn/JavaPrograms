/*
1584. Min Cost to Connect All Points

You are given an array points representing integer coordinates of some points on a 2D-plane, 
where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the Manhattan distance between them:
|xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly
one simple path between any two points.

Example 1:
Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
Explanation: 
We can connect the points as shown above to get the minimum cost of 20.
Notice that there is a unique path between every pair of points.

Example 2:
Input: points = [[3,12],[-2,5],[-4,1]]
Output: 18

*/

package Graph.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MinCostToAllPoints {
	// Using Prim's Algorithm
	public static int minCostConnectPointsPrims(int[][] points) {
		int n = points.length;
		
		if (n <= 1) {
			return 0;
		}
		
		int minCost = 0;
		int edgeCount = n - 1; // Since MST has (n - 1) edges
		
		// HashMap to map each element with an index
		HashMap<int[], Integer> map = new HashMap<>();
		
		// Using Prim's Algorithm to find minimum cost to connect all the points
		boolean[] vis = new boolean[n];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		// Adding initial Edge weights to Priority Queue for creating Min-heap
		for (int i = 0; i < n; i++) {
			map.put(points[i], i);
		}
		
		pq.offer(new Edge(points[0], points[0]));
		// edgeCount >= 0 to because Edge(0, 0) is already in the PriorityQueue
		while (!pq.isEmpty() && edgeCount >= 0) {
			Edge curr = pq.poll();
			
			int[] dest = curr.y;
			int destIndex = map.get(dest);
			
			if (!vis[destIndex]) {
				vis[destIndex] = true;
				minCost += curr.cost;
				--edgeCount;
				
				// Adding neighbors
				for (int[] point : points) {
					if (!vis[map.get(point)]) {
						pq.offer(new Edge(dest, point));
					}
				}
			}
		}
		
		return minCost;
	}
	
	// Using Arrays
	public static int minCostConnectPointsArray(int[][] points) {
		int n = points.length;
		
		if (n <= 1) {
			return 0;
		}
		
		int minCost = 0;
		boolean[] vis = new boolean[n];
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		// Start with the first node
		int[] curr = points[0];
		vis[0] = true;
		for (int i = 1; i < n; i++) {
			int smallest = Integer.MAX_VALUE;
			int smallestIndex = -1;
			
			// Compute all distances with curr MST.
			for (int j = 0; j < n; j++) {
				if (!vis[j]) {
					int[] dest = points[j];
					int currDist = Math.abs(curr[0] - dest[0]) +  Math.abs(curr[1] - dest[1]);
					dist[j] = Math.min(dist[j], currDist);
					
					if (dist[j] < smallest) {
						smallestIndex = j;
						smallest = dist[j];
					}
				}
			}
			
			vis[smallestIndex] = true;
			minCost += smallest;
			curr = points[smallestIndex];
		}
		
		return minCost;
	}
	
	public static void main(String[] args) {
		int[][] points = {{0, 0}, {1, 1}, {1, 0}, {-1, 1}};
		
		System.out.println(minCostConnectPointsPrims(points));
		System.out.println(minCostConnectPointsArray(points));
	}
	
	public static class Edge implements Comparable<Edge> {
		int[] x, y;
		int cost;
		
		public Edge(int[] x, int[] y) {
			this.x = x;
			this.y = y;
			this.cost = Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]); // Manhattan Distance
		}
		
		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost; // For ascending sorting
		}
	}
}

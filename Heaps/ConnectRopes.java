/*
Connect N Ropes

Given are N ropes of different lengths, the task is to connect these ropes into one rope with
minimum cost, such that the cost to connect two ropes is equal to the sum of their lengths.

Example 1:
Input: {4,3,2,6}
Output: 29
Explanation:
connect 2 & 3: 5
connect 5 & 4: 9
connect 9 & 6: 15
Total Cost: 5 + 9 + 15 = 29

*/

package Heaps;

import java.util.PriorityQueue;

public class ConnectRopes {
	@SuppressWarnings("DataFlowIssue")
	public static int minCost(int[] arr) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int cost = 0;
		
		for (int i : arr) {
			pq.add(i);
		}
		
		while (pq.size() > 1) {
			int firstMin = pq.poll();
			int secondMin = pq.poll();
			cost += firstMin + secondMin;
			pq.add(firstMin + secondMin);
		}
		
		return cost;
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 3, 2, 6};
		System.out.println(minCost(arr));
	}
}

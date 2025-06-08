/*
658. Find K Closest Elements

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the
array. The result should also be sorted in ascending order.

An integer 'a' is closer to x than an integer b if:
	|a - x| < |b - x|, or
	|a - x| == |b - x| and a < b

Example 1:
Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]

Example 2:
Input: arr = [1,1,2,3,4,5], k = 4, x = -1
Output: [1,1,2,3]

*/

package Heaps.LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestElements {
	// Aam Zindagi
	public static List<Integer> findClosestElements(int[] arr, int k, int x) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		List<Integer> res = new ArrayList<>();
		
		for (int i : arr) {
			int dist = Math.abs(x - i);
			pq.add(new Node(i, dist));
		}
		
		int count = 0;
		while (!pq.isEmpty() && count < k) {
			res.add(pq.poll().data);
			++count;
		}

		res.sort(Comparator.comparingInt(a -> a));
		
		return res;
	}
	
	// Mentos Zindagi
	public static List<Integer> findClosestElementsOptimized(int[] arr, int k, int x) {
		List<Integer> res = new ArrayList<>();
		int left = 0, right = arr.length - 1;
		
		while (right - left >= k) {
			if (Math.abs(arr[right] - x) < Math.abs(arr[left] - x)) {
				++left;
			} else {
				--right;
			}
		}
		
		for (int i = left; i <= right; ++i) {
			res.add(arr[i]);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
		int k = 3, x = 5;
		
		List<Integer> result = findClosestElements(arr, k, x);
		System.out.println(result);
		
		List<Integer> result2 = findClosestElementsOptimized(arr, k, x);
		System.out.println(result2);
	}
	
	static class Node implements Comparable<Node> {
		int data, dist;
		
		public Node(int data, int dist) {
			this.data = data;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Node p) {
			if (this.dist == p.dist) {
				return this.data - p.data;
			}
			return this.dist - p.dist;
		}
	}
}

/*
207. Course Schedule

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates
that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1, you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished 
course 1. So it is impossible.

*/

package Graph.LeetCode;

import java.util.ArrayList;

public class CourseSchedule {
	
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		for (int i = 0; i < numCourses; i++) {
			adj.add(new ArrayList<>());
		}
		
		for (int[] t : prerequisites) {
			adj.get(t[0]).add(t[1]);
		}
		
		boolean[] visited = new boolean[numCourses];
		boolean[] helper = new boolean[numCourses];
		
		for (int i = 0; i < adj.size(); i++) {
			if (directedCycleDetect(adj, i, visited, helper)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean directedCycleDetect(ArrayList<ArrayList<Integer>> adj, int index,
	                                          boolean[] visited, boolean[] helper) {
		visited[index] = true;
		helper[index] = true;
		ArrayList<Integer> neighbours = adj.get(index);
		
		for (int curr : neighbours) {
			if (visited[curr] && helper[curr]) {
				return true;
			} else if (!visited[curr]) {
				if (directedCycleDetect(adj, curr, visited, helper)) {
					return true;
				}
			}
		}
		
		helper[index] = false;
		return false;
	}
	
	public static void main(String[] args) {
		int n = 3;
		int[][] pre = {{0, 1}, {1, 2}, {0, 2}};
		boolean a = canFinish(n, pre);
		System.out.println(a);
	}
}

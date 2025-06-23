/*
797. All Paths From Source to Target

Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1,
find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from
node i (i.e., there is a directed edge from node i to node graph[i][j]).

Example 1:
Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

Example 2:
Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]

 */

package Graph.LeetCode;

import java.util.*;

public class AllPathsFromSourceToTarget {
	public static void getPath(int[][] graph, int source, int target, ArrayList<Integer> path,
	                           ArrayList<ArrayList<Integer>> allPaths) {
		if (source == target) {
			ArrayList<Integer> temp = new ArrayList<>(path);
			allPaths.add(temp);
		} else {
			for (int neighbor : graph[source]) {
				path.add(neighbor);
				getPath(graph, neighbor, target, path, allPaths);
				path.remove(path.size() - 1);
			}
		}
	}
	
	public static ArrayList<ArrayList<Integer>> allPaths(int[][] graph) {
		ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();
		
		for (int neighbor : graph[0]) {
			ArrayList<Integer> path = new ArrayList<>();
			path.add(0);
			path.add(neighbor);
			getPath(graph, neighbor, graph.length - 1, path, allPaths);
		}
		
		return allPaths;
	}
	
	public static void main(String[] args) {
		int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
		ArrayList<ArrayList<Integer>> allPaths = allPaths(graph);
		
		for (ArrayList<Integer> path : allPaths) {
			System.out.println(path);
		}
	}
}
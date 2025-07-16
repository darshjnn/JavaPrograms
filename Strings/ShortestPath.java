/*
Shortest Path

Given a route containing 4 directions (E, W, N, S),
Find the shortest path to reach destination.
Take East as a positive-x direction.
Take West as a negative-x direction.
Take North as a positive-y direction.
Take South as a negative-y direction.

Example 1:
directions = "WNEENESENNN"
ans = 5

*/

package Strings;

public class ShortestPath {
	public static float shortestPath(String directions) {
		int x = 0, y = 0;
		
		for (char dir : directions.toCharArray()) {
			if (dir == 'E' || dir == 'e') {
				// East
				++x;
			} else if (dir == 'W' || dir == 'w') {
				// West
				--x;
			} else if (dir == 'N' || dir == 'n') {
				// North
				++y;
			} else if (dir == 'S' || dir == 's') {
				// South
				--y;
			}
		}
		
		return (float) Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
	}
	
	public static void main(String[] args) {
		String directions = "WNEENESENNN";
		System.out.print("Shortest Path: ");
		System.out.println(shortestPath(directions));
	}
}
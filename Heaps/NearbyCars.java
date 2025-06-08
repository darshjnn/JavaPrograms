/*
Nearby Cars

Given N points in a 2D plane, which are locations of N cars. Print k nearest cars from the origin.

Example 1:
Input: C0(3, 3), C1(5, -1), C2(-2, 4).
Output: C0 and C2

*/

package Heaps;

import java.util.PriorityQueue;

public class NearbyCars {
	public static void getNearbyCars(int[][] cars, int k) {
		PriorityQueue<Car> pq = new PriorityQueue<>();
		
		for (int i = 0; i < cars.length; i++) {
			// For simplicity, square root of distance is ignored.
			int dist = (int) Math.pow(cars[i][0], 2) + (int) Math.pow(cars[i][1], 2);
			pq.add(new Car(i, dist));
		}
		
		System.out.print(k + " nearest cars are: ");
		int count = 0;
		while (!pq.isEmpty() && count < k) {
			System.out.print("C" + pq.poll().id + " ");
			++count;
		}
	}
	
	public static void main(String[] args) {
		int[][] cars = {{3, 3}, {5, -1}, {-2, 4}};
		int k = 2;
		
		getNearbyCars(cars, k);
	}
	
	static class Car implements Comparable<Car> {
		int id, dist;
		
		public Car(int id, int dist) {
			this.id = id;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Car car) {
			return this.dist - car.dist;
		}
	}
}

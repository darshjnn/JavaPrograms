package Heaps;

import java.util.ArrayList;

public class HeapsImplementation {
	public static void main(String[] args) {
		Heaps heap = new Heaps();
		ArrayList<Integer> arr = new ArrayList<>();
		
		// Check if the heap is empty
		System.out.println("Is heap empty?: " + heap.isEmpty(arr) + "\n");
		
		// Insert data
		int[] data = {4, 5, 3, 2, 7, 1};
		for (int d : data) {
			heap.insert(arr, d);
		}
		
		System.out.println(arr + "\n");
		
		// Getting the minimum element
		System.out.println("Minimum Element in the Heap: " + heap.peek(arr));
		
		// Removing the minimum element
		System.out.println("Popping the min element from the heap: " + heap.delete(arr));
		System.out.println(arr + "\n");
	}
}

/*
Heaps
Heap data structures are kind of Binary Trees.

Heaps can be visualized as Binary Tree, &, implemented as Array.

The Binary trees are implemented using Arrays, &, using Binary Tree implementation, Priority Queues
are extracted.

Two types of Heaps are there:
	1. Max Heap: The Maximum element has the highest priority in the PQ.
	2. Min Heap: The Minimum element has the highest priority in the PQ.
	
In Java, by default, PQ is implemented using min heap.

Properties of Heaps:
	1. Binary Tree: at most 2 children
	
	2. Complete Binary Tree (CBT): CBT is a Binary Tree in which all the levels are filled, except
									possibly the last one, which is filled from left to right
	
	3. Heap Order Property: Children >= Parent, for Min Heap
							Children <= Parent, for Max Heap

Heaps are not implemented as a class because of time complexity:
	O(n) will be required to find the correct place to insert the node so that CBT property is
	satisfied.
	After insertion, extra time will be required to rearrange the nodes to maintain min heap or
	max heap.
	
Heaps are implemented as ArrayLists after visualizing it as Binary Tree.
Indexes of children node will be:
	Left child: 2i + 1
	Right child: 2i + 2

Heapify is the process of creating a heap data structure from a binary tree. It is used to
create a Min-Heap or a Max-Heap.

*/

package Heaps;

import java.util.ArrayList;

public class Heaps {
	// Insert data. O(logn) time
	public void insert(ArrayList<Integer> heap, int data) {
		// Step 1: Add at last index; O(1) time
		heap.add(data);
		
		// Step 2: Fix the heap structure; O(logn) time
		int x = heap.size() - 1;
		int parent = (x - 1) / 2;
		
		while (heap.get(x) < heap.get(parent)) {
			int temp = heap.get(x);
			heap.set(x, heap.get(parent));
			heap.set(parent, temp);
			
			x = parent;
			parent = (parent - 1) / 2;
		}
	}
	
	// Peek returns the minimum element, which is the top of Tree and fist element of Array
	public int peek(ArrayList<Integer> heap) {
		return heap.get(0);
	}
	
	// Removing the element;
	public int delete(ArrayList<Integer> heap) {
		// Step 1: Swap with the last element; O(1) time
		int temp = heap.get(0);
		heap.set(0, heap.get(heap.size() - 1));
		heap.set(heap.size() - 1, temp);
		
		// Step 2: Deleting the last element; O(1) time
		heap.remove(heap.size() - 1);
		
		// Step 3: Heapify; O(logn) time
		this.heapify(heap, 0);
		
		// Return the popped element
		return heap.get(temp);
	}
	
	// Heapify
	private void heapify(ArrayList<Integer> heap, int root) {
		int left = (2 * root) + 1;
		int right = (2 * root) + 2;
		int minIndex = root;
		
		if (left < heap.size() && heap.get(left) < heap.get(minIndex)) {
			minIndex = left;
		}
		
		if (right < heap.size() && heap.get(right) < heap.get(minIndex)) {
			minIndex = right;
		}
		
		if (minIndex != root) {
			// Swap
			int temp = heap.get(minIndex);
			heap.set(minIndex, heap.get(root));
			heap.set(root, temp);
			
			heapify(heap, minIndex);
		}
	}
	
	// Check if the heap is empty
	public boolean isEmpty(ArrayList<Integer> heap) {
		return heap.isEmpty();
	}
}

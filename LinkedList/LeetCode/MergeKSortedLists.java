/*
23. Merge k Sorted Lists

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: []

*/

package LinkedList.LeetCode;

import LinkedList.Node;

public class MergeKSortedLists {
	@SuppressWarnings("DuplicatedCode")
	public static Node merge(Node leftHead, Node rightHead) {
		if (leftHead == null) {
			return rightHead;
		}
		
		if (rightHead == null) {
			return leftHead;
		}
		
		Node merged = new Node(Integer.MIN_VALUE);
		Node temp = merged;
		
		while ((leftHead != null) && (rightHead != null)) {
			if ((leftHead.data) < (rightHead.data)) {
				temp.next = leftHead;
				leftHead = leftHead.next;
			} else {
				temp.next = rightHead;
				rightHead = rightHead.next;
			}
			temp = temp.next;
		}
		
		while (leftHead != null) {
			temp.next = leftHead;
			leftHead = leftHead.next;
			temp = temp.next;
		}
		
		while (rightHead != null) {
			temp.next = rightHead;
			rightHead = rightHead.next;
			temp = temp.next;
		}
		
		return merged.next;
		
	}
	
	// Aam Zindagi: Brute Force Approach - O(k * n), k = no. of lists, n = no. Of nodes
	public static Node bruteMergeKLists(Node[] lists) {
        if (lists.length == 0) {
            System.out.println("Empty Set of Lists...");
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        int n = lists.length;
        Node merged = new Node(Integer.MIN_VALUE);

        for (int i = 0; i <= (n - 1); i++) {
            merged = merge(lists[i], merged);
        }

        return merged.next;
	}
	
	// Mentos Zindagi: Optimised Approach - O(n * logk)
	public static Node optimisedMergeKLists(Node[] lists) {
		if (lists.length == 0) {
			System.out.println("Empty Set of Lists...");
			return null;
		}
		
		if (lists.length == 1) {
			return lists[0];
		}
		
		int n = lists.length - 1;

		while (n != 0) {
			int i = 0, j = n;
			while (i < j) {
				lists[i] = merge(lists[i], lists[j]);
				
				++i;
				--j;
				
				if (i >= j) {
					n = j;
				}
			}
		}

		return lists[0];
	}
	
	public static void main(String[] args) {
		Node a = new Node(-4);
		a.next = new Node(4);
		a.next.next = new Node(5);
		
		Node b = new Node(1);
		b.next = new Node(3);
		b.next.next = new Node(4);
		
		Node c = new Node(2);
		c.next = new Node(6);
		
		Node[] lists = {a, null, b, c, null};
		
		Node merged = bruteMergeKLists(lists);
		while (merged != null) {
			System.out.print(merged.data + "  ");
			merged = merged.next;
		}
		System.out.println();
		
		Node d = new Node(-4);
		d.next = new Node(1);
		d.next.next = new Node(6);
		
		Node e = new Node(1);
		e.next = new Node(3);
		e.next.next = new Node(4);
		
		Node f = new Node(2);
		f.next = new Node(6);
		
		Node[] lists2 = new Node[]{d, null, null, e, f, null};
		
		merged = optimisedMergeKLists(lists2);
		while (merged != null) {
			System.out.print(merged.data + "  ");
			merged = merged.next;
		}
		System.out.println();
		
	}
}
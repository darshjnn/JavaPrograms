/*
328. Odd Even Linked List

Given the head of a singly linked list, group all the nodes with odd indices together followed
by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the
input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

Example 1:
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]

Example 2:
Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]

*/

package LinkedList.LeetCode;

import LinkedList.SingleLinkedList;
import LinkedList.Node;

public class OddEvenLinkedList {
	public static void oddEvenList(SingleLinkedList list) {
		if (list.head == null || list.head.next == null) {
			return;
		}
		
		Node curr = list.head;
		Node even = new Node(-1);
		Node tempEven = even;
		
		while (curr.next != null) {
			tempEven.next = curr.next;
			tempEven = tempEven.next;
			curr.next = curr.next.next;
			tempEven.next = null;
			
			if (curr.next != null) {
				curr = curr.next;
			} else {
				break;
			}
		}
		
		curr.next = even.next;
	}
	
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.addEnd(2);
		list.addEnd(4);
		list.addEnd(6);
		list.addStart(1);
		list.addEnd(3);
		list.addEnd(5);
		list.addEnd(7);
		list.addEnd(10);
		list.addEnd(8);
		
		System.out.println("Original List: ");
		list.printList();
		
		System.out.println();
		System.out.println("Odd Even List: ");
		oddEvenList(list);
		list.printList();
		
	}
}
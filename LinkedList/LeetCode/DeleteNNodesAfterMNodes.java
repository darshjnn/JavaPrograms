/*
1474. Delete N Nodes After M Nodes of a Linked List

You are given the head of a linked list and two integers m and n.

Traverse the linked list and remove some nodes in the following way:
	1. Start with the head as the current node.
	2. Keep the first m nodes starting with the current node.
	3. Remove the next n nodes
	4. Keep repeating steps 2 and 3 until you reach the end of the list.
	5. Return the head of the modified list after removing the mentioned nodes.

Example 1:
Input: head = [1,2,3,4,5,6,7,8,9,10,11,12,13], m = 2, n = 3
Output: [1,2,6,7,11,12]
Explanation: Keep the first (m = 2) nodes starting from the head of the linked List (1 -> 2)
shown in black nodes.
Delete the next (n = 3) nodes (3 -> 4 -> 5) show in read nodes.
Continue with the same procedure until reaching the tail of the Linked List.
Head of the linked list after removing nodes is returned.

Example 2:
Input: head = [1,2,3,4,5,6,7,8,9,10,11], m = 1, n = 3
Output: [1,5,9]
Explanation: Head of linked list after removing nodes is returned.

*/

package LinkedList.LeetCode;

import LinkedList.Node;
import LinkedList.SingleLinkedList;

public class DeleteNNodesAfterMNodes {
	public static void skipMdeleteN(SingleLinkedList list, int n, int m) {
		if (list.head == null) {
			System.out.println("List is Empty...");
			return;
		}
		
		if (list.size == 1 || list.size < m) {
			return;
		}
		
		Node curr = list.head;
		int count = list.size / m;
		for (int i = 0; i < count; i++) {
			int pos = 1;
			while (curr != null && pos < m) {
				curr = curr.next;
				++pos;
			}
			
			if (curr != null && curr.next != null) {
				pos = 0;
				Node temp = curr.next;
				while (temp != null && pos < n) {
					temp = temp.next;
					++pos;
				}
				curr.next = temp;
				curr = curr.next;
			} else {
				return;
			}
		}
		
		Node temp = list.head;
		while (temp.next != null) {
			temp = temp.next;
		}
		list.tail = temp;
	}
	
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		list.head.next.next.next = list.tail = new Node(4);
		Node next = new Node(5);
		next.next = new Node(6);
		next.next.next = new Node(7);
		next.next.next.next = new Node(8);
		next.next.next.next.next = new Node(9);
		list.tail.next = next;
		
		next.next.next.next.next.next = list.tail = new Node(10);
		
		list.size = 10;
		list.addEnd(11);
		list.addEnd(12);
		
		System.out.println("Original List: ");
		list.printList();
		
		System.out.println();
		
		int n = 2, m = 3;
		System.out.println("After deleting " + n + " after every " + m + " nodes:");
		skipMdeleteN(list, n, m);
		list.printList();
	}
}

/*
Alternate Solution:

	public static void skipMdeleteN(Node head, int M, int N) {
		Node curr = head, t;
		int count;
		
		while (curr != null) {
			for (count = 1; count < M && curr != null; count++) {
				curr = curr.next;
			}
			
			if (curr == null) {
				return;
			}
			
			t = curr.next;
			
			for (count = 1; count <= N && t != null; count++) {
				t = t.next;
			}
			
			curr.next = t;
			curr = t;
		}
	}
	
*/
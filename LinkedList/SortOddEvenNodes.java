/*
Sort Odd & Even Nodes in the Linked List

Given a Linked List. Arrange all the Odd nodes at the start, and even nodes at the end of
the Linked List

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

Example 1:
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]

*/

package LinkedList;

public class SortOddEvenNodes {
	public static void sortOddEven(SingleLinkedList list) {
		Node dummy = new Node(-1);
		dummy.next = list.head;
		Node curr = dummy;
		
		Node even = new Node(-2);
		Node tempEven = even;
		
		while (true) {
			while ((curr.next != null) && (curr.next.data % 2 == 0)) {
				tempEven.next = curr.next;
				tempEven = tempEven.next;
				curr.next = curr.next.next;
				tempEven.next = null;
			}
			
			if (curr.next != null) {
				curr = curr.next;
			} else {
				break;
			}
			
		}
		
		curr.next = even.next;
		list.head = dummy.next;
	}
	
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.addEnd(4);
		list.addEnd(2);
		list.addStart(1);
		list.addEnd(6);
		list.addEnd(5);
		list.addEnd(3);
		list.addEnd(7);
		list.addEnd(8);
		list.addEnd(10);
		
		System.out.println("Original List: ");
		list.printList();
		
		System.out.println();
		System.out.println("Odd Even List: ");
		sortOddEven(list);
		list.printList();
	}
}
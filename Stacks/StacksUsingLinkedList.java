// Stack can be implemented using Array, ArrayList & Linked List

// Implementing Stack in the form of Linked List

package Stacks;

public class StacksUsingLinkedList {
	static class Node {
		int data;
		Node next;
		
		Node (int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	static class Stack {
		Node head;
		
		public boolean isEmpty() {
			return this.head == null;
		}
		
		public void push(int data) {
			Node newNode = new Node(data);
			if (this.head == null) {
				this.head = newNode;
				return;
			}
			newNode.next = this.head;
			this.head = newNode;
		}
		
		public int pop() {
			if (this.head == null) {
				return -1;
			}
			int returnVal = this.head.data;
			this.head = this.head.next;
			return returnVal;
		}
		
		public int peek() {
			if (this.head == null) {
				return -1;
			}
			return this.head.data;
		}
	}
	
	public static void main(String[] args) {
		Stack stack1 = new Stack();
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		
		Stack stack2 = new Stack();
		stack2.push(10);
		stack2.push(20);
		stack2.push(30);
		
		System.out.println(stack1.peek());
		System.out.println(stack2.peek());
	}
}




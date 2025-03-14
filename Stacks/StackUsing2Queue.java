// Implementing Stack using 2 Queues

package Stacks;

import java.util.*;

public class StackUsing2Queue {
	static Queue<Integer> q1 = new LinkedList<>();
	static Queue<Integer> q2 = new LinkedList<>();
	
	public boolean isEmpty() {
		return q1.isEmpty() && q2.isEmpty();
	}
	
	public void add(int data) {
		if (q1.isEmpty()) {
			q2.add(data);
		} else {
			q1.add(data);
		}
	}
	
	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		int top = -1;
		if (q2.isEmpty()) {
			while (!q1.isEmpty()) {
				top = q1.remove();
				if (q1.isEmpty()) {
					break;
				}
				q2.add(top);
			}
		} else {
			while (!q2.isEmpty()) {
				top = q2.remove();
				if (q2.isEmpty()) {
					break;
				}
				q1.add(top);
			}
		}
		return top;
	}
	
	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		int top = -1;
		if (q1.isEmpty()) {
			while(!q2.isEmpty()) {
				top = q2.remove();
				q1.add(top);
			}
		} else {
			while(!q1.isEmpty()) {
				top = q1.remove();
				q2.add(top);
			}
		}
		return top;
	}
	
	public static void main(String[] args) {
		StackUsing2Queue s = new StackUsing2Queue();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.peek());
	}
}
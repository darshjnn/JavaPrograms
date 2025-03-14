/*
Reverse k Elements of Queue

Given an integer k and a queue of integers. The task is to reverse the order of k elements of
the queue, leaving the other elements in the same relative order.

Example 1:
Input: Q = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100] , k = 5
Output: Q = [50, 40, 30, 20, 10, 100, 90, 80, 70, 60]

*/

package Queue;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class ReverseKElements {
    public static void reverseK(Queue<Integer> q, int k) {
        if (k > q.size() || k <= 1) {
            return;
        }

        Stack<Integer> s = new Stack<>();
        int count = 0, index = 0;

        while (index < q.size() && k <= (q.size() - index)) {
            while (count < k) {
                s.push(q.poll());
                ++count;
                ++index;
            }
            while (!s.isEmpty()) {
                q.offer(s.pop());
            }
            count = 0;
        }

        while (index < q.size()) {
            q.offer(q.poll());
            ++index;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(10);
        q.offer(20);
        q.offer(30);
        q.offer(40);
        q.offer(50);
        q.offer(60);
        q.offer(70);
	    
	    for (Integer i : q) {
		    System.out.print(i + " ");
	    }
        System.out.println();

        int k = 4;
	    
        reverseK(q, k);

        for (Integer i : q) {
		    System.out.print(i + " ");
	    }
        System.out.println();
    }
}
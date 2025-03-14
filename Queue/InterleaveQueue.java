// Interleaving 2 halves of Queue of even length.

package Queue;

import java.util.*;

public class InterleaveQueue {
	public static void interleaveQueue(Queue<Integer> q) {
		if (q.isEmpty() || q.size() == 1) {
			return;
		}

		Queue<Integer> temp = new LinkedList<>();
		int size = q.size();

		for (int i = 0; i < (size / 2); i++) {
			temp.offer(q.poll());
		}

		while (!temp.isEmpty()) {
			q.offer(temp.poll());
			q.offer(q.poll());
		}
	}
	
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.offer(5);
		q.offer(6);

		Iterator<Integer> i = q.iterator();
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}
		System.out.println();

		interleaveQueue(q);

		i = q.iterator();
		while (i.hasNext()) {
			System.out.print(i.next() + " ");
		}
	}
}
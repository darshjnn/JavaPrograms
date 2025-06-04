/*
Priority Queue
Higher priority element will be removed first irrespective of the order of insertion.

	1. add(): O(log(n))
	2. remove(): O(log(n))
	3. peek(): O(1)
	
If the PQ is of Integer, then, by default, lower the value; higher will be its priority.

*/

package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueues {
	public static class Student implements Comparable<Student> {
		String name;
		int rank;
		
		public Student(String name, int rank) {
			this.name = name;
			this.rank = rank;
		}
		
		@Override
		public int compareTo(Student s) {
			return this.rank - s.rank;
		}
	}
	
	public static void main(String[] args) {
		// PQ of Integer with higher value having higher priority
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		pq.add(20);
		pq.add(10);
		pq.add(40);
		pq.add(30);
		pq.add(5);
		System.out.println(pq + "\n");
		
		// PQ of Student Object
		PriorityQueue<Student> pqStu = new PriorityQueue<>();
		pqStu.add(new Student("A", 3));
		pqStu.add(new Student("B", 1));
		pqStu.add(new Student("C", 4));
		pqStu.add(new Student("D", 2));
		pqStu.add(new Student("E", 5));
		
		for (Student s : pqStu) {
			System.out.println("Name: " + s.name + ", Rank: " + s.rank);
		}
	}
}

/*
Single Linked List Class

*/

package LinkedList;

@SuppressWarnings("DuplicatedCode")
public class SingleLinkedList {
	public Node head, tail;
	public int size;
	
	public SingleLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	// Add element at Start
	public void addStart(int data) {
		Node newNode = new Node(data);
		++this.size;
		
		if (this.head == null) {
			this.head = this.tail = newNode;
			return;
		}
		
		newNode.next = this.head;
		this.head = newNode;
	}
	
	// Add element at Last
	public void addEnd(int data) {
		Node newNode = new Node(data);
		++this.size;
		
		if (this.head == null) {
			this.head = this.tail = newNode;
			return;
		}
		
		this.tail.next = newNode;
		this.tail = newNode;
	}

	public void add(int data) {
		this.addEnd(data);
	}
	
	// Add element in Middle
	public void addMid(int data, int index) {
		Node newNode = new Node(data);
		++this.size;
		
		if (this.head == null || index <= 0) {
			this.head = this.tail = newNode;
			return;
		}
		
		if (index >= this.size) {
			this.tail.next = newNode;
			this.tail = newNode;
			return;
		}
		
		int i = 0;
		Node temp = this.head;
		while (i < (index - 1)) {
			temp = temp.next;
			++i;
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}
	
	// Remove element from Start
	public Object removeStart() {
		if (this.head == null) {
			System.out.println("List is Empty...");
			return Integer.MIN_VALUE;
		} else if (this.size == 1) {
			this.size = 0;
			Object temp = this.head.data;
			this.head = this.tail = null;
			return temp;
		}
		
		--this.size;
		Object temp = this.head.data;
		this.head = this.head.next;
		return temp;
	}
	
	// Remove element from End
	public Object removeEnd() {
		if (this.head == null || this.size == 1) {
			return this.removeStart();
		}
		
		--this.size;
		Node temp = this.head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		int tempValue = temp.next.data;
		temp.next = null;
		this.tail = temp;
		return tempValue;
	}
	
	// Print elements
	public void printList() {
		if (this.head == null) {
			System.out.println("List is Empty...");
			return;
		}
		
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + "  ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	// Search element using Iteration
	public int itrSearch(int key) {
		if (this.head == null) {
			System.out.println("List is Empty...");
			return -1;
		}
		
		int i = 0;
		Node temp = this.head;
		while (temp != null) {
			if (temp.data == key) {
				return i;
			}
			++i;
			temp = temp.next;
		}
		System.out.println("Element not found...");
		return Integer.MAX_VALUE;
	}
	
	// Search element using Recursion
	public int recSearchHelper(Node head, int key) {
		if (head == null) {
			return Integer.MAX_VALUE;
		}
		
		if (head.data == key) {
			return 0;
		}
		
		int index = recSearchHelper(head.next, key);
		if (index == Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		
		return ++index;
	}
	
	public int recSearch(int key) {
		if (this.head == null) {
			System.out.println("List is Empty...");
			return -1;
		}
		
		return recSearchHelper(this.head, key);
	}
	
	// Clone the Linked List
	public SingleLinkedList copy() {
		SingleLinkedList copy = new SingleLinkedList();
		Node temp = this.head;
		
		while (temp != null) {
			copy.addEnd(temp.data);
			temp = temp.next;
		}
		
		return copy;
	}
	
	// Reverse the Linked List
	public void reverse() {
		Node prev = null;
		Node curr = this.tail = this.head;
		Node next;
		
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		this.head = prev;
	}
	
	// Delete Nth node from end
	public Object delFromEnd(int index) {
		if (this.head == null) {
			System.out.println("List is Empty...");
			return Integer.MIN_VALUE;
		}
		
		--this.size;
		
		if (index >= this.size) {
			return removeStart();
		}
		
		if (index <= 0) {
			return removeEnd();
		}
		
		Node temp = this.head;
		int i = 1;
		int pos = this.size - index;
		while (i < pos) {
			temp = temp.next;
			++i;
		}
		int tempData = temp.next.data;
		temp.next = temp.next.next;
		return tempData;
	}
	
	// Finding Middle Node Linked List using Slow-fast approach
	public Node getMid() {
		if (this.head == null) {
			System.out.println("List is Empty...");
			return null;
		}
		
		Node slow = this.head, fast = this.head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}
	
	// Check if Linked List is Palindrome
	public boolean isPalindrome() {
		if (this.head == null) {
			System.out.println("List is Empty...");
			return true;
		}
		
		SingleLinkedList temp = this.copy();
		Node mid = temp.getMid();
		Node prev = null;
		Node next;
		while (mid != null) {
			next = mid.next;
			mid.next = prev;
			prev = mid;
			mid = next;
		}
		
		Node left = temp.head;
		Node right = prev;
		while (right != null && left != null) {
			if (left.data != right.data) {
				return false;
			}
			left = left.next;
			right = right.next;
		}
		
		return true;
	}
	
	// Floyd's Cycle Finding Algorithm
	public boolean isCycle() {
		if (this.head == null) {
			System.out.println("List is Empty...");
			return false;
		}
		
		Node slow = this.head, fast = this.head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		
		return false;
	}
	
	// Remove Cycle
	public void removeCycle() {
		Node slow = this.head, fast = this.head;
		boolean flag = false;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				flag = true;
				break;
			}
		}
		
		if (!flag) {
			return;
		}
		
		if (fast == this.head) {
			while (fast.next != this.head) {
				fast = fast.next;
			}
			fast.next = null;
			return;
		}
		
		slow = this.head;
		Node prev = fast;
		while (slow != fast) {
			prev = fast;
			fast = fast.next;
			slow = slow.next;
		}
		
		prev.next = null;
	}
	
	// Merge Sort
	public Node getMid(Node head) {
		Node slow = head;
		Node fast = head.next;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	public Node merge(Node leftHead, Node rightHead) {
		Node merged = new Node(-1);
		Node temp = merged;
		
		while (leftHead != null && rightHead != null) {
			if (leftHead.data < rightHead.data) {
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
	
	public Node mergeSortHelper(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		Node mid = this.getMid(head);
		Node right = mid.next;
		mid.next = null;
		
		return merge(mergeSortHelper(head), mergeSortHelper(right));
	}
	
	public Node mergeSort() {
		if (this.head == null) {
			System.out.println("List is Empty...");
			return null;
		}
		Node temp = this.head;
		return mergeSortHelper(temp);
	}
	
	// Zig-zag Linked list OR Reorder List (LeetCode 143)
	public void zigZag() {
		if (this.head == null) {
			System.out.println("List is Empty...");
			return;
		}

		Node mid = this.getMid();
		Node curr = mid.next;
		mid.next = null;

		Node prev = null, next;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		Node right = prev;
		Node left = this.head;
		Node nextLeft, nextRight;

		while (left != null && right != null) {
			nextLeft = left.next;
			left.next = right;
			nextRight = right.next;
			right.next = nextLeft;
			left = nextLeft;
			right = nextRight;
		}
	}
}

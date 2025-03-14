// Implementing Queue using Linked List

package Queue;

public class QueueUsingLinkedList {
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    
    static class Queue {
        static Node head = null;
        static Node tail = null;
        
        boolean isEmpty() {
            return head == null && tail == null;
        }
        
        //Enqueue
        void add(int data) {
            Node newNode = new Node(data);
            
            if(isEmpty()) {
                tail = head = newNode;
                return;
            }
            
            tail.next = newNode;
            tail = newNode;
        }
        
        //Dequeue
        int remove() {
            if(isEmpty()) {
                System.out.println("Queue is empty...");
                return -1;
            }
            
            int front = head.data;
            if(head == tail) {
                tail = null;
            }
            head = head.next;
            return front;
        }
        
        //Peek
        int peek() {
            if(isEmpty()) {
                System.out.println("Queue is empty...");
                return -1;
            }
            
            return head.data;
        }
    }
    
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        
        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();            
        }
        System.out.println(q.remove());
    }
}

// Creating circular Queue using Arrays

package Queue;

public class CircularQueueUsingArray {
    static class CircularQueue {
        static int[] arr;
        static int size;
        static int front;
        static int rear;
        
        CircularQueue(int size) {
            arr = new int[size];
            CircularQueue.front = CircularQueue.rear = -1;
            CircularQueue.size = size;
        }
        
        public boolean isEmpty() {
            return (front == -1 && rear == -1);
        }
        
        public boolean isFull() {
            return front == ((rear + 1) % size);
        }
        
        public void enqueue(int item) {
            if (isFull()) {
                System.out.println("Queue is Full");
                return;
            }
            if (isEmpty()) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = item;
        }
        
        public int dequeue() {
            if (isEmpty()) {
                return -1;
            }
            int returnVal = arr[front];
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return returnVal;
        }
        
        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return arr[front];
        }
    }
    
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        queue.enqueue(5);
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}

// Stack can be implemented using Array, ArrayList & Linked List

// Implementing Stack using Array List

package Stacks;

import java.util.ArrayList;

public class StackUsingArrayList {
    static class Stack {
        ArrayList<Integer> stack = new ArrayList<>();
        
        public boolean isEmpty() {
            return stack.isEmpty();
        }
        
        public void push(int data) {
            stack.add(data);
        }
        
        public int pop() {
            if (stack.isEmpty()) {
                return -1;
            }
            int top = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            return top;
        }
        
        public int peek() {
            if (stack.isEmpty()) {
                return -1;
            }
            return stack.get(stack.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        Stack stack1 = new Stack();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        System.out.println(stack1.peek());
        System.out.println(stack1.pop());
        System.out.println(stack1.isEmpty());
        System.out.println(stack1.peek());
        
        Stack stack2 = new Stack();
        stack2.push(4);
        stack2.push(5);
        System.out.println(stack2.peek());
        System.out.println(stack1.peek());
        
        while(!stack2.isEmpty()) {
            System.out.print(stack2.pop() + " ");
        }
    }
}

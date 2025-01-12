// Reverse a Stack

package Stacks;

import java.util.Stack;

public class ReverseStack {
    public static void pushAtBottom(Stack<Object> stack, Object value) {
        if (stack.isEmpty()) {
            
            stack.push(value);
            return;
        }
        Object top = stack.pop();
        pushAtBottom(stack, value);
        stack.push(top);
    }
    
    public static void reverseStack(Stack<Object> stack) {
        if (stack.isEmpty()) {
            return;
        }
        Object top = stack.pop();
        reverseStack(stack);
        pushAtBottom(stack, top);
    }
    
    public static void main(String[] args) {
        Stack<Object> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        
        while (!stack.isEmpty()) {
            System.out.print(stack.peek() + " ");
            stack.pop();
        }
        System.out.println();
        
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        
        reverseStack(stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.peek() + " ");
            stack.pop();
        }
        System.out.println();
    }
}

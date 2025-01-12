// Implementing Stack using Java Collection Framework

package Stacks;

import java.util.Stack;

public class StackUsingJVC {
    public static void main(String[] args) {
        Stack<Integer> list = new Stack<>();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        System.out.println(list);
        while (!list.isEmpty()) {
            System.out.println(list.peek());
            list.pop();
        }
    }
}

/*
Palindrome Linked List

Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false

*/

package Stacks;

import java.util.Stack;
import LinkedList.SingleLinkedList;
import LinkedList.Node;

public class PalindromeLinkedList {
    public static boolean isPalindrome(SingleLinkedList list) {
        if (list.head == null) {
            System.out.println("Empty List...");
            return true;
        }

        Stack<Node> stack = new Stack<>();
        Node temp = list.head;
        Node mid = list.getMid();

        while (mid != null) {
            stack.push(mid);
            mid = mid.next;
        }

        while (!stack.isEmpty()) {
            if (temp.data != stack.peek().data) {
                return false;
            }
            
            stack.pop();
            temp = temp.next;
        }

        return true;
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.addStart(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        System.out.println();
        list.printList();
        System.out.println("Is list Palindrome?: " + isPalindrome(list) + "\n");
    }
}

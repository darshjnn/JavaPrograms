/*
1373. Maximum Sum BST in Binary Tree

Given a binary tree root, return the maximum sum of all keys of any subtree which
is also a Binary Search Tree (BST).

Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
Output: 20
Explanation: Maximum sum in a valid Binary search tree is obtained in root node with key
equal to 3.

Example 2:
Input: root = [4,3,null,1,2]
Output: 2
Explanation: Maximum sum in a valid Binary search tree is obtained in a single root node
with key equal to 2.

Example 3:
Input: root = [-4,-2,-5]
Output: 0
Explanation: All values are negatives. Return an empty BST.

*/

package BinarySearchTree.LeetCode;

import BinaryTree.Node.Node;
import BinarySearchTree.BSTNode.NodeInfo;

public class MaximumSumBST {
    static int result;

    // Normal Zindagi
    public static NodeInfo maxSum(Node root) {
        if (root == null) {
            return new NodeInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        NodeInfo left = maxSum(root.left);
        NodeInfo right = maxSum(root.right);

        int min = Math.min(root.data, Math.min(left.min, right.min));
        int max = Math.max(root.data, Math.max(left.max, right.max));
        int sum = Math.max(left.sum, right.sum);

        if (root.data <= left.max || root.data >= right.min) {
            return new NodeInfo(false, sum, min, max);
        }

        if (left.isBST && right.isBST) {
            sum = root.data + left.sum + right.sum;
            result = Math.max(result, sum);
            return new NodeInfo(true, sum, min, max);
        }

        return new NodeInfo(false, sum, min, max);
    }

    // Mentos Zindagi
    public static int maxSumOpt(Node root) {
        if (root == null) {
            return 0;
        }

        int left = maxSumOpt(root.left);
        int right = maxSumOpt(root.right);

        if (left == Integer.MIN_VALUE || right == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (root.left != null) {
            Node curr = root.left;
            while (curr.right != null) {
                curr = curr.right;
            }
            if (root.data <= curr.data) {
                return Integer.MIN_VALUE;
            }
        }

        if (root.right != null) {
            Node curr = root.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            if (root.data >= curr.data) {
                return Integer.MIN_VALUE;
            }
        }

        int sum = root.data + left + right;
        result = Math.max(result, sum);
        return sum;
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(8);
        root.left.left = new Node(6);
        root.left.left.left = new Node(9);

        root.left.right = new Node(1);
        root.left.right.left = new Node(-5);
        root.left.right.left.right = new Node(-3);

        root.left.right.right = new Node(4);
        root.left.right.right.right = new Node(10);

        result = 0;
        System.out.println("Max BST Sum:");

        maxSum(root);
        System.out.println("\tNormal Zindagi: " + result);

        result = 0;
        maxSumOpt(root);
        System.out.println("\tMentos Zindagi: " + result);

    }
}

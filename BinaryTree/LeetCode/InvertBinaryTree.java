/*
226. Invert Binary Tree

Given the root of a binary tree, invert the tree, and return its root.

Example 1:
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Example 2:
Input: root = [2,1,3]
Output: [2,3,1]

Example 3:
Input: root = []
Output: []

*/

package BinaryTree.LeetCode;

import BinaryTree.Node.Node;
import BinaryTree.BinaryTree;

public class InvertBinaryTree {
    public static Node invertTree(Node root) {
        if (root == null) {
            return root;
        }

        Node left = invertTree(root.left);
        Node right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] arr = { 4, 2, 1, -1, -1, 3, -1, -1, 7, 6, -1, -1, 9, -1, -1 };
        Node root = tree.buildTree(arr, new int[] { 0 });

        tree.levelOrder(root);
        System.out.println();

        invertTree(root);
        tree.levelOrder(root);
    }
}

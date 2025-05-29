/*
965. UniValued Binary Tree

A binary tree is uni-valued if every node in the tree has the same value.

Given the root of a binary tree, return true if the given tree is uni-valued, or false 
otherwise.

Example 1:
Input: root = [1,1,1,1,1,null,1]
Output: true

Example 2:
Input: root = [2,2,2,5,2]
Output: false

*/

package BinaryTree.LeetCode;

import BinaryTree.Node.Node;
import BinaryTree.BinaryTree;

public class UniValuedBinaryTree {
    public static boolean isUniValTree(Node root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.data != root.left.data) {
            return false;
        }

        if (root.right != null && root.data != root.right.data) {
            return false;
        }

        return isUniValTree(root.left) && isUniValTree(root.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] arr = { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 };
        Node root = tree.buildTree(arr, new int[] { 0 });

        System.out.println(isUniValTree(root));
    }
}

/*
111. Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down
to the nearest leaf node.

Note: A leaf is a node with no children.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 2

Example 2:
Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5

*/

package BinaryTree.LeetCode;

import BinaryTree.Node.Node;
import BinaryTree.BinaryTree;

public class MinDepth {
    public static int minDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if (root.left == null) {
            return rightDepth + 1;
        }

        if (root.right == null) {
            return leftDepth + 1;
        }

        return Math.min(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, -1, 3, -1, 4, -1, 5, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(arr, new int[] { 0 });

        System.out.println(minDepth(root));
    }
}
package BinarySearchTree;

import java.util.Arrays;

import BinarySearchTree.BSTNode.NodeInfo;
import BinaryTree.Node.Node;

public class BSTImplement {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = bst.buildBST(values);

        // Inorder Traversal
        System.out.print("Inorder Traversal: ");
        bst.inorder(root);

        // Level order Traversal
        System.out.println("\n\nLevel Order Traversal: ");
        bst.levelOrder(root);

        // Searching an Element
        System.out.println("\nSearching key = 14: " + bst.search(root, 14) + "\n");

        // Delete a Node
        System.out.println("Delete Node: 10");
		bst.delete(root, 10);
		bst.levelOrder(root);
        
        // Print in Range
        System.out.print("\nPrint in Range(5, 10): ");
        bst.printInRange(root, 5, 10);

        // Sum in Range
        System.out.println("\nSum in Range(5, 10) : " + bst.sumInRange(root, 5, 10));

        // Root to Leaf Paths
        System.out.println("\nRoot to Leaf Paths: ");
        bst.rootToLeaf(root);
        
        // Is Valid BST
        System.out.println("\nIs BST Valid: " + bst.isValidBST(root, null, null));

        // Mirror/Invert the BST
        System.out.println("\nInvert/Mirror BST: ");
        bst.invertTree(root);
        bst.levelOrder(root);
        bst.invertTree(root);

        // Sorted Array to Balanced BST
		int[] nums = { 3, 5, 6, 8, 10, 11, 12 };
        Node arrRoot = bst.sortedArrayToBST(nums, 0, 6);
        System.out.println("\nSorted Array to BST: " + Arrays.toString(nums));
        bst.levelOrder(arrRoot);

        // BST to Balanced BST
        Node bstRoot = new Node(8);
		bstRoot.left = new Node(6);
		bstRoot.left.left = new Node(5);
		bstRoot.left.left.left = new Node(3);
		bstRoot.right = new Node(10);
		bstRoot.right.right = new Node(11);
        bstRoot.right.right.right = new Node(12);
        
        System.out.println("\nUnbalanced BST: ");
        bst.levelOrder(bstRoot);
        System.out.println("\nBalanced BST: ");
        bstRoot = bst.balanceBST(bstRoot);
        bst.levelOrder(bstRoot);

        // Merge Two BSTs
        System.out.println("\nBST 1: ");
        bst.levelOrder(root);
        System.out.println("\nBST 2: ");
        bst.levelOrder(bstRoot);
        Node merged = bst.mergeBST(root, bstRoot);
        System.out.println("\nMerged BST: ");
        bst.levelOrder(merged);
        
        // Size and Sum of the largest BST in Binary Tree
        Node root2 = new Node(50);
		root2.left = new Node(30);
		root2.left.left = new Node(5);
		root2.left.right = new Node(40);

		root2.right = new Node(60);
		root2.right.left = new Node(45);
		root2.right.right = new Node(70);
		root2.right.right.left = new Node(65);
        root2.right.right.right = new Node(40);
        
        System.out.println("\nTree Structure: ");
		bst.levelOrder(root2);
        
        NodeInfo n = bst.largestBST(root2);
        System.out.println("\nSize of Largest BST: " + n.size);
		System.out.println("Sum of Largest BST: " + n.sum);
    }
}
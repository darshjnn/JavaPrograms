package BinarySearchTree;

import BinarySearchTree.BSTNode.AVLNode;

public class AVLTreeImplement {
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		AVLNode root = new AVLNode(10);
		
		int[] values = {20, 30, 40, 50, 60, 70, 80, 90};
		for (int value : values) {
			root = tree.insert(root, value);
		}
		
		tree.levelOrder(root);
		
		// Delete a Node
		int key = 50;
		System.out.println("\nDeleting node: " + key);
		root = tree.deleteNode(root, key);
		tree.levelOrder(root);
	}
}

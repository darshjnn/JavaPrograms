/*
450. Delete Node in a BST

Given a root node reference of a BST and a key, delete the node with the given key in the BST.
Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:
	1. Search for a node to remove.
	2. If the node is found, delete the node.
 

Example 1:
Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Example 2:
Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.

Example 3:
Input: root = [], key = 0
Output: []

Constraints:
	Each node has a unique value.
	root is a valid binary search tree.


*/

package BinarySearchTree.LeetCode;

import BinaryTree.Node.Node;

public class DeleteNode {
	public static Node deleteNode(Node root, int key) {
		if (root == null) {
			return null;
		}
		
		if (key < root.data) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.data) {
			root.right = deleteNode(root.right, key);
		} else {
			// Voila!!!
			// Case 1: Leaf Node
			if (root.left == null && root.right == null) {
				return null;
			}

			// Case 2: Only Single Child Exists
			if (root.left == null) {
				return root.right;
			}
			if (root.right == null) {
				return root.left;
			}

			// Case 3: Both Child Exists
			int inorderPredecessor = findInorderPredecessor(root.left);
			root.data = inorderPredecessor;
			root.left = deleteNode(root.left, inorderPredecessor);
		}
		
		return root;
	}

	// Find Inorder Predecessor of the key
	// Inorder Predecessor is the right-most node int the left subtree
	public static int findInorderPredecessor(Node root) {
		while (root.right != null) {
			root = root.right;
		}

		return root.data;
	}
	
	public static void main(String[] args) {
		Node root = new Node(5);
		
		root.left = new Node(3);
		root.left.left = new Node(2);
		root.left.right = new Node(4);

		root.right = new Node(6);
		root.right.right = new Node(7);
		
		int key = 3;

		deleteNode(root, key);
		System.out.println("Deleted: " + key);
	}
}

/*
AVL Trees
These are self-balancing BST.

*/

package BinarySearchTree;

import BinarySearchTree.BSTNode.AVLNode;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("SuspiciousNameCombination")
public class AVLTree {
	// Height of a Node
	public int height(AVLNode root) {
		if (root == null) {
			return 0;
		}
		
		return root.height;
	}
	
	// Balance factor of a Node
	public int balanceFactor(AVLNode root) {
		if (root == null) {
			return 0;
		}
		
		return this.height(root.left) - this.height(root.right);
	}
	
	// Left-Left Case, i.e., Right rotation of subtree with root y
	public AVLNode rightRotate(AVLNode y) {
		AVLNode x = y.left;
		AVLNode temp = x.right;
		
		// Rotation
		x.right = y;
		y.left = temp;
		
		// Update heights
		y.height = Math.max(this.height(y.left), this.height(y.right)) + 1;
		x.height = Math.max(this.height(x.left), this.height(x.right)) + 1;
		
		// x is the new root
		return x;
	}
	
	// Right-Right Case, i.e., Left rotation of a subtree with root y
	public AVLNode leftRotate(AVLNode y) {
		AVLNode x = y.right;
		AVLNode temp = x.left;
		
		// Rotation
		x.left = y;
		y.right = temp;
		
		// Update heights
		y.height = Math.max(this.height(y.left), this.height(y.right)) + 1;
		x.height = Math.max(this.height(x.left), this.height(x.right)) + 1;
		
		// x is the new root
		return x;
	}
	
	// Insert a Node
	public AVLNode insert(AVLNode root, int key) {
		if (root == null) {
			return new AVLNode(key);
		}
		
		if (key < root.data) {
			root.left = this.insert(root.left, key);
		} else if (key > root.data) {
			root.right = this.insert(root.right, key);
		} else {
			// Duplicate Entries are not allowed
			return root;
		}
		
		// Update height of the Current Node
		root.height = 1 + Math.max(this.height(root.left), this.height(root.right));
		
		// Get the Balance factor of the Current Node
		int balanceFactor = this.balanceFactor(root);
		
		// Left-Left Case: Right rotation
		if (balanceFactor > 1 && key < root.left.data) {
			return this.rightRotate(root);
		}
		
		// Right-Right Case: Left rotation
		if (balanceFactor < -1 && key > root.right.data) {
			return this.leftRotate(root);
		}
		
		// Left-Right Case: Left Rotation -> Right rotation
		if (balanceFactor > 1 && key > root.left.data) {
			root.left = this.leftRotate(root.left);
			return this.rightRotate(root);
		}
		
		// Right-left Case: Right rotation -> Left Rotation
		if (balanceFactor < -1 && key < root.right.data) {
			root.right = this.rightRotate(root.right);
			return this.leftRotate(root);
		}
		
		return root;
	}
	
	// Delete a Node
	public AVLNode deleteNode(AVLNode root, int key) {
		if (root == null) {
			return null;
		}
		
		if (key < root.data) {
			root.left = this.deleteNode(root.left, key);
		} else if (key > root.data) {
			root.right = this.deleteNode(root.right, key);
		} else {
			// Voilà!!!
			if (root.left == null && root.right == null) {
				// Case 1: Node with no child, i.e., Leaf Node
				root = null;
			} else if (root.left == null) {
				// Case 2: Node with only a right child
				root = root.right;
			} else if (root.right == null) {
				// Case 3: Node with only a left child
				root = root.left;
			} else {
				// Case 4: Both children exist
				AVLNode inorderSuccessor = this.getInorderSuccessor(root.right);
				root.data = inorderSuccessor.data;
				root.right = this.deleteNode(root.right, inorderSuccessor.data);
			}
		}
		
		// Return if the tree had only one child
		if (root == null) {
			return null;
		}
		
		// Update the height of the current node
		root.height = 1 + Math.max(this.height(root.left), this.height(root.right));
		
		// Get the Balance factor
		int balanceFactor = this.balanceFactor(root);
		
		// Left-Left Case: Right rotation
		if (balanceFactor > 1 && this.balanceFactor(root.left) >= 0) {
			return this.rightRotate(root);
		}
		
		// Right-Right Case: Left rotation
		if (balanceFactor < -1 && this.balanceFactor(root.right) <= 0) {
			return this.leftRotate(root);
		}
		
		// Left-Right Case: Left Rotation -> Right rotation
		if (balanceFactor > 1 && this.balanceFactor(root.left) < 0) {
			root.left = this.leftRotate(root.left);
			return this.rightRotate(root);
		}
		
		// Right-left Case: Right rotation -> Left Rotation
		if(balanceFactor < -1 && this.balanceFactor(root.right) > 0) {
			root.right = this.rightRotate(root.right);
			return this.leftRotate(root);
		}
		
		return root;
	}
	
	// Get Inorder Successor of a Node
	//	Inorder successor in BST is left most node in right subtree
	public AVLNode getInorderSuccessor(AVLNode root) {
		while (root.left != null) {
			root = root.left;
		}
		
		return root;
	}
	
	// Level Order Traversal
	public void levelOrder(AVLNode root) {
		if (root == null) {
			return;
		}
		
		Queue<AVLNode> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		
		while (!q.isEmpty()) {
			AVLNode curr = q.poll();
			if (curr != null) {
				System.out.print(curr.data + " ");
				if (curr.left != null) {
					q.offer(curr.left);
				}
				if (curr.right != null) {
					q.offer(curr.right);
				}
			} else {
				System.out.println();
				if (q.isEmpty()) {
					break;
				} else {
					q.offer(null);
				}
			}
		}
	}
}

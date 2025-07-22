/*
1932. Merge BSTs to Create Single BST

You are given n BST (binary search tree) root nodes for n separate BSTs stored in an array
trees (0-indexed). Each BST in trees has at most 3 nodes, and no two roots have the same value.

In one operation, you can:
	1. Select two distinct indices i and j such that the value stored at one of the leaves of
	   trees[i] is equal to the root value of trees[j].
	2. Replace the leaf node in trees[i] with trees[j].
	3. Remove trees[j] from trees.

Return the root of the resulting BST if it is possible to form a valid BST after performing n - 1
operations, or null if it is impossible to create a valid BST.

A BST (binary search tree) is a binary tree where each node satisfies the following property:
	1. Every node in the node's left subtree has a value strictly less than the node's value.
	2. Every node in the node's right subtree has a value strictly greater than the node's value.

A leaf is a node that has no children.

Example 1:
Input: trees = [[2,1],[3,2,5],[5,4]]
Output: [3,2,5,1,null,4]
Explanation:
In the first operation, pick i=1 and j=0, and merge trees[0] into trees[1].
Delete trees[0], so trees = [[3,2,5,1],[5,4]].

In the second operation, pick i=0 and j=1, and merge trees[1] into trees[0].
Delete trees[1], so trees = [[3,2,5,1,null,4]].

The resulting tree, shown above, is a valid BST, so return its root.

Example 2:
Input: trees = [[5,3,8],[3,2,6]]
Output: []
Explanation:
Pick i=0 and j=1 and merge trees[1] into trees[0].
Delete trees[1], so trees = [[5,3,8,2,6]].

The resulting tree is shown above. This is the only valid operation that can be performed, but
the resulting tree is not a valid BST, so return null.

Example 3:
Input: trees = [[5,4],[3]]
Output: []
Explanation: It is impossible to perform any operations.

Hint: The root value of the final tree does not occur as a value in any of the leaves of the
		original tree.

Constraints:
	n == trees.length
	1 <= n <= 5 * 10^4
	The number of nodes in each tree is in the range [1, 3].
	Each node in the input may have children but no grandchildren.
	No two roots of trees have the same value.
	All the trees in the input are valid BSTs.
	1 <= TreeNode.val <= 5 * 10^4.

*/

package BinarySearchTree.LeetCode;

import BinaryTree.Node.Node;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MergeBST {
	static HashMap<Integer, Node> valToTree = new HashMap<>();
	static HashMap<Integer, Integer> leafCount = new HashMap<>();
	static HashSet<Integer> used = new HashSet<>();
	
	public static Node canMerge(List<Node> trees) {
		if (trees == null || trees.isEmpty()) {
			return null;
		}
		
		if (trees.size() == 1) {
			return trees.getFirst();
		}
		
		// Step 1: Initialize valToTree and count all leaf values
		for (Node tree : trees) {
			valToTree.put(tree.data, tree);
			
			if (tree.left != null) {
				leafCount.put(tree.left.data, leafCount.getOrDefault(tree.data, (0)) + 1);
			}
			
			if (tree.right != null) {
				leafCount.put(tree.right.data, leafCount.getOrDefault(tree.data, (0)) + 1);
			}
		}
		
		
		Node root = null;
		// Step 2: Find the unique root (not a leaf in any other tree)
		for (Node tree : trees) {
			if (!leafCount.containsKey(tree.data)) {
				if (root != null) {
					// Multiple roots found
					return null;
				}
				root = tree;
			}
		}
		
		// Step 3: Merge process
		if (!merge(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
			return null;
		}
		
		// Step 4: Validate all trees used (except the root one)
		if (used.size() != trees.size() - 1) {
			return null;
		}
		
		return root;
	}
	
	static boolean merge(Node root, int min, int max) {
		if (root == null) {
			return true;
		}
		
		if (root.data <= min || root.data >= max) {
			return false;
		}
		
		// If it's a leaf and another tree has node.val as root and hasn't been used
		if (root.left == null && root.right == null && valToTree.containsKey(root.data)
				&& !used.contains(root.data)) {
			// Connect the subtree's children
			Node subNode = valToTree.get(root.data);
			root.left = subNode.left;
			root.right = subNode.right;
			
			used.add(root.data);
		}
		
		return merge(root.left, min, root.data) && merge(root.right, root.data, max);
	}
	
	// Preorder for BST
	public static void preorder(Node root) {
		if (root == null) {
			System.out.print("null ");
			return;
		}
		
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public static void main(String[] args) {
		Node root1 = new Node(10, new Node(9), null);
		Node root2 = new Node(9, new Node(8), null);
		Node root3 = new Node(8, new Node(7), null);
		
		List<Node> trees = Arrays.asList(root1, root2, root3);
		
		Node ans = canMerge(trees);
		preorder(ans);
	}
}

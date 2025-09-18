/*
1325. Delete Leaves With a Given Value

Given a binary tree root and an integer target, delete all the leaf nodes with value target.

Note that once you delete a leaf node with value target, if its parent node becomes a leaf node
and has the value target, it should also be deleted (you need to continue doing that until you
cannot).

Example 1:
Input: root = [1,2,3,2,null,2,4], target = 2
Output: [1,null,3,null,4]
Explanation: Leaf nodes in green with value (target = 2) are removed (Picture in left).
After removing, new nodes become leaf nodes with value (target = 2) (Picture in center).

Example 2:
Input: root = [1,3,3,3,2], target = 3
Output: [1,3,null,null,2]

Example 3:
Input: root = [1,2,null,2,null,2], target = 2
Output: [1]
Explanation: Leaf nodes in green with value (target = 2) are removed at each step.

*/

package BinaryTree.LeetCode;

import BinaryTree.Node.Node;
import BinaryTree.BinaryTree;

public class DeleteLeaves {
	public static Node removeLeafNodes(Node root, int key) {
		if (root == null) {
			return null;
		}
		
		root.left = removeLeafNodes(root.left, key);
		root.right = removeLeafNodes(root.right, key);
		
		if  (root.data == key && root.left == null && root.right == null) {
			return null;
		}
		
		return root;
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(2);
		
		root.right = new Node(3);
		root.right.left = new Node(2);
		root.right.right = new Node(4);
		
		BinaryTree bt = new BinaryTree();
		
		bt.levelOrder(root);
		System.out.println();
		
		removeLeafNodes(root, 2);
		
		bt.levelOrder(root);
	}
}

/*
Alternate Solution:
public TreeNode removeLeafNodes(TreeNode root, int target) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root, lastRightNode = null;

        while (!stack.isEmpty() || currentNode != null) {
            // Push left nodes to the stack until reaching the leftmost node.
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            // Access the top node on the stack without removing it.
            // This node is the current candidate for processing.
            currentNode = stack.peek();

            // Check if the current node has an unexplored right subtree.
            // If so, shift to the right subtree unless it's the subtree we just visited.
            if (
                currentNode.right != lastRightNode && currentNode.right != null
            ) {
                currentNode = currentNode.right;
                
                // Continue in the while loop to push this new subtree's leftmost nodes.
                continue;
            }

            // Remove the node from the stack, since we're about to process it.
            stack.pop();

            // If the node has no right subtree or the right subtree has already been visited,
            // then check if it is a leaf node with the target value.
            if (
                currentNode.right == null &&
                currentNode.left == null &&
                currentNode.val == target
            ) {
                // If the stack is empty after popping, it means the root was a target leaf node.
                if (stack.isEmpty()) {
                    return null; // The tree becomes empty as the root itself is removed.
                }

                // Identify the parent of the current node.
                TreeNode parent = stack.isEmpty() ? null : stack.peek();

                // Disconnect the current node from its parent.
                if (parent != null) {
                    if (parent.left == currentNode) {
                        // If current is a left child, set the left pointer to null.
                        parent.left = null;
                    } else {
                        // If current is a right child, set the right pointer to null.
                        parent.right = null;
                    }
                }
            }

            // Mark this node as visited by setting 'lastRightNode' to 'currentNode' before
            moving to the next iteration.
            lastRightNode = currentNode;
            
            // Reset 'currentNode' to null to ensure the next node from the stack is processed.
            currentNode = null;
        }
        
        // Return the modified tree.
        return root;
    }

*/